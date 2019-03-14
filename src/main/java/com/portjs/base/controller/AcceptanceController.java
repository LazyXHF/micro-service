package com.portjs.base.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.Acceptance;
import com.portjs.base.service.AcceptanceService;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.StringUtils.Convert;
import com.portjs.base.vo.ArrayVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author gumingyang
 **/
@Controller
@RequestMapping("/acceptance")
public class AcceptanceController extends BaseController {
    @Resource
    private AcceptanceService acceptanceService;
    static final  String TAG = "AcceptanceController================>";

    @LogInfo(methodName = "删除项目验收",modelName = "项目验收模块")
    @RequestMapping("/delete-acceptance")
    @ResponseBody
    public ResponseMessage deleteDesign(@RequestBody String ids){
        logger.debug(TAG+ids);
        return acceptanceService.deleteByPrimaryKey(ids);
    }

    @LogInfo(methodName = "添加项目验收",modelName = "项目验收模块")
    @RequestMapping("/insert-acceptance")
    @ResponseBody
    public ResponseMessage insertDesign(@RequestBody String responseBody){
        JSONObject requestJson = JSONObject.parseObject(responseBody);
        Acceptance annex = JSONObject.toJavaObject(requestJson, Acceptance.class);
        logger.debug(TAG+responseBody);
        return acceptanceService.insertSelective(annex);
    }

    @LogInfo(methodName = "根据主键更新项目验收",modelName = "项目验收模块")
    @RequestMapping("/update-acceptance")
    @ResponseBody
    public ResponseMessage updateDesign(@RequestBody String responseBody){
        logger.debug(TAG+responseBody);
        JSONObject requestJson = JSONObject.parseObject(responseBody);
        Acceptance annex = JSONObject.toJavaObject(requestJson, Acceptance.class);
        return acceptanceService.updateByPrimaryKeySelective(annex);
    }

    @LogInfo(methodName = "查询项目验收",modelName = "项目验收模块")
    @RequestMapping("/select-acceptance")
    @ResponseBody
    public ResponseMessage selectDesign(@RequestBody String responseBody){
        logger.debug(TAG+responseBody);
        JSONObject requestJson = JSONObject.parseObject(responseBody);
        Acceptance annex = JSONObject.toJavaObject(requestJson, Acceptance.class);
        return acceptanceService.selectByPrimaryKey(annex);
    }

}
