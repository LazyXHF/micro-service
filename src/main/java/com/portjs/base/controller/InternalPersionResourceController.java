package com.portjs.base.controller;

import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.InternalPersionResource;
import com.portjs.base.service.InternalPersionResourceService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("internal-persion-resource")
@CrossOrigin
@RestController
public class InternalPersionResourceController extends BaseController{
    static final String tag = "InternalProjectService===>";

    @Autowired
    InternalPersionResourceService internalPersionResourceService;

    ResponseMessage responseMessage=null;

    /**
     * 添加项目相关人员信息
     * @param internalPersionResource
     * @return
     */
    @RequestMapping("insert-persion-info")
    @LogInfo(methodName = "插入人员信息")
    public ResponseMessage insertProjectInfo(@RequestBody InternalPersionResource internalPersionResource) {
        logger.debug("internalPersionResource() begin...");
        try{
            responseMessage = internalPersionResourceService.insertPersionInfo(internalPersionResource);
        }catch (Exception e){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"服务器异常"+e);
            logger.error("internalPersionResource() error...",e);
        }
        return responseMessage;
    }

    /**
     * 根据id查询人员信息
     * @param id
     * @return
     */
    @RequestMapping("select-persion-info-by-id")
    @LogInfo(methodName = "根据id查询人员信息")
    public ResponseMessage selectByPrimaryKey(@RequestBody String id) {
        logger.debug("internalPersionResource() begin...");
        try{
            responseMessage = internalPersionResourceService.selectByPrimaryKey(id);
        }catch (Exception e){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"服务器异常"+e);
            logger.error("internalPersionResource() error...",e);
        }
        return responseMessage;
    }

    /**
     * 更新人员信息
     * @param record
     * @return
     */
    @RequestMapping("update-persion-info")
    @LogInfo(methodName = "更新人员信息")
    public ResponseMessage updatePersionInfo(@RequestBody InternalPersionResource record) {
        logger.debug("internalPersionResource() begin...");
        try{
            responseMessage = internalPersionResourceService.updatePersionInfo(record);
        }catch (Exception e){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"服务器异常"+e);
            logger.error("internalPersionResource() error...",e);
        }
        return responseMessage;
    }

    /**
     * 根据id删除人员信息
     * @param id
     * @return
     */
    @RequestMapping("delete-persion-info-by-id")
    @LogInfo(methodName = "根据id删除人员信息")
    public ResponseMessage deleteByPrimaryKey(@RequestBody String id) {
        logger.debug("internalPersionResource() begin...");
        try{
            responseMessage = internalPersionResourceService.deleteByPrimaryKey(id);
        }catch (Exception e){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"服务器异常"+e);
            logger.error("internalPersionResource() error...",e);
        }
        return responseMessage;
    }

}
