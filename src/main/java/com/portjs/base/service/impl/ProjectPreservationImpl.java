package com.portjs.base.service.impl;

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

    /**
     * 立项暂存/提交
     * @param responseBody
     * @return
     */
    @Override
    public ResponseMessage insertStorage(String responseBody) {
        try {
            JSONObject jsonObject = JSONObject.parseObject(responseBody);
            //项目基本信息
            String project_name = jsonObject.getString("project_name");//项目名称
            String project_type = jsonObject.getString("project_type");//项目类型
            String leval = jsonObject.getString("leval");//项目等级
            String organization = jsonObject.getString("organization");//责任单位
            String range = jsonObject.getString("range");//实施范围
            String kickoff_date = jsonObject.getString("kickoff_date");//启动日期
            String project_desc = jsonObject.getString("project_desc");//项目描述
            String file_url1 = jsonObject.getString("file_url1");//立项附件
            //项目人员
            String name = jsonObject.getString("name");//人员名称
            String type = jsonObject.getString("type");//资源分类
            String sort = jsonObject.getString("sort");//人员分类
            String unit = jsonObject.getString("unit");//单位
            //立项文件
            String file_type = jsonObject.getString("file_type");//文件类型
            String file_name = jsonObject.getString("file_name");//文件名称
            String file_url = jsonObject.getString("file_url");//文件路径
            //审批流程
            String id = jsonObject.getString("id");//部门负责人id
            //当前登录人
            String user_id = jsonObject.getString("user_id");
            //项目状态（0暂存1提交）
            String status = jsonObject.getString("status");

            //首先新增项目基本信息
            ProjectApplication application = new ProjectApplication();
            application.setId(String.valueOf(IDUtils.genItemId()));
            application.setProjectName(project_name);
            application.setProjectType(project_type);
            application.setLeval(leval);
            application.setOrganization(organization);
            application.setRange1(range);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            application.setKickoffDate(format.parse(kickoff_date));
            application.setCreater(user_id);
            application.setProjectDesc(project_desc);
            application.setFileUrl(file_url1);
            application.setStatus(status);
            int i = applicationMapper.insertSelective(application);
            if(i!=1){
                return new ResponseMessage(Code.CODE_ERROR,"暂存失败");
            }
            //然后新增项目人员信息
            ProjectMembers members = new ProjectMembers();
            members.setId(String.valueOf(IDUtils.genItemId()));
            members.setApplicationId(application.getId());
            members.setName(name);
            members.setType(type);
            members.setSort(sort);
            members.setUnit(unit);
            members.setCreater(user_id);
            members.setCreateTime(new Date());
            int i1 = membersMapper.insertSelective(members);
            if(i1!=1){
                return new ResponseMessage(Code.CODE_ERROR,"暂存失败");
            }
            //接下来新增立项文件信息
            InternalAttachment attachment = new InternalAttachment();
            attachment.setId(String.valueOf(IDUtils.genItemId()));
            attachment.setUploadTime(new Date());
            attachment.setUploader(user_id);
            attachment.setRelateddomain("项目立项");
            attachment.setFileUrl(file_url);
            attachment.setRelateddomainId(application.getId());
            attachment.setFileType(file_type);
            attachment.setFileName(file_name);
            int i2 = attachmentMapper.insertSelective(attachment);
            if(i2!=1){
                return new ResponseMessage(Code.CODE_ERROR,"暂存失败");
            }
            if("1".equals(status)){
                //当项目状态为提交时首先判断登录人id和部门负责人id是否为空
                if(StringUtils.isEmpty(user_id)||StringUtils.isEmpty(id)){
                    return new ResponseMessage(Code.CODE_ERROR,"登录人id或者部门负责人id不能为空");
                }
                //然后新增一条当前登录人的流程记录
                TWorkflowstep workflowstep = new TWorkflowstep();
                workflowstep.setId(String.valueOf(IDUtils.genItemId()));
                workflowstep.setRelateddomain("项目立项");
                workflowstep.setRelateddomainId(application.getId());
                workflowstep.setStepDesc("项目负责人提交");
                workflowstep.setActionuserId(user_id);
                workflowstep.setActionTime(new Date());
                workflowstep.setStatus("1");

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
                tWorkflowstep.setActionuserId(id);
                tWorkflowstep.setActionTime(new Date());
                tWorkflowstep.setStatus("0");

                int i4 = workflowstepMapper.insertSelective(tWorkflowstep);
                if(i4!=1){
                    return new ResponseMessage(Code.CODE_ERROR,"提交失败");
                }
                //最后新增一条代办
                TTodo todo = new TTodo();
                todo.setId(String.valueOf(IDUtils.genItemId()));
                todo.setCurrentstepId(tWorkflowstep.getId());
                todo.setStepDesc("提交审核");
                todo.setRelateddomain("项目立项");
                todo.setRelateddomainId(application.getId());
                todo.setSenderId(user_id);
                todo.setSenderTime(new Date());
                todo.setReceiverId(id);
                //查询代办类型
                TXietongDictionaryExample example = new TXietongDictionaryExample();
                TXietongDictionaryExample.Criteria criteria = example.createCriteria();
                criteria.andTypeIdEqualTo("8");
                criteria.andTypeCodeEqualTo("38");
                criteria.andMidValueEqualTo("1");
                List<TXietongDictionary> dictionaryList = dictionaryMapper.selectByExample(example);
                todo.setTodoType(dictionaryList.get(0).getMainValue());
                todo.setStatus("0");
                int i5 = todoMapper.insertSelective(todo);
                if(i5!=1){
                    return new ResponseMessage(Code.CODE_ERROR,"提交失败");
                }
                return new ResponseMessage(Code.CODE_OK,"提交成功");
            }

            return new ResponseMessage(Code.CODE_OK,"暂存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(Code.CODE_ERROR,"服务器异常");
        }
    }

    /**
     * 立项退回
     * @param responseBody
     * @return
     */
    @Override
    public ResponseMessage returnStorage(String responseBody) {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(Code.CODE_ERROR,"服务器异常");
        }
    }
}
