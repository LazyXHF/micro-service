package com.portjs.base.dao;

import com.portjs.base.entity.PurchaseReview;
import com.portjs.base.entity.PurchaseReviewExample;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.ContractVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface PurchaseReviewMapper {
    int countByExample(PurchaseReviewExample example);

    int deleteByExample(PurchaseReviewExample example);

    int deleteByPrimaryKey(String id);

    int insert(PurchaseReview record);

    int insertSelective(PurchaseReview record);

    List<PurchaseReview> selectByExample(PurchaseReviewExample example);

    PurchaseReview selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PurchaseReview record, @Param("example") PurchaseReviewExample example);

    int updateByExample(@Param("record") PurchaseReview record, @Param("example") PurchaseReviewExample example);

    int updateByPrimaryKeySelective(PurchaseReview record);

    int updateByPrimaryKey(PurchaseReview record);

    /**
     * 查询总数
     * @param method
     * @param projectCode
     * @param projectName
     * @return
     */
    int selectByMethodCount(@Param("method") String method, @Param("projectCode") String projectCode, @Param("projectName") String projectName);

    /**
     * 查询每页数据
     * @param method
     * @param projectCode
     * @param projectName
     * @param rowNum
     * @param pageCount
     * @return
     */
    List<ContractVo> selectByPage(@Param("method") String method, @Param("projectCode") String projectCode, @Param("projectName") String projectName, @Param("rowNum") Integer rowNum, @Param("pageCount") Integer pageCount);
    @Select(" select max(review_num)  from purchase_review")
    String findMaxOdd();

    List<PurchaseReview> queryPucharseReview(@Param("projectCode") String projectCode, @Param("projectName") String projectName, @Param("method") String method, @Param("supplier") String supplier, @Param("submitTime") String submitTime, @Param("status") String status);

    PurchaseReview queryPucharseReviewBase(@Param("id") String id);

    int updateProjectReviewStatus(@Param("id") String id, @Param("nowBackUp3") String nowBackUp3);

    int deleteProjectReview(@Param("id") String id);

    int updateProjectReviewStatus2(PurchaseReview p);
}