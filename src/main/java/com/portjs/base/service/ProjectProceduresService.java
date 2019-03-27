package com.portjs.base.service;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;

import com.portjs.base.util.ResponseMessage;

public interface ProjectProceduresService {
	/**
	 * 创建项目流程
	 * @param requestBody
	 * @return
	 */
	ResponseMessage createProjectProcedures(@RequestBody Map<String, Object> requestBody);
	
	/**
	 * 项目立项阶段的信息查询
	 * @param requestBody
	 * @return
	 */
	ResponseMessage selectProjectProcedures(String requestBody);
    
	/**
	 * 项目立项阶段的审批流程添加
	 * @param requestBody
	 * @return
	 */
	ResponseMessage insertProjectProcedures(String requestBody);
    
	/**
	 * 立项阶段的归档操作
	 * @param requestBody
	 * @return
	 */
	ResponseMessage projectProceduresArchive(String requestBody);

	

	

}
