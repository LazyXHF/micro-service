package com.portjs.base.service;

import com.portjs.base.util.ResponseMessage;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface ProjectApprovalService {

	/**
	 * 项目立项阶段的审批流程添加
	 * @param requestBody
	 * @return
	 */
	ResponseMessage insertProjectProcedures(String requestBody)throws Exception;
    
	/**
	 * 立项阶段的归档操作
	 * @param requestBody
	 * @return
	 */
	ResponseMessage projectProceduresArchive(String requestBody)throws Exception;

	/**
	 * 待办查询
	 * @param requestBody
	 * @return
	 * @throws Exception
	 */
	ResponseMessage queryTodos(String requestBody)throws Exception;
}
