package com.portjs.base.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.Design;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.DesignService;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.ArrayVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author gumingyang
 **/
@Controller
@CrossOrigin
@RequestMapping("/design")
public class DesignController extends BaseController {
    static final  String TAG = "DesignController================>";
    @Resource
    private DesignService designService;


    @LogInfo(methodName = "添加项目设计",modelName = "项目设计模块")
    @RequestMapping("/insert-design")
    @ResponseBody
    public ResponseMessage insertDesign(@RequestBody String responseBody){
        logger.debug(TAG+responseBody);
        UnifiedExceptionHandler.method= responseBody + "insert-design==============================" + responseBody;
        JSONObject requestJson = JSON.parseObject(responseBody);
        return designService.insertSelective(requestJson);
    }

    @LogInfo(methodName = "根据主键更新项目设计",modelName = "项目设计模块")
    @RequestMapping("/update-design")
    @ResponseBody
    public ResponseMessage updateDesign(@RequestBody String responseBody){
        logger.debug(TAG+responseBody);
        UnifiedExceptionHandler.method= responseBody + "update-design==============================" + responseBody;
        JSONObject requestJson = JSONObject.parseObject(responseBody);
        Design annex = JSONObject.toJavaObject(requestJson, Design.class);
        return designService.updateByPrimaryKeySelective(annex);
    }

    @LogInfo(methodName = "查询项目设计",modelName = "项目设计模块")
    @RequestMapping("/select-design")
    @ResponseBody
    public ResponseMessage selectDesign(@RequestBody String responseBody){
        logger.debug(TAG+responseBody);
        JSONObject requestJson = JSONObject.parseObject(responseBody);
        Design annex = JSONObject.toJavaObject(requestJson, Design.class);
        return designService.selectByPrimaryKey(annex);
    }
    @LogInfo(methodName = "删除项目设计",modelName = "项目设计模块")
    @RequestMapping("/delete-design")
    @ResponseBody
    public ResponseMessage deleteDesign(@RequestBody ArrayVO arrayVO){
        logger.debug(TAG+arrayVO);
        return designService.deleteByPrimaryKey(arrayVO.getList());
    }

}
