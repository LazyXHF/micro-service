package com.portjs.base.dao;

import com.portjs.base.entity.PurchaseReview;
import com.portjs.base.util.ResponseMessage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseReviewMapper {
    int deleteByPrimaryKey(String id);

    int insert(PurchaseReview record);

    int insertSelective(PurchaseReview record);

    PurchaseReview selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PurchaseReview record);

    int updateByPrimaryKey(PurchaseReview record);


}