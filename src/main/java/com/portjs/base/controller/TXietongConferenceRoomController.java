package com.portjs.base.controller;

import com.portjs.base.aop.LogInfo;
import com.portjs.base.service.TXietongConferenceRoomService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/TXietongConferenceRoom")
public class TXietongConferenceRoomController extends BaseController {
	@Autowired
	private TXietongConferenceRoomService txietongConferenceRoom;
	
	private ResponseMessage responseMessage;

	/**
	 * 根据用户和用户部门获取可见范围的会议室
	 * 
	 * @param requestBody
	 * @return
	 */
	@LogInfo(methodName = "根据用户和用户部门获取可见范围的会议室")
	@RequestMapping("selectMeetingRoom")
	public ResponseMessage selectMeetingRoom(@RequestBody String requestBody) {
		logger.debug("selectMeetingRoom()begin requestBody=",requestBody);
		try {
			responseMessage=txietongConferenceRoom.selectMeetingRoom(requestBody);
			return responseMessage;
		} catch (Exception e) {
			logger.error("selectMeetingRoom()error=",e);
			responseMessage=new ResponseMessage(Code.CODE_ERROR, "服务器异常"+e);
			return responseMessage;
		}
	}
	/**
	 * 获取会议室申请的详细信息
	 * @param requestBody
	 * @return
	 */
	@RequestMapping("selectConferenceRoom")
	public ResponseMessage selectConferenceRoom(@RequestBody String requestBody) {
		logger.debug("selectConferenceRoom()begin requestBody=",requestBody);
		try {
			responseMessage= txietongConferenceRoom.selectConferenceRoom(requestBody);
			return responseMessage;
		} catch (Exception e) {
			logger.error("selectConferenceRoom()error=",e);
			responseMessage=new ResponseMessage(Code.CODE_ERROR, "服务器异常"+e);
			return responseMessage;
		}
	}
	/**
	 * 预定会议室
	 * @param requestBody
	 * @return
	 */
	@RequestMapping("reserveConferenceRoom")
	public ResponseMessage reserveConferenceRoom(@RequestBody String requestBody) {
		logger.debug("reserveConferenceRoom()begin requestBody=",requestBody);
		try {
			responseMessage= txietongConferenceRoom.reserveConferenceRoom(requestBody);
			return responseMessage;
		} catch (Exception e) {
			logger.error("reserveConferenceRoom()error=",e);
			responseMessage=new ResponseMessage(Code.CODE_ERROR, "服务器异常"+e);
			return responseMessage;
		}
	}
	/**
	 * 预定详情
	 * @param requestBody
	 * @return
	 */
	@RequestMapping("reservationDetails")
	public ResponseMessage reservationDetails(@RequestBody String requestBody) {
		logger.debug("reservationDetails()begin requestBody=",requestBody);
		try {
			responseMessage= txietongConferenceRoom.reservationDetails(requestBody);
			return responseMessage;
		} catch (Exception e) {
			logger.error("reservationDetails()error=",e);
			responseMessage=new ResponseMessage(Code.CODE_ERROR, "服务器异常"+e);
			return responseMessage;
		}
	}
	/**
	 * 取消会议室预定
	 * @param requestBody
	 * @return
	 */
	@RequestMapping("cancelConferenceRoom")
	public ResponseMessage cancelConferenceRoom(@RequestBody String requestBody) {
		logger.debug("cancelConferenceRoom()begin requestBody=",requestBody);
		try {
			responseMessage= txietongConferenceRoom.cancelConferenceRoom(requestBody);
			return responseMessage;
		} catch (Exception e) {
			logger.error("cancelConferenceRoom()error=",e);
			responseMessage=new ResponseMessage(Code.CODE_ERROR, "服务器异常"+e);
			return responseMessage;
		}
	}
	/**
	 * 会议室审批
	 * @param requestBody
	 * @return
	 */
	@RequestMapping("approveConferenceRoom")
	public ResponseMessage approveConferenceRoom(@RequestBody String requestBody) {
		logger.debug("approveConferenceRoom()begin requestBody=",requestBody);
		try {
			responseMessage= txietongConferenceRoom.approveConferenceRoom(requestBody);
			return responseMessage;
		} catch (Exception e) {
			logger.error("approveConferenceRoom()error=",e);
			responseMessage=new ResponseMessage(Code.CODE_ERROR, "服务器异常"+e);
			return responseMessage;
		}
	}
	/**
	 * 审批人审批
	 * @param requestBody
	 * @return
	 */
	@RequestMapping("updateAfterCheckConferenceRoom")
	public ResponseMessage updateAfterCheckConferenceRoom(@RequestBody String requestBody) {
		logger.debug("updateAfterCheckConferenceRoom()begin requestBody=",requestBody);
		try {
			responseMessage=txietongConferenceRoom.updateAfterCheckConferenceRoom(requestBody);
			return responseMessage;
		} catch (Exception e) {
			logger.error("updateAfterCheckConferenceRoom()error=",e);
			responseMessage=new ResponseMessage(Code.CODE_ERROR, "服务器异常"+e);
			return responseMessage;
		}
	}
}
