package com.portjs.base.service;

import com.portjs.base.entity.PurchaseList;
import com.portjs.base.util.ResponseMessage;

import java.util.List;

public interface PurchaseListService {

    //ResponseMessage deleteByPrimaryKey(String id);

    //ResponseMessage insert(PurchaseList record);

    //ResponseMessage insertSelective(PurchaseList record);

    //ResponseMessage selectByPrimaryKey(String id);

    ResponseMessage updateByPrimaryKeySelective(PurchaseList record);

    ResponseMessage insertPurchaseListSelective(PurchaseList record);
    //ResponseMessage updateByPrimaryKey(PurchaseList record);
    /**
     * 对列表的分页并模糊查询
     * @param requestBody
     * @return
     */
    ResponseMessage queryPurchaseListInfo(String requestBody);
    /**
     * 批量软删除
     * @param ids
     * @return
     */
    ResponseMessage updateDeleteTimeByIds(List<String> ids);

    ResponseMessage queryPurchaseListById(String ids);
}
