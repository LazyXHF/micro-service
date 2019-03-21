package com.portjs.base.service;

import com.portjs.base.util.ResponseMessage;

public interface TXietongMeetingroomService {
	/**
	 * 添加会议室信息
	 * @param requestBody
	 * @return
	 */
	 ResponseMessage insertMeetingroom(String requestBody);
	 /**
	  * 查询会议室信息
	  * @param requestBody
	  * @return
	  */
	  ResponseMessage selectMeetingroom(String requestBody);
	  /**
	   * 编辑会议室之前获取该会议室信息
	   * @param requestBody
	   * @return
	   */
	  ResponseMessage selectMeetingroomBeforUpdate(String requestBody);
      /**
       * 修改会议室信息
       * @param requestBody
       * @return
       */
	  ResponseMessage updateMeetingroom(String requestBody);
      /**
       * 冻结会议室信息
       * @param requestBody
       * @return
       */
	  ResponseMessage deleteMeetingroom(String requestBody);
}
