package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.*;
import com.portjs.base.entity.*;
import com.portjs.base.service.ProjectApprovalService;
import com.portjs.base.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;

@Service
public class ProjectApprovalServiceImpl implements ProjectApprovalService {
	@Autowired
	private TTodoMapper tTodoMapper;
	@Autowired
	private TWorkflowstepMapper tWorkflowstepMapper;
	@Autowired
	private ProjectApplicationMapper projectApplicationMapper;
	@Autowired
	private  TUserMapper tUserMapper;
	@Autowired
	private TXietongDictionaryMapper dictionaryMapper;
	@Autowired
	private InvestmentPlanMapper planMapper;
	@Autowired
	private ProjectMembersMapper projectMembersMapper;
	@Autowired
	private InternalAttachmentMapper internalAttachmentMapper;
	@Autowired
	private  ProjectCommunicationMapper projectCommunicationMapper;
	@Autowired
	private ProjectAddorUpdateUtil updateUtil;

	//返参信息
	public final static String PARAM_MESSAGE_1 = "未传";
	public final static String PARAM_MESSAGE_2 = "已存在";
	public final static String PARAM_MESSAGE_3 = "不规范";


	//项目立项阶段的审批流程添加
	@Override
	public ResponseMessage insertProjectProcedures(String requestBody)throws Exception {
		JSONObject jsonObj=JSONObject.parseObject(requestBody);
		String relateddomain="项目立项";//业务模块
		String relateddomain_id=jsonObj.getString("relateddomainId");//业务id
		String sender_id=jsonObj.getString("senderId");//当前人的id
		String currentstep_id=jsonObj.getString("currentstepId");//当前处理步骤
		String todo_id=jsonObj.getString("todoId");//当前todo表中id
		String workflowstep_id=jsonObj.getString("workflowstepId");//当前workflowstep表中的id
		String actionComment=jsonObj.getString("actionComment");//审核意见
		String actionResult=jsonObj.getString("actionResult");//0 同意 1 不同意or退回
		String backup3 = jsonObj.getString("sort");//第几个步骤
		String reviewIds = jsonObj.getString("nextReviewerId");//下一个审核人的信息
		String userName = jsonObj.getString("userName");//用户姓名
		String projectName = jsonObj.getString("projectName");//项目名字

		//必要参数空值判断
		if(StringUtils.isEmpty(reviewIds)){
			return new ResponseMessage(Code.CODE_ERROR, "nextReviewerId"+PARAM_MESSAGE_1);
		}
		JSONArray nextReviewerId=JSONArray.parseArray(reviewIds);

		if(StringUtils.isEmpty(relateddomain_id)){
			return new ResponseMessage(Code.CODE_ERROR, "relateddomainId"+PARAM_MESSAGE_1);
		}
		if(StringUtils.isEmpty(sender_id)){
			return new ResponseMessage(Code.CODE_ERROR, "senderId"+PARAM_MESSAGE_1);
		}
		if(StringUtils.isEmpty(currentstep_id)){
			return new ResponseMessage(Code.CODE_ERROR, "currentstepId"+PARAM_MESSAGE_1);
		}
		if(StringUtils.isEmpty(todo_id)){
			return new ResponseMessage(Code.CODE_ERROR, "todoId"+PARAM_MESSAGE_1);
		}
		if(StringUtils.isEmpty(workflowstep_id)){
			return new ResponseMessage(Code.CODE_ERROR, "workflowstepId"+PARAM_MESSAGE_1);
		}
		if(StringUtils.isEmpty(actionResult)){
			return new ResponseMessage(Code.CODE_ERROR, "actionResult"+PARAM_MESSAGE_1);
		}
		if(StringUtils.isEmpty(backup3)){
			return new ResponseMessage(Code.CODE_ERROR, "sort"+PARAM_MESSAGE_1);
		}

		/*
		 * 修改掉当前todo表对应的id的信息
		 */
		TTodo tTodo=new TTodo();
		tTodo.setId(todo_id);
		tTodo.setActiontime(new Date());
		tTodo.setStatus("1");
		int k=tTodoMapper.updateByPrimaryKeySelective(tTodo);
		if(k<=0) {
			return new ResponseMessage(Code.CODE_ERROR, "审核失败");
		}

		/*
		 * 修改当前workflowstep表中对应id的信息
		 */
		TWorkflowstep tWorkflowstep=new TWorkflowstep();
		tWorkflowstep.setId(workflowstep_id);
		tWorkflowstep.setActionTime(new Date());
		tWorkflowstep.setActionComment(actionComment);
		tWorkflowstep.setStatus("1");
		if(actionResult.equals("0")) {
			tWorkflowstep.setActionResult(0);
		}else if(actionResult.equals("1")) {
			tWorkflowstep.setActionResult(1);
		}
		int j=tWorkflowstepMapper.updateByPrimaryKeySelective(tWorkflowstep);
		if(j<=0) {
			return new ResponseMessage(Code.CODE_ERROR, "审核失败");
		}

		//步骤描述
		String stepDesc="";
		String stepTodo="";
		String ss="1";
		if(backup3.equals("2")){
			ss=backup3;
			stepTodo="部门负责人审核";
			stepDesc="分管领导审核";
			backup3=new String("3");
		}else if(backup3.equals("3")){
			ss=backup3;
			stepTodo="分管领导审核";
			stepDesc="技术委员会审核";
			backup3=new String("4");
		}else if(backup3.equals("4")){
			ss=backup3;
			stepTodo="技术委员会审核";
			stepDesc="总经办审核";
			backup3=new String("5");
		}else if(backup3.equals("5")){
			ss=backup3;
			stepTodo="总经办审核";
			stepDesc="规划部归档";
			backup3=new String("6");
		}

		/*//判断多人是否有退回的状态
		TWorkflowstepExample examples = new TWorkflowstepExample();
		TWorkflowstepExample.Criteria criteria1 = examples.createCriteria();
		criteria1.andRelateddomainIdEqualTo(relateddomain_id);
		criteria1.andActionResultEqualTo(1);
		List<TWorkflowstep> tWorkflowsteps = tWorkflowstepMapper.selectByExample(examples);

		//查询所有的工作记录
		List<TWorkflowstep> tWorkfow =tWorkflowstepMapper.queryNotReviewProject(relateddomain_id);
		TWorkflowstep t = null;
		if(!CollectionUtils.isEmpty(tWorkfow)){
			t=tWorkfow.get(tWorkfow.size()-1);
		}*/
		//三个条件进入审核
		TWorkflowstepExample examples = new TWorkflowstepExample();
		TWorkflowstepExample.Criteria criteria1 = examples.createCriteria();
		criteria1.andRelateddomainIdEqualTo(relateddomain_id);
		criteria1.andActionResultEqualTo(1);
		criteria1.andBackup3EqualTo("4");
		List<TWorkflowstep> tWorkflowsteps = tWorkflowstepMapper.selectByExample(examples);
		//查询是否是最后一人审核
		TWorkflowstepExample exampless = new TWorkflowstepExample();
		TWorkflowstepExample.Criteria criteria1s = exampless.createCriteria();
		criteria1s.andRelateddomainIdEqualTo(relateddomain_id);
		criteria1s.andBackup3EqualTo("4");
		criteria1s.andStatusEqualTo("0");
		List<TWorkflowstep> tWorkflowstepss = tWorkflowstepMapper.selectByExample(exampless);

		//查询所有的工作记录
		List<TWorkflowstep> tWorkfow =tWorkflowstepMapper.queryNotReviewProject(relateddomain_id);
		TWorkflowstep t = null;
		if(!CollectionUtils.isEmpty(tWorkfow)){
			t=tWorkfow.get(tWorkfow.size()-1);
		}
		ProjectApplicationExample projectApplicationExample = new ProjectApplicationExample();
		ProjectApplicationExample.Criteria  criteri = projectApplicationExample.createCriteria();
		criteri.andEnableEqualTo("0");
		criteri.andIdEqualTo(relateddomain_id);
		List<ProjectApplication>  projectApplications = projectApplicationMapper.selectByExample(projectApplicationExample);

		if(!CollectionUtils.isEmpty(tWorkflowsteps)&&CollectionUtils.isEmpty(tWorkflowstepss)&&t!=null&&t.getBackup3().equals("4")&&!CollectionUtils.isEmpty(projectApplications)){

			//判断现在是哪一步退回如果是技术委员退回则判断是否是最后一个人退回
			TWorkflowstepExample example = new TWorkflowstepExample();
			TWorkflowstepExample.Criteria criteria = example.createCriteria();
			criteria.andRelateddomainIdEqualTo(relateddomain_id);
			criteria.andStatusEqualTo("0");
			List<TWorkflowstep> tWorkflowste = tWorkflowstepMapper.selectByExample(example);
			if(tWorkflowste.size()==0){
				//如果当前审核人员只有一个的话则生成待办
				TTodo todo = new TTodo();
				todo.setId(String.valueOf(IDUtils.genItemId()));
				todo.setCurrentstepId(workflowstep_id);
				todo.setStepDesc(projectName+"的立项批复流程等待您的处理");
				todo.setRelateddomain("项目立项");
				todo.setRelateddomainId(relateddomain_id);
				todo.setSenderId(sender_id);
				todo.setSenderTime(new Date());

				todo.setBackUp7(userName);//发起人
				//取项目流程中第一个项目负责人id
				TWorkflowstepExample exampl = new TWorkflowstepExample();
				exampl.setOrderByClause("prestep_id");
				TWorkflowstepExample.Criteria criteria3 = exampl.createCriteria();
				criteria3.andRelateddomainIdEqualTo(relateddomain_id);

				List<TWorkflowstep> tWorkflow = tWorkflowstepMapper.selectByExample(exampl);
				todo.setReceiverId(tWorkflow.get(0).getActionuserId());

				//查询代办类型
				TXietongDictionaryExample example1 = new TXietongDictionaryExample();
				TXietongDictionaryExample.Criteria criteria2 = example1.createCriteria();
				criteria2.andTypeIdEqualTo("8");
				criteria2.andTypeCodeEqualTo("38");
				criteria2.andMidValueEqualTo("1");
				List<TXietongDictionary> dictionaryList = dictionaryMapper.selectByExample(example1);
				todo.setTodoType(dictionaryList.get(0).getMainValue());
				todo.setStatus("0");
				int i1 = tTodoMapper.insertSelective(todo);
				if(i1!=1){
					return new ResponseMessage(Code.CODE_ERROR,"退回失败");
				}
			}
			//改变当前立项表状态为退回
			ProjectApplication application = new ProjectApplication();
			application.setId(relateddomain_id);
			application.setStatus("8");
			int i1 = projectApplicationMapper.updateByPrimaryKeySelective(application);
			if(i1==0){
				return new ResponseMessage(Code.CODE_ERROR,"退回失败");
			}
		}else{
			//查询待办类型
			TXietongDictionaryExample example = new TXietongDictionaryExample();
			TXietongDictionaryExample.Criteria criteria = example.createCriteria();
			criteria.andTypeIdEqualTo("8");
			criteria.andTypeCodeEqualTo("38");
			criteria.andMidValueEqualTo("1");
			List<TXietongDictionary> dictionaryList = dictionaryMapper.selectByExample(example);

			/*
			 * 选择下一个审核人进行的操作
			 * 对todo表中进行添加操作
			 * 对Workflowstep表中进行添加操作
			 */
			boolean flag= false;//最后一人审核标识
			for(int c=0;c<nextReviewerId.size();c++) {
				//进入到多个人审核阶段，修改待办
				if(backup3.equals("5")){
					TWorkflowstepExample example1=new TWorkflowstepExample();
					TWorkflowstepExample.Criteria criteria2 = example1.createCriteria();
					criteria2.andStatusEqualTo("0");
					criteria2.andRelateddomainIdEqualTo(relateddomain_id);
					criteria2.andBackup3EqualTo("4");
					List<TWorkflowstep> list = tWorkflowstepMapper.selectByExample(example1);
					//最后一人审核
					if(CollectionUtils.isEmpty(list)){
						TWorkflowstep workflowstep=new TWorkflowstep();
						workflowstep.setId(String.valueOf(UUID.randomUUID()));
						workflowstep.setRelateddomain(relateddomain);
						workflowstep.setRelateddomainId(relateddomain_id);
						workflowstep.setPrestepId(workflowstep_id);
						workflowstep.setActionuserId(nextReviewerId.getString(c));
						workflowstep.setStatus("0");
						workflowstep.setBackup3(backup3);
						workflowstep.setStepDesc(stepDesc);
						int m=tWorkflowstepMapper.insertSelective(workflowstep);
						if(m<=0) {
							return new ResponseMessage(Code.CODE_ERROR, "添加下一个审核人信息失败");
						}
						TTodo internalToDo=new TTodo();
						internalToDo.setId(String.valueOf(UUID.randomUUID()));
						internalToDo.setCurrentstepId(workflowstep.getId());
						internalToDo.setRelateddomain(relateddomain);
						internalToDo.setRelateddomainId(relateddomain_id);
						internalToDo.setSenderId(sender_id);
						internalToDo.setReceiverId(nextReviewerId.getString(c));
						internalToDo.setSenderTime(new Date());
						internalToDo.setTodoType(dictionaryList.get(0).getMainValue());
						internalToDo.setStepDesc(projectName+"的立项批复流程等待您的处理");
						internalToDo.setStatus("0");
						internalToDo.setBackUp7(userName);//发起人

						int n=tTodoMapper.insertSelective(internalToDo);
						if(n<=0) {
							return new ResponseMessage(Code.CODE_ERROR, "添加下一个审核人信息失败");
						}
						flag=true;
					}
				}else{
					TWorkflowstep workflowstep=new TWorkflowstep();
					workflowstep.setId(String.valueOf(UUID.randomUUID()));
					workflowstep.setRelateddomain(relateddomain);
					workflowstep.setRelateddomainId(relateddomain_id);
					workflowstep.setPrestepId(workflowstep_id);
					workflowstep.setActionuserId(nextReviewerId.getString(c));
					workflowstep.setStatus("0");
					workflowstep.setBackup3(backup3);
					workflowstep.setStepDesc(stepDesc);
					int m=tWorkflowstepMapper.insertSelective(workflowstep);
					if(m<=0) {
						return new ResponseMessage(Code.CODE_ERROR, "添加下一个审核人信息失败");
					}
					TTodo internalToDo=new TTodo();
					internalToDo.setId(String.valueOf(UUID.randomUUID()));
					internalToDo.setCurrentstepId(workflowstep.getId());
					internalToDo.setRelateddomain(relateddomain);
					internalToDo.setRelateddomainId(relateddomain_id);
					internalToDo.setSenderId(sender_id);
					internalToDo.setReceiverId(nextReviewerId.getString(c));
					internalToDo.setSenderTime(new Date());
					internalToDo.setTodoType(dictionaryList.get(0).getMainValue());
					internalToDo.setStepDesc(projectName+"的立项批复流程等待您的处理");
					internalToDo.setStatus("0");
					internalToDo.setBackUp7(userName);//发起人
					int n=tTodoMapper.insertSelective(internalToDo);
					if(n<=0) {
						return new ResponseMessage(Code.CODE_ERROR, "添加下一个审核人信息失败");
					}
				}
			}
			//更新projectApplication
			ProjectApplication projectApplication = new ProjectApplication();
			projectApplication.setId(relateddomain_id);
			//多人审核阶段
			if(backup3.equals("5")){
				//审核结束
				if(flag){
					projectApplication.setStatus("4");
				}else{
					//审核开始
					projectApplication.setStatus("3");
				}
			}else{
				projectApplication.setStatus(ss);
			}

			int num =projectApplicationMapper.updateByPrimaryKeySelective(projectApplication);
			if(num<=0){
				return new ResponseMessage(Code.CODE_ERROR, "审核完成失败");
			}
		}
   return new ResponseMessage(Code.CODE_OK, "审核完成");
}

    //立项阶段的归档操作
	@Override
	@Transactional(rollbackFor = Exception.class)
	public ResponseMessage projectProceduresArchive(String requestBody)throws Exception {
		JSONObject jsonObj=JSONObject.parseObject(requestBody);
		//当前待办的ID
		String todoId=jsonObj.getString("todoId");
		//当前步骤ID
		String workflowstepId=jsonObj.getString("workflowstepId");
		//项目编码
		String projectCoding=jsonObj.getString("projectCoding");
		//业务id
		String relateddomainId=jsonObj.getString("relateddomainId");
		//项目id
		String projectId=jsonObj.getString("projectId");
		String projectCode=projectCoding;
		String projectName=jsonObj.getString("projectName");
		String projectType=jsonObj.getString("projectType");
		String schedule="A";
		String creator=jsonObj.getString("creator");
		String organization=jsonObj.getString("organization");
		String projectMoney=jsonObj.getString("projectMoney");
		String projectStatus="Ab1";
		String investor=jsonObj.getString("investor");

		updateUtil.projectMethod(projectId,projectCode,projectName,projectType,schedule,creator,organization,projectMoney,projectStatus,investor);

		if(StringUtils.isEmpty(todoId)){
			return new ResponseMessage(Code.CODE_ERROR, "todoId"+PARAM_MESSAGE_1);
		}
		if(StringUtils.isEmpty(workflowstepId)){
			return new ResponseMessage(Code.CODE_ERROR, "workflowstepId"+PARAM_MESSAGE_1);
		}
		if(StringUtils.isEmpty(projectCoding)){
			return new ResponseMessage(Code.CODE_ERROR, "projectCoding"+PARAM_MESSAGE_1);
		}
		if(StringUtils.isEmpty(relateddomainId)){
			return new ResponseMessage(Code.CODE_ERROR, "relateddomainId"+PARAM_MESSAGE_1);
		}
		//检查项目的编码是否重复
		ProjectApplicationExample projectApplicationExample = new ProjectApplicationExample();
		ProjectApplicationExample.Criteria criteria2 = projectApplicationExample.createCriteria();
		criteria2.andProjectCodeEqualTo(projectCoding);
		criteria2.andEnableEqualTo("1");
		int count = projectApplicationMapper.countByExample(projectApplicationExample);
		if(count>0){
			return new ResponseMessage(Code.CODE_ERROR, "项目编码"+ PARAM_MESSAGE_2);
		}

		//修改掉当前todo表对应的id的信息
		TTodo tTodo=new TTodo();
		tTodo.setId(todoId);
		tTodo.setActiontime(new Date());
		tTodo.setStatus("1");
		int k=tTodoMapper.updateByPrimaryKeySelective(tTodo);
		if(k<=0) {
			return new ResponseMessage(Code.CODE_ERROR, "归档失败");
		}
		 //修改当前workflowstep表中对应id的信息
		TWorkflowstep tWorkflowstep=new TWorkflowstep();
		tWorkflowstep.setId(workflowstepId);
		tWorkflowstep.setActionTime(new Date());
		tWorkflowstep.setStatus("1");
		int j=tWorkflowstepMapper.updateByPrimaryKeySelective(tWorkflowstep);
		if(j<=0) {
			return new ResponseMessage(Code.CODE_ERROR, "归档失败");
		}

		//更新立项表中的项目编码
		ProjectApplication example = new ProjectApplication();
		example.setId(relateddomainId);
		example.setProjectCode(projectCoding);
		example.setStatus("6");
		count = projectApplicationMapper.updateByPrimaryKeySelective(example);
		if(count<=0){
			return new ResponseMessage(Code.CODE_ERROR, "归档失败");
		}
		//新增项目信息
		//ProjectMapper
		return new ResponseMessage(Code.CODE_OK, "归档完成");
	}

	//待办查询
	@Override
	@Transactional(rollbackFor = Exception.class)
	public ResponseMessage queryTodos(String requestBody) throws Exception {
		JSONObject jsonObj=JSONObject.parseObject(requestBody);
		String userId = jsonObj.getString("userId");//当前登录人id
		//status 0  userId  条件
		TTodo todo = JSONObject.toJavaObject(jsonObj,TTodo.class);
		todo.setStatus("0");
		todo.setReceiverId(userId);

		if(StringUtils.isEmpty(userId)){
			return new ResponseMessage(Code.CODE_ERROR, "userId"+PARAM_MESSAGE_1);
		}

		//分页条件查询
		Page<TTodo> pag = new Page<TTodo>();
		int count = tTodoMapper.selectCountBySomething(todo);
		pag.init(count, Integer.valueOf(todo.getParams().get("pageNo").toString()), Integer.valueOf(todo.getParams().get("pageSize").toString()));
		todo.getParams().put("pageNo",pag.getRowNum());
		todo.getParams().put("pageSize",pag.getPageCount());

		List<TTodo> list = tTodoMapper.selectBySomething(todo);
		//替换姓名
		for(int i=0;i<list.size();i++){
			TTodo tTodo = list.get(i);
			//发送人
			String name = tUserMapper.selectById(tTodo.getSenderId());
			if(!StringUtils.isEmpty(name)){
				tTodo.setSenderId(name);
			}else {
				tTodo.setSenderId("");
			}

			if("项目立项".equals(tTodo.getRelateddomain())){
				Map<String,Object> map = new HashMap<String,Object>();
				ProjectApplicationExample projectApplicationExample = new ProjectApplicationExample();
				ProjectApplicationExample.Criteria criteria2 = projectApplicationExample.createCriteria();
				criteria2.andIdEqualTo(list.get(i).getRelateddomainId());
				//查询此条数据的状态
				List<ProjectApplication> list1 = projectApplicationMapper.selectByExample(projectApplicationExample);
				if(!CollectionUtils.isEmpty(list1)){
					//status 8和0(暂存编辑状态):退回状态,其余审核中
					if("8".equals(list1.get(0).getStatus())||"0".equals(list1.get(0).getStatus())){
						map.put("returnStatus","0");
					}else{
						map.put("returnStatus","1");
					}
					tTodo.setParams(map);
				}
			}
		}
		pag.setList(list);
		return new ResponseMessage(Code.CODE_OK, "查询成功",pag);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ResponseMessage todoGo(String requestBody) throws Exception {
		//1.人员分页参数2.type类型查询
		JSONObject jsonObj=JSONObject.parseObject(requestBody);
		String moduel = jsonObj.getString("Relateddomain");//项目模块
		if(StringUtils.isEmpty(moduel)){
			return new ResponseMessage(Code.CODE_ERROR, "Relateddomain"+PARAM_MESSAGE_1);
		}
		switch(moduel.trim()){
			case"项目立项":
				break;
			default:
				return new ResponseMessage(Code.CODE_ERROR, "不存在此模块");
		}
		return null;
	}

	/**
	 * 查询项目具体信息
	 * @param requestBody
	 * @return
	 * @throws Exception
	 */
	@Override
	public ResponseMessage queryProjectDetials(String requestBody) throws Exception {
		JSONObject jsonObj=JSONObject.parseObject(requestBody);
		String projectId = jsonObj.getString("projectId");//项目id
		String stage = jsonObj.getString("stage");//项目阶段
		String node=jsonObj.getString("node");//阶段下的节点
		String pageSize= jsonObj.getString("pageSize");
		String pageNo =jsonObj.getString("pageNo");
		//空值判断
		if(StringUtils.isEmpty(projectId)){
			return new ResponseMessage(Code.CODE_ERROR, "projectId"+PARAM_MESSAGE_1);
		}
		if(StringUtils.isEmpty(stage)){
			return new ResponseMessage(Code.CODE_ERROR, "stage"+PARAM_MESSAGE_1);
		}
		if(StringUtils.isEmpty(node)){
			return new ResponseMessage(Code.CODE_ERROR, "node"+PARAM_MESSAGE_1);
		}
		if(StringUtils.isEmpty(pageSize)){
			return new ResponseMessage(Code.CODE_ERROR, "pageSize"+PARAM_MESSAGE_1);
		}
		if(StringUtils.isEmpty(pageNo)){
			return new ResponseMessage(Code.CODE_ERROR, "pageNo"+PARAM_MESSAGE_1);
		}
		//A:立项阶段 B:工程准备阶段 C:设计阶段 D:建设阶段 E:验收阶段 F:收尾阶段 G:沟通记录
		if(stage.equals("A")){
			//a：投资计划 b:立项批复 c:项目交底
			if("a".equals(node)){
				InvestmentPlanExample planExample = new InvestmentPlanExample();
				InvestmentPlanExample.Criteria criteria = planExample.createCriteria();
				criteria.andProjectIdEqualTo(projectId);
				List <InvestmentPlan> data = planMapper.selectByExample(planExample);
				if(!CollectionUtils.isEmpty(data)){
					return  new ResponseMessage(Code.CODE_OK, "查询成功",data.get(0));
				}
				return  new ResponseMessage(Code.CODE_OK, "查询成功",data);
			}else if("b".equals(node)){
				ProjectApplicationExample projectApplicationExample = new ProjectApplicationExample();
				ProjectApplicationExample.Criteria criteria = projectApplicationExample.createCriteria();
				criteria.andProjectIdEqualTo(projectId);
				List <ProjectApplication> data = projectApplicationMapper.selectByExample(projectApplicationExample);

				Map<String,Object> mapData = null;
				if(!CollectionUtils.isEmpty(data)){
					mapData = new HashMap<String,Object>();
					ProjectApplication projectApplication = data.get(0);
					//立项id
					String id = projectApplication.getId();
					//根据获取到的计划id查询对应的计划编码
					String planId=projectApplication.getInvestmentId();
					InvestmentPlanExample planExamples = new InvestmentPlanExample();
					InvestmentPlanExample.Criteria criterias = planExamples.createCriteria();
					criterias.andIdEqualTo(planId);
					List <InvestmentPlan> planData = planMapper.selectByExample(planExamples);
					/*projectApplication.setPlanNum(planData.get(0).getPlanNum());*/
					mapData.put("Application",projectApplication);
					//人员
					Page page=new Page();
					int totalCount=projectMembersMapper.queryProjectPersonsCount(id);
					page.init(totalCount,Integer.valueOf(pageNo),Integer.valueOf(pageSize));
					List<ProjectMembers> list = projectMembersMapper.selectByPage(page.getRowNum(), page.getPageCount(),id);
					page.setList(list);
					mapData.put("Persons",page);
					//附件
					InternalAttachmentExample example = new InternalAttachmentExample();
					InternalAttachmentExample.Criteria criteria2 = example.createCriteria();
					criteria2.andRelateddomainIdEqualTo(id);
					List<InternalAttachment> files = internalAttachmentMapper.selectByExample(example);
					mapData.put("Files",files);
				}
				return  new ResponseMessage(Code.CODE_OK, "查询成功",mapData);
			}else{
				return new ResponseMessage(Code.CODE_ERROR, "不存在此种状态");
			}
		}else if(stage.equals("B")){
			return null;
		}else if(stage.equals("C")){
			return null;
		}else if(stage.equals("D")){
			return null;
		}else if(stage.equals("E")){
			return null;
		}else if(stage.equals("F")){
			return null;
		}else if(stage.equals("G")){
			//沟通记录
			if("a".equals(node)){
				String schedule =jsonObj.getString("schedule");
				ProjectCommunication projectCommunication = new ProjectCommunication();
				projectCommunication.setProjectId(projectId);
				projectCommunication.setPhase(schedule);

				Page page=new Page();
				int totalCount = projectCommunicationMapper.queryProjectCommunicatisCount(projectCommunication);
				page.init(totalCount,Integer.valueOf(pageNo),Integer.valueOf(pageSize));
				Map<String,Object> map = new HashMap<String, Object>();
				map.put("pageNo",page.getRowNum());
				map.put("pageSize",page.getPageCount());
				projectCommunication.setParams(map);

				List<ProjectCommunication> dataList = projectCommunicationMapper.queryProjectCommunicatisByPage(projectCommunication);
				page.setList(dataList);
				return  new ResponseMessage(Code.CODE_OK, "查询成功",page);
			}
		}else{
			return new ResponseMessage(Code.CODE_ERROR, "不存在此种状态");
		}
		return null;
	}
}
