package com.portjs.base.controller;


import com.portjs.base.aop.LogInfo;
import com.portjs.base.service.TXietongMeetingroomService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/TXietongMeetingroom")
public class TXietongMeetingRoomController extends BaseController{
	 @Autowired
	 private TXietongMeetingroomService txietongMeetingroom;
	 
	 private ResponseMessage responseMessage;
	  /**
	     * 新增会议室
	     * @return
	     */
	    @LogInfo(methodName = "新增会议室")
	    @RequestMapping("insertMeetingroom")
	    public ResponseMessage insertMeetingroom (@RequestBody String requestBody) {
          logger.debug("insertMeetingroom()begin requestBody=",requestBody);
  		try {
  			responseMessage=txietongMeetingroom.insertMeetingroom(requestBody);
  			return responseMessage;
  		} catch (Exception e) {
  			logger.error("insertMeetingroom()error=",e);
  			responseMessage=new ResponseMessage(Code.CODE_ERROR, "服务器异常"+e);
  			return responseMessage;
  		}
	   }

	    /**
	     * 查询会议室
	     * @return
	     */
	    @LogInfo(methodName = "查询会议室")
	    @RequestMapping("selectMeetingroom")
	    public ResponseMessage selectMeetingroom (@RequestBody String requestBody) {
	    	logger.debug("selectMeetingroom()begin requestBody=",requestBody);
	    	try {
	  			responseMessage=txietongMeetingroom.selectMeetingroom(requestBody);
	  			return responseMessage;
	  		} catch (Exception e) {
	  			logger.error("selectMeetingroom()error=",e);
	  			responseMessage=new ResponseMessage(Code.CODE_ERROR, "服务器异常"+e);
	  			return responseMessage;
	  		}
	    }
	    /**
	     * 
	     * 修改会议室之前获取该条信息
	     * @return
	     */
	    @LogInfo(methodName = "查询会议室")
	    @RequestMapping("selectMeetingroomBeforUpdate")
	    public  ResponseMessage selectMeetingroomBeforUpdate(String requestBody) {
	    	logger.debug("selectMeetingroomBeforUpdate()begin requestBody=",requestBody);
	    	try {
	  			responseMessage=txietongMeetingroom.selectMeetingroomBeforUpdate(requestBody);
	  			return responseMessage;
	  		} catch (Exception e) {
	  			logger.error("selectMeetingroomBeforUpdate()error=",e);
	  			responseMessage=new ResponseMessage(Code.CODE_ERROR, "服务器异常"+e);
	  			return responseMessage;
	  		}
	    }
	    /**
	     * 修改会议室
	     * @return
	     */
	    @LogInfo(methodName = "修改会议室")
	    @RequestMapping("updateMeetingroom")
	    public ResponseMessage updateMeetingroom (@RequestBody String requestBody) {
	    	logger.debug("updateMeetingroom()begin requestBody=",requestBody);
	    	try {
	  			responseMessage=txietongMeetingroom.updateMeetingroom(requestBody);
	  			return responseMessage;
	  		} catch (Exception e) {
	  			logger.error("updateMeetingroom()error=",e);
	  			responseMessage=new ResponseMessage(Code.CODE_ERROR, "服务器异常"+e);
	  			return responseMessage;
	  		}
	    }


	    /**
	     * 删除会议室
	     * @return
	     */
	    @LogInfo(methodName = "删除会议室")
	    @RequestMapping("deleteMeetingroom")
	    public ResponseMessage deleteMeetingroom (@RequestBody String requestBody) {
	    	logger.debug("deleteMeetingroom()begin requestBody=",requestBody);
	    	try {
	  			responseMessage=txietongMeetingroom.deleteMeetingroom(requestBody);
	  			return responseMessage;
	  		} catch (Exception e) {
	  			logger.error("deleteMeetingroom()error=",e);
	  			responseMessage=new ResponseMessage(Code.CODE_ERROR, "服务器异常"+e);
	  			return responseMessage;
	  		}
	    }

}
