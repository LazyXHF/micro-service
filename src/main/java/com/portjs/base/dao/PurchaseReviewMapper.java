package com.portjs.base.dao;

import com.portjs.base.entity.PurchaseReview;
import com.portjs.base.entity.PurchaseReviewExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
}