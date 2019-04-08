package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.*;
import com.portjs.base.entity.*;
import com.portjs.base.service.PurchasingManagementService;
import com.portjs.base.util.Code;
import com.portjs.base.util.IDUtils;
import com.portjs.base.util.ProjectAddorUpdateUtil;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.StringUtils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by dengshuangzhen on 2019\4\4 0004
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PurchasingManagementImpl implements PurchasingManagementService {
    @Autowired
    private TTodoMapper todoMapper;
    @Autowired
    private PurchaseRequestMapper requestMapper;
    @Autowired
    private PurchaseListMapper listMapper;
    @Autowired
    private TWorkflowstepMapper workflowstepMapper;
    @Autowired
    private TXietongDictionaryMapper dictionaryMapper;
    @Autowired
    private ProjectAddorUpdateUtil updateUtil;

    //返参信息
    public final static String PARAM_MESSAGE_1 = "未传";
    public final static String PARAM_MESSAGE_2 = "已存在";
    /**
     * 采购详情暂存/提交
     * @param responseBody
     * @return
     */
    @Override
    public ResponseMessage inserProcurementDetails(String responseBody) {
        JSONObject jsonObject = JSONObject.parseObject(responseBody);
        String status = jsonObject.getString("Status");//0暂存7提交
        String userId = jsonObject.getString("UserId");//登录用户
        String userName = jsonObject.getString("UserName");//登录用户名
        JSONObject requestJSON = jsonObject.getJSONObject("Request");//基本信息
        JSONArray listJSON = jsonObject.getJSONArray("List");//采购清单
        JSONArray nextViewJSON = jsonObject.getJSONArray("NextViews");//下一步处理人
        String tTodoId = jsonObject.getString("tTodoId");//待办表id

        //判断状态 是否存在 如果不存在则返回前台
        if(StringUtils.isEmpty(status)){
            return new ResponseMessage(Code.CODE_ERROR,"Status"+PARAM_MESSAGE_1);
        }
        //判断登录人id 是否存在 如果不存在则返回前台
        if(StringUtils.isEmpty(userId)){
            return new ResponseMessage(Code.CODE_ERROR,"UserId"+PARAM_MESSAGE_1);
        }
        //判断基本信息 是否存在 如果不存在则返回前台
        if(StringUtils.isEmpty(requestJSON)){
            return new ResponseMessage(Code.CODE_ERROR,"Application"+PARAM_MESSAGE_1);
        }
        String message1;
        String message2;
        //0暂存
        if(status.equals("0")){
            message1="暂存失败";
            message2="更新失败";
            //暂存状态，不用接收下一步处理人
            nextViewJSON.clear();
        }else{
            //提交
            //判断采购清单 是否存在 如果不存在则返回前台
            if(CollectionUtils.isEmpty(listJSON)){
                return new ResponseMessage(Code.CODE_ERROR,"Persons"+PARAM_MESSAGE_1);
            }
            //判断下一步处理人 是否存在 如果不存在则返回前台
            if(CollectionUtils.isEmpty(nextViewJSON)){
                return new ResponseMessage(Code.CODE_ERROR,"Files"+PARAM_MESSAGE_1);
            }
            if (!StringUtils.isEmpty(tTodoId)){
                TTodo todo = new TTodo();
                todo.setId(tTodoId);
                todo.setStatus("1");
                todo.setActiontime(new Date());
                int i = todoMapper.updateByPrimaryKeySelective(todo);
                if(i!=1){
                    return new ResponseMessage(Code.CODE_ERROR,"提交失败");
                }
            }
            message1="提交失败";
            message2="提交失败";
        }
        //项目基本信息
        PurchaseRequest request = JSONObject.toJavaObject(requestJSON, PurchaseRequest.class);
        request.setCreater(userId);
        request.setCreateTime(new Date());
        request.setStatus(status);
        //插入还是更新
        if(StringUtils.isEmpty(request.getId())){
            request.setId(String.valueOf(IDUtils.genItemId()));
            int i = requestMapper.insertSelective(request);
            if(i!=1){
                return new ResponseMessage(Code.CODE_ERROR,message1);
            }
        }else{
            request.setUpdateTime(new Date());
            int i = requestMapper.updateByPrimaryKeySelective(request);
            if(i!=1){
                return new ResponseMessage(Code.CODE_ERROR,message2);
            }
        }
        //新增采购清单 先删除后增加
        PurchaseListExample listExample = new PurchaseListExample();
        PurchaseListExample.Criteria listCriteria = listExample.createCriteria();
        listCriteria.andProjectIdEqualTo(request.getId());
        listMapper.deleteByExample(listExample);
        //增加人员
        for(int i=0;i<listJSON.size();i++){
            JSONObject object = listJSON.getJSONObject(i);
            PurchaseList purchaseList = JSONObject.toJavaObject(object, PurchaseList.class);
            purchaseList.setId(String.valueOf(IDUtils.genItemId()));
            purchaseList.setRequestId(request.getId());
            purchaseList.setCreater(userId);
            purchaseList.setCreateTime(new Date());
            int num = listMapper.insertSelective(purchaseList);
            if(num<=0){
                return new ResponseMessage(Code.CODE_ERROR,"未知异常");
            }
        }
        //查询流程表中当前业务单id对应的处理结果是不同意的流程记录
        TWorkflowstepExample workflowstepExample = new TWorkflowstepExample();
        TWorkflowstepExample.Criteria workflowstepCriteria = workflowstepExample.createCriteria();
        workflowstepCriteria.andRelateddomainIdEqualTo(request.getId());
        workflowstepCriteria.andActionResultEqualTo(1);
        List<TWorkflowstep> list = workflowstepMapper.selectByExample(workflowstepExample);
        //提交时进入审核
        for(int i=0;i<nextViewJSON.size();i++){
            TWorkflowstep workflowstep = new TWorkflowstep();
            if(CollectionUtils.isEmpty(list)){
                //然后新增一条当前登录人的流程记录
                workflowstep.setId(String.valueOf(IDUtils.genItemId()));
                workflowstep.setRelateddomain("项目立项");
                workflowstep.setPrestepId("0");
                workflowstep.setRelateddomainId(request.getId());
                workflowstep.setStepDesc("项目负责人提交");
                workflowstep.setActionuserId(userId);
                workflowstep.setActionTime(new Date());
                workflowstep.setActionComment("同意");
                workflowstep.setActionResult(0);
                workflowstep.setStatus("1");
                workflowstep.setBackup3("1");

                int i3 = workflowstepMapper.insertSelective(workflowstep);
                if(i3!=1){
                    return new ResponseMessage(Code.CODE_ERROR,"提交失败");
                }
            }else {
                workflowstep.setId(list.get(0).getId());
            }
            //接下来再新增一条部门负责人的流程记录
            TWorkflowstep tWorkflowstep = new TWorkflowstep();
            tWorkflowstep.setId(String.valueOf(IDUtils.genItemId()));
            tWorkflowstep.setRelateddomain("项目立项");
            tWorkflowstep.setRelateddomainId(request.getId());
            tWorkflowstep.setPrestepId(workflowstep.getId());
            tWorkflowstep.setStepDesc("部门负责人审核");
            tWorkflowstep.setActionuserId(nextViewJSON.getString(i));
            // tWorkflowstep.setActionTime(new Date());
            tWorkflowstep.setStatus("0");
            tWorkflowstep.setBackup3("2");

            int i4 = workflowstepMapper.insertSelective(tWorkflowstep);
            if(i4!=1){
                return new ResponseMessage(Code.CODE_ERROR,"提交失败");
            }
            //最后新增一条代办
            TTodo todo = new TTodo();
            todo.setId(String.valueOf(IDUtils.genItemId()));
            todo.setCurrentstepId(tWorkflowstep.getId());
            todo.setStepDesc("项目负责人提交");
            todo.setRelateddomain("项目立项");
            todo.setRelateddomainId(request.getId());
            todo.setSenderId(userId);
            todo.setSenderTime(new Date());
            todo.setReceiverId(nextViewJSON.getString(i));
            //查询代办类型
            TXietongDictionaryExample example = new TXietongDictionaryExample();
            TXietongDictionaryExample.Criteria criteria = example.createCriteria();
            criteria.andTypeIdEqualTo("8");
            criteria.andTypeCodeEqualTo("38");
            criteria.andMidValueEqualTo("1");
            List<TXietongDictionary> dictionaryList = dictionaryMapper.selectByExample(example);
            //查询待办类型
            todo.setTodoType(dictionaryList.get(0).getMainValue());
            todo.setStatus("0");
            todo.setBackUp7(userName);//发起人
            int i5 = todoMapper.insertSelective(todo);
            if(i5!=1){
                return new ResponseMessage(Code.CODE_ERROR,"提交失败");
            }

            /*String id = String.valueOf(IDUtils.genItemId());*/

            /*updateUtil.projectMethod(application.getProjectId(),null,request.getProjectName(),
                    application.getProjectType(),"A",userId,application.getOrganization()
                    ,application.getApplicationAmount().toString(),"Ab2",application.getInvestor());*/
            return new ResponseMessage(Code.CODE_OK,"提交成功");
        }

        return new ResponseMessage(Code.CODE_OK,"操作成功");
    }
}
