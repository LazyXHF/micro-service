package com.portjs.base.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.Construction;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.ConstructionService;
import com.portjs.base.service.DesignService;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.ArrayVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 项目开发
 * @author gumingyang
 **/
@Controller
@CrossOrigin
@RequestMapping("/construction")
public class ConstructionController extends BaseController {
    static final  String TAG = "ConstructionController================>";
    @Resource
    private ConstructionService constructionService;


    @LogInfo(methodName = "添加项目开发",modelName = "项目开发模块")
    @RequestMapping("/insert-construction")
    @ResponseBody
    public ResponseMessage insertDesign(@RequestBody String responseBody){
        logger.debug(TAG+responseBody);
        UnifiedExceptionHandler.method= responseBody + "insert-construction==============================" + responseBody;
        JSONObject requestJson = JSON.parseObject(responseBody);
        Construction annex = JSONObject.toJavaObject(requestJson, Construction.class);
        return constructionService.insertSelective(annex);
    }

    @LogInfo(methodName = "根据主键更新项目开发",modelName = "项目开发模块")
    @RequestMapping("/update-construction")
    @ResponseBody
    public ResponseMessage updateDesign(@RequestBody String responseBody){
        logger.debug(TAG+responseBody);
        UnifiedExceptionHandler.method= responseBody + "update-construction==============================" + responseBody;
        JSONObject requestJson = JSONObject.parseObject(responseBody);
        Construction annex = JSONObject.toJavaObject(requestJson, Construction.class);
        return constructionService.updateByPrimaryKeySelective(annex);
    }

    @LogInfo(methodName = "查询项目开发",modelName = "项目开发模块")
    @RequestMapping("/select-construction")
    @ResponseBody
    public ResponseMessage selectDesign(@RequestBody String responseBody){
        logger.debug(TAG+responseBody);
        UnifiedExceptionHandler.method= responseBody + "select-construction==============================" + responseBody;
        JSONObject requestJson = JSONObject.parseObject(responseBody);
        Construction annex = JSONObject.toJavaObject(requestJson, Construction.class);
        return constructionService.selectByPrimaryKey(annex);
    }
    @LogInfo(methodName = "删除项目开发",modelName = "项目开发模块")
    @RequestMapping("/delete-construction")
    @ResponseBody
    public ResponseMessage deleteDesign(@RequestBody ArrayVO arrayVO){
        logger.debug(TAG+arrayVO.getList());
        UnifiedExceptionHandler.method= arrayVO + "delete-construction==============================" + arrayVO.getList();
        return constructionService.deleteByPrimaryKey(arrayVO.getList());
    }
}
