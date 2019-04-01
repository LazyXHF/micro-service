package com.portjs.base.service;

import com.portjs.base.entity.BugDetailsRecord;
import com.portjs.base.util.ResponseMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BugDetailsRecordService {
    /**
     * 根据id删除审批信息（可批量删除）
     * @param ids
     * @return
     */
    ResponseMessage deleteByPrimaryKey(@Param("id") List<String> ids);

    //int insert(BugDetailsRecord record);

    /**
     * 添加审批意见
     * @param record
     * @return
     */
    ResponseMessage insertSelective(BugDetailsRecord record);

    /**
     * 根据id查询审批意见
     * @param id
     * @return
     */
    ResponseMessage selectByPrimaryKey(String id);
    /**
     * 根据Bug id查询审批意见
     * @param bugDetailsRecord
     * @return
     */
    ResponseMessage queryBugRecordByBugId(BugDetailsRecord bugDetailsRecord);
    /**
     * 更新审批意见
     * @param record
     * @return
     */
    ResponseMessage updateByPrimaryKeySelective(BugDetailsRecord record);

/**
 * TODO  流程操作方法------------------分割线--------------------------------------------------------------------------------------------------------------------
 */
    /**
     * 进行流程操作--更新record表状态值（status）
     * @param  requestBody  传status  Record表的状态值
     * @return
     */
    //ResponseMessage updateFlowOperation(String requestBody);
    /**
     * 进行流程操作--插入record状态
     * @param requestBody  此id为bug主表id
     * @return
     */
    ResponseMessage insertFlowOperation(String requestBody);
/**
 * TODO  流程操作方法------------------分割线--------------------------------------------------------------------------------------------------------------------
 */


}
