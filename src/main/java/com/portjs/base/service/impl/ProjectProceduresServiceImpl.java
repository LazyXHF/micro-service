package com.portjs.base.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.portjs.base.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.InternalPersionResourceMapper;
import com.portjs.base.dao.InternalProjectMapper;
import com.portjs.base.dao.InternalTodoMapper;
import com.portjs.base.dao.InternalWorkflowstepMapper;
import com.portjs.base.entity.InternalPersionResource;
import com.portjs.base.entity.InternalProject;
import com.portjs.base.entity.InternalTodo;
import com.portjs.base.entity.InternalTodoExample;
import com.portjs.base.entity.InternalTodoExample.Criteria;
import com.portjs.base.entity.InternalWorkflowstep;
import com.portjs.base.entity.InternalWorkflowstepExample;
import com.portjs.base.service.ProjectProceduresService;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProjectProceduresServiceImpl implements ProjectProceduresService {
	@Autowired
	private InternalTodoMapper internalToDoMapper;
	@Autowired
	private InternalWorkflowstepMapper internalWorkflowstepMapper;
	@Autowired
	private InternalProjectMapper internalProjectMapper;
	@Autowired
	private InternalPersionResourceMapper internalPersionResourceMapper;
	//创建项目流程
	@Override
	public ResponseMessage createProjectProcedures(@RequestBody Map<String, Object> requestBody) {
		try {
			JSONArray array = JSONArray.parseArray(JsonXMLUtils.obj2json(requestBody.get("InternalPersionResource")));
			JSONArray nextReviewerIdArray=JSONArray.parseArray(JsonXMLUtils.obj2json(requestBody.get("NextReviewerId")));
			//项目添加
			InternalProject internalProject=JsonXMLUtils.map2obj((Map<String, Object>)requestBody.get("InternalProject"), InternalProject.class);
			//暂存还是提交
			String type =requestBody.get("Type").toString();
			//type 1:暂存 2.提交
			if(type.equals("1")){
				internalProject.setStatus("草稿");
				nextReviewerIdArray.clear();
			}
			internalProject.setId(String.valueOf(UUID.randomUUID()));
			internalProject.setCreater(UserUtils.getCurrentUser().getId());
			int c=internalProjectMapper.insert(internalProject);
			if(c<=0) {
				return new ResponseMessage(Code.CODE_ERROR, "创建失败");
			}
			//人员添加
			for (int i = 0; i < array.size(); i++) {
				 JSONObject requestMsg = JSONObject.parseObject(array.getString(i));
				InternalPersionResource internalPersionResource=new InternalPersionResource();
				internalPersionResource.setId(String.valueOf(UUID.randomUUID()));
				internalPersionResource.setProjectId(internalProject.getId());
				internalPersionResource.setPersionName(requestMsg.getString("persionName"));
				internalPersionResource.setUnnit(requestMsg.getString("unnit"));
				internalPersionResource.setType(requestMsg.getString("type"));
				internalPersionResource.setSort(requestMsg.getString("sort"));
				int k=internalPersionResourceMapper.insertPersionInfo(internalPersionResource);
				if(k<=0) {
					return new ResponseMessage(Code.CODE_ERROR, "创建失败");
				}
			}

			for(int n=0;n<nextReviewerIdArray.size();n++) {
				//放入待办事项
				InternalTodo BackLoginternalToDo=new InternalTodo();
				BackLoginternalToDo.setId(String.valueOf(UUID.randomUUID()));
				BackLoginternalToDo.setCurrentstepId(BackLoginternalToDo.getId());
				BackLoginternalToDo.setStepDesc("项目负责人提交");
				BackLoginternalToDo.setRelateddomain("项目立项");
				BackLoginternalToDo.setRelateddomainId(internalProject.getId());
				BackLoginternalToDo.setSenderId(internalProject.getCreater());
				BackLoginternalToDo.setReceiverId(nextReviewerIdArray.getString(n));
				BackLoginternalToDo.setTodoType("项目立项");
				BackLoginternalToDo.setStatus("0");
				int b=internalToDoMapper.insert(BackLoginternalToDo);
				if(b<=0) {
					return new ResponseMessage(Code.CODE_ERROR, "创建失败");
				}

				//工作流
				InternalWorkflowstep workflowstep=new InternalWorkflowstep();
				workflowstep.setId(String.valueOf(UUID.randomUUID()));
				workflowstep.setRelateddomain("项目立项");
				workflowstep.setRelateddomainId(internalProject.getId());
				workflowstep.setPrestepId("0");
				workflowstep.setStepDesc("项目负责人提交");
				workflowstep.setActionuserId(UserUtils.getCurrentUser().getId());
				workflowstep.setStatus("1");
				workflowstep.setBackup3("1");
				int m=internalWorkflowstepMapper.insert(workflowstep);
				if(m<=0) {
					return new ResponseMessage(Code.CODE_ERROR, "创建失败");
				}
				InternalWorkflowstep workflowstep2=new InternalWorkflowstep();
				workflowstep2.setId(String.valueOf(UUID.randomUUID()));
				workflowstep2.setRelateddomain("项目立项");
				workflowstep2.setRelateddomainId(internalProject.getId());
				workflowstep2.setPrestepId(workflowstep.getId());
				workflowstep2.setStepDesc("部门负责人审核");
				workflowstep2.setActionuserId(nextReviewerIdArray.getString(n));
				workflowstep2.setStatus("0");
				workflowstep2.setBackup3("2");
				int s=internalWorkflowstepMapper.insert(workflowstep2);
				if(s<=0) {
					return new ResponseMessage(Code.CODE_ERROR, "创建失败");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseMessage(Code.CODE_OK, "创建成功");
	}
	
	//项目立项阶段的信息查询
	@Override
	public ResponseMessage selectProjectProcedures(String requestBody) {
		JSONObject jsonObj=JSONObject.parseObject(requestBody);
		String id=jsonObj.getString("projectId");
		String person_id=jsonObj.getString("personId");
		String pageNo=jsonObj.getString("pageNo");
		String pageSize=jsonObj.getString("pageSize");
		InternalProject internalProject=new InternalProject();
		internalProject.setId(id);
		internalProject=internalProjectMapper.selectByPrimaryKey(internalProject);
		/*
		 * 分页查询项目人员信息
		 */
		Page<InternalPersionResource>page=new Page<InternalPersionResource>();
		int totleCount=internalPersionResourceMapper.persionCounts(id);
		page.init(totleCount, Integer.valueOf(pageNo), Integer.valueOf(pageSize));
		List<InternalPersionResource> list = internalPersionResourceMapper.queryAllPersionInfo(id, page.getRowNum(), page.getPageCount());
		page.setList(list);
		internalProject.setPage(page);
		/*
		 * 查询对应todo表中该登陆人待审核信息
		 */
		InternalTodoExample example=new InternalTodoExample();
		Criteria criteria = example.createCriteria();
		criteria.andRelateddomainIdEqualTo(id);
		criteria.andReceiverIdEqualTo(person_id);
		criteria.andStatusEqualTo("0");
		List<InternalTodo> internalTodo = internalToDoMapper.selectByExample(example);
		internalProject.setInternalToDo(internalTodo);
		/*
		 * 查询workflowstep表中所有该业务id对应的信息
		 */
		InternalWorkflowstepExample example1=new InternalWorkflowstepExample();
		com.portjs.base.entity.InternalWorkflowstepExample.Criteria criteria2 = example1.createCriteria();
		criteria2.andRelateddomainIdEqualTo(id);
		//criteria2.andActionuserIdEqualTo(person_id);
		List<InternalWorkflowstep> internalWorkflowstep = internalWorkflowstepMapper.selectByExample(example1);
		internalProject.setInternalWorkflowstep(internalWorkflowstep);
		return new ResponseMessage(Code.CODE_OK, "查询成功",internalProject);
	}
	
    
	//项目立项阶段的审批流程添加
	@Override
	public ResponseMessage insertProjectProcedures(String requestBody) {
		JSONObject jsonObj=JSONObject.parseObject(requestBody);
		String relateddomain="项目立项";//业务模块
		String relateddomain_id=jsonObj.getString("relateddomainId");//业务id
		String sender_id=jsonObj.getString("senderId");//当前人的id
		JSONArray nextReviewerId=JSONArray.parseArray(jsonObj.getString("nextReviewerId"));//下一个审核人的信息
		String currentstep_id=jsonObj.getString("currentstep_id");//当前处理步骤
		String todo_id=jsonObj.getString("todo_id");//当前todo表中id
		String workflowstep_id=jsonObj.getString("workflowstep_id");//当前workflowstep表中的id
		String actionComment=jsonObj.getString("actionComment");//审核意见
		String actionResult=jsonObj.getString("actionResult");//0 同意 1 不同意or退回
		String backup3 = jsonObj.getString("backup3");//第几个步骤
		String stepDesc="";
		if(backup3.equals("2")){
			stepDesc="分管领导审核";
			backup3="3";
		}else if(backup3.equals("3")){
			stepDesc="技术委员会审核";
			backup3="4";
		}else if(backup3.equals("4")){
			stepDesc="总经办审核";
			backup3="5";
		}else if(backup3.equals("5")){
			stepDesc="规划部归档";
			backup3="6";
		}
		/*
		 * 修改掉当前todo表对应的id的信息
		 */
		InternalTodo BackLoginternalToDo=new InternalTodo();
		BackLoginternalToDo.setId(todo_id);
		BackLoginternalToDo.setActiontime(new Date());
		BackLoginternalToDo.setStatus("1");
		int k=internalToDoMapper.updateByPrimaryKeySelective(BackLoginternalToDo);
		if(k<=0) {
			return new ResponseMessage(Code.CODE_ERROR, "审核失败");
		}
		/*
		 * 修改当前workflowstep表中对应id的信息
		 */
		InternalWorkflowstep BackLoginternalWorkflowstep=new InternalWorkflowstep();
		BackLoginternalWorkflowstep.setId(workflowstep_id);
		BackLoginternalWorkflowstep.setActionTime(new Date());	
		BackLoginternalWorkflowstep.setActionComment(actionComment);
		BackLoginternalWorkflowstep.setStatus("1");
        if(actionResult.equals("0")) {
        	BackLoginternalWorkflowstep.setActionResult(0);
		}else if(actionResult.equals("1")) {
			BackLoginternalWorkflowstep.setActionResult(1);
		}
		int j=internalWorkflowstepMapper.updateByPrimaryKeySelective(BackLoginternalWorkflowstep);
		if(j<=0) {
			return new ResponseMessage(Code.CODE_ERROR, "审核失败");
		}
		/*
		 * 选择下一个审核人进行的操作
		 * 对todo表中进行添加操作
		 * 对Workflowstep表中进行添加操作
		 */
		for(int c=0;c<nextReviewerId.size();c++) {
			//进入到多个人审核阶段
			if(backup3.equals("5")){
				InternalWorkflowstepExample example1=new InternalWorkflowstepExample();
				com.portjs.base.entity.InternalWorkflowstepExample.Criteria criteria2 = example1.createCriteria();
				criteria2.andStatusEqualTo("0");
				criteria2.andRelateddomainIdEqualTo(relateddomain_id);
				criteria2.andBackup3EqualTo("4");
				List<InternalWorkflowstep> list = internalWorkflowstepMapper.selectByExample(example1);
				if(CollectionUtils.isEmpty(list)){
					InternalTodo internalToDo=new InternalTodo();
					internalToDo.setId(String.valueOf(UUID.randomUUID()));
					internalToDo.setCurrentstepId(currentstep_id);
					internalToDo.setRelateddomain(relateddomain);
					internalToDo.setRelateddomainId(relateddomain_id);
					internalToDo.setSenderId(sender_id);
					internalToDo.setReceiverId(nextReviewerId.getString(c));
					internalToDo.setSenderTime(new Date());
					internalToDo.setTodoType("项目立项审核流程");
					internalToDo.setStatus("0");
					int n=internalToDoMapper.insert(internalToDo);
					if(n<=0) {
						return new ResponseMessage(Code.CODE_ERROR, "添加下一个审核人信息失败");
					}
					InternalWorkflowstep workflowstep=new InternalWorkflowstep();
					workflowstep.setId(String.valueOf(UUID.randomUUID()));
					workflowstep.setRelateddomain(relateddomain);
					workflowstep.setRelateddomainId(relateddomain_id);
					workflowstep.setPrestepId(workflowstep_id);
					workflowstep.setActionuserId(nextReviewerId.getString(c));
					workflowstep.setStatus("0");
					workflowstep.setBackup3(backup3);
					workflowstep.setStepDesc(stepDesc);
					int m=internalWorkflowstepMapper.insert(workflowstep);
					if(m<=0) {
						return new ResponseMessage(Code.CODE_ERROR, "添加下一个审核人信息失败");
					}
				}
			}else{
				InternalTodo internalToDo=new InternalTodo();
				internalToDo.setId(String.valueOf(UUID.randomUUID()));
				internalToDo.setCurrentstepId(currentstep_id);
				internalToDo.setRelateddomain(relateddomain);
				internalToDo.setRelateddomainId(relateddomain_id);
				internalToDo.setSenderId(sender_id);
				internalToDo.setReceiverId(nextReviewerId.getString(c));
				internalToDo.setSenderTime(new Date());
				internalToDo.setTodoType("项目立项审核流程");
				internalToDo.setStatus("0");
				int n=internalToDoMapper.insert(internalToDo);
				if(n<=0) {
					return new ResponseMessage(Code.CODE_ERROR, "添加下一个审核人信息失败");
				}
				InternalWorkflowstep workflowstep=new InternalWorkflowstep();
				workflowstep.setId(String.valueOf(UUID.randomUUID()));
				workflowstep.setRelateddomain(relateddomain);
				workflowstep.setRelateddomainId(relateddomain_id);
				workflowstep.setPrestepId(workflowstep_id);
				workflowstep.setActionuserId(nextReviewerId.getString(c));
				workflowstep.setStatus("0");
				workflowstep.setBackup3(backup3);
				workflowstep.setStepDesc(stepDesc);
				int m=internalWorkflowstepMapper.insert(workflowstep);
				if(m<=0) {
					return new ResponseMessage(Code.CODE_ERROR, "添加下一个审核人信息失败");
				}
			}
	}
   return new ResponseMessage(Code.CODE_OK, "审核完成");
}

    //立项阶段的归档操作
	@Override
	public ResponseMessage projectProceduresArchive(String requestBody) {
		JSONObject jsonObj=JSONObject.parseObject(requestBody);
		String todo_id=jsonObj.getString("todo_id");
		String workflowstep_id=jsonObj.getString("workflowstep_id");
		String projectCoding=jsonObj.getString("projectCoding");
		/*
		 * 修改掉当前todo表对应的id的信息
		 */
		InternalTodo BackLoginternalToDo=new InternalTodo();
		BackLoginternalToDo.setId(todo_id);
		BackLoginternalToDo.setActiontime(new Date());
		BackLoginternalToDo.setStatus("1");
		int k=internalToDoMapper.updateByPrimaryKeySelective(BackLoginternalToDo);
		if(k<=0) {
			return new ResponseMessage(Code.CODE_ERROR, "归档失败");
		}
		/*
		 * 修改当前workflowstep表中对应id的信息
		 */
		InternalWorkflowstep BackLoginternalWorkflowstep=new InternalWorkflowstep();
		BackLoginternalWorkflowstep.setId(workflowstep_id);
		BackLoginternalWorkflowstep.setActionTime(new Date());	
		BackLoginternalWorkflowstep.setStatus("1");
		BackLoginternalWorkflowstep.setProjectCoding(projectCoding);
		int j=internalWorkflowstepMapper.updateByPrimaryKeySelective(BackLoginternalWorkflowstep);
		if(j<=0) {
			return new ResponseMessage(Code.CODE_ERROR, "归档失败");
		}
		 return new ResponseMessage(Code.CODE_OK, "归档完成");
	}
}
