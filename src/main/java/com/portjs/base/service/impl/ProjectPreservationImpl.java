package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.*;
import com.portjs.base.entity.*;
import com.portjs.base.service.ProjectManagerService;
import com.portjs.base.service.ProjectPreservationService;
import com.portjs.base.util.*;
import com.portjs.base.util.StringUtils.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.spi.DirStateFactory;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Autowired
    private InvestmentPlanMapper planMapper;
    @Autowired
    private ProjectAddorUpdateUtil updateUtil;
    @Autowired
    private TRoleMapper roleMapper;
    @Autowired
    private TUserMapper userMapper;
    @Autowired
    private TUserRoleMapper userRoleMapper;


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
        String userName = jsonObject.getString("UserName");//登录用户名
        JSONObject application1JSON = jsonObject.getJSONObject("Application");
        JSONArray arrayJSON = jsonObject.getJSONArray("Persons");
        JSONArray resourcesJSON = jsonObject.getJSONArray("Files");
        JSONArray nextViewJSON = jsonObject.getJSONArray("NextViews");
        String tTodoId = jsonObject.getString("tTodoId");
        String projectName = jsonObject.getString("projectName");//项目名字

        if(StringUtils.isEmpty(status)){
            return new ResponseMessage(Code.CODE_ERROR,"Status"+PARAM_MESSAGE_1);
        }
        if(StringUtils.isEmpty(userId)){
            return new ResponseMessage(Code.CODE_ERROR,"UserId"+PARAM_MESSAGE_1);
        }
        if(StringUtils.isEmpty(application1JSON)){
            return new ResponseMessage(Code.CODE_ERROR,"Application"+PARAM_MESSAGE_1);
        }


        //项目基本信息
        ProjectApplication application = JSONObject.toJavaObject(application1JSON,ProjectApplication.class);
        application.setCreater(userId);
        application.setCreateTime(new Date());
        application.setStatus(status);
        application.setEnable("1");
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
            if(CollectionUtils.isEmpty(arrayJSON)){
                return new ResponseMessage(Code.CODE_ERROR,"Persons"+PARAM_MESSAGE_1);
            }
            if(CollectionUtils.isEmpty(resourcesJSON)){
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
            application.setStatus("1");
        }
        //项目基本信息
        /*ProjectApplication application = JSONObject.toJavaObject(application1JSON,ProjectApplication.class);
        application.setCreater(userId);
        application.setCreateTime(new Date());
        application.setStatus(status);*/
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

        TWorkflowstepExample workflowstepExample = new TWorkflowstepExample();
        TWorkflowstepExample.Criteria workflowstepCriteria = workflowstepExample.createCriteria();
        workflowstepCriteria.andRelateddomainIdEqualTo(application.getId());
        workflowstepCriteria.andActionResultEqualTo(1);
        List<TWorkflowstep> list = workflowstepMapper.selectByExample(workflowstepExample);
        //进入审核

        for(int i=0;i<nextViewJSON.size();i++){
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

            /*String id = String.valueOf(IDUtils.genItemId());*/

            updateUtil.projectMethod(application.getProjectId(),null,application.getProjectName(),
                    application.getProjectType(),"A",userId,application.getOrganization()
                    ,application.getApplicationAmount().toString(),"Ab2",application.getInvestor());
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
    public ResponseMessage returnStorage(String responseBody) {
            JSONObject jsonObject = JSONObject.parseObject(responseBody);
            String application_id = jsonObject.getString("application_id");//立项记录id
            String workflowstep_id = jsonObject.getString("workflowstep_id");//立项流程id
            String stepDesc = jsonObject.getString("stepDesc");//当前流程步骤
            String stepDesc1 =  stepDesc.substring(0,stepDesc.length()-2);

            String user_id  = jsonObject.getString("user_id");//当前登录人id
            String user_name  = jsonObject.getString("user_name");//当前登录人姓名
            String action  = jsonObject.getString("action_commont");//处理意见
            String todoId =  jsonObject.getString("todoId");//当前步骤待办id
            String fistId =  jsonObject.getString("fistId");//项目负责人id
            String projectName = jsonObject.getString("projectName");//项目名字

             //将当前对应流程关闭
            TWorkflowstep workflowstep = new TWorkflowstep();
            workflowstep.setId(workflowstep_id);
            workflowstep.setStepDesc(stepDesc1+"退回");
            workflowstep.setStatus("1");
            workflowstep.setActionResult(1);
            workflowstep.setActionComment(action);
            workflowstep.setActionTime(new Date());
            int i = workflowstepMapper.updateByPrimaryKeySelective(workflowstep);
            if(i==0){
                return new ResponseMessage(Code.CODE_ERROR,"退回失败");
            }
            //修改当前待办表
            TTodo tTodo = new TTodo();
            tTodo.setId(todoId);
            tTodo.setStatus("1");
            tTodo.setActiontime(new Date());
            int k = todoMapper.updateByPrimaryKeySelective(tTodo);
            if(k!=1){
                return new ResponseMessage(Code.CODE_ERROR,"退回失败");
            }

            //判断现在是哪一步退回如果是技术委员退回则判断是否是最后一个人退回
            TWorkflowstepExample example = new TWorkflowstepExample();
            TWorkflowstepExample.Criteria criteria = example.createCriteria();
            criteria.andRelateddomainIdEqualTo(application_id);
            criteria.andStatusEqualTo("0");
            List<TWorkflowstep> tWorkflowsteps = workflowstepMapper.selectByExample(example);
            if(tWorkflowsteps.size()==0){
                    //如果当前审核人员只有一个的话则生成待办
                    TTodo todo = new TTodo();
                    todo.setId(String.valueOf(IDUtils.genItemId()));
                    todo.setCurrentstepId(workflowstep_id);
                    todo.setStepDesc(projectName+"的立项批复流程等待您的处理");
                    todo.setRelateddomain("项目立项");
                    todo.setRelateddomainId(application_id);
                    todo.setSenderId(user_id);
                    todo.setSenderTime(new Date());

                    todo.setBackUp7(user_name);//发起人
                    /*ProjectApplication application = applicationMapper.selectByPrimaryKey(application_id);*/
                    todo.setReceiverId(fistId);
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

                    //改变当前立项表状态为退回
                    ProjectApplication application = new ProjectApplication();
                    application.setId(application_id);
                     application.setEnable("0");
                    application.setStatus("8");
                    int i11 = applicationMapper.updateByPrimaryKeySelective(application);
                    if(i11==0){
                        return new ResponseMessage(Code.CODE_ERROR,"退回失败");
                    }
                }

        ProjectApplication application = new ProjectApplication();
        application.setId(application_id);
        application.setEnable("0");
        int i11 = applicationMapper.updateByPrimaryKeySelective(application);
        if(i11==0){
            return new ResponseMessage(Code.CODE_ERROR,"退回失败");
        }
            //新增一条退回流程
            /*TWorkflowstep tWorkflowstep = new TWorkflowstep();
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
            }*/
            return new ResponseMessage(Code.CODE_OK,"退回成功");
    }

    /**
     * 查询项目分类/投资主体/责任单位/建设方式 (投资计划导入管理模块)
     * @return
     */
    @Override
    public ResponseMessage selectBox(String requestBody) {
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        String type = jsonObject.getString("type");//1 项目类型 2 投资主体 3 责任单位 4 建设方式
        InvestmentPlanExample example = new InvestmentPlanExample();
        example.setOrderByClause("create_time");
        List<InvestmentPlan> investmentPlans = planMapper.selectByExample(example);
        LinkedList list = new LinkedList();
        if(!investmentPlans.isEmpty()){
            for (InvestmentPlan plan: investmentPlans) {
                if(StringUtils.isEmpty(type)){
                    return new ResponseMessage(Code.CODE_OK,"查询类型不得为空");
                }else if(Integer.valueOf(type)==1){
                    list.add(plan.getProjectType());
                }else if(Integer.valueOf(type)==2){
                    list.add(plan.getInvestor());
                }else if(Integer.valueOf(type)==3){
                    list.add(plan.getOrganization());
                }else if(Integer.valueOf(type)==4){
                    list.add(plan.getConstructionMode());
                }else {
                    return new ResponseMessage(Code.CODE_OK,"查询类型错误");
                }

            }
        }
        HashSet set = new HashSet(list);
        list.clear();
        list.addAll(set);
        return new ResponseMessage(Code.CODE_OK,"查询成功",list);
    }

    /**
     * 查询投资主体/责任单位 (立项管理管理模块)
     * @return
     */
    @Override
    public ResponseMessage selectBoxTwo(String requestBody) {
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        String type = jsonObject.getString("type");// 1 投资主体 2 责任单位
        ProjectApplicationExample example = new ProjectApplicationExample();
        example.setOrderByClause("create_time");
        List<ProjectApplication> applications = applicationMapper.selectByExample(example);
        LinkedList list = new LinkedList();
        if(!applications.isEmpty()){
            for (ProjectApplication application: applications) {
                if(StringUtils.isEmpty(type)){
                    return new ResponseMessage(Code.CODE_OK,"查询类型不得为空");
                }else if(Integer.valueOf(type)==1){
                    list.add(application.getInvestor());
                }else if(Integer.valueOf(type)==2){
                    list.add(application.getOrganization());
                }else {
                    return new ResponseMessage(Code.CODE_OK,"查询类型错误");
                }

            }
        }
        HashSet set = new HashSet(list);
        list.clear();
        list.addAll(set);
        return new ResponseMessage(Code.CODE_OK,"查询成功",list);
    }

    /**
     * 按条件分页查询投资计划
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage selectInvestment(String requestBody) {
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        String pageNum = jsonObject.getString("pageNum");//当前页数
        String pageCount = jsonObject.getString("pageCount");//每页显示记录数
        String project_name = jsonObject.getString("project_name");//项目名称
        String project_type = jsonObject.getString("project_type");//项目分类
        String investor = jsonObject.getString("investor");//投资主体
        String organization = jsonObject.getString("organization");//责任单位
        String construction_mode = jsonObject.getString("construction_mode");//建设方式
        String amount = jsonObject.getString("amount");//投资金额

        InvestmentPlan plan= new InvestmentPlan();

        if (!StringUtils.isEmpty(project_name)) {
            plan.setProjectName(project_name);
        }
        if(!StringUtils.isEmpty(project_type)){
            plan.setProjectType(project_type);
        }
        if(!StringUtils.isEmpty(investor)){
            plan.setInvestor(investor);
        }
        if(!StringUtils.isEmpty(organization)){
            plan.setOrganization(organization);
        }
        if (!StringUtils.isEmpty(construction_mode)) {
          plan.setConstructionMode(construction_mode);
        }
        if(!StringUtils.isEmpty(amount)){
            BigDecimal decimal = new BigDecimal(amount);
            decimal=decimal.setScale(3, BigDecimal.ROUND_HALF_UP);
            plan.setAmount(decimal);
        }
        int totelCount=planMapper.selectCountByExample(plan);
        Page page = new Page();
        page.init(totelCount,Integer.valueOf(pageNum),Integer.valueOf(pageCount));
        plan.setRowNum(page.getRowNum());
        plan.setPageCount(page.getPageCount());
        List<InvestmentPlan> investmentPlans = planMapper.selectByPage(plan);
        page.setList(investmentPlans);
        String message = investmentPlans.isEmpty()?"查询失败":"查询成功";
        Integer code = investmentPlans.isEmpty() ? Code.CODE_ERROR : Code.CODE_OK ;
        return new ResponseMessage(code,message,page);
    }

    /**
     *Excel导入（poi）
     * @param file
     * @return
     */
    @Override
    public ResponseMessage insertExcel(MultipartFile file,String loginId)  throws Exception{
        InputStream is;

        // 判断文件的类型，是2003还是2007
        boolean isExcel2003 = true;
        if (WDWUtil.isExcel2007(file.getOriginalFilename())) {
            isExcel2003 = false;
        }
        is = file.getInputStream();
        Workbook workbook = read(is, isExcel2003);
        Sheet sheet = workbook.getSheetAt(0);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if(row!=null){
                InvestmentPlan plan = new InvestmentPlan();
                plan.setId(String.valueOf(IDUtils.genItemId()));


                //设置计划编号
                if(!StringUtils.isEmpty(row.getCell(0).toString())){
                    plan.setPlanNum(row.getCell(0).toString());
                }else {
                    return new ResponseMessage(Code.CODE_ERROR, "导入计划编号不得为空");
                }
                // 设置项目分类
                if (!StringUtils.isEmpty(row.getCell(1).toString())) {
                    plan.setProjectType(row.getCell(1).toString());
                }
                // 设置项目名称
                if (!StringUtils.isEmpty(row.getCell(2).toString())) {
                    plan.setProjectName(row.getCell(2).toString());
                }else {
                    return new ResponseMessage(Code.CODE_ERROR, "导入项目名称不得为空");
                }
                // 设置项目简介
                if (!StringUtils.isEmpty(row.getCell(3).toString())) {
                    plan.setProjectDesc(row.getCell(3).toString());
                }
                // 设置责任单位
                if (!StringUtils.isEmpty(row.getCell(4).toString())) {
                    plan.setOrganization(row.getCell(4).toString());
                }
                // 设置投资主体
                if (!StringUtils.isEmpty(row.getCell(5).toString())) {
                   plan.setInvestor(row.getCell(5).toString());
                }
                  // 设置金额
                if (!StringUtils.isEmpty(row.getCell(6).toString())) {
                   boolean flag =ProjectPreservationImpl.isNumeric(row.getCell(6).toString());
                    if(flag){
                        return new ResponseMessage(Code.CODE_ERROR, "请输入正确投资金额");
                    }
                    BigDecimal decimal = new BigDecimal(row.getCell(6).toString());
                    decimal=decimal.setScale(3, BigDecimal.ROUND_HALF_UP);
                    plan.setAmount(decimal);
                }else {
                    return new ResponseMessage(Code.CODE_ERROR, "导入计划金额不得为空");
                }
                 // 设置建设方式
                if (!StringUtils.isEmpty(row.getCell(7).toString())) {
                    plan.setConstructionMode(row.getCell(7).toString());
                }
                // 设置备注
                if (!StringUtils.isEmpty(row.getCell(8).toString())) {
                    plan.setRemark(row.getCell(8).toString());
                }
                plan.setCreateTime(new Date());

                //查询所有项目校验导入计划编号和项目名称是否重复
                InvestmentPlanExample example = new InvestmentPlanExample();
                List<InvestmentPlan> plans = planMapper.selectByExample(example);
                for (InvestmentPlan o : plans) {
                    if(o.getPlanNum().equals(plan.getPlanNum())){
                        return new ResponseMessage(Code.CODE_ERROR, "计划编号不可重复");
                    }
                    if(o.getProjectName().equals(plan.getProjectName())){
                        return new ResponseMessage(Code.CODE_ERROR, "项目名称不可重复");
                    }
                }
                String id = String.valueOf(IDUtils.genItemId());
                plan.setProjectId(id);

                int agendaInsert = planMapper.insertSelective(plan);
                if (agendaInsert != 1) {
                    return new ResponseMessage(Code.CODE_ERROR, "导入失败");
                }
                updateUtil.projectMethod(id,null,plan.getProjectName(),
                        plan.getProjectType(),"A",loginId,plan.getOrganization(),
                        plan.getAmount().toString(),"Aa1",plan.getInvestor());
            }
        }
        return new ResponseMessage(Code.CODE_OK, "导入成功");
    }

    /**
     *Excel导入（EasyPoi）
     * @param list
     * @return
     */
    @Override
    public ResponseMessage insertExcelByEasyPoi(List<InvestmentPlan> list,String loginId) throws Exception{

        for (int i =0;i<list.size();i++) {
            InvestmentPlan plan = list.get(i);

            if(StringUtils.isEmpty(plan.getPlanNum())){
                int count = i+2;
                return new ResponseMessage(Code.CODE_ERROR, "第"+count+"行的计划编号不可为空");
            }
            if(StringUtils.isEmpty(plan.getProjectName())){
                int count = i+2;
                return new ResponseMessage(Code.CODE_ERROR, "第"+count+"行的项目名称不可为空");
            }




            /*BigDecimal decimal = new BigDecimal(0);
            if(plan.getAmount()==decimal){
                return new ResponseMessage(Code.CODE_ERROR, "导入失败");
            }*/
            String id = String.valueOf(IDUtils.genItemId());


            //查询所有项目
            InvestmentPlanExample example = new InvestmentPlanExample();
            List<InvestmentPlan> plans = planMapper.selectByExample(example);
            for (InvestmentPlan o : plans) {
                if(o.getPlanNum().equals(plan.getPlanNum())){
                    return new ResponseMessage(Code.CODE_ERROR, "计划编号不可重复");
                }
                if(o.getProjectName().equals(plan.getProjectName())){
                    return new ResponseMessage(Code.CODE_ERROR, "项目名称不可重复");
                }
            }
            

            plan.setId(String.valueOf(IDUtils.genItemId()));
            plan.setCreateTime(new Date());
            plan.setProjectId(id);
            int j = planMapper.insertSelective(plan);
            if(j!=1){
                return new ResponseMessage(Code.CODE_ERROR, "导入失败");
            }
            updateUtil.projectMethod(id,null,plan.getProjectName(),
                    plan.getProjectType(),"A",loginId,plan.getOrganization(),
                    plan.getAmount().toString(),"Aa1",plan.getInvestor());
        }
        return new ResponseMessage(Code.CODE_OK, "导入成功");
    }

    /**
     * 查询所有项目
     * @return
     */
    @Override
    public List selectAll() {
        InvestmentPlanExample example = new InvestmentPlanExample();
        List<InvestmentPlan> list = planMapper.selectByExample(example);

        return list;
    }

    /**
     *总经办查询
     * @param
     * @return
     */
    @Override
    public ResponseMessage selectUser() {
        TRoleExample example = new TRoleExample();
        TRoleExample.Criteria criteria = example.createCriteria();
        criteria.andRoleNameEqualTo("总经办汇总人员角色（请勿删除）");
        List<TRole> roles = roleMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(roles)){
            return new ResponseMessage(Code.CODE_ERROR, "查询失败");
        }
        TUserRoleExample example1 = new TUserRoleExample();
        TUserRoleExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andRoleIdEqualTo(roles.get(0).getId());
        List<TUserRole> tUserRoles = userRoleMapper.selectByExample(example1);
        if(CollectionUtils.isEmpty(tUserRoles)){
            return new ResponseMessage(Code.CODE_ERROR, "查询失败");
        }
        TUser tUser = userMapper.selectByPrimaryKey(tUserRoles.get(0).getUserId());
        if(tUser==null){
            return new ResponseMessage(Code.CODE_ERROR, "查询失败");
        }
        return new ResponseMessage(Code.CODE_OK, "查询成功",tUser);
    }

    // 根据不同类型的文件 创建不同的处理对象
    public Workbook read(InputStream inputStream, boolean isExcel2003) throws IOException {
        /** 根据版本选择创建Workbook的方式 */
        Workbook wb;
        if (isExcel2003) {
            wb = new HSSFWorkbook(inputStream);
        } else {
            wb = new XSSFWorkbook(inputStream);
        }
        return wb;
    }

    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("^[0-9]+(.[0-9]+)?$");
        Matcher isNum = pattern.matcher(str);
        if(isNum.matches()){
            return false;
        }
        return true;
    }

}
