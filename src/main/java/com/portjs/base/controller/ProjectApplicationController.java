package com.portjs.base.controller;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.ProjectApplicationService;
import com.portjs.base.util.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author gumingyang 项目
 **/
@Controller
@CrossOrigin
@RequestMapping("/projectApplication")
@Component
public class ProjectApplicationController extends BaseController {
    static final  String TAG = "ProjectApplication================>";
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    ProjectApplicationService applicationService;


    @LogInfo(methodName = "查询立项申请",modelName = "立项管理")
    @RequestMapping("queryProject")
    @ResponseBody
    public ResponseMessage queryProject(@RequestBody String responseBody){
        logger.debug(TAG+"queryProject() begin");

        JSONObject requestJson=JSONObject.parseObject(responseBody);
        return  applicationService.queryProject(requestJson);
    }


//==========================下面的接口是审核页面的查询接口===================================
    @LogInfo(methodName = "项目基本信息查询",modelName = "立项管理")
    @RequestMapping("queryProjectBase")
    @ResponseBody
    public ResponseMessage queryProjectBase(@RequestBody String responseBody) {
        logger.debug(TAG + "queryProjectBase() begin");
        JSONObject requestJson=JSONObject.parseObject(responseBody);
        return  applicationService.queryProjectBase(requestJson);
    }
    @LogInfo(methodName = "项目人员",modelName = "立项管理")
    @RequestMapping("queryProjectPersons")
    @ResponseBody
    public ResponseMessage queryProjectPersons(@RequestBody String responseBody) {
        logger.debug(TAG + "queryProjectPersons() begin");
        JSONObject requestJson=JSONObject.parseObject(responseBody);
        return  applicationService.queryProjectPersons(requestJson);
    }
    @LogInfo(methodName = "立项文件",modelName = "立项管理")
    @RequestMapping("queryProjectFiles")
    @ResponseBody
    public ResponseMessage queryProjectFiles(@RequestBody String responseBody) {
        logger.debug(TAG + "queryProjectFiles() begin");
        JSONObject requestJson=JSONObject.parseObject(responseBody);
        return  applicationService.queryProjectFiles(requestJson);
    }
    @LogInfo(methodName = "审批意见结果列表",modelName = "立项管理")
    @RequestMapping("queryProjectRecords")
    @ResponseBody
    public ResponseMessage queryProjectRecords(@RequestBody String responseBody) {
        logger.debug(TAG + "queryProjectRecords() begin");
        JSONObject requestJson=JSONObject.parseObject(responseBody);
        return  applicationService.queryProjectRecords(requestJson);
    }

//假删除  更改字段
    @LogInfo(methodName = "删除立项申请",modelName = "立项管理")
    @RequestMapping("deleteProject")
    @ResponseBody
    public ResponseMessage deleteProject(@RequestBody String responseBody){
        logger.debug(TAG+"deleteProject() begin");
        JSONObject requestJson=JSONObject.parseObject(responseBody);
        return  applicationService.deleteProject(requestJson);
    }

   /* 项目基本信息
    投资计划下拉框*/
   @LogInfo(methodName = "投资计划",modelName = "立项管理")
   @RequestMapping("queryProjectPlan")
   @ResponseBody
   public ResponseMessage queryProjectPlan(@RequestBody String responseBody){
       logger.debug(TAG+"queryProjectPlan() begin");
       JSONObject requestJson=JSONObject.parseObject(responseBody);
       return  applicationService.queryProjectPlan(requestJson);
   }








    @LogInfo(methodName = "编辑立项申请",modelName = "立项管理")
    @RequestMapping("updateProject")
    @ResponseBody
    public ResponseMessage updateProject(@RequestBody String responseBody){
        logger.debug(TAG+"updateProject() begin");
       JSONObject requestJson=JSONObject.parseObject(responseBody);
       return  applicationService.updateProject(requestJson);
    }



}
