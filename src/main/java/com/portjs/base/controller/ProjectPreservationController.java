package com.portjs.base.controller;

/**
 * Created by dengshuangzhen on 2019\3\28 0028
 * 立项保存
 */

import com.portjs.base.aop.LogInfo;
import com.portjs.base.service.ProjectPreservationService;
import com.portjs.base.util.ResponseMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@CrossOrigin
@Controller
@RequestMapping("/projectPreservation")
public class ProjectPreservationController  extends BaseController {
    static final  String TAG = "ProjectController================>";
    @Resource
    private ProjectPreservationService projectPreservationService;
    @LogInfo(methodName = "立项暂存/提交",modelName = "立项保存模块")
    @RequestMapping("/insert-designs")
    @ResponseBody
    public ResponseMessage insertDesigns(@RequestBody String responseBody) {
        try {
            logger.error(TAG + "insert-designs()begin....." + responseBody);
            return projectPreservationService.insertStorage(responseBody);
        } catch (Exception e) {
            logger.error(TAG + "insert-designs()error.....", e);
            throw new RuntimeException();
        }
    }

    @LogInfo(methodName = "立项退回",modelName = "立项保存模块")
    @RequestMapping("/return-designs")
    @ResponseBody
    public ResponseMessage returnDesigns(@RequestBody String responseBody){
        try {
            logger.error(TAG + "return-designs()begin....." + responseBody);
            return projectPreservationService.returnStorage(responseBody);
        } catch (Exception e) {
            logger.error(TAG + "return-designs()error.....", e);
            throw new RuntimeException();
        }
    }

    @LogInfo(methodName = "查询所有下拉框",modelName = "投资计划管理模块")
    @RequestMapping("/select-box")
    @ResponseBody
    public ResponseMessage selectBox(@RequestBody String requestBody){
        try {
            logger.error(TAG + "select-box()begin....."+requestBody );
            return projectPreservationService.selectBox(requestBody);
        } catch (Exception e) {
            logger.error(TAG + "select-box()error.....", e);
            throw new RuntimeException();
        }
    }

    @LogInfo(methodName = "按条件分页查询投资计划",modelName = "投资计划管理模块")
    @RequestMapping("/select-investment")
    @ResponseBody
    public ResponseMessage selectInvestment(@RequestBody String requestBody){
        try {
            logger.error(TAG + "select-investment()begin....."+requestBody );
            return projectPreservationService.selectInvestment(requestBody);
        } catch (Exception e) {
            logger.error(TAG + "select-investment()error.....", e);
            throw new RuntimeException();
        }
    }

    @LogInfo(methodName = "Excel导入",modelName = "投资计划管理模块")
    @RequestMapping("/insert-for-excel")
    @ResponseBody
    public ResponseMessage insertForExcel(@RequestBody String requestBody){
        try {
            logger.error(TAG + "insert-for-excel()begin....."+requestBody );
            return projectPreservationService.selectInvestment(requestBody);
        } catch (Exception e) {
            logger.error(TAG + "insert-for-excel()error.....", e);
            throw new RuntimeException();
        }
    }

}
