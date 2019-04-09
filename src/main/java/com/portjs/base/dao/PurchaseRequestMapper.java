package com.portjs.base.dao;

import com.portjs.base.entity.PurchaseRequest;
import com.portjs.base.entity.PurchaseRequestExample;
import com.portjs.base.util.ResponseMessage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PurchaseRequestMapper {
    int countByExample(PurchaseRequestExample example);

    int deleteByExample(PurchaseRequestExample example);

    int deleteByPrimaryKey(String id);

    int insert(PurchaseRequest record);

    int insertSelective(PurchaseRequest record);

    List<PurchaseRequest> selectByExample(PurchaseRequestExample example);

    PurchaseRequest selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PurchaseRequest record, @Param("example") PurchaseRequestExample example);

    int updateByExample(@Param("record") PurchaseRequest record, @Param("example") PurchaseRequestExample example);

    int updateByPrimaryKeySelective(PurchaseRequest record);

    int updateByPrimaryKey(PurchaseRequest record);

    List queryPucharseList(@Param("method") String method, @Param("projectCode") String projectCode,@Param("projectName") String projectName);
}