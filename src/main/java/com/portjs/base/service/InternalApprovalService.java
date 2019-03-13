package com.portjs.base.service;

import com.portjs.base.util.ResponseMessage;

public interface InternalApprovalService {

    ResponseMessage selectByPrimaryKey(String id);
    /**
     * 统计今年新增项目条数
     * @return
     */
    ResponseMessage newIncreaseProjectCount();

    /**
     * 统计今年新增项目总金额
     * @return
     */
    ResponseMessage newIncreaseProjectAmountCount();

}
