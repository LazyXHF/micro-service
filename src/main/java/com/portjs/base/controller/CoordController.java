package com.portjs.base.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.Coord;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.CoordService;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.ArrayVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author gumingyang
 **/
@Controller
@RequestMapping("/coord")
public class CoordController extends BaseController {
    static final  String TAG = "CoordController================>";
    @Resource
    private CoordService coordService;

    @LogInfo(methodName = "添加协调事项",modelName = "协调事项")
    @RequestMapping("/insert-coord")
    @ResponseBody
    public ResponseMessage insertDesign(@RequestBody String responseBody){
        logger.debug(TAG + responseBody);
        UnifiedExceptionHandler.method= responseBody + "insert-coord==============================" + responseBody;
        JSONObject requestJson = JSON.parseObject(responseBody);
        Coord annex = JSONObject.toJavaObject(requestJson, Coord.class);
        return coordService.insertSelective(annex);
    }

    @LogInfo(methodName = "根据主键更新协调事项",modelName = "协调事项")
    @RequestMapping("/update-coord")
    @ResponseBody
    public ResponseMessage updateDesign(@RequestBody String responseBody){
        logger.debug(TAG+responseBody);
        JSONObject requestJson = JSONObject.parseObject(responseBody);
        Coord annex = JSONObject.toJavaObject(requestJson, Coord.class);
        return coordService.updateByPrimaryKeySelective(annex);
    }

    @LogInfo(methodName = "查询协调事项",modelName = "协调事项")
    @RequestMapping("/select-coord")
    @ResponseBody
    public ResponseMessage selectDesign(@RequestBody String responseBody){
        logger.debug(TAG+responseBody);
        JSONObject requestJson = JSONObject.parseObject(responseBody);
        Coord annex = JSONObject.toJavaObject(requestJson, Coord.class);
        return coordService.selectByPrimaryKey(annex);
    }
/*
    @LogInfo(methodName = "删除协调事项",modelName = "协调事项")
    @RequestMapping("/delete-coord")
    @ResponseBody
    public ResponseMessage deleteDesign(@RequestBody ArrayVO arrayVO){
        logger.debug(TAG+arrayVO);
        return coordService.deleteByPrimaryKey(arrayVO.getList());
    }*/
}
