package com.portjs.base.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portjs.base.service.ProjectProceduresService;
import com.portjs.base.util.ResponseMessage;

@CrossOrigin
@RestController
@RequestMapping("/projectProcedures")
public class ProjectProceduresContoller extends BaseController {
	static final String tag = "ProjectProceduresService===>";
   @Autowired
   private ProjectProceduresService projectProceduresService;
   //提交
   @RequestMapping("/create-project-procedures")
   public ResponseMessage createProjectProcedures(@RequestBody Map<String, Object> requestBody) {
	   logger.debug("create-project-procedures()begin......"+requestBody);
	   try {
		   return projectProceduresService.createProjectProcedures(requestBody);
		} catch (Exception e) {
		logger.error("create-project-procedures()error....",e);
		throw new RuntimeException();
		}
	
   }
   @RequestMapping("/select-project-procedures")
   //展示立项阶段的页面基本信息
   public ResponseMessage selectProjectProcedures(@RequestBody String requestBody) {
	   logger.debug("select-project-procedures()begin......"+requestBody);
	   try {
		return projectProceduresService.selectProjectProcedures(requestBody);
	} catch (Exception e) {
		logger.error("select-project-procedures()error....",e);
		throw new RuntimeException();
	}
   }
   @RequestMapping("/insert-project-procedures")
   //项目立项过程中的审核流转
   public ResponseMessage insertProjectProcedures(@RequestBody String requestBody) {
	   logger.debug("insertProjectProcedures()begin......"+requestBody);
	try {
		return projectProceduresService.insertProjectProcedures(requestBody);
	} catch (Exception e) {
		logger.error("insertProjectProcedures()error.....",e);
		throw new RuntimeException();
	}   
   }
   @RequestMapping("/project-procedures-archive")
   //立项阶段的归档操作
   public ResponseMessage projectProceduresArchive(@RequestBody String requestBody) {
	
	   logger.debug("projectProceduresArchive()begin......"+requestBody);
		try {
			return projectProceduresService.projectProceduresArchive(requestBody);
		} catch (Exception e) {
			logger.error("projectProceduresArchive()error.....",e);
			throw new RuntimeException();
		}   
   }
}
