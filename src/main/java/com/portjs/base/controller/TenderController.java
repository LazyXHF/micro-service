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

    @LogInfo(methodName = "生成招标申请单",modelName = "招标模块")
    @RequestMapping("/get-tender-num")
    @ResponseBody
    public ResponseMessage getTenderNum(){
        try {
            logger.error(TAG+"get-tender-num()begin.....");
            return tenderService.getTenderNum();
        } catch (Exception e) {
            logger.error(TAG+"get-tender-num()error.....",e);
            throw new RuntimeException();
        }
    }

    @LogInfo(methodName = "查询招标流程申请单",modelName = "招标模块")
    @RequestMapping("/query-review-tender")
    @ResponseBody
    public ResponseMessage queryReviewTender(@RequestBody String requestBody){
        try {
            logger.error(TAG+"query-review-tender()begin....."+requestBody);
            return tenderService.queryReviewTender(requestBody);
        } catch (Exception e) {
            logger.error(TAG+"query-review-tender()error.....",e);
            throw new RuntimeException();
        }
    }

    @LogInfo(methodName = "查询招标申请单",modelName = "招标模块")
    @RequestMapping("/query-tender")
    @ResponseBody
    public ResponseMessage queryTender(@RequestBody String requestBody){
        try {


            logger.error(TAG+"query-tender()begin....."+requestBody);
            return tenderService.queryTender(requestBody);
        } catch (Exception e) {
            logger.error(TAG+"query-tender()error.....",e);
            throw new RuntimeException();
        }
    }

    @LogInfo(methodName = "暂存/提交",modelName = "招标模块")
    @RequestMapping("/insert-tender")
    @ResponseBody
    public ResponseMessage insertTender(@RequestBody String requestBody){
        try {
            logger.error(TAG+"insert-tender()begin....."+requestBody);
            return tenderService.insertTender(requestBody);
        } catch (Exception e) {
            logger.error(TAG+"insert-tender()error.....",e);
            throw new RuntimeException();
        }
    }

    @LogInfo(methodName = "废除",modelName = "招标模块")
    @RequestMapping("/abolition-tender")
    @ResponseBody
    public ResponseMessage abolitionTender(@RequestBody String requestBody){
        try {
            logger.error(TAG+"abolition-tender()begin....."+requestBody);
            return tenderService.abolitionTender(requestBody);
        } catch (Exception e) {
            logger.error(TAG+"abolition-tender()error.....",e);
            throw new RuntimeException();
        }
    }

    @LogInfo(methodName = "删除",modelName = "招标模块")
    @RequestMapping("/delete-tender")
    @ResponseBody
    public ResponseMessage deleteTender(@RequestBody String requestBody){

        try {
            logger.error(TAG+"delete-tender()begin....."+requestBody);
            return tenderService.deleteTender(requestBody);
        } catch (Exception e) {
            logger.error(TAG+"delete-tender()error.....",e);
            throw new RuntimeException();
        }
    }

    @LogInfo(methodName = "审核",modelName = "招标模块")
    @RequestMapping("/review-tender")
    @ResponseBody
    public ResponseMessage reviewTender(@RequestBody String requestBody){
        try {
            logger.error(TAG+"review-tender()begin....."+requestBody);
            return tenderService.reviewTender(requestBody);
        } catch (Exception e) {
            logger.error(TAG+"review-tender()error.....",e);
            throw new RuntimeException();
        }
    }

    @LogInfo(methodName = "定标",modelName = "招标模块")
    @RequestMapping("/target-tender")
    @ResponseBody
    public ResponseMessage targetTender(@RequestBody String responseBody){
        try {
            logger.error(TAG+"target-tender()begin....."+responseBody);
            return tenderService.targetTender(responseBody);
        } catch (Exception e) {
            logger.error(TAG+"target-tender()error.....",e);
            throw new RuntimeException();
        }
    }

    @LogInfo(methodName = "退回",modelName = "招标模块")
    @RequestMapping("/return-tender")
    @ResponseBody
    public ResponseMessage returnTender(@RequestBody String responseBody){
        try {
            logger.error(TAG+"return-tender()begin....."+responseBody);
            return tenderService.returnTender(responseBody);
        } catch (Exception e) {
            logger.error(TAG+"return-tender()error.....",e);
            throw new RuntimeException();
        }
    }
}
