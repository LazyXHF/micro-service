package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.portjs.base.dao.*;
import com.portjs.base.entity.*;
import com.portjs.base.service.AcceptanceService;
import com.portjs.base.service.ProjectApplicationService;
import com.portjs.base.util.*;
import com.portjs.base.util.StringUtils.StringUtils;
import com.portjs.base.util.workflow.ApplicationUserConfig;
import org.apache.juli.logging.LogFactory;
import org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi;
import org.omg.CORBA.CODESET_INCOMPATIBLE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
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
/*@ConfigurationProperties("workflower.properties")*/
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

    @Value("${lxfgRoleId}")
    public String lxFgRoleId;
    @Autowired
    private ProjectBudgetMapper budgetMapper;
    @Autowired
    private TUserMapper userMapper;
    @Autowired
    private TDepartmentMapper departmentMapper;
    @Autowired
    private TRoleMapper roleMapper;
    @Autowired
    private ApplicationUserConfig applicationUserConfig;
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
        LinkedList<ProjectApplication> alllist=applicationMapper.queryProject(projectCode,projectName,projectType,organization,leval,projectManager,owneId);
        if(CollectionUtils.isEmpty(alllist)){
            return  new ResponseMessage(Code.CODE_OK,"暂无数据");
        }else {
            for (ProjectApplication application : alllist) {
                TTodoExample todoExample = new TTodoExample();
                TTodoExample.Criteria todoCriteria = todoExample.createCriteria();
                todoCriteria.andStatusEqualTo("0");
                todoCriteria.andRelateddomainIdEqualTo(application.getId());
                todoCriteria.andReceiverIdEqualTo(owneId);

                List<TWorkflowstep> tworkList= tWorkflowstepMapper.queryProjectRecords(application.getId());
                if(!CollectionUtils.isEmpty(tworkList)) {
                    String ownerId2 = tworkList.get(0).getActionuserId();
                    if (ownerId2.equals(owneId)) {
                        application.setIsRight("1");
                    } else {
                        application.setIsRight("0");
                    }
                }else {
                    application.setIsRight("0");
                }
                List<TTodo> tTodos = todoMapper.selectByExample(todoExample);
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
        /*String type = requestJson.getString("type");//类型*/

        LinkedHashMap<String, Object> map = new LinkedHashMap();
        //查询基本信息
        ProjectApplication projectApplication=applicationMapper.queryProjectBase(id);
        if(projectApplication==null){
            /*return  new ResponseMessage(Code.CODE_OK,"项目信息查询失败");*/
            throw new Exception("项目基本信息查询失败");

        }
        TUser tUser = userMapper.selectByPrimaryKey(ownerId);
        TDepartment tDepartment = departmentMapper.selectByPrimaryKey(tUser.getDepartmentId());
        //status项目状态0草稿1部门负责人审核 2:分管领导审核3：技术委员会审核4：总经办审核5：规划部归档6:已完成7:提交8:退回 9:废除
        LinkedList list = new LinkedList();
        if(projectApplication.getStatus().equals("0")){
            //草稿时查询部门负责人（根据当前登录人 查询当前登录人所在部门 然后查询部门对应负责人）


            if (!StringUtils.isEmpty(tDepartment.getLeaderId())){
                TUser user = userMapper.selectByPrimaryKey(tDepartment.getLeaderId());
                list.add(user);
            }
        }else if(projectApplication.getStatus().equals("1")){
            //部门负责人审核时查询分管领导通过角色查询人员

            List<TUser> users = tUserMapper.selectUserByRoleId(applicationUserConfig.getLxfgRoleId());
            list.addLast(users);
        }else if(projectApplication.getStatus().equals("2")){
            //分管领导审核时通过角色查询所有技术委员会成员
            List<TUser> users = tUserMapper.selectUserByRoleId(applicationUserConfig.getLxjswyhRoleId());
            list.addLast(users);
        }else if(projectApplication.getStatus().equals("3")){
            //技术委员会审核时通过角色查询总经办
            List<TUser> users = tUserMapper.selectUserByRoleId(applicationUserConfig.getLxzjbRoleId());
            list.addLast(users);
        }else if(projectApplication.getStatus().equals("4")){
            //技术委员会审核时通过角色查询总经办
            List<TUser> users = tUserMapper.selectUserByRoleId(applicationUserConfig.getLxghbRoleId());
            list.addLast(users);
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
        if(projectApplication.getType().equals("1")){
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
            map.put("Configuration",businessConfigurations);
            map.put("Persons",page);
            map.put("Budget",projectBudgets);
            map.put("Files",internalAttachments);

        }
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
        map.put("Records",tWorkflowsteps);
        map.put("Todo",tTodo);
        map.put("Users",list);
        return  new ResponseMessage(Code.CODE_OK,"项目信息",map);
    }

    /**
     *新增时查询对应部门领导
     * @param requestJson
     * @return
     */
    @Override
    public ResponseMessage selectLeader(JSONObject requestJson) {
        String loginId = requestJson.getString("loginId");
        TUser tUser = userMapper.selectByPrimaryKey(loginId);
        TDepartment tDepartment = departmentMapper.selectByPrimaryKey(tUser.getDepartmentId());
        if (!StringUtils.isEmpty(tDepartment.getLeaderId())){
            TUser user = userMapper.selectByPrimaryKey(tDepartment.getLeaderId());
            return new ResponseMessage(Code.CODE_OK,"查询成功",user);
        }
        return new ResponseMessage(Code.CODE_ERROR,"查询失败");

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

    /**
     * 立项废除
     * @param id
     * @return
     */
    @Override
    public ResponseMessage abolitionProject(String id)throws Exception {
        ProjectApplication application = new ProjectApplication();
        application.setId(id);
        application.setStatus("9");
        int i = applicationMapper.updateByPrimaryKeySelective(application);
        if(i!=1){
           throw new Exception("废除失败");
        }
        TTodoExample example = new TTodoExample();
        TTodoExample.Criteria criteria = example.createCriteria();
        criteria.andRelateddomainIdEqualTo(id);
        TTodo tTodo = new TTodo();
        tTodo.setStatus("1");
        int i1 = todoMapper.updateByExampleSelective(tTodo, example);
        /*if(i1<=0){
            throw new Exception("废除失败");
        }*/
        return new ResponseMessage(Code.CODE_OK,"废除成功");
    }


    @Override
    public ResponseMessage deleteProject(String id)throws Exception{

        /*String ownerId=requestJson.getString("ownerId");
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
        }*/
        ProjectApplication application = new ProjectApplication();
        application.setId(id);
        application.setIsDelete("1");
        int i = applicationMapper.updateByPrimaryKeySelective(application);
        if(i!=1){
            throw new Exception("删除失败");
        }
        return  new ResponseMessage(Code.CODE_OK,"删除成功");
    }

    @Override
    public ResponseMessage queryProjectPlan() {
        //筛选未选用的的投资计划方式
        List<InvestmentPlan>  list=investmentPlanMapper.queryProjectPlan();
        List<InvestmentPlan>  data=new ArrayList<InvestmentPlan>();
        if(list.isEmpty()){
            return  new ResponseMessage(Code.CODE_ERROR,"下拉信息为空");
        }
        for ( InvestmentPlan p : list){
            ProjectApplicationExample todoExample = new ProjectApplicationExample();
            ProjectApplicationExample.Criteria todoCriteria = todoExample.createCriteria();
            todoCriteria.andInvestmentIdEqualTo(p.getId());
            List<ProjectApplication> dataList = applicationMapper.selectByExample(todoExample);
            if(CollectionUtils.isEmpty(dataList)){
                data.add(p);
            }
        }

        return  new ResponseMessage(Code.CODE_OK,"投资列表信息",data);
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
