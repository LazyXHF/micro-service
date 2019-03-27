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
@RequestMapping("projectProcedures")
public class ProjectProceduresContoller extends BaseController {
	static final String tag = "ProjectProceduresService===>";
   @Autowired
   private ProjectProceduresService projectProceduresService;
   @RequestMapping("createProjectProcedures")
   public ResponseMessage createProjectProcedures(@RequestBody Map<String, Object> requestBody) {
	   logger.debug("createProjectProcedures()begin......"+requestBody);
	   try {
		   return projectProceduresService.createProjectProcedures(requestBody);
	} catch (Exception e) {
		logger.error("createProjectProcedures()error....",e);
		throw new RuntimeException();
	}
	
   }
   @RequestMapping("selectProjectProcedures")
   //展示立项阶段的页面基本信息
   public ResponseMessage selectProjectProcedures(@RequestBody String requestBody) {
	   logger.debug("selectProjectProcedures()begin......"+requestBody);
	   try {
		return projectProceduresService.selectProjectProcedures(requestBody);
	} catch (Exception e) {
		logger.error("selectProjectProcedures()error....",e);
		throw new RuntimeException();
	}
   }
   @RequestMapping("insertProjectProcedures")
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
   @RequestMapping("projectProceduresArchive")
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
