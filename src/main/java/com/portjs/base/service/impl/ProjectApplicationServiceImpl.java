package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.*;
import com.portjs.base.entity.*;
import com.portjs.base.service.AcceptanceService;
import com.portjs.base.service.ProjectApplicationService;
import com.portjs.base.util.Code;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.StringUtils.StringUtils;
import com.portjs.base.util.UserUtils;
import org.apache.juli.logging.LogFactory;
import org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi;
import org.omg.CORBA.CODESET_INCOMPATIBLE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author gumingyang
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class ProjectApplicationServiceImpl implements ProjectApplicationService {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    ProjectApplicationMapper applicationMapper;
    @Autowired
    TWorkflowstepMapper tWorkflowstepMapper;
    @Autowired
    ProjectMembersMapper projectMembersMapper;
    @Autowired
    InternalAttachmentMapper internalAttachmentMapper;
    @Override
    public ResponseMessage updateProject(JSONObject requestJson) {
        try {
            String id = requestJson.getString("id");
            String projectCode = requestJson.getString("projectCode");
            String projectName = requestJson.getString("projectName");
            String projectType = requestJson.getString("projectType");
            String leval = requestJson.getString("leval");
            String projectDesc = requestJson.getString("projectDesc");
            String organization = requestJson.getString("organization");
            String range1=requestJson.getString("range");
            Date kickoffDate = requestJson.getDate("kickoffDate");
            String creater = requestJson.getString("creater");
            Date createTime = requestJson.getDate("createTime");
            Date updateTime = requestJson.getDate("updateTime");
            String enable = requestJson.getString("enable");
            ProjectApplication projectApplication = new ProjectApplication();
            projectApplication.setId(id);
            projectApplication.setProjectCode(projectCode);
            projectApplication.setProjectName(projectName);
            projectApplication.setProjectType(projectType);
            projectApplication.setLeval(leval);
            projectApplication.setProjectDesc(projectDesc);
            projectApplication.setOrganization(organization);
            projectApplication.setRange1(range1);
            projectApplication.setKickoffDate(kickoffDate);
            projectApplication.setCreater(creater);
            projectApplication.setCreateTime(createTime);
            projectApplication.setUpdateTime(updateTime);
            projectApplication.setEnable(enable);
            int f = applicationMapper.updateProject(projectApplication);
            if (f != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "更新项目信息失败");
            }
            return new ResponseMessage(Code.CODE_OK, "更新项目信息成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("updateProject() erroe",e);
            return  new ResponseMessage(Code.CODE_ERROR, "服务器错误", e);

        }
    }

    @Override
    public ResponseMessage queryProject(JSONObject requestJson) {
      /*  ProjectApplication annex = JSONObject.toJavaObject(requestJson, ProjectApplication.class);*/
        String owneId=requestJson.getString("ownerId");
        String projectCode=requestJson.getString("projectCode");
        String projectType=requestJson.getString("projectType");
        String creater=requestJson.getString("creater");
        String status=requestJson.getString("stepDesc");
        String pageNum=requestJson.getString("pageNum");
        String pageCount=requestJson.getString("pageCount");
        Page page=new Page();
        int totalCount=applicationMapper.queryProjectCount(projectCode,projectType,creater,status);
        page.init(totalCount,Integer.valueOf(pageNum),Integer.valueOf(pageCount));

        List<ProjectApplication> list=applicationMapper.queryProject(projectCode,projectType,creater,status,page.getRowNum(),page.getPageCount());
        if(list.isEmpty()){
            return  new ResponseMessage(Code.CODE_OK,"查询项目信息为空");
        }else{
            for(ProjectApplication application:list){
              String id=application.getId();
                //查询当前登录人是否是审批人
              String approverId=tWorkflowstepMapper.isApproveingId(id);
              if(owneId.equals(approverId)){
                  application.setIsApprover("1");
              }else {
                  application.setIsApprover("0");
              }}
            page.setList(list);
            return  new ResponseMessage(Code.CODE_OK,"项目分页信息",page);
            }
         }

    @Override
    public ResponseMessage queryProjectBase(JSONObject requestJson){
        String id=requestJson.getString("id");
        ProjectApplication projectApplication=applicationMapper.queryProjectBase(id);
        if(StringUtils.isNull(projectApplication)){
        return  new ResponseMessage(Code.CODE_OK,"项目信息查询失败");
        }else {
            return  new ResponseMessage(Code.CODE_OK,"项目基本信息",projectApplication);
        }

    }

    @Override
    public ResponseMessage queryProjectPersons(JSONObject requestJson) {
        String id=requestJson.getString("id");
        String pageNum=requestJson.getString("pageNum");
        String pageCount=requestJson.getString("pageCount");
        Page page=new Page();
        int totalCount=projectMembersMapper.queryProjectPersonsCount(id);
        page.init(totalCount,Integer.valueOf(pageNum),Integer.valueOf(pageCount));
        List<ProjectApplication> projectApplicationList=projectMembersMapper.queryProjectPersons(id);
        if(projectApplicationList.isEmpty()){
            return  new ResponseMessage(Code.CODE_OK,"项目人员信息查询失败");
        }else {
            page.setList(projectApplicationList);
            return  new ResponseMessage(Code.CODE_OK,"项目基本信息",page);
        }

    }

    @Override
    public ResponseMessage queryProjectFiles(JSONObject requestJson) {
        String id=requestJson.getString("id");
        List<InternalAttachment> internalAttachments=internalAttachmentMapper.queryProjectFiles(id);
        if(StringUtils.isNull(internalAttachments)){
            return  new ResponseMessage(Code.CODE_OK,"立项文件信息查询失败");
        }else {
            return  new ResponseMessage(Code.CODE_OK,"立项文件列表",internalAttachments);
        }
    }

    @Override
    public ResponseMessage queryProjectRecords(JSONObject requestJson) {
        String id=requestJson.getString("id");
        List<TWorkflowstep> tWorkflowsteps=tWorkflowstepMapper.queryProjectRecords(id);
        if(StringUtils.isNull(tWorkflowsteps)){
            return  new ResponseMessage(Code.CODE_OK,"审批信息查询失败");
        }else {
            return  new ResponseMessage(Code.CODE_OK,"审批信息列表",tWorkflowsteps);
        }
    }

    @Override
    public ResponseMessage deleteProject(JSONObject requestJson) {
        String id=requestJson.getString("id");
        int f=applicationMapper.deleteProject(id);
        if(f!=1){
            return  new ResponseMessage(Code.CODE_ERROR,"删除失败");
        }
        return  new ResponseMessage(Code.CODE_OK,"删除成功");
    }

    @Override
    public ResponseMessage queryProjectPlan(JSONObject requestJson) {
        return null;
    }

}
