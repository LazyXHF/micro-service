package com.portjs.base.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.Construction;
import com.portjs.base.entity.TXietongDictionary;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.DictionaryService;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 统一模块化配置
 */
@RequestMapping("dictionary")
@CrossOrigin
@RestController
public class DictionaryController extends  BaseController{

    static final String tag = "OfficeSupplies===>";

    @Autowired
    DictionaryService dictionaryService;

    /**
     * 查询人员配置信息
     * @return
     */
    @LogInfo(methodName = "人员分类配置",modelName = "统一模块配置")
    @RequestMapping("query-persion-model-info")
    @ResponseBody
    public ResponseMessage queryPersionModelInfo(){
        /*logger.debug(tag+responseBody);
        UnifiedExceptionHandler.method= responseBody + "insert-construction==============================" + responseBody;
        JSONObject requestJson = JSON.parseObject(responseBody);
        Construction annex = JSONObject.toJavaObject(requestJson, Construction.class);
        return constructionService.insertSelective(annex);*/
        logger.debug(tag);
        UnifiedExceptionHandler.method = "queryPersionModelInfo==============================" ;
        ResponseMessage responseMessage = dictionaryService.queryPersionModelInfo();
        return responseMessage;
    }

    /**
     * 添加人员配置信息
     * @param dictionary
     * @return
     */
    @LogInfo(methodName = "人员分类配置",modelName = "统一模块配置")
    @RequestMapping("insert-persion-model-info")
    @ResponseBody
    public ResponseMessage insertPersionModelInfo(@RequestBody TXietongDictionary dictionary){
        logger.debug(tag+dictionary);
        UnifiedExceptionHandler.method =dictionary+ "insertPersionModelInfo==============================" +dictionary;
        ResponseMessage responseMessage = dictionaryService.insertPersionModelInfo(dictionary);
        return responseMessage;
    }

    /**
     * 修改人员配置信息
     * @param dictionary
     * @return
     */
    @LogInfo(methodName = "人员分类配置",modelName = "统一模块配置")
    @RequestMapping("update-persion-model-info")
    @ResponseBody
    public ResponseMessage updatePersionModelInfo(@RequestBody TXietongDictionary dictionary){
        logger.debug(tag+dictionary);
        UnifiedExceptionHandler.method =dictionary+ "updatePersionModelInfo==============================" +dictionary;
        ResponseMessage responseMessage = dictionaryService.updatePersionModelInfo(dictionary);
        return responseMessage;
    }

    /**
     * 删除人员配置信息
     * @param dictionary
     * @return
     */
    @LogInfo(methodName = "人员分类配置",modelName = "统一模块配置")
    @RequestMapping("delete-persion-model-info")
    @ResponseBody
    public ResponseMessage deletePersionModelInfo(@RequestBody TXietongDictionary dictionary){
        logger.debug(tag+dictionary);
        UnifiedExceptionHandler.method =dictionary+ "deletePersionModelInfo==============================" +dictionary;
        ResponseMessage responseMessage = dictionaryService.deletePersionModelInfo(dictionary);
        return responseMessage;
    }

    /**
     * 查询资源配置信息
     * @return
     */
    @LogInfo(methodName = "资源分类配置",modelName = "统一模块配置")
    @RequestMapping("query-resource-model-info")
    @ResponseBody
    public ResponseMessage queryResourceModelInfo(){
        /*logger.debug(tag+responseBody);
        UnifiedExceptionHandler.method= responseBody + "insert-construction==============================" + responseBody;
        JSONObject requestJson = JSON.parseObject(responseBody);
        Construction annex = JSONObject.toJavaObject(requestJson, Construction.class);
        return constructionService.insertSelective(annex);*/
        logger.debug(tag);
        UnifiedExceptionHandler.method = "queryResourceModelInfo==============================" ;
        ResponseMessage responseMessage = dictionaryService.queryResourceModelInfo();
        return responseMessage;
    }

    /**
     * 添加资源配置信息
     * @param dictionary
     * @return
     */
    @LogInfo(methodName = "资源分类配置",modelName = "统一模块配置")
    @RequestMapping("insert-resource-model-info")
    @ResponseBody
    public ResponseMessage insertResourceModelInfo(@RequestBody TXietongDictionary dictionary){
        logger.debug(tag+dictionary);
        UnifiedExceptionHandler.method =dictionary+ "insertResourceModelInfo==============================" +dictionary;
        ResponseMessage responseMessage = dictionaryService.insertResourceModelInfo(dictionary);
        return responseMessage;
    }

    /**
     * 修改资源配置信息
     * @param dictionary
     * @return
     */
    @LogInfo(methodName = "资源分类配置",modelName = "统一模块配置")
    @RequestMapping("update-resource-model-info")
    @ResponseBody
    public ResponseMessage updateResourceModelInfo(@RequestBody TXietongDictionary dictionary){
        logger.debug(tag+dictionary);
        UnifiedExceptionHandler.method =dictionary+ "updateResourceModelInfo==============================" +dictionary;
        ResponseMessage responseMessage = dictionaryService.updateResourceModelInfo(dictionary);
        return responseMessage;
    }

    /**
     * 删除资源配置信息
     * @param dictionary
     * @return
     */
    @LogInfo(methodName = "资源分类配置",modelName = "统一模块配置")
    @RequestMapping("delete-resource-model-info")
    @ResponseBody
    public ResponseMessage deleteResourceModelInfo(@RequestBody TXietongDictionary dictionary){
        logger.debug(tag+dictionary);
        UnifiedExceptionHandler.method =dictionary+ "deleteResourceModelInfo==============================" +dictionary;
        ResponseMessage responseMessage = dictionaryService.deleteResourceModelInfo(dictionary);
        return responseMessage;
    }
}
