package com.portjs.base.controller;

import com.portjs.base.aop.LogInfo;
import com.portjs.base.service.PucharseReviewService;
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





}
