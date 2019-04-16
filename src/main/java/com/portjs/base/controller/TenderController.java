package com.portjs.base.controller;

import com.portjs.base.aop.LogInfo;
import com.portjs.base.service.TenderService;
import com.portjs.base.util.ResponseMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author gumingyang
 * @description 招标
 **/
@RequestMapping("/tender")
@Controller
@CrossOrigin
public class TenderController extends BaseController {
    ResponseMessage responseMessage=null;
    static final String TAG = "tenderService===>";

    @Resource
    private TenderService tenderService;

    @LogInfo(methodName = "采购申请单查询",modelName = "招标模块")
    @RequestMapping("/query-requests")
    @ResponseBody
    public ResponseMessage queryRequests(@RequestBody String responseBody){
        try {
            logger.error(TAG+"query-requests()begin....."+responseBody);
            return tenderService.queryRequests(responseBody);
        } catch (Exception e) {
            logger.error(TAG+"query-requests()error.....",e);
            throw new RuntimeException();
        }
    }

}
