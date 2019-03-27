package com.portjs.base.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
import com.portjs.base.util.Code;
import com.portjs.base.util.JsonXMLUtils;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;
@Service
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
			InternalProject internalProject=JsonXMLUtils.map2obj((Map<String, Object>)requestBody.get("internalProject"), InternalProject.class);
			JSONArray array = JSONArray.parseArray(JsonXMLUtils.obj2json(requestBody.get("internalPersionResource")));
			JSONArray nextReviewerIdArray=JSONArray.parseArray(JsonXMLUtils.obj2json(requestBody.get("nextReviewerId")));
			int c=internalProjectMapper.insert(internalProject);
			if(c<=0) {
				return new ResponseMessage(Code.CODE_ERROR, "创建失败");
			}
			for (int i = 0; i < array.size(); i++) {
				 JSONObject requestMsg = JSONObject.parseObject(array.getString(i));
				InternalPersionResource internalPersionResource=new InternalPersionResource();
				internalPersionResource.setId(String.valueOf(UUID.randomUUID()));
				internalPersionResource.setProjectId(internalProject.getId());
				internalPersionResource.setPersionName(requestMsg.getString("persionName"));
				internalPersionResource.setUnnit(requestMsg.getString("unnit"));
				internalPersionResource.setType(requestMsg.getString("type"));
				internalPersionResource.setEnable(requestMsg.getString("enable"));
				internalPersionResource.setSort(requestMsg.getString("enable"));
				int k=internalPersionResourceMapper.insertPersionInfo(internalPersionResource);
				if(k<=0) {
					return new ResponseMessage(Code.CODE_ERROR, "创建失败");
				}
			}
			for(int n=0;n<nextReviewerIdArray.size();n++) {
			InternalTodo BackLoginternalToDo=new InternalTodo();
			BackLoginternalToDo.setId(String.valueOf(UUID.randomUUID()));
			BackLoginternalToDo.setRelateddomain(internalProject.getName());
			BackLoginternalToDo.setRelateddomainId(internalProject.getId());
			BackLoginternalToDo.setSenderId(internalProject.getCreater());
			BackLoginternalToDo.setReceiverId(nextReviewerIdArray.getString(n));
			BackLoginternalToDo.setStatus("0");
			int b=internalToDoMapper.insert(BackLoginternalToDo);
			InternalWorkflowstep workflowstep=new InternalWorkflowstep();
			workflowstep.setId(String.valueOf(UUID.randomUUID()));
			workflowstep.setRelateddomain(internalProject.getName());
			workflowstep.setRelateddomainId(internalProject.getId());
			workflowstep.setActionuserId(nextReviewerIdArray.getString(n));
			workflowstep.setStatus("0");
			int m=internalWorkflowstepMapper.insert(workflowstep);
			if(b<=0) {
				return new ResponseMessage(Code.CODE_ERROR, "创建失败");
			}
			if(m<=0) {
				return new ResponseMessage(Code.CODE_ERROR, "创建失败");
			}
		}
			return new ResponseMessage(Code.CODE_OK, "创建成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseMessage(Code.CODE_OK, "创建成功");
	}
	
	//项目立项阶段的信息查询
	@Override
	public ResponseMessage selectProjectProcedures(String requestBody) {
		JSONObject jsonObj=JSONObject.parseObject(requestBody);
		String id=jsonObj.getString("id");
		String person_id=jsonObj.getString("person_id");
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
		List<InternalWorkflowstep> internalWorkflowstep = internalWorkflowstepMapper.selectByExample(example1);
		internalProject.setInternalWorkflowstep(internalWorkflowstep);
		return new ResponseMessage(Code.CODE_OK, "查询成功",internalProject);
	}
	
    
	//项目立项阶段的审批流程添加
	@Override
	public ResponseMessage insertProjectProcedures(String requestBody) {
		JSONObject jsonObj=JSONObject.parseObject(requestBody);
		String relateddomain=jsonObj.getString("relateddomain");//业务模块
		String relateddomain_id=jsonObj.getString("relateddomain_id");//业务id
		String sender_id=jsonObj.getString("sender_id");//当前人的id
		JSONArray nextReviewerId=JSONArray.parseArray(jsonObj.getString("nextReviewerId"));//下一个审核人的信息
		String currentstep_id=jsonObj.getString("currentstep_id");//当前处理步骤
		String todo_id=jsonObj.getString("todo_id");//当前todo表中id
		String workflowstep_id=jsonObj.getString("workflowstep_id");//当前workflowstep表中的id
		String actionComment=jsonObj.getString("actionComment");//审核意见
		String actionResult=jsonObj.getString("actionResult");//0 同意 1 不同意or退回
		/*
		 * 修改掉当前todo表对应的id的信息
		 */
		InternalTodo BackLoginternalToDo=new InternalTodo();
		BackLoginternalToDo.setId(todo_id);
		BackLoginternalToDo.setActiontime(new Date());
		BackLoginternalToDo.setStatus("1");
		int k=internalToDoMapper.updateByPrimaryKey(BackLoginternalToDo);
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
		int j=internalWorkflowstepMapper.updateByPrimaryKey(BackLoginternalWorkflowstep);
		if(j<=0) {
			return new ResponseMessage(Code.CODE_ERROR, "审核失败");
		}
		/*
		 * 选择下一个审核人进行的操作
		 * 对todo表中进行添加操作
		 * 对Workflowstep表中进行添加操作
		 */
		for(int c=0;c<nextReviewerId.size();c++) {	
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
		InternalWorkflowstep workflowstep=new InternalWorkflowstep();
		workflowstep.setId(String.valueOf(UUID.randomUUID()));
		workflowstep.setRelateddomain(relateddomain);
		workflowstep.setRelateddomainId(relateddomain_id);
		workflowstep.setPrestepId(workflowstep_id);
		workflowstep.setActionuserId(nextReviewerId.getString(c));
		workflowstep.setStatus("0");
		int n=internalToDoMapper.insert(internalToDo);
		int m=internalWorkflowstepMapper.insert(workflowstep);
		if(n<=0) {
			return new ResponseMessage(Code.CODE_ERROR, "添加下一个审核人信息失败");
		}else if(m<=0) {
			return new ResponseMessage(Code.CODE_ERROR, "添加下一个审核人信息失败");
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
		int k=internalToDoMapper.updateByPrimaryKey(BackLoginternalToDo);
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
		int j=internalWorkflowstepMapper.updateByPrimaryKey(BackLoginternalWorkflowstep);
		if(j<=0) {
			return new ResponseMessage(Code.CODE_ERROR, "归档失败");
		}
		 return new ResponseMessage(Code.CODE_OK, "归档完成");
	}
}
