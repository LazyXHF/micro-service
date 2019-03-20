package com.portjs.base.controller;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.InternalPersionResource;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.InternalPersionResourceService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.ArrayVO;
import com.portjs.base.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * 查询项目相关人员信息
     * @param pageVo
     * @return
     */
    @LogInfo(methodName = "查询用户信息",modelName = "用户模块")
    @RequestMapping("query-all-persion-info")
    @ResponseBody
    public ResponseMessage queryAllPersionInfo(@RequestBody PageVo pageVo){
        logger.debug(tag+pageVo);
        String id=pageVo.getObject();
        int pageNo = pageVo.getPageNo();
        int pageSize = pageVo.getPageSize();
        UnifiedExceptionHandler.method= tag+"queryAllPersionInfo=============================="+pageVo;
        responseMessage = internalPersionResourceService.queryAllPersionInfo(id,pageNo,pageSize);
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
            JSONObject jsonObject = JSONObject.parseObject(id);
            String ids = jsonObject.getString("id");

            responseMessage = internalPersionResourceService.selectByPrimaryKey(ids);
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

            JSONObject jsonObject = JSONObject.parseObject(id);
            String ids = jsonObject.getString("id");
            responseMessage = internalPersionResourceService.deleteByPrimaryKey(ids);
        }catch (Exception e){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"服务器异常"+e);
            logger.error("internalPersionResource() error...",e);
        }
        return responseMessage;
    }

    /**
     * 根据id批量软删除人员信息
     * @param
     * @return
     */
    @RequestMapping("update-persion-info-by-ids")
    @LogInfo(methodName = "根据id删除人员信息")
    public ResponseMessage updatePersionInfoByIds(@RequestBody ArrayVO arrayVO) {
        logger.debug(tag+arrayVO);
        UnifiedExceptionHandler.method = tag + "updatePersionInfoByIds============================" +arrayVO;
        responseMessage = internalPersionResourceService.updatePersionInfoByIds(arrayVO.getList());
        return responseMessage;
    }
}
