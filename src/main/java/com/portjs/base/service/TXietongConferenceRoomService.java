package com.portjs.base.service;

import com.portjs.base.util.ResponseMessage;


public interface TXietongConferenceRoomService {
	/**
	 * 根据用户和用户部门获取可见范围的会议室
	 * 
	 * @param requestBody
	 * @return
	 */
	ResponseMessage selectMeetingRoom(String requestBody);

	/**
	 * 获取会议室申请的详细信息
	 * 
	 * @param requestBody
	 * @return
	 */
	ResponseMessage selectConferenceRoom(String requestBody);

	/**
	 * 预定会议室
	 * 
	 * @param requestBody
	 * @return
	 */
	ResponseMessage reserveConferenceRoom(String requestBody);

	/**
	 * 会议室审批
	 * 
	 * @param requestBody
	 * @return
	 */
	ResponseMessage approveConferenceRoom(String requestBody);

	/**
	 * 审批人审批会议室
	 * 
	 * @param requestBody
	 * @return
	 */
	ResponseMessage updateAfterCheckConferenceRoom(String requestBody);

	/**
	 * 会议室预定详情
	 * 
	 * @param requestBody
	 * @return
	 */
	ResponseMessage reservationDetails(String requestBody);

	/**
	 * 取消会议室预定
	 * @param requestBody
	 * @return
	 */
	ResponseMessage cancelConferenceRoom(String requestBody);
}
