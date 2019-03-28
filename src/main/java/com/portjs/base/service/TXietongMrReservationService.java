package com.portjs.base.service;

import com.portjs.base.util.ResponseMessage;


public interface TXietongMrReservationService {
	/**
	 * 会议查询
	 * 
	 * @param requestBody
	 * @return
	 */
	ResponseMessage selectTXietongMrReservation(String requestBody);

	/**
	 * 新建会议
	 * 
	 * @param requestBody
	 * @return
	 */
	ResponseMessage insertTXietongMrReservation(String requestBody);

	/**
	 * 编辑会议
	 * 
	 * @param requestBody
	 * @return
	 */
	ResponseMessage updateTXietongMrReservation(String requestBody);

	/**
	 * 删除会议
	 * 
	 * @param requestBody
	 * @return
	 */
	ResponseMessage deleteTXietongMrReservation(String requestBody);
    /**
     * 待开会议
     * @param requestBody
     * @return
     */
	ResponseMessage waitingTXietongMrReservation(String requestBody);
    /**
     * 撤销待开会议
     * @param requestBody
     * @return
     */
	ResponseMessage revocationTXietongMrReservation(String requestBody);
    /**
     * 会议的查询详情
     * @param requestBody
     * @return
     */
	ResponseMessage txietongMrReservationInformation(String requestBody);
    /**
     * 已开会议的查询详情
     * @param requestBody
     * @return
     */
	ResponseMessage txietongMrReservationIsOver(String requestBody);
    /**
     * 会议发布
     * @param requestBody
     * @return
     */
	ResponseMessage txietongMrReservationPublish(String requestBody);

}
