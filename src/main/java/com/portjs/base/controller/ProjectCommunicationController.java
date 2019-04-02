package com.portjs.base.controller;

import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.ProjectCommunication;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.ProjectCommunicationService;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.ArrayVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目沟通模块（信息展示）
 */
@RequestMapping("projectCommunication")
@CrossOrigin
@RestController
public class ProjectCommunicationController extends BaseController{
    ResponseMessage responseMessage=null;
    static final String TAG = "projectCommunicationService===>";

    @Autowired
    ProjectCommunicationService projectCommunicationService;

    /**
     * 查询项目沟通信息并分页且模糊查询
     * @param requestBody
     * @return
     */
    @RequestMapping("query-project-communication-info")
    @LogInfo(methodName = "查询项目沟通信息并分页且模糊查询")
    public ResponseMessage queryProjectCommunicationInfo(@RequestBody String requestBody) {
        logger.debug(TAG+requestBody);
        UnifiedExceptionHandler.method = TAG + "queryProjectCommunicationInfo()==================================>" + requestBody;
        responseMessage = projectCommunicationService.queryProjectCommunicationInfo(requestBody);
        return responseMessage;
    }

    /**
     * 根据id批量软删除项目问题信息
     * @param
     * @return
     */
    @RequestMapping("update-project-communication-delete-time")
    @LogInfo(methodName = "根据id删除项目问题信息")
    public ResponseMessage updateDeleteTime(@RequestBody ArrayVO arrayVO) {
        logger.debug(TAG+arrayVO);
        UnifiedExceptionHandler.method = TAG + "insertDeleteTime============================" +arrayVO;
        responseMessage = projectCommunicationService.updateDeleteTime(arrayVO.getList());
        return responseMessage;
    }

    /**
     * 修改项目问题信息
     * @param record
     * @return
     */
    @RequestMapping("update-project-communication")
    @LogInfo(methodName = "根据id更新项目问题信息")
    public ResponseMessage updateByPrimaryKeySelective(@RequestBody ProjectCommunication record) {
        logger.debug(TAG+record);
        UnifiedExceptionHandler.method = TAG + "updateByPrimaryKeySelective============================" +record;
        responseMessage = projectCommunicationService.updateByPrimaryKeySelective(record);
        return responseMessage;
    }

    /**
     * 新建项目问题信息
     * @param record
     * @return
     */
    @RequestMapping("insert-project-communication")
    @LogInfo(methodName = "新建项目问题信息")
    public ResponseMessage insertProjectCommunicationSelective(@RequestBody ProjectCommunication record) {
        logger.debug(TAG+record);
        UnifiedExceptionHandler.method = TAG + "insertSelective============================" +record;
        responseMessage = projectCommunicationService.insertProjectCommunicationSelective(record);
        return responseMessage;
    }
}
