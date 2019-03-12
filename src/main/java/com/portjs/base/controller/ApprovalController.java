package com.portjs.base.controller;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.Approval;
import com.portjs.base.service.ApprovalService;
import com.portjs.base.util.ResponseMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author gumingyang
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
        logger.debug(TAG+responseBody);
        return approvalService.insertSelective(responseBody);
    }

    @LogInfo(methodName = "根据主键更新项目开发",modelName = "项目开发模块")
    @RequestMapping("/update-approval")
    @ResponseBody
    public ResponseMessage updateDesign(@RequestBody String responseBody){
        logger.debug(TAG+responseBody);
        JSONObject requestJson = JSONObject.parseObject(responseBody);
        Approval annex = JSONObject.toJavaObject(requestJson, Approval.class);
        return approvalService.updateByPrimaryKeySelective(annex);
    }

    @LogInfo(methodName = "查询项目开发",modelName = "项目开发模块")
    @RequestMapping("/select-approval")
    @ResponseBody
    public ResponseMessage selectDesign(@RequestBody String responseBody){
        logger.debug(TAG+responseBody);
        JSONObject requestJson = JSONObject.parseObject(responseBody);
        Approval annex = JSONObject.toJavaObject(requestJson, Approval.class);
        return approvalService.selectByPrimaryKey(annex);
    }
}
