package com.portjs.base.controller;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.InternalProject;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.InternalProjectService;
import com.portjs.base.util.Code;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * 关于项目信息
 */
@RequestMapping("internal-project")
@CrossOrigin
@RestController
public class InternalProjectController extends BaseController{
    static final String tag = "InternalProjectService===>";

    @Autowired
    InternalProjectService internalProjectService;

    ResponseMessage responseMessage=null;

    /**
     * 项目概览里‘基本信息’和‘项目人员’信息
     * @return
     */
    @RequestMapping("select-all-project-info")
    @LogInfo(methodName = "查询所有项目信息")
    public ResponseMessage selectAllProjectInfo(@RequestBody PageVo pageVo){

        logger.debug("selectAllProjectInfo() begin...");
        try{
            int pageNo = pageVo.getPageNo();
            int pageSize = pageVo.getPageSize();
            String id = pageVo.getObject();

            Page<InternalProject> project = internalProjectService.selectAllProjectInfo(id,pageNo, pageSize);
            if (project == null) {
                responseMessage = new ResponseMessage(Code.CODE_ERROR, "查询数据为空");
                return responseMessage;
            }
            responseMessage = new ResponseMessage(Code.CODE_OK, "查询成功", project);
        }catch (Exception e){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"服务器异常"+e);
            logger.error("selectAllProjectInfo() error...",e);

        }
        return responseMessage;
    }

    /**
     * 报表页面
     * 所有项目信息(项目信息监控接口)并按照
     * @return
     */
    @RequestMapping("query-all-project-info")
    @LogInfo(methodName = "查询所有项目信息")
    public ResponseMessage queryAllProjectInfo(@RequestBody PageVo pageVo){
        logger.debug("queryAllProjectInfo() begin...");
        try{
            int pageNo =   pageVo.getPageNo();
            int pageSize = pageVo.getPageSize();
            if (pageNo == 0) {
                pageNo = 0;
            }
            if (pageSize == 0) {
                pageSize = 10;
            }
            Page<Map<String,Object>> project = internalProjectService.queryAllProjectInfos(pageNo, pageSize);
            if (project == null) {
                responseMessage = new ResponseMessage(Code.CODE_ERROR, "查询数据为空");
                return responseMessage;
            }
            responseMessage = new ResponseMessage(Code.CODE_OK, "查询成功", project);
        }catch (Exception e){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"服务器异常"+e);
            logger.error("queryAllProjectInfo() error...",e);

        }
        return responseMessage;
    }

    /**
     *  添加项目信息
     * @param internalProject
     * @return
     */
    @RequestMapping("insert-project-info")
    @LogInfo(methodName = "添加项目信息")
    public ResponseMessage insertProjectInfo(@RequestBody InternalProject internalProject) {
        logger.debug("insertProjectInfo() begin...");
        try{
            responseMessage = internalProjectService.insertProjectInfo(internalProject);
        }catch (Exception e){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"服务器异常"+e);
            logger.error("insertProjectInfo() error...",e);
        }
        return responseMessage;
    }
    /**
     *  添加项目概览信息
     * @param internalProject
     * @return
     */
    @RequestMapping("insert-project-info-gailan")
    @LogInfo(methodName = "添加项目信息")
    public ResponseMessage insertProjectInfoGailan(@RequestBody InternalProject internalProject) {
        logger.debug(tag+internalProject);
        UnifiedExceptionHandler.method= internalProject + "insert-project-info-gailan==============================" + internalProject;
        return internalProjectService.insertProjectInfoGailan(internalProject);
    }

    /**
     * 更新项目信息（报表页面）
     * @param record
     * @return
     */
    @RequestMapping("update-project-info")
    @LogInfo(methodName = "添加项目信息")
    @ResponseBody
    public ResponseMessage updateByPrimaryKeySelective(@RequestBody InternalProject record) {
        logger.debug(tag+record);
        UnifiedExceptionHandler.method= record + "insert-project-info==============================" + record;
        return internalProjectService.updateByPrimaryKeySelective(record);
    }

    /**
     * 更新项目信息（项目概览）
     * @param record
     * @return
     */
    @RequestMapping("update-project-info-gailan")
    @LogInfo(methodName = "添加项目概览信息")
    @ResponseBody
    public ResponseMessage updateSelective(@RequestBody InternalProject record) {
        logger.debug(tag+record);
        UnifiedExceptionHandler.method= record + "insert-project-info-gailan==============================" + record;
        return internalProjectService.updateByPrimaryKeySelective(record);
    }
    /**
     * 根据id查询项目信息
     * @param internalProject
     * @return
     */
    @RequestMapping("select-project-by-id")
    @LogInfo(methodName = "添加项目概览信息")
    @ResponseBody
    public ResponseMessage selectByPrimaryKey(@RequestBody InternalProject internalProject) {
        logger.debug(tag+internalProject);
        UnifiedExceptionHandler.method= internalProject + "selectByPrimaryKey==============================" + internalProject;
        return internalProjectService.selectByPrimaryKey(internalProject);
    }
}
