package com.portjs.base.controller;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.BugDetails;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.BugDetailsRecordService;
import com.portjs.base.service.BugDetailsService;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.ArrayVO;
import com.portjs.base.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * bug模块
 */
@RequestMapping("bug-details")
@CrossOrigin
@RestController
public class BugDetailsController extends BaseController{
    static final String TAG = "InternalProjectService===>";
    ResponseMessage responseMessage;

    @Autowired
    BugDetailsService bugDetailsService;

    @Autowired
    BugDetailsRecordService bugDetailsRecordService;


    /**
     * TODO Bug详情查询并分页并模糊查询（添加页面）
     * @param
     * @return
     */
    @LogInfo(methodName = "查询Bug信息",modelName = "缺陷模块")
    @RequestMapping("query-all-bug-info")
    @ResponseBody
    public ResponseMessage queryAllBugInfo(@RequestBody String requestBody){
        logger.debug(TAG+requestBody);
        /*int pageNo = pageVo.getPageNo();
        int pageSize = pageVo.getPageSize();*/
        UnifiedExceptionHandler.method= TAG+"queryAllBugInfo=============================="+requestBody;
        responseMessage = bugDetailsService.queryAllBugInfo(requestBody);
        return responseMessage;
    }


    /**
     * 根据record表的ownerid ,status(result) ,去查询主表信息并分页
     */
    @LogInfo(methodName = "查询Bug信息",modelName = "缺陷模块")
    @RequestMapping("query-all-bug-info-flow")
    @ResponseBody
    public ResponseMessage queryAllBugInfoFlow(@RequestBody String requestBody){
        logger.debug(TAG+requestBody);
        UnifiedExceptionHandler.method= TAG+"queryAllBugInfoFlow=============================="+requestBody;
        responseMessage = bugDetailsService.queryAllBugInfoFlow(requestBody);
        return responseMessage;
    }






    /**
     *  TODO 更新Bug信息
     * @param record
     * @return
     */
    @RequestMapping("update-bug-info")
    @LogInfo(methodName = "添加Bug信息")
    @ResponseBody
    public ResponseMessage updateByPrimaryKeySelective(@RequestBody BugDetails record) {
        logger.debug(TAG+record);
        UnifiedExceptionHandler.method= record + "update-bug-info==============================" + record;
        return bugDetailsService.updateByPrimaryKeySelective(record);
    }


    /**
     * 暂存Bug信息
     * @param record
     * @return
     */
    @RequestMapping("temporary-bug-info")
    @LogInfo(methodName = "暂存Bug信息")
    @ResponseBody
    public ResponseMessage temporaryBugs(@RequestBody BugDetails record) {
        logger.debug(TAG+record);
        UnifiedExceptionHandler.method= record + "temporaryBugs==============================" + record;
        return bugDetailsService.temporaryBugs(record);
    }


    /**
     * 修改暂存
     */
    @RequestMapping("update-bug-search-dealt-temporary")
    @LogInfo(methodName = "修改暂存")
    public ResponseMessage updateBugSearchDealtTemporary(@RequestBody BugDetails details) {
        UnifiedExceptionHandler.method=  "updateBugSearchDealtTemporary==============================";
        responseMessage = bugDetailsService.updateTemporaryBugs(details);
        return responseMessage;
    }

    /**
     * 删除暂存
     */
    @RequestMapping("delete-bug-search-dealt-temporary")
    @LogInfo(methodName = "删除暂存")
    public ResponseMessage deleteBugSearchDealtTemporary(@RequestBody String requestBody) {
        UnifiedExceptionHandler.method=  "updateBugSearchDealtTemporary==============================";
        responseMessage = bugDetailsService.deleteBugSearchDealtTemporary(requestBody);
        return responseMessage;
    }





    /**
     *  TODO 根据自身id查询Bug信息
     * @param id
     * @return
     */
    @RequestMapping("select-bug-info")
    @LogInfo(methodName = "根据自身id查询Bug信息")
    @ResponseBody
    public ResponseMessage selectBugInfo(@RequestBody String id) {
        logger.debug(TAG+id);
        JSONObject jsonObject = JSONObject.parseObject(id);
        String ids = jsonObject.getString("id");
        UnifiedExceptionHandler.method= ids + "select-bug-info==============================" + ids;
        return bugDetailsService.selectByPrimaryKey(ids);
    }
    /**
     * TODO 添加项目相关Bug信息
     * @param record
     * @return
     */
    @RequestMapping("insert-bug-info")
    @LogInfo(methodName = "添加Bug信息")
    public ResponseMessage insertBugInfo(@RequestBody BugDetails record) {
        logger.debug(TAG+record);
//        System.out.println(record.getBackup3());
        UnifiedExceptionHandler.method= record + "update-bug-info==============================" + record;
        responseMessage = bugDetailsService.insertSelective(record);
        return responseMessage;
    }



    /**
     * TODO 根据id批量删除Bug信息
     * @param
     * @return
     */
    @RequestMapping("delete-bug-info")
    @LogInfo(methodName = "根据id删除Bug信息")
    public ResponseMessage deleteBugInfo(@RequestBody ArrayVO arrayVO) {
        logger.debug(TAG+arrayVO);
        UnifiedExceptionHandler.method = TAG + "deleteBugInfo============================" +arrayVO;
        responseMessage = bugDetailsService.deleteByPrimaryKey(arrayVO.getList());
        return responseMessage;
    }

    /**
     * 查询所有Bug信息
     * @return
     */
    /*@RequestMapping("query-bug-infos")
    @LogInfo(methodName = "查询Bug信息")
    public ResponseMessage queryBugInfos() {
        logger.debug(TAG);
        UnifiedExceptionHandler.method= "query-bug-infos==============================";
        responseMessage = bugDetailsService.queryAllBugInfos();
        return responseMessage;
    }*/

    /**
     * TODO 级联查询
     * @return
     */
    @RequestMapping("query-bug-and-record-infos")
    @LogInfo(methodName = "查询Bug信息")
    public ResponseMessage queryAllBugAndRecordInfo(@RequestBody String id) {
        logger.debug(TAG+id);
        UnifiedExceptionHandler.method= id+ "queryAllBugAndRecordInfo==============================" + id;
        JSONObject ids = JSONObject.parseObject(id);
        String is = ids.getString("id");

        responseMessage = bugDetailsService.queryAllBugAndRecordInfo(is);
        return responseMessage;
    }


    /**
     * bug查询条件
     * @param
     * @return
     */
    @RequestMapping("query-bug-search")
    @LogInfo(methodName = "bug查询条件")
    public ResponseMessage queryBugSearch() {

        UnifiedExceptionHandler.method=  "queryBugSearch==============================";
        responseMessage = bugDetailsService.queryBugSearch();
        return responseMessage;
    }


    /**
     * 查询待办
     * @param pageVo
     * @return
     */
    @RequestMapping("select-bug-search-dealt-with")
    @LogInfo(methodName = "bug查询条件")
    public ResponseMessage selectBugSearchDealtWith(@RequestBody PageVo pageVo) {
        UnifiedExceptionHandler.method=  "selectBugSearchDealtWith==============================";
        responseMessage = bugDetailsService.selectBugSearchDealtWith(pageVo);
        return responseMessage;
    }


    /**
     * 查询在办
     * @param pageVo
     * @return
     */
    @RequestMapping("select-bug-search-dealt-doing")
    @LogInfo(methodName = "bug查询条件")
    public ResponseMessage selectBugSearchDealtDoing(@RequestBody PageVo pageVo) {
        UnifiedExceptionHandler.method=  "selectBugSearchDealtDoing==============================";
        responseMessage = bugDetailsService.selectBugSearchDealtDoing(pageVo);
        return responseMessage;
    }


    /**
     * 查找已办
     */
    @RequestMapping("select-bug-search-dealt-end")
    @LogInfo(methodName = "bug查询条件")
    public ResponseMessage selectBugSearchDealtEnd(@RequestBody PageVo pageVo) {
        UnifiedExceptionHandler.method=  "selectBugSearchDealtDoing==============================";
        responseMessage = bugDetailsService.selectBugSearchDealtEnd(pageVo);
        return responseMessage;
    }




    /**
     * 查找暂存
     */
    @RequestMapping("select-bug-search-dealt-temporary")
    @LogInfo(methodName = "bug查询条件")
    public ResponseMessage selectBugSearchDealtTemporary(@RequestBody PageVo pageVo) {
        UnifiedExceptionHandler.method=  "selectBugSearchDealtTemporary==============================";
        responseMessage = bugDetailsService.selectBugSearchDealtTemporary(pageVo);
        return responseMessage;
    }







}
