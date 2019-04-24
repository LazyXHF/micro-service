package com.portjs.base.service;

import com.portjs.base.util.ResponseMessage;

/**
 * Created by dengshuangzhen on 2019\4\23 0023
 */
public interface WeeklyAndMonthlyReportManagementService {


    /**
     * 周报详情查询
     * @param requestBody
     * @return
     */
    ResponseMessage selectWeeklyDetails(String requestBody) throws Exception;

    /**
     * 提交保存周报详情
     * @param requestBody
     * @return
     */
    ResponseMessage submissionWeeklyDetails(String requestBody);

    /**
     * 周报查询
     * @param requestBody
     * @return
     */
    ResponseMessage selectWeekly(String requestBody) throws Exception;
}
