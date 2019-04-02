package com.portjs.base.controller;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.CommunicationLog;
import com.portjs.base.entity.ProjectCommunication;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.CommunicationLogService;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.ArrayVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目沟通模块沟通记录
 */
@RequestMapping("communication-log")
@CrossOrigin
@RestController
public class CommunicationLogController extends BaseController {
    ResponseMessage responseMessage=null;
    static final String TAG = "communicationLogService===>";

    @Autowired
    CommunicationLogService communicationLogService;


    /**
     * 根据id批量软删除项目问题信息
     * @param
     * @return
     */
    /*@RequestMapping("delete-communication-log")
    @LogInfo(methodName = "根据id删除项目问题信息")
    public ResponseMessage deleteCommunicationLogs(@RequestBody ArrayVO arrayVO) {
        logger.debug(TAG+arrayVO);
        UnifiedExceptionHandler.method = TAG + "deleteCommunicationLogs============================" +arrayVO;
        responseMessage = communicationLogService.deleteCommunicationLogs(arrayVO.getList());
        return responseMessage;
    }*/
    /**
     * 修改项目问题记录信息
     * @param record
     * @return
     */
    @RequestMapping("update-communication-log")
    @LogInfo(methodName = "根据id更新项目问题记录信息")
    public ResponseMessage updateByPrimaryKeySelective(@RequestBody CommunicationLog record) {
        logger.debug(TAG+record);
        UnifiedExceptionHandler.method = TAG + "updateByPrimaryKeySelective============================" +record;
        responseMessage = communicationLogService.updateByPrimaryKeySelective(record);
        return responseMessage;
    }

    /**
     * 新建项目问题记录信息
     * @param record
     * @return
     */
    @RequestMapping("insert-communication-log")
    @LogInfo(methodName = "新建项目问题记录信息")
    public ResponseMessage insertCommunicationLogSelective(@RequestBody CommunicationLog record) {
        logger.debug(TAG+record);
        UnifiedExceptionHandler.method = TAG + "insertCommunicationLogSelective============================" +record;
        responseMessage = communicationLogService.insertCommunicationLogSelective(record);
        return responseMessage;
    }
    /**
     * 查询项目沟通记录信息
     * @param communicationId
     * @return
     */
    @RequestMapping("query-communication-log-info")
    @LogInfo(methodName = "查询项目沟通信息")
    public ResponseMessage queryCommunicationInfo(@RequestBody String communicationId) {
        logger.debug(TAG+communicationId);
        JSONObject jsonObject = JSONObject.parseObject(communicationId);
        String communicationIds = jsonObject.getString("communicationId");
        UnifiedExceptionHandler.method = TAG + "queryProjectCommunicationInfo()==================================>" + communicationIds;
        responseMessage = communicationLogService.queryCommunicationLog(communicationIds);
        return responseMessage;
    }

    /**
     * 查询项目沟通记录再回复信息
     * @param id  记录信息id
     * @return
     */
    @RequestMapping("query-project-communication-info-reply")
    @LogInfo(methodName = "查询项目沟通信息再回复")
    public ResponseMessage queryCommunicationLogs(@RequestBody String id) {
        logger.debug(TAG+id);
        JSONObject jsonObject = JSONObject.parseObject(id);
        String ids = jsonObject.getString("id");
        UnifiedExceptionHandler.method = TAG + "queryProjectCommunicationInfo()==================================>" + ids;
        responseMessage = communicationLogService.queryCommunicationLogs(ids);
        return responseMessage;
    }

}
