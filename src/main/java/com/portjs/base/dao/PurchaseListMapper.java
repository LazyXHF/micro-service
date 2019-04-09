package com.portjs.base.dao;

import com.portjs.base.entity.PurchaseList;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.entity.PurchaseListExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PurchaseListMapper {
    int countByExample(PurchaseListExample example);

    int deleteByExample(PurchaseListExample example);

    int deleteByPrimaryKey(String id);

    int insert(PurchaseList record);

    int insertSelective(PurchaseList record);

    PurchaseList selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PurchaseList record);

    int updateByPrimaryKey(PurchaseList record);
    /**
     * 采购清单列表统计
     * @param projectId
     * @param requestId
     * @return
     */
    int purchaseListCounts(@Param("projectId") String projectId,@Param("requestId") String requestId);

    /**
     * 采购清单列表的分页
     * @param projectId
     * @param requestId
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<PurchaseList> queryPurchaseListInfo(@Param("projectId") String projectId,@Param("requestId") String requestId,
                                             @Param("pageNo") Integer pageNo,@Param("pageSize") Integer pageSize);
    /**
     * 批量软删除
     * @param ids
     * @return
     */
    int updateDeleteTimeByIds(@Param("id") List<String> ids);

    PurchaseList queryPurchaseListById(@Param("id") String ids);

    int insertPurchaseListSelective(PurchaseList record);

    List<PurchaseList> selectByExample(PurchaseListExample example);

    /*PurchaseList selectByPrimaryKey(String id);*/

    int updateByExampleSelective(@Param("record") PurchaseList record, @Param("example") PurchaseListExample example);

    int updateByExample(@Param("record") PurchaseList record, @Param("example") PurchaseListExample example);

    /*int updateByPrimaryKeySelective(PurchaseList record);

    int updateByPrimaryKey(PurchaseList record);*/
}