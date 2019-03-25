package com.portjs.base.controller;

import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.Manager;
import com.portjs.base.entity.TXietongDictionary;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.DictionaryService;
import com.portjs.base.service.InternalProjectService;
import com.portjs.base.service.ManagerService;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    @Resource
    InternalProjectService  internalProjectService;
    @Resource
    ManagerService managerService;
    /**
     * 查询人员配置信息
     * @return
     */
    @LogInfo(methodName = "人员分类配置",modelName = "统一模块配置")
    @RequestMapping("query-persion-model-info")
    @ResponseBody
    public ResponseMessage queryPersionModelInfo(){
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
    @LogInfo(methodName = "查询所有项目",modelName = "统一模块配置")
    @RequestMapping("query-all-projects")
    @ResponseBody
    public ResponseMessage queryAllProjects(){
        UnifiedExceptionHandler.method ="queryAllProjects==============================";
        return internalProjectService.queryAllProjects();
    }
    @LogInfo(methodName = "新增项目的人员配置",modelName = "统一模块配置")
    @RequestMapping("add-staffing-project")
    @ResponseBody
    public ResponseMessage add(@RequestBody String responseBody){
        UnifiedExceptionHandler.method ="add-staffing-project==============================";
        return managerService.insertStaffing(responseBody);
    }
    @LogInfo(methodName = "修改项目的人员配置",modelName = "统一模块配置")
    @RequestMapping("update-staffing-project")
    @ResponseBody
    public ResponseMessage update(){
        UnifiedExceptionHandler.method ="update-staffing-project==============================";
        // ResponseMessage responseMessage = internalProjectService.queryAllProjects();
        return null;
    }
    @LogInfo(methodName = "删除项目的人员配置",modelName = "统一模块配置")
    @RequestMapping("delete-staffing-project")
    @ResponseBody
    public ResponseMessage delete(){
        UnifiedExceptionHandler.method ="delete-staffing-project==============================";
        // ResponseMessage responseMessage = internalProjectService.queryAllProjects();
        return null;
    }
    @LogInfo(methodName = "查询项目的人员配置",modelName = "统一模块配置")
    @RequestMapping("query-staffing-project")
    @ResponseBody
    public ResponseMessage query(){
        UnifiedExceptionHandler.method ="query-staffing-project==============================";
        // ResponseMessage responseMessage = internalProjectService.queryAllProjects();
        return null;
    }
}
