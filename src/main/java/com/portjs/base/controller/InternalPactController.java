package com.portjs.base.controller;


import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.InternalPact;
import com.portjs.base.entity.InternalProject;
import com.portjs.base.service.InternalPactService;
import com.portjs.base.util.Code;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 关于合同信息
 */
@RequestMapping("internal-pact")
@CrossOrigin
@RestController
public class InternalPactController extends BaseController {
    static final String tag = "InternalPactService===>";

    ResponseMessage responseMessage = null;

    @Autowired
    InternalPactService internalPactService;

    /**
     * 查询所有合同信息
     * @param pageVo
     * @return
     */
    @RequestMapping("query-all-pact-info")
    @LogInfo(methodName = "查询所有合同信息")
    public ResponseMessage selectAllProjectInfo(@RequestBody PageVo pageVo) {
        logger.debug("queryAllProjectInfo() begin...");
        try{
            int pageNo = pageVo.getPageNo();
            int pageSize = pageVo.getPageSize();
            String id = pageVo.getObject();
            responseMessage = internalPactService.queryAllPacts(id, pageNo, pageSize);
        }catch (Exception e){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"服务器异常"+e);
            logger.error("queryAllPactInfo() error...",e);
        }
        return responseMessage;
    }
    /**
     * 插入合同信息
     * @param
     * @return
     */
    @RequestMapping("insert-pact-info")
    @LogInfo(methodName = "插入合同信息")
    public ResponseMessage insertPactInfo(@RequestBody InternalPact internalPact) {
        logger.debug("insertPactInfo() begin...");
        try{
            responseMessage = internalPactService.insertPact(internalPact);
        }catch (Exception e){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"服务器异常"+e);
            logger.error("insertPactInfo() error...",e);
        }
        return responseMessage;
    }

    /**
     * 根据id查询合同信息
     * @param id
     * @return
     */
    @RequestMapping("select-pact-info-by-id")
    @LogInfo(methodName = "根据id查询合同信息")
    public ResponseMessage selectByPrimaryKey(@RequestBody String id) {
        logger.debug("InternalPact-selectByPrimaryKey() begin...");
        try{
            responseMessage = internalPactService.selectByPrimaryKey(id);
        }catch (Exception e){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"服务器异常"+e);
            logger.error("InternalPact-selectByPrimaryKey() error...",e);
        }
        return responseMessage;
    }

    /**
     * 更新合同信息
     * @param record
     * @return
     */
    @RequestMapping("update-pact-info")
    @LogInfo(methodName = "更新合同信息")
    public ResponseMessage updatePactInfo(@RequestBody InternalPact record) {
        logger.debug("InternalPact-updatePactInfo() begin...");
        try{
            responseMessage = internalPactService.updateByPrimaryKey(record);
        }catch (Exception e){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"服务器异常"+e);
            logger.error("InternalPact-updatePactInfo() error...",e);
        }
        return responseMessage;
    }

    /**
     * 根据id删除合同信息
     * @param id
     * @return
     */
    @RequestMapping("delete-pact-info-by-id")
    @LogInfo(methodName = "删除合同信息")
    public ResponseMessage deleteByPrimaryKey(@RequestBody String id) {
        logger.debug("InternalPact-deleteByPrimaryKey() begin...");
        try{
            responseMessage = internalPactService.deleteByPrimaryKey(id);
        }catch (Exception e){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"服务器异常"+e);
            logger.error("InternalPact-deleteByPrimaryKey() error...",e);
        }
        return responseMessage;
    }

}


