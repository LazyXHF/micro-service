package com.portjs.base.controller;


import com.portjs.base.service.TXietongMrReservationService;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/TXietongMrReservation")
public class TXietongMrReservationController {
	@Autowired
	private TXietongMrReservationService txietongMrReservation;
    /**
     * 会议查询
     * @param requestBody
     * @return
     */
	@RequestMapping("selectTXietongMrReservation")
	public ResponseMessage selectTXietongMrReservation(@RequestBody String requestBody) {
		return txietongMrReservation.selectTXietongMrReservation(requestBody);
	}
	
	/**
	 * 新建会议
	 * @param requestBody
	 * @return
	 */
    @RequestMapping("insertTXietongMrReservation")
    public ResponseMessage insertTXietongMrReservation(@RequestBody String requestBody) {
    	return txietongMrReservation.insertTXietongMrReservation(requestBody);
    }
    /**
     * 发布会议
     * @param requestBody
     * @return
     */
    @RequestMapping("txietongMrReservationPublish")
    public ResponseMessage txietongMrReservationPublish(@RequestBody String requestBody) {
    	return txietongMrReservation.txietongMrReservationPublish(requestBody);
    }
    /**
     * 编辑会议
     * @param requestBody
     * @return
     */
	@RequestMapping("updateTXietongMrReservation")
	public ResponseMessage updateTXietongMrReservation(@RequestBody String requestBody) {
		return txietongMrReservation.updateTXietongMrReservation(requestBody);
	}
    /**
     * 删除会议
     * @param requestBody
     * @return
     */
	@RequestMapping("deleteTXietongMrReservation")
	public ResponseMessage deleteTXietongMrReservation(@RequestBody String requestBody) {
		return txietongMrReservation.deleteTXietongMrReservation(requestBody);
	}
	/**
	 * 待开会议查询
	 * @param requestBody
	 * @return
	 */
	@RequestMapping("waitingTXietongMrReservation")
	public ResponseMessage waitingTXietongMrReservation(@RequestBody String requestBody) {
		return txietongMrReservation.waitingTXietongMrReservation(requestBody);
	}
	/**
	 * 撤销待开会议
	 * @param requestBody
	 * @return
	 */
	@RequestMapping("revocationTXietongMrReservation")
	public ResponseMessage revocationTXietongMrReservation(@RequestBody String requestBody) {
		return txietongMrReservation.revocationTXietongMrReservation(requestBody);
	}
	/**
	 * 会议的详细信息
	 */
	@RequestMapping("txietongMrReservationInformation")
	public ResponseMessage txietongMrReservationInformation(@RequestBody String requestBody) {
		return txietongMrReservation.txietongMrReservationInformation(requestBody);
	}
	/**
	 * 已开会议的查询详情
	 * @param requestBody
	 * @return
	 */
	@RequestMapping("txietongMrReservationIsOver")
	public ResponseMessage txietongMrReservationIsOver(@RequestBody String requestBody) {
		return txietongMrReservation.txietongMrReservationIsOver(requestBody);
	}
	
}
