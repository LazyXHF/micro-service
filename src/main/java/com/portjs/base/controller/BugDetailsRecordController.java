package com.portjs.base.controller;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.BugDetails;
import com.portjs.base.entity.BugDetailsRecord;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.BugDetailsRecordService;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.ArrayVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * bug模块
 */
@RequestMapping("bug-details-record")
@CrossOrigin
@RestController
public class BugDetailsRecordController extends BaseController{
    static final String TAG = "InternalProjectService===>";
    ResponseMessage responseMessage;

    @Autowired
    BugDetailsRecordService bugDetailsRecordService;


    /**
     * TODO 流程操作
     * @param requestBody
     * @return
     */
    @RequestMapping("insert-flow-operation")
    @LogInfo(methodName = "添加Bug信息")
    public ResponseMessage insertFlowOperation(@RequestBody String requestBody) {
        logger.debug(TAG+requestBody);
        UnifiedExceptionHandler.method= requestBody + "update-bug-info==============================" + requestBody;
        responseMessage = bugDetailsRecordService.insertFlowOperation(requestBody);
        return responseMessage;
    }


    /**
     *  TODO 根据自身id查询Bug审批相关信息
     * @param id
     * @return
     */
    @RequestMapping("select-bug-record-info")
    @LogInfo(methodName = "根据自身id查询Bug信息")
    @ResponseBody
    public ResponseMessage selectBugRecordInfo(@RequestBody String id) {
        logger.debug(TAG+id);
        JSONObject jsonObject = JSONObject.parseObject(id);
        String str = jsonObject.getString("id");
        UnifiedExceptionHandler.method= str + "select-bug-record-info==============================" + str;
        return bugDetailsRecordService.selectByPrimaryKey(str);
    }
    /**
     *  TODO 根据Bug id查询审批意见
     * @param bugDetailsRecord
     * @return
     */
    @RequestMapping("query-bug-record-info")
    @LogInfo(methodName = "根据Bug id查询审批意见")
    @ResponseBody
    public ResponseMessage queryBugRecordByBugId(@RequestBody BugDetailsRecord bugDetailsRecord) {
        logger.debug(TAG+bugDetailsRecord);
        UnifiedExceptionHandler.method= bugDetailsRecord + "query-bug-record-info==============================" + bugDetailsRecord;
        return bugDetailsRecordService.queryBugRecordByBugId(bugDetailsRecord);
    }
    /**
     *  TODO 更新Bug审批相关信息
     * @param record
     * @return
     */
    @RequestMapping("update-bug-record-info")
    @LogInfo(methodName = "更新Bug审批相关信息")
    @ResponseBody
    public ResponseMessage updateByPrimaryKeySelective(@RequestBody BugDetailsRecord record) {
        logger.debug(TAG+record);
        UnifiedExceptionHandler.method= record + "update-bug-record-info==============================" + record;
        return bugDetailsRecordService.updateByPrimaryKeySelective(record);
    }
    /**
     * TODO 添加Bug审批相关信息
     * @param record
     * @return
     */
    @RequestMapping("insert-bug-record-info")
    @LogInfo(methodName = "添加Bug审批相关信息")
    public ResponseMessage insertBugRecordInfo(@RequestBody BugDetailsRecord record) {
        logger.debug("insertBugRecordInfo() begin...");
        UnifiedExceptionHandler.method= record + "insert-bug-record-info==============================" + record;
        responseMessage = bugDetailsRecordService.insertSelective(record);
        return responseMessage;
    }
    /**
     * TODO 根据id批量删除Bug审批相关信息
     * @param
     * @return
     */
    @RequestMapping("delete-bug-record-info")
    @LogInfo(methodName = "根据id删除Bug审批相关信息")
    public ResponseMessage deleteBugRecordInfo(@RequestBody ArrayVO arrayVO) {
        logger.debug(TAG+arrayVO);
        UnifiedExceptionHandler.method = TAG + "deleteBugRecordInfo============================" +arrayVO;
        responseMessage = bugDetailsRecordService.deleteByPrimaryKey(arrayVO.getList());
        return responseMessage;
    }


}
