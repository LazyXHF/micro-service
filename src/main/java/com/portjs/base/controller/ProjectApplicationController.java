package com.portjs.base.controller;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.ProjectApplicationService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ProjectAddorUpdateUtil;
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
        try {
            JSONObject requestJson=JSONObject.parseObject(responseBody);
            return  applicationService.queryProjectBase(requestJson);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(Code.CODE_ERROR,e.getMessage());
        }
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
    @LogInfo(methodName = "待办审批",modelName = "立项管理")
    @RequestMapping("toApprove")
    @ResponseBody
    public ResponseMessage toApprove(@RequestBody String responseBody) {
        logger.debug(TAG + "toApprove() begin");
        JSONObject requestJson=JSONObject.parseObject(responseBody);
        return  applicationService.toApprove(requestJson);
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
   public ResponseMessage queryProjectPlan(){
       logger.debug(TAG+"queryProjectPlan() begin");
       return  applicationService.queryProjectPlan();
   }
    @LogInfo(methodName = "投资计划对应项目信息",modelName = "立项管理")
    @RequestMapping("queryProjectPlanInfo")
    @ResponseBody
    public ResponseMessage queryProjectPlanInfo(@RequestBody String responseBody){
        logger.debug(TAG+"queryProjectPlanInfo() begin");
        JSONObject requestJson=JSONObject.parseObject(responseBody);
        return  applicationService.queryProjectPlanInfo(requestJson);
    }







    @LogInfo(methodName = "编辑立项申请",modelName = "立项管理")
    @RequestMapping("updateProject")
    @ResponseBody
    public ResponseMessage updateProject(@RequestBody String responseBody){
        logger.debug(TAG+"updateProject() begin");
       JSONObject requestJson=JSONObject.parseObject(responseBody);
       return  applicationService.updateProject(requestJson);
    }
    @Autowired
    ProjectAddorUpdateUtil projectAddorUpdateUtil;
    @LogInfo(methodName = "测试添加项目",modelName = "立项管理")
    @RequestMapping("addProject")
    @ResponseBody
    public void addProject(@RequestBody String responseBody){
        logger.debug(TAG+"updateProject() begin");
        JSONObject requestJson=JSONObject.parseObject(responseBody);
        String projectId=requestJson.getString("projectId");
        String projectCode=requestJson.getString("projectCode");
        String projectName=requestJson.getString("projectName");
        String projectType=requestJson.getString("projectType");
        String schedule=requestJson.getString("schedule");
        String creator=requestJson.getString("creator");
        String organization=requestJson.getString("organization");
        String projectMoney=requestJson.getString("projectMoney");
        String projectStatus=requestJson.getString("projectStatus");
        //投资主体
        String investor=requestJson.getString("investor");
        try {
            projectAddorUpdateUtil.projectMethod(projectId,projectCode,projectName,projectType,schedule,creator,organization,projectMoney,projectStatus,investor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @LogInfo(methodName = "废除申请记录",modelName = "立项管理")
    @RequestMapping("abolishProject")
    @ResponseBody
    public ResponseMessage abolishProject(@RequestBody String responseBody){
        logger.debug(TAG+"abolishProject() begin");
        JSONObject requestJson=JSONObject.parseObject(responseBody);
        return  applicationService.abolishProject(requestJson);
    }


}
