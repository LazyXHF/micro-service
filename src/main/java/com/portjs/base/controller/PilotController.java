package com.portjs.base.controller;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.Pilot;
import com.portjs.base.service.PilotService;
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
@RequestMapping("/pilot")
public class PilotController extends BaseController {
    static final  String TAG = "PilotController================>";
    @Resource
    private PilotService pilotService;

    @LogInfo(methodName = "添加项目建设试点实施",modelName = "项目建设试点实施模块")
    @RequestMapping("/insert-pilot")
    @ResponseBody
    public ResponseMessage insertDesign(@RequestBody String responseBody){
        logger.debug(TAG+responseBody);
        return pilotService.insertSelective(responseBody);
    }

    @LogInfo(methodName = "根据主键更新项目建设试点实施",modelName = "项目建设试点实施模块")
    @RequestMapping("/update-pilot")
    @ResponseBody
    public ResponseMessage updateDesign(@RequestBody String responseBody){
        logger.debug(TAG+responseBody);
        JSONObject requestJson = JSONObject.parseObject(responseBody);
        Pilot annex = JSONObject.toJavaObject(requestJson, Pilot.class);
        return pilotService.updateByPrimaryKeySelective(annex);
    }

    @LogInfo(methodName = "查询项目建设试点实施",modelName = "项目建设试点实施模块")
    @RequestMapping("/select-pilot")
    @ResponseBody
    public ResponseMessage selectDesign(@RequestBody String responseBody){
        logger.debug(TAG+responseBody);
        JSONObject requestJson = JSONObject.parseObject(responseBody);
        Pilot annex = JSONObject.toJavaObject(requestJson, Pilot.class);
        return pilotService.selectByPrimaryKey(annex);
    }
}
