package com.portjs.base.service;

import com.portjs.base.util.ResponseMessage;

/**
 * Created by dengshuangzhen on 2019\4\10 0010
 */
public interface ContractService {

    /**
     * 查询合同来源
     * @param responseBody
     * @return
     */
    ResponseMessage selectContractSource(String responseBody);
}
