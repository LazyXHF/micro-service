package com.portjs.base.controller;

import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.InternalProject;
import com.portjs.base.service.InternalProjectService;
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
            if (pageNo == 0) {
                pageNo = 0;
            }
            if (pageSize == 0) {
                pageSize = 10;
            }
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
     * 所有项目信息(项目信息监控接口)
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
            Page<InternalProject> project = internalProjectService.queryAllProjectInfo(pageNo, pageSize);
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
    public ResponseMessage insertPactInfo(@RequestBody InternalProject internalProject) {
        logger.debug("insertProjectInfo() begin...");
        try{
            responseMessage = internalProjectService.insertProjectInfo(internalProject);
        }catch (Exception e){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"服务器异常"+e);
            logger.error("insertProjectInfo() error...",e);
        }
        return responseMessage;
    }

}
