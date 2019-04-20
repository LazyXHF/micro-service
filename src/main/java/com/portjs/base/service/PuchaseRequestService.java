package com.portjs.base.service;

import com.portjs.base.entity.PurchaseRequest;
import com.portjs.base.util.ResponseMessage;

import java.util.List;

public interface PuchaseRequestService {
    //ResponseMessage deleteByPrimaryKey(String id);

    //ResponseMessage insert(PurchaseRequest record);

    //ResponseMessage insertSelective(PurchaseRequest record);

    //ResponseMessage selectByPrimaryKey(String id);

    //ResponseMessage updateByPrimaryKey(PurchaseRequest record);

    ResponseMessage updateByPrimaryKeySelective(PurchaseRequest record);

    ResponseMessage insertPurchaseRequestSelective(String responseBody);
    /**
     * 对列表的分页并模糊查询
     * @param requestBody
     * @return
     */
    ResponseMessage queryPurchaseRequestInfo(String requestBody);
    /**
     * 批量软删除
     * @param ids
     * @return
     */
    ResponseMessage updateDeleteTimeByIds(List<String> ids);

    /**
     * 根据id查询申请信息
     * @param ids
     * @return
     */
    ResponseMessage queryPurchaseRequestById(String ids);



}
