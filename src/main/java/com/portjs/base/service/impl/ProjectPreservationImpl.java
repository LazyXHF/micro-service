package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.*;
import com.portjs.base.entity.*;
import com.portjs.base.service.ProjectManagerService;
import com.portjs.base.service.ProjectPreservationService;
import com.portjs.base.util.Code;
import com.portjs.base.util.IDUtils;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.StringUtils.StringUtils;
import com.portjs.base.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.naming.spi.DirStateFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by dengshuangzhen on 2019\3\28 0028
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProjectPreservationImpl implements ProjectPreservationService {
    @Autowired
    private ProjectApplicationMapper applicationMapper;
    @Autowired
    private ProjectMembersMapper membersMapper;
    @Autowired
    private InternalAttachmentMapper attachmentMapper;
    @Autowired
    private TWorkflowstepMapper workflowstepMapper;
    @Autowired
    private TXietongDictionaryMapper dictionaryMapper;
    @Autowired
    private TTodoMapper todoMapper;

    //返参信息
    public final static String PARAM_MESSAGE_1 = "未传";
    public final static String PARAM_MESSAGE_2 = "已存在";
    /**
     * 立项暂存/提交
     * @param responseBody
     * @return
     */
    @Override
    public ResponseMessage insertStorage(String responseBody)throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(responseBody);
        String status = jsonObject.getString("Status");//0暂存7提交
        String userId = jsonObject.getString("UserId");//登录用户
        JSONObject application1JSON = jsonObject.getJSONObject("Application");
        JSONArray arrayJSON = jsonObject.getJSONArray("Persons");
        JSONArray resourcesJSON = jsonObject.getJSONArray("Files");
        JSONArray nextViewJSON = jsonObject.getJSONArray("NextViews");

        if(StringUtils.isEmpty(status)){
            return new ResponseMessage(Code.CODE_ERROR,"Status"+PARAM_MESSAGE_1);
        }
        if(StringUtils.isEmpty(userId)){
            return new ResponseMessage(Code.CODE_ERROR,"UserId"+PARAM_MESSAGE_1);
        }
        if(StringUtils.isEmpty(application1JSON)){
            return new ResponseMessage(Code.CODE_ERROR,"Application"+PARAM_MESSAGE_1);
        }
        if(CollectionUtils.isEmpty(arrayJSON)){
            return new ResponseMessage(Code.CODE_ERROR,"Persons"+PARAM_MESSAGE_1);
        }
        if(CollectionUtils.isEmpty(resourcesJSON)){
            return new ResponseMessage(Code.CODE_ERROR,"Files"+PARAM_MESSAGE_1);
        }
        String message1="";
        String message2="";
        //0暂存
        if(status.equals("0")){
            message1="暂存失败";
            message2="更新失败";
            //暂存状态，不用接收负责人
            nextViewJSON.clear();
        }else{
          //提交
            message1="提交失败";
            message2="提交失败";
        }
        //项目基本信息
        ProjectApplication application = JSONObject.toJavaObject(application1JSON,ProjectApplication.class);
        application.setStatus(status);
        //插入还是更新
        if(StringUtils.isEmpty(application.getId())){
            application.setId(String.valueOf(IDUtils.genItemId()));
            application.setCreater(userId);
            int i = applicationMapper.insertSelective(application);
            if(i!=1){
                return new ResponseMessage(Code.CODE_ERROR,message1);
            }
        }else{
            application.setUpdateTime(new Date());
            int i = applicationMapper.updateByPrimaryKeySelective(application);
            if(i!=1){
                return new ResponseMessage(Code.CODE_ERROR,message2);
            }
        }
        //新增人员 先删除后增加
        ProjectMembersExample exampleMem = new ProjectMembersExample();
        ProjectMembersExample.Criteria criteriaMem = exampleMem.createCriteria();
        criteriaMem.andApplicationIdEqualTo(application.getId());
        membersMapper.deleteByExample(exampleMem);
        //增加人员
        for(int i=0;i<arrayJSON.size();i++){
            JSONObject object = arrayJSON.getJSONObject(i);
            ProjectMembers projectMembers = JSONObject.toJavaObject(object,ProjectMembers.class);
            projectMembers.setId(String.valueOf(IDUtils.genItemId()));
            projectMembers.setApplicationId(application.getId());
            projectMembers.setCreater(userId);
            projectMembers.setCreateTime(new Date());
            int num = membersMapper.insertSelective(projectMembers);
            if(num<=0){
                return new ResponseMessage(Code.CODE_ERROR,"未知异常");
            }
        }
        //新增立项 先删除后增加
        InternalAttachmentExample exampleIn = new InternalAttachmentExample();
        InternalAttachmentExample.Criteria criteriaIn = exampleIn.createCriteria();
        criteriaIn.andRelateddomainIdEqualTo(application.getId());
        attachmentMapper.deleteByExample(exampleIn);
        //增加附件
        for(int i=0;i<resourcesJSON.size();i++){
            JSONObject object = resourcesJSON.getJSONObject(i);
            InternalAttachment projectMembers = JSONObject.toJavaObject(object,InternalAttachment.class);
            projectMembers.setId(String.valueOf(IDUtils.genItemId()));
            projectMembers.setUploadTime(new Date());
            projectMembers.setUploader(userId);
            projectMembers.setRelateddomain("项目立项模块");
            projectMembers.setRelateddomainId(application.getId());
            int num = attachmentMapper.insertSelective(projectMembers);
            if(num<=0){
                return new ResponseMessage(Code.CODE_ERROR,"未知异常");
            }
        }

        //进入审核
        for(int i=0;i<nextViewJSON.size();i++){
            //然后新增一条当前登录人的流程记录
            TWorkflowstep workflowstep = new TWorkflowstep();
            workflowstep.setId(String.valueOf(IDUtils.genItemId()));
            workflowstep.setRelateddomain("项目立项");
            workflowstep.setPrestepId("0");
            workflowstep.setRelateddomainId(application.getId());
            workflowstep.setStepDesc("项目负责人提交");
            workflowstep.setActionuserId(userId);
            workflowstep.setActionTime(new Date());
            workflowstep.setStatus("1");
            workflowstep.setBackup3("1");

            int i3 = workflowstepMapper.insertSelective(workflowstep);
            if(i3!=1){
                return new ResponseMessage(Code.CODE_ERROR,"提交失败");
            }
            //接下来再新增一条部门负责人的流程记录
            TWorkflowstep tWorkflowstep = new TWorkflowstep();
            tWorkflowstep.setId(String.valueOf(IDUtils.genItemId()));
            tWorkflowstep.setRelateddomain("项目立项");
            tWorkflowstep.setRelateddomainId(application.getId());
            tWorkflowstep.setPrestepId(workflowstep.getId());
            tWorkflowstep.setStepDesc("部门负责人审核");
            tWorkflowstep.setActionuserId(nextViewJSON.getString(i));
            tWorkflowstep.setActionTime(new Date());
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
            int i5 = todoMapper.insertSelective(todo);
            if(i5!=1){
                return new ResponseMessage(Code.CODE_ERROR,"提交失败");
            }
            return new ResponseMessage(Code.CODE_OK,"提交成功");
        }
        return new ResponseMessage(Code.CODE_OK,"操作成功");
    }

    /**
     * 立项退回
     * @param responseBody
     * @return
     */
    @Override
    public ResponseMessage returnStorage(String responseBody)throws Exception {
            JSONObject jsonObject = JSONObject.parseObject(responseBody);
            String application_id = jsonObject.getString("application_id");//立项记录id
            String workflowstep_id = jsonObject.getString("workflowstep_id");//立项流程id
            String stepDesc = jsonObject.getString("stepDesc");//当前流程步骤
            String stepDesc1 =  stepDesc.substring(0,stepDesc.length()-2);

            String user_id  = jsonObject.getString("user_id");//当前登录人id

            //判断现在是哪一步退回如果是技术委员退回则判断是否是最后一个人退回
            TWorkflowstepExample example = new TWorkflowstepExample();
            TWorkflowstepExample.Criteria criteria = example.createCriteria();
            criteria.andRelateddomainIdEqualTo(application_id);
            criteria.andStatusEqualTo("0");
            List<TWorkflowstep> tWorkflowsteps = workflowstepMapper.selectByExample(example);
            if(tWorkflowsteps.size()==1){
                    //如果当前审核人员只有一个的话则生成待办
                    TTodo todo = new TTodo();
                    todo.setId(String.valueOf(IDUtils.genItemId()));
                    todo.setCurrentstepId(workflowstep_id);
                    todo.setStepDesc(stepDesc1+"退回");
                    todo.setRelateddomain("项目立项");
                    todo.setRelateddomainId(application_id);
                    todo.setSenderId(user_id);
                    todo.setSenderTime(new Date());
                    ProjectApplication application = applicationMapper.selectByPrimaryKey(application_id);
                    todo.setReceiverId(application.getCreater());
                    //查询代办类型
                    TXietongDictionaryExample example1 = new TXietongDictionaryExample();
                    TXietongDictionaryExample.Criteria criteria1 = example1.createCriteria();
                    criteria1.andTypeIdEqualTo("8");
                    criteria1.andTypeCodeEqualTo("38");
                    criteria1.andMidValueEqualTo("1");
                    List<TXietongDictionary> dictionaryList = dictionaryMapper.selectByExample(example1);
                    todo.setTodoType(dictionaryList.get(0).getMainValue());
                    todo.setStatus("0");
                    int i1 = todoMapper.insertSelective(todo);
                    if(i1!=1){
                        return new ResponseMessage(Code.CODE_ERROR,"退回失败");
                    }
                }
            //将当前对应流程关闭
            TWorkflowstep workflowstep = new TWorkflowstep();
            workflowstep.setId(workflowstep_id);
            workflowstep.setStatus("1");
            int i = workflowstepMapper.updateByPrimaryKeySelective(workflowstep);
            if(i==0){
                return new ResponseMessage(Code.CODE_ERROR,"退回失败");
            }
            //新增一条退回流程
            TWorkflowstep tWorkflowstep = new TWorkflowstep();
            tWorkflowstep.setId(String.valueOf(IDUtils.genItemId()));
            tWorkflowstep.setRelateddomain("项目立项");
            tWorkflowstep.setRelateddomainId(application_id);
            tWorkflowstep.setPrestepId(workflowstep.getId());
            tWorkflowstep.setStepDesc(stepDesc1+"退回");
            tWorkflowstep.setActionuserId(user_id);
            tWorkflowstep.setActionTime(new Date());
            tWorkflowstep.setStatus("1");
            int i4 = workflowstepMapper.insertSelective(tWorkflowstep);
            if(i4!=1){
                return new ResponseMessage(Code.CODE_ERROR,"退回失败");
            }
            return new ResponseMessage(Code.CODE_OK,"退回成功");
    }
}
