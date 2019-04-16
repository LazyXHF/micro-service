package com.portjs.base.service;

import com.portjs.base.entity.Contract;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.ContractVo;

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

    /**
     * 新增合同
     * @param contract
     * @return
     */
    ResponseMessage insertContract(Contract contract);

    /**
     * 合同查询
     * @param contract
     * @return
     */
    ResponseMessage selectContract(ContractVo contract);

    /**
     * 合同详情查询
     * @param id
     * @return
     */
    ResponseMessage selectContractDetails(String id);
}
