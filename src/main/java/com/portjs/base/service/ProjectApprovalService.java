package com.portjs.base.service;

import com.portjs.base.util.ResponseMessage;

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

	/**
	 * 待办查询
	 * @param requestBody
	 * @return
	 * @throws Exception
	 */
	ResponseMessage todoGo(String requestBody)throws Exception;

	/**
	 *
	 * @param requestBody
	 * @return
	 * @throws Exception
	 */
	ResponseMessage queryProjectDetials(String requestBody)throws Exception;

	/**
	 *项目注册审核
	 * @param requestBody
	 * @return
	 * @throws Exception
	 */
	ResponseMessage insertProjectProcedureRegistration(String requestBody)throws  Exception;
}
