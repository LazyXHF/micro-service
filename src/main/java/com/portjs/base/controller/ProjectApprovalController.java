package com.portjs.base.controller;

import com.portjs.base.aop.LogInfo;
import com.portjs.base.service.ProjectApprovalService;
import com.portjs.base.service.ProjectPreservationService;
import com.portjs.base.util.ResponseMessage;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author gumingyang
 **/
@CrossOrigin
@RestController
@RequestMapping("/FProject")
public class ProjectApprovalController extends BaseController{
    static final String TAG = "FProject===>";
    @Resource
    private ProjectApprovalService projectApprovalService;
    @Resource
    private ProjectPreservationService projectPreservationService;
    
    @RequestMapping("/circulation-project")
    //项目立项过程中的审核流转
    public ResponseMessage insertProjectProcedures(@RequestBody String requestBody) {
        logger.debug("circulation-projectbegin......"+requestBody);
        try {
            return projectApprovalService.insertProjectProcedures(requestBody);
        } catch (Exception e) {
            logger.error("circulation-project()error.....",e);
            throw new RuntimeException();
        }
    }
    @RequestMapping("/archive-project")
    //立项阶段的归档操作
    public ResponseMessage projectProceduresArchive(@RequestBody String requestBody) {
        logger.debug("archive-project()begin......"+requestBody);
        try {
            return projectApprovalService.projectProceduresArchive(requestBody);
        } catch (Exception e) {
            logger.error("archive-project()error.....",e);
            throw new RuntimeException();
        }
    }

    @LogInfo(methodName = "立项暂存/提交",modelName = "立项保存模块")
    @RequestMapping("/insert-designs")
    @ResponseBody
    public ResponseMessage insertDesigns(@RequestBody String responseBody){
        try {
            logger.error(TAG+"insert-designs()begin....."+responseBody);
            return projectPreservationService.insertStorage(responseBody);
        } catch (Exception e) {
            logger.error(TAG+"insert-designs()error.....",e);
            throw new RuntimeException();
        }
    }
    @LogInfo(methodName = "待办任务查询",modelName = "待办模块")
    @RequestMapping("/query-todos")
    @ResponseBody
    public ResponseMessage insertDesigs(@RequestBody String responseBody){
        try {
            logger.error(TAG+"query-todos()begin....."+responseBody);
            return projectApprovalService.queryTodos(responseBody);
        } catch (Exception e) {
            logger.error(TAG+"query-todos()error.....",e);
            throw new RuntimeException();
        }
    }
    @LogInfo(methodName = "待办跳转",modelName = "待办模块")
    @RequestMapping("/todos-go")
    @ResponseBody
    public ResponseMessage todoGo(@RequestBody String responseBody){
        try {
            logger.error(TAG+"todos-go()begin....."+responseBody);
            return projectApprovalService.todoGo(responseBody);
        } catch (Exception e) {
            logger.error(TAG+"todos-go()error.....",e);
            throw new RuntimeException();
        }
    }
    @LogInfo(methodName = "查询项目节点具体信息",modelName = "项目节点模块")
    @RequestMapping("/query-project-details")
    @ResponseBody
    public ResponseMessage queryProjectDetials(@RequestBody String responseBody){
        try {
            logger.error(TAG+"query-project-details()begin....."+responseBody);
            return projectApprovalService.queryProjectDetials(responseBody);
        } catch (Exception e) {
            logger.error(TAG+"query-project-details()error.....",e);
            throw new RuntimeException();
        }
    }
}
