package com.portjs.base.service;

import com.portjs.base.util.ResponseMessage;

/**
 * Created by dengshuangzhen on 2019\4\4 0004
 */
public interface PurchasingManagementService {
    /**
     * 采购详情暂存/提交
     * @param responseBody
     * @return
     */
    ResponseMessage inserProcurementDetails(String responseBody);
}
