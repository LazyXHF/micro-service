package com.portjs.base.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.Approval;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.ApprovalService;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.ArrayVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author gumingyang 项目
 **/
@Controller
@CrossOrigin
@RequestMapping("/approval")
public class ApprovalController extends BaseController {
    static final  String TAG = "ApprovalController================>";
    @Resource
    private ApprovalService approvalService;


    @LogInfo(methodName = "添加项目立项",modelName = "项目立项模块")
    @RequestMapping("/insert-approval")
    @ResponseBody
    public ResponseMessage insertDesign(@RequestBody String responseBody){
        logger.debug(TAG + responseBody);
        UnifiedExceptionHandler.method= responseBody + "insert-approval==============================" + responseBody;
        JSONObject requestJson = JSONObject.parseObject(responseBody);
        return approvalService.insertSelective( requestJson);
    }

    @LogInfo(methodName = "根据主键更新项目立项",modelName = "项目立项模块")
    @RequestMapping("/update-approval")
    @ResponseBody
    public ResponseMessage updateDesign(@RequestBody String responseBody){
        logger.debug(TAG+responseBody);
        UnifiedExceptionHandler.method= responseBody + "update-approval==============================" + responseBody;
        JSONObject requestJson = JSONObject.parseObject(responseBody);
        Approval annex = JSONObject.toJavaObject(requestJson, Approval.class);
        return approvalService.updateByPrimaryKeySelective(annex);
    }

    @LogInfo(methodName = "查询项目立项",modelName = "项目立项模块")
    @RequestMapping("/select-approval")
    @ResponseBody
    public ResponseMessage selectDesign(@RequestBody String responseBody){
        logger.debug(TAG+responseBody);
        UnifiedExceptionHandler.method= responseBody + "select-approval==============================" + responseBody;
        JSONObject requestJson = JSONObject.parseObject(responseBody);
        Approval annex = JSONObject.toJavaObject(requestJson, Approval.class);
        return approvalService.selectByPrimaryKey(annex);
    }
    @LogInfo(methodName = "删除项目立项",modelName = "项目立项模块")
    @RequestMapping("/delete-approval")
    @ResponseBody
    public ResponseMessage deleteDesign(@RequestBody ArrayVO arrayVO){
        logger.debug(TAG+arrayVO.getList());
        UnifiedExceptionHandler.method= arrayVO + "delete-approval==============================" + arrayVO.getList();
        return approvalService.deleteByPrimaryKey(arrayVO.getList());
    }
}
