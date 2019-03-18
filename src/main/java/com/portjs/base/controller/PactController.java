package com.portjs.base.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.InternalPact;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.InternalPactService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.ArrayVO;
import com.portjs.base.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author  gumingyang
 */
@RequestMapping("/pact")
@CrossOrigin
@RestController
public class PactController extends BaseController {
    static final  String TAG = "PactController================>";
    @Resource
    private InternalPactService internalPactService;

    @LogInfo(methodName = "添加项目合同",modelName = "项目合同")
    @RequestMapping("/insert-pact")
    @ResponseBody
    public ResponseMessage insertDesign(@RequestBody String responseBody){
        logger.debug(TAG + responseBody);
        UnifiedExceptionHandler.method= responseBody + "insert-coord==============================" + responseBody;
        JSONArray requestJson = JSON.parseArray(responseBody);
        return internalPactService.insertSelective(requestJson);
    }
    @LogInfo(methodName = "查询项目合同",modelName = "项目合同")
    @RequestMapping("/select-pact")
    @ResponseBody
    public ResponseMessage selectDesign(@RequestBody String responseBody){
        logger.debug(TAG+responseBody);
        JSONObject requestJson = JSONObject.parseObject(responseBody);
        InternalPact annex = JSONObject.toJavaObject(requestJson, InternalPact.class);
        return internalPactService.selectByPrimaryKey(annex);
    }
}


