package com.portjs.base.controller;

import com.portjs.base.aop.LogInfo;
import com.portjs.base.exception.UnifiedExceptionHandler;
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
        logger.debug(TAG + responseBody);
        UnifiedExceptionHandler.method= responseBody + "insert-designs==============================" + responseBody;
        return projectPreservationService.insertStorage(responseBody);
    }
}
