package com.portjs.base.dao;

import com.portjs.base.entity.PurchaseRequest;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRequestMapper {
    int deleteByPrimaryKey(String id);

    int insert(PurchaseRequest record);

    int insertSelective(PurchaseRequest record);

    PurchaseRequest selectByPrimaryKey(String id);

    int updateByPrimaryKey(PurchaseRequest record);

    int updateByPrimaryKeySelective(PurchaseRequest record);

    /**
     * 采购清单列表统计
     * @param projectId
     * @param requestId
     * @return
     */
    int purchaseRequestCounts(@Param("projectId") String projectId, @Param("requestId") String requestId);

    /**
     * 采购清单列表的分页
     * @param projectId
     * @param requestId
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<PurchaseRequest> queryPurchaseRequestInfo(@Param("projectId") String projectId,@Param("requestId") String requestId,
                                             @Param("pageNo") Integer pageNo,@Param("pageSize") Integer pageSize);
    /**
     * 批量软删除
     * @param ids
     * @return
     */
    int updateDeleteTimeByIds(@Param("id") List<String> ids);

    PurchaseRequest queryPurchaseRequestById(@Param("id") String ids);

    int insertPurchaseRequestSelective(PurchaseRequest record);

    /**
     * 查询最大流水单号
     * @return
     */
    @Select("select max(request_num) from purchase_request")
    String findMaxOdd();

    List queryPucharseList(String method, String projectCode, String projectName);
}