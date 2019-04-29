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

    ResponseMessage updateByPrimaryKeySelective(String responseBody);

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

    /**
     * 审核采购流程
     * @return
     */
    ResponseMessage approvePurchaseRequest(String responseBody);

    /**
     * 查询所有可用部门
     * @return
     */
    ResponseMessage findAllDepartment();

    /**
     * 查询所有的审核流程
     * @return relateddomainId 业务单id
     */
    ResponseMessage queryAllWorkFlowStep(String requestBody);

    ResponseMessage returnRecord(String requestBody);

    ResponseMessage queryDropList();

    /**
     * 废除
     * @return  更新status:9 废除 根据主键更新
     */
    ResponseMessage abolishRecord(PurchaseRequest purchaseRequest);

}
