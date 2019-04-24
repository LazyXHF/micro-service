package com.portjs.base.controller;

import com.portjs.base.aop.LogInfo;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.TUserService;
import com.portjs.base.service.WeeklyAndMonthlyReportManagementService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by dengshuangzhen on 2019\4\23 0023
 * 周报月报管理
 */
@RestController
@RequestMapping("WeeklyAndMonthlyReportManagement")
@CrossOrigin
public class WeeklyAndMonthlyReportManagementController extends BaseController  {
    static  final String tag = "UserController======>";
    private ResponseMessage responseMessage;
    @Autowired
    private WeeklyAndMonthlyReportManagementService weeklyAndMonthlyReportManagementService;




    @LogInfo(methodName = "周报详情查询",modelName = "周报月报管理模块")
    @RequestMapping("select-weekly-details")
    @ResponseBody
    public ResponseMessage selectWeeklyDetails(@RequestBody String requestBody){
        logger.debug(tag+requestBody);
        UnifiedExceptionHandler.method= tag+"select-weekly-details=============================="+requestBody;

        try {
            responseMessage = weeklyAndMonthlyReportManagementService.selectWeeklyDetails(requestBody);
        } catch (Exception e) {
            return new ResponseMessage(Code.CODE_ERROR,e.getMessage());
        }
        return responseMessage;
    }

    @LogInfo(methodName = "提交保存周报详情",modelName = "周报月报管理模块")
    @RequestMapping("submission-weekly-details")
    @ResponseBody
    public ResponseMessage submissionWeeklyDetails(@RequestBody String requestBody){
        logger.debug(tag+requestBody);
        UnifiedExceptionHandler.method= tag+"submission-weekly-details=============================="+requestBody;
        try {
            responseMessage = weeklyAndMonthlyReportManagementService.submissionWeeklyDetails(requestBody);
        } catch (Exception e) {
            return new ResponseMessage(Code.CODE_ERROR,e.getMessage());
        }
        return responseMessage;
    }
    @LogInfo(methodName = "周报查询",modelName = "周报月报管理模块")
    @RequestMapping("select-weekly")
    @ResponseBody
    public ResponseMessage selectWeekly(@RequestBody String requestBody){
        logger.debug(tag+requestBody);
        UnifiedExceptionHandler.method= tag+"select-weekly=============================="+requestBody;
        try {
            responseMessage = weeklyAndMonthlyReportManagementService.selectWeekly(requestBody);
        } catch (Exception e) {
            return new ResponseMessage(Code.CODE_ERROR,e.getMessage());
        }
        return responseMessage;
    }

}
