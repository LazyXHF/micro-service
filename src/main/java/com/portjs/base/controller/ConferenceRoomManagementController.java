package com.portjs.base.controller;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.service.ConferenceRoomManagementService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 会议室申请
 * Created by dengshuangzhen on 2018\12\17 0017
 */

@RestController
@CrossOrigin
@RequestMapping("/ConferenceRoomManagement")

public class ConferenceRoomManagementController extends BaseController{
    @Autowired
    private ConferenceRoomManagementService conferenceRoomManagement;

    private String tag = "ConferenceRoomManagementController()";
    private ResponseMessage responseMessage = null;

    /**
     * 申请人查询所有会议室
     * @return
     */
    @LogInfo(methodName = "申请人查询所有会议室")
    @RequestMapping("selectConferenceRoom")
    public ResponseMessage selectConferenceRoom () {
        logger.debug(tag+"selectConferenceRoom() begin...");
        try {
            return conferenceRoomManagement.selectConferenceRoom();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("selectConferenceRoom() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }

    /**
     * 申请人新增会议室预定
     * @return
     */
    @LogInfo(methodName = "申请人新增会议室预定")
    @RequestMapping("insertConferenceRoom")
    public ResponseMessage insertConferenceRoom (@RequestBody String requestBody) {
        logger.debug("insertConferenceRoom() begin...",requestBody);
        try {
            logger.debug("insertConferenceRoom() begin...",requestBody);
            responseMessage = conferenceRoomManagement.insertConferenceRoom(requestBody);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("insertConferenceRoom() end...",e);
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"未知异常");
            return responseMessage;
        }
        return responseMessage;
    }


    /**
     * 申请人查询会议室预定
     * @return
     */
    @LogInfo(methodName = "申请人查询会议室预定")
    @RequestMapping("selectReservation")
    public ResponseMessage selectReservation (@RequestBody String requestBody) {
        logger.debug("selectReservation() begin...",requestBody);
        try {
            return conferenceRoomManagement.selectReservation(requestBody);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("selectReservation() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }

    /**
     * 查询申请人会议室预定详情
     * @return
     */
    @LogInfo(methodName = "查询申请人会议室预定详情")
    @RequestMapping("selectReservationDetails")
    public ResponseMessage selectReservationDetails (@RequestBody String requestBody) {
        logger.debug("selectReservationDetails() begin...",requestBody);
        try {
            return conferenceRoomManagement.selectReservationDetails(requestBody);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("selectReservationDetails() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }

    /**
     * 申请人取消会议室预定
     * @return
     */
    @LogInfo(methodName = "申请人取消会议室预定")
    @RequestMapping("updateReservationDetails")
    public ResponseMessage updateReservationDetails (@RequestBody String requestBody) {
        logger.debug("updateReservationDetails() begin...",requestBody);
        try {
            return conferenceRoomManagement.updateReservationDetails(requestBody);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("updateReservationDetails() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }


    /**
     * 审核人审核页面查询
     * @return
     */
    @LogInfo(methodName = "审核人审核页面查询")
    @RequestMapping("selectUserAll")
    public ResponseMessage selectUserAll (@RequestBody String requestBody) {
        logger.debug("selectUserAll() begin...",requestBody);
        try {
            return conferenceRoomManagement.selectUserAll(requestBody);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("selectUserAll() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }


    /**
     * 审核人审核页面查询
     * @return
     */
    @LogInfo(methodName = "审核人审核页面查询")
    @RequestMapping("conferenceRoomAudit")
    public ResponseMessage conferenceRoomAudit (@RequestBody String requestBody) {
        logger.debug("conferenceRoomAudit() begin...",requestBody);
        try {
            return conferenceRoomManagement.conferenceRoomAudit(requestBody);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("conferenceRoomAudit() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }

    /**
     * 审核人审核页面审核
     * @return
     */
    @LogInfo(methodName = "审核人审核页面查询")
    @RequestMapping("updateconferenceRoomAudit")
    public ResponseMessage updateconferenceRoomAudit (@RequestBody String requestBody) {
        logger.debug("conferenceRoomAudit() begin...",requestBody);
        try {
            return conferenceRoomManagement.updateconferenceRoomAudit(requestBody);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("updateconferenceRoomAudit() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }



}
