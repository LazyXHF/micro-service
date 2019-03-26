package com.portjs.base.controller;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.InternalProject;
import com.portjs.base.entity.Life;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.InternalProjectService;
import com.portjs.base.service.LifeService;
import com.portjs.base.util.Code;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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

    @Autowired
    LifeService lifeService;


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
     * 报表页面
     * 所有新增项目列表分页查询
     * @return
     */
    @RequestMapping("query-new-project-info")
    @LogInfo(methodName = "所有新增项目列表分页查询")
    public ResponseMessage queryNewProjectInfo(@RequestBody PageVo pageVo){
        logger.debug("queryNewProjectInfo() begin...");
        try{
            int pageNo =   pageVo.getPageNo();
            int pageSize = pageVo.getPageSize();
            if (pageNo == 0) {
                pageNo = 0;
            }
            if (pageSize == 0) {
                pageSize = 10;
            }
            //获取当前年份
            Integer year = Calendar.getInstance().get(Calendar.YEAR);
            ResponseMessage responseMessage = internalProjectService.selectListsByBackup1(year.toString(),pageNo, pageSize);
            if (responseMessage == null) {
                this.responseMessage = new ResponseMessage(Code.CODE_ERROR, "查询数据为空");
                return this.responseMessage;
            }
            this.responseMessage = new ResponseMessage(Code.CODE_OK, "查询成功", responseMessage);
        }catch (Exception e){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"服务器异常"+e);
            logger.error("queryNewProjectInfo() error...",e);

        }
        return responseMessage;
    }

    /**
     * 报表页面
     * 所有在建项目列表分页查询
     * @return
     */
    @RequestMapping("query-construction-projects")
    @LogInfo(methodName = "所有在建项目列表分页查询")
    public ResponseMessage queryConstructionProjects(@RequestBody PageVo pageVo){
        logger.debug("queryConstructionProjects() begin...");
        String ids = null;
        String  id = null;
        List<String> list = new ArrayList<>();
        try{

            int pageNo =   pageVo.getPageNo();
            int pageSize = pageVo.getPageSize();
            List<Life> list1 = lifeService.sumLines();//查询所有在建项目id
            for(int i=0;i<list1.size();i++) {
                ids = list1.get(i).getProjectId();
                pageVo.setObject(ids);
                id = pageVo.getObject();
                list.add(id);
            }
            ResponseMessage responseMessage = internalProjectService.queryConstructionProjects(list,pageNo, pageSize);
            if (pageNo == 0) {
                pageNo = 0;
            }
            if (pageSize == 0) {
                pageSize = 10;
            }

            if (responseMessage == null) {
                this.responseMessage = new ResponseMessage(Code.CODE_ERROR, "查询数据为空");
                return this.responseMessage;
            }
            this.responseMessage = new ResponseMessage(Code.CODE_OK, "查询成功", responseMessage);

        }catch (Exception e){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"服务器异常"+e);
            logger.error("queryConstructionProjects() error...",e);

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
    @RequestMapping("insert-project-info-overview")
    @LogInfo(methodName = "添加项目信息")
    public ResponseMessage insertProjectInfoOverview(@RequestBody InternalProject internalProject) {
        logger.debug(tag+internalProject);
        UnifiedExceptionHandler.method= internalProject + "insert-project-info-overview==============================" + internalProject;
        return internalProjectService.insertProjectInfoOverview(internalProject);
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
    @RequestMapping("update-project-info-overview")
    @LogInfo(methodName = "添加项目概览信息")
    @ResponseBody
    public ResponseMessage updateSelective(@RequestBody InternalProject record) {
        logger.debug(tag+record);
        UnifiedExceptionHandler.method= record + "insert-project-info-overview==============================" + record;
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
