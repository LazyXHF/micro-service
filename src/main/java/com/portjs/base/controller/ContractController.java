package com.portjs.base.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.Contract;
import com.portjs.base.entity.Coord;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.ContractService;
import com.portjs.base.service.CoordService;
import com.portjs.base.util.ResponseMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 合同管理模块
 * Created by dengshuangzhen on 2019\4\10 0010
 */
@Controller
@RequestMapping("/contract")
public class ContractController extends BaseController{
    static final  String TAG = "CoordController================>";
    @Resource
    private ContractService contractService;

    @LogInfo(methodName = "查询合同来源",modelName = "合同管理模块")
    @RequestMapping("/select-contract-source")
    @ResponseBody
    public ResponseMessage selectContractSource(@RequestBody String responseBody){
        logger.debug(TAG + responseBody);
        UnifiedExceptionHandler.method= responseBody + "insert-contract-Source==============================" + responseBody;
        return contractService.selectContractSource(responseBody);
    }

    @LogInfo(methodName = "新增合同",modelName = "合同管理模块")
    @RequestMapping("/insert-contract")
    @ResponseBody
    public ResponseMessage insertContract(@RequestBody String responseBody){
        logger.debug(TAG + responseBody);
        UnifiedExceptionHandler.method= responseBody + "insert-contract==============================" + responseBody;
        JSONObject requestJson = JSON.parseObject(responseBody);
        Contract contract = JSONObject.toJavaObject(requestJson, Contract.class);
        return contractService.insertContract(contract);
    }

    @LogInfo(methodName = "合同查询",modelName = "合同管理模块")
    @RequestMapping("/select-contract")
    @ResponseBody
    public ResponseMessage selectContract(@RequestBody String responseBody){
        logger.debug(TAG + responseBody);
        UnifiedExceptionHandler.method= responseBody + "select-contract==============================" + responseBody;
        JSONObject requestJson = JSON.parseObject(responseBody);
        Contract contract = JSONObject.toJavaObject(requestJson, Contract.class);
        return contractService.selectContract(contract);
    }
}
