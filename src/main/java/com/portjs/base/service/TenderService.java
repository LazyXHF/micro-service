package com.portjs.base.service;

import com.portjs.base.util.ResponseMessage;

public interface TenderService {

	/**
	 * 招标的采购清单查询
	 * @param requestBody
	 * @return
	 */
	ResponseMessage queryRequests(String requestBody)throws Exception;

	/**
	 * 生成招标申请单号
	 * @return
	 */
	ResponseMessage getTenderNum();

	/**
	 * 暂存/提交
	 * @param requestBody
	 * @return
	 */
	ResponseMessage insertTender(String requestBody);

	/**
	 *查询招标申请单
	 * @param requestBody
	 * @return
	 */
	ResponseMessage queryTender(String requestBody);

	/**
	 * 查询招标流程申请单
	 * @param requestBody
	 * @return
	 */
	ResponseMessage queryReviewTender(String requestBody);
	/**
	 *废除
	 * @param requestBody
	 * @return
	 */
	ResponseMessage abolitionTender(String requestBody);
	/**
	 *删除
	 * @param requestBody
	 * @return
	 */
	ResponseMessage deleteTender(String requestBody);
	/**
	 *审核
	 * @param requestBody
	 * @return
	 */
	ResponseMessage reviewTender(String requestBody);

	/**
	 *定标
	 * @param requestBody
	 * @return
	 */
	ResponseMessage targetTender(String requestBody);

	/**
	 *退回
	 * @param requestBody
	 * @return
	 */
	ResponseMessage returnTender(String requestBody);
}
