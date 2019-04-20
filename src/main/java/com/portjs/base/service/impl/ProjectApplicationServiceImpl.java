package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

import java.util.*;

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
    @Autowired
    InvestmentPlanMapper investmentPlanMapper;
    @Autowired
    TTodoMapper todoMapper;
    @Autowired
    TUserMapper tUserMapper;
    @Autowired
    private ProjectDeclarationMapper declarationMapper;
    @Autowired
    private BusinessConfigurationMapper configurationMapper;
    @Autowired
    private ProjectBudgetMapper budgetMapper;
    @Override
    @Transactional(rollbackFor = Exception.class)
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
        //项目编码
        String projectCode=requestJson.getString("projectCode");
        //项目名称
        String projectName=requestJson.getString("projectName");
        //申请部门（业务单位）
        String organization=requestJson.getString("organization");
        //项目等级
        String leval=requestJson.getString("leval");
        //项目类型
        String projectType=requestJson.getString("projectType");
        //承建负责人
        String projectManager=requestJson.getString("projectManager");

        String owneId=requestJson.getString("ownerId");
        String pageNum=requestJson.getString("pageNum");
        String pageCount=requestJson.getString("pageCount");

        int totalCount=applicationMapper.queryProjectCount(projectCode,projectName,projectType,organization,leval,projectManager,owneId);
        List<ProjectApplication> alllist=applicationMapper.queryProject(projectCode,projectName,projectType,organization,leval,projectManager,owneId);
        if(alllist.isEmpty()){
            return  new ResponseMessage(Code.CODE_OK,"查询项目信息为空");
        }else {
            for (ProjectApplication application : alllist) {
                TTodoExample todoExample = new TTodoExample();
                TTodoExample.Criteria todoCriteria = todoExample.createCriteria();
                todoCriteria.andStatusEqualTo("0");
                todoCriteria.andRelateddomainIdEqualTo(application.getId());
                todoCriteria.andReceiverIdEqualTo(owneId);
                List<TTodo> tTodos = todoMapper.selectByExample(todoExample);
                List<TWorkflowstep> tworkList= tWorkflowstepMapper.queryProjectRecords(application.getId());
                if(tworkList!=null&&tworkList.size()>0) {
                    String ownerId2 = tworkList.get(0).getActionuserId();
                    if (ownerId2.equals(owneId)) {
                        application.setIsRight("1");
                    } else {
                        application.setIsRight("0");
                    }
                }else {
                    application.setIsRight("0");
                }
                //isApprove(当前任是否是审批人 0：不是 1：是)
                if (CollectionUtils.isEmpty(tTodos)) {
                    application.setIsApprover("0");
                } else {
                    application.setIsApprover("1");
                }
            }

            Set<ProjectApplication> treeSet = new TreeSet<>(new Comparator<ProjectApplication>() {
                @Override
                public int compare(ProjectApplication o1, ProjectApplication o2) {
                    //按照年龄排序，主要条件
                    int num =Integer.parseInt(o2.getIsApprover())- Integer.parseInt(o1.getIsApprover());
                    //如果年龄相同，比较姓名，如果姓名相同的话，才是同一个对象
                    int num1 = num == 0 ? 1 : num;
                    return num1;
                }
            });
            treeSet.addAll(alllist);

            Page page=new Page();
            ArrayList arrayList = new ArrayList(treeSet);
            page.init(totalCount,Integer.valueOf(pageNum),Integer.valueOf(pageCount));
            System.out.println(page);
            if(page.getRowNum()+page.getPageCount()>arrayList.size()){
                page.setList(arrayList.subList(page.getRowNum(),arrayList.size()));
            }else {
                page.setList(arrayList.subList(page.getRowNum(), page.getPageCount() * page.getPageNum()));
            }
            return new ResponseMessage(Code.CODE_OK, "项目分页信息", page);
        }
    }



    @Override
    public ResponseMessage queryProjectBase(JSONObject requestJson) throws Exception{

        String id=requestJson.getString("id");//application(基本信息表id)
        String projectId=requestJson.getString("projectId");//项目id
        String pageNum=requestJson.getString("pageNum");//当前页数（人员分页信息）
        String pageCount=requestJson.getString("pageCount");//每页显示记录数（人员分页信息）
        String ownerId=requestJson.getString("ownerId");//当前登录人id


        LinkedHashMap<String, Object> map = new LinkedHashMap();
        //查询基本信息
        ProjectApplication projectApplication=applicationMapper.queryProjectBase(id);
        if(projectApplication==null){
            /*return  new ResponseMessage(Code.CODE_OK,"项目信息查询失败");*/
            throw new Exception("项目基本信息查询失败");

        }

        //查询申报信息
        ProjectDeclarationExample declarationExample = new ProjectDeclarationExample();
        ProjectDeclarationExample.Criteria declarationCriteria = declarationExample.createCriteria();
        declarationCriteria.andApplicationIdEqualTo(id);
        List<ProjectDeclaration> projectDeclarations = declarationMapper.selectByExample(declarationExample);
        if(CollectionUtils.isEmpty(projectDeclarations)){
            /*return  new ResponseMessage(Code.CODE_OK,"申报信息查询失败");*/
            throw new Exception("申报信息查询失败");
        }
        //查询里程碑
        BusinessConfigurationExample configurationExample = new BusinessConfigurationExample();
        BusinessConfigurationExample.Criteria configurationCriteria = configurationExample.createCriteria();
        configurationCriteria.andProjectIdEqualTo(projectId);
        List<BusinessConfiguration> businessConfigurations = configurationMapper.selectByExample(configurationExample);
        Page page=new Page();
        //查询人员信息
        int totalCount=projectMembersMapper.queryProjectPersonsCount(id);
        page.init(totalCount,Integer.valueOf(pageNum),Integer.valueOf(pageCount));

        List<ProjectMembers> members=projectMembersMapper.queryProjectPersons(id,page.getRowNum(),page.getPageCount());
        page.setList(members);
        //查询项目预算
        ProjectBudgetExample budgetExample = new ProjectBudgetExample();
        ProjectBudgetExample.Criteria budgetCriteria = budgetExample.createCriteria();
        budgetCriteria.andApplicationIdEqualTo(id);
        List<ProjectBudget> projectBudgets = budgetMapper.selectByExample(budgetExample);
        //查询项目文件
        List<InternalAttachment> internalAttachments=internalAttachmentMapper.queryProjectFiles(id);
        //审核信息查询
        List<TWorkflowstep> tWorkflowsteps=tWorkflowstepMapper.queryProjectRecords(id);
        if(!CollectionUtils.isEmpty(tWorkflowsteps)){
            for(TWorkflowstep tWorkflowstep:tWorkflowsteps){
                String actionUserId=tWorkflowstep.getActionuserId();
                String userName=tUserMapper.queryUserNameByUserId(actionUserId);
                tWorkflowstep.setUserName(userName);
            }
        }
        //待办信息查询
        List<TTodo> tTodo=todoMapper.toApprove(id,ownerId);
        map.put("Application",projectApplication);
        map.put("Declaration",projectDeclarations);
        map.put("Configuration",businessConfigurations);
        map.put("Persons",page);
        map.put("Budget",projectBudgets);
        map.put("Files",internalAttachments);
        map.put("Records",tWorkflowsteps);
        map.put("Todo",tTodo);
        return  new ResponseMessage(Code.CODE_OK,"项目信息",map);
    }

    @Override
    public ResponseMessage queryProjectPersons(JSONObject requestJson) {
        String id=requestJson.getString("id");
        String pageNum=requestJson.getString("pageNum");
        String pageCount=requestJson.getString("pageCount");
        Page page=new Page();
        int totalCount=projectMembersMapper.queryProjectPersonsCount(id);
        page.init(totalCount,Integer.valueOf(pageNum),Integer.valueOf(pageCount));
        List<ProjectMembers> projectApplicationList=projectMembersMapper.queryProjectPersons(id,page.getRowNum(),page.getPageCount());
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
            for(TWorkflowstep tWorkflowstep:tWorkflowsteps){
              String actionUserId=tWorkflowstep.getActionuserId();
              String userName=tUserMapper.queryUserNameByUserId(actionUserId);
              tWorkflowstep.setUserName(userName);
            }
            return  new ResponseMessage(Code.CODE_OK,"审批信息列表",tWorkflowsteps);
        }
    }

    @Override
    public ResponseMessage deleteProject(JSONObject requestJson) {
        String id=requestJson.getString("id");
        String ownerId=requestJson.getString("ownerId");
        int count=todoMapper.queryTodoRecord(id,ownerId);
        if(count>0){
         int f=todoMapper.deleteTodoRecord(id,ownerId);
         if(f!=1){
             return  new ResponseMessage(Code.CODE_ERROR,"删除失败");
         }
        }
        int f=applicationMapper.deleteProject(id);
        if(f!=1){
            return  new ResponseMessage(Code.CODE_ERROR,"删除失败");
        }

        return  new ResponseMessage(Code.CODE_OK,"删除成功");
    }

    @Override
    public ResponseMessage queryProjectPlan() {
        //筛选未选用的的投资计划方式
        List<InvestmentPlan>  list=investmentPlanMapper.queryProjectPlan();
         /*  List<InvestmentPlan>  data=new ArrayList<InvestmentPlan>();
           for ( InvestmentPlan p : list){
            ProjectApplicationExample todoExample = new ProjectApplicationExample();
            ProjectApplicationExample.Criteria todoCriteria = todoExample.createCriteria();
            todoCriteria.andProjectIdEqualTo(p.getProjectId());
            List<ProjectApplication> dataList = applicationMapper.selectByExample(todoExample);
            if(CollectionUtils.isEmpty(dataList)){
                data.add(p);
            }
        }*/
        if(list.isEmpty()){
            return  new ResponseMessage(Code.CODE_ERROR,"下拉信息为空");
        }
        return  new ResponseMessage(Code.CODE_OK,"投资列表信息",list);
    }

    @Override
    public ResponseMessage queryProjectPlanInfo(JSONObject requestJson) {
        String id=requestJson.getString("id");
        InvestmentPlan investmentPlan=investmentPlanMapper.queryProjectPlanInfo(id);
        if(StringUtils.isNull(investmentPlan)){
            return  new ResponseMessage(Code.CODE_OK,"立项投资对应项目信息查询为空");
        }else {
            return  new ResponseMessage(Code.CODE_OK,"立项文件列表",investmentPlan);
        }
    }

    @Override
    public ResponseMessage toApprove(JSONObject requestJson) {
        String id=requestJson.getString("id");
        String ownerId=requestJson.getString("ownerId");
        List<TTodo> tTodo=todoMapper.toApprove(id,ownerId);
        if(StringUtils.isNull(tTodo)){
            return  new ResponseMessage(Code.CODE_OK,"待审核人为空为空");
        }else {
            return  new ResponseMessage(Code.CODE_OK,"立项文件列表",tTodo);
        }
    }

    @Override
    public ResponseMessage abolishProject(JSONObject requestJson) {
        String  id=requestJson.getString("id");
        String  ownerId=requestJson.getString("ownerId");

        int f=applicationMapper.abolishProject(id);
        if(f!=1){
            return  new ResponseMessage(Code.CODE_ERROR,"废除数据失败");
        }

       int f1=todoMapper.deleteTodoRecord(id,ownerId);
        if(f1!=1){
            return  new ResponseMessage(Code.CODE_ERROR,"废除待办记录失败");
        }
        return new ResponseMessage(Code.CODE_OK,"废除记录成功");
    }

}
