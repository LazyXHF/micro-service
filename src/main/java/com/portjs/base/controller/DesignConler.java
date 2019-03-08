package com.portjs.base.controller;

import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.Design;
import com.portjs.base.service.DesignService;
import com.portjs.base.util.ResponseMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author gumingyang
 **/
@Controller
@CrossOrigin
@RequestMapping("/design")
public class DesignConler extends BaseController {
    static final  String tag = "DesignConler================>";
    ResponseMessage responseMessage = null;
    @Resource
    private DesignService designService;


    @LogInfo(methodName = "添加项目设计",modelName = "项目设计模块")
    @RequestMapping("/insert-design")
    @ResponseBody
    public ResponseMessage insertDesign(@RequestBody String responseBody){
        logger.debug(tag+responseBody);
        responseMessage =designService.insertSelective(responseBody);
        return responseMessage;
    }

}
