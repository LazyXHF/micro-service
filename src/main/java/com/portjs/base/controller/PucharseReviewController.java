package com.portjs.base.controller;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.service.PucharseReviewService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/4/8.
 */
//采购评审单
@RequestMapping("/pucharseReview")
@RestController
public class PucharseReviewController {
    static final  String TAG = "PucharseReviewController================>";
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    PucharseReviewService  pucharseReviewService;
    @LogInfo(methodName = "采购申请单列表",modelName = "采购评审")
    @RequestMapping("/queryPucharseList")
    @ResponseBody
    public ResponseMessage queryPucharseList(@RequestBody String requestBody) {
        logger.debug("queryPucharseList" + requestBody);
        return pucharseReviewService.queryPucharseList(requestBody);
    }
   @LogInfo(methodName = "新增采购评审",modelName = "采购管理")
    @RequestMapping("/addPucharseReview")
    @ResponseBody
    public ResponseMessage addPucharseReview(@RequestBody String requestBody) {
        logger.debug("addPucharseReview" + requestBody);
            return pucharseReviewService.addPucharseReview(requestBody);
    }
    @LogInfo(methodName = "采购评审列表",modelName = "采购管理")
    @RequestMapping("/queryPucharseReview")
    @ResponseBody
    public ResponseMessage queryPucharseReview(@RequestBody String requestBody) {
        logger.debug("queryPucharseReview" + requestBody);
        return pucharseReviewService.queryPucharseReview(requestBody);
    }

    @LogInfo(methodName = "采购评审所有信息",modelName = "采购管理")
    @RequestMapping("/queryPucharseReviewAll")
    @ResponseBody
    public ResponseMessage queryPucharseReviewAll(@RequestBody String requestBody) {
        logger.debug("queryPucharseReview" + requestBody);
        return pucharseReviewService.queryPucharseReviewAll(requestBody);
    }

    @LogInfo(methodName = "采购评审审核",modelName = "采购评审")
    @RequestMapping("/handlePucharseReview")
    @ResponseBody
    public ResponseMessage handlePucharseReview(@RequestBody String requestBody) {
        logger.debug("handlePucharseReview" + requestBody);
        try {
            return pucharseReviewService.handlePucharseReview(requestBody);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(Code.CODE_ERROR,"服务器异常");
        }
    }
    @LogInfo(methodName = "退回",modelName = "采购评审")
    @RequestMapping("/returnRecord")
    @ResponseBody
    public ResponseMessage returnRecord(@RequestBody String requestBody) {
        logger.debug("returnRecord" + requestBody);
        return pucharseReviewService.returnRecord(requestBody);
    }
    //假删除  更改字段
    @LogInfo(methodName = "删除采购评审",modelName = "采购评审")
    @RequestMapping("deleteProjectReview")
    @ResponseBody
    public ResponseMessage deleteProjectReview(@RequestBody String responseBody){
        logger.debug(TAG+"deleteProjectReview() begin");
        JSONObject requestJson=JSONObject.parseObject(responseBody);
        return  pucharseReviewService.deleteProjectReview(requestJson);
    }









}
