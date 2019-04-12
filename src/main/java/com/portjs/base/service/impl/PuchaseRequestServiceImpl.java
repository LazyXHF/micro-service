package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.PurchaseRequestMapper;
import com.portjs.base.entity.PurchaseRequest;
import com.portjs.base.service.PuchaseRequestService;
import com.portjs.base.util.Code;
import com.portjs.base.util.LSUtils;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.StringUtils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class PuchaseRequestServiceImpl implements PuchaseRequestService {

    @Autowired
    PurchaseRequestMapper purchaseRequestMapper;


    @Override
    public ResponseMessage updateByPrimaryKeySelective(PurchaseRequest record) {
        return null;
    }

    //返参信息
    public final static String PARAM_MESSAGE_1 = "未传";
    public final static String PARAM_MESSAGE_2 = "已存在";
    /**
     * 立项暂存/提交
     * @param
     * @return
     */
    @Override
    public ResponseMessage insertPurchaseRequestSelective(String responseBody) {
        //status为10：完成 ；0：暂存；1：提交（开始流程）2：根据前端传值来判断是暂存还是提交


        JSONObject jsonObject = JSONObject.parseObject(responseBody);
        String status = jsonObject.getString("status");//0暂存1提交
        String projectId = jsonObject.getString("projectId");//所属项目id

        String DS = jsonObject.getString("DS");//获取导入的清单列表JSON数组字符串

        if(StringUtils.isEmpty(status)){
            return new ResponseMessage(Code.CODE_ERROR,"Status"+PARAM_MESSAGE_1);
        }


        PurchaseRequest purchaseRequest = new PurchaseRequest();
        purchaseRequest.setRequestNum(LSUtils.createOdd("PR"));

        //int i = purchaseRequestMapper.insertPurchaseRequestSelective();
        net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(DS);//并将DS内容取出转为json数组
        for (int i = 0; i < jsonArray.size(); i++) {     //遍历json数组内容
            net.sf.json.JSONObject object = jsonArray.getJSONObject(i);
            System.out.println(object.getString("字段名1"));

        }
        //进入审核

        /*for(int i=0;i<nextViewJSON.size();i++){
            TWorkflowstep workflowstep = new TWorkflowstep();
            if(CollectionUtils.isEmpty(list)){
                //然后新增一条当前登录人的流程记录
                workflowstep.setId(String.valueOf(IDUtils.genItemId()));
                workflowstep.setRelateddomain("项目立项");
                workflowstep.setPrestepId("0");
                workflowstep.setRelateddomainId(application.getId());
                workflowstep.setStepDesc("项目负责人提交");
                workflowstep.setActionuserId(userId);
                workflowstep.setActionTime(new Date());
                //workflowstep.setActionComment("同意");
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
            tWorkflowstep.setRelateddomainId(application.getId());
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
            todo.setStepDesc(projectName+"的立项批复流程等待您的处理");
            todo.setRelateddomain("项目立项");
            todo.setRelateddomainId(application.getId());
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

            *//*String id = String.valueOf(IDUtils.genItemId());*//*

            updateUtil.projectMethod(application.getProjectId(),null,application.getProjectName(),
                    application.getProjectType(),"A",userId,application.getOrganization()
                    ,application.getApplicationAmount().toString(),"Ab2",application.getInvestor());
            return new ResponseMessage(Code.CODE_OK,"提交成功");
        }*/


        return new ResponseMessage(Code.CODE_OK,"操作成功");
    }


    @Override
    public ResponseMessage queryPurchaseRequestInfo(String requestBody) {
        return null;
    }

    @Override
    public ResponseMessage updateDeleteTimeByIds(List<String> ids) {
        return null;
    }

    @Override
    public ResponseMessage queryPurchaseRequestById(String ids) {
        return null;
    }
}
