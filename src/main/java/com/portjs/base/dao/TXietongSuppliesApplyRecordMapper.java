package com.portjs.base.dao;

import com.portjs.base.entity.TXietongSuppliesApplyRecord;
import com.portjs.base.entity.TXietongSuppliesApplyRecordExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TXietongSuppliesApplyRecordMapper {
    int countByExample(TXietongSuppliesApplyRecordExample example);

    int deleteByExample(TXietongSuppliesApplyRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(TXietongSuppliesApplyRecord record);

    int insertSelective(TXietongSuppliesApplyRecord record);

    List<TXietongSuppliesApplyRecord> selectByExample(TXietongSuppliesApplyRecordExample example);

    TXietongSuppliesApplyRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TXietongSuppliesApplyRecord record, @Param("example") TXietongSuppliesApplyRecordExample example);

    int updateByExample(@Param("record") TXietongSuppliesApplyRecord record, @Param("example") TXietongSuppliesApplyRecordExample example);

    int updateByPrimaryKeySelective(TXietongSuppliesApplyRecord record);

    int updateByPrimaryKey(TXietongSuppliesApplyRecord record);
/*
     ============================================自己写的方法=========================================================================
*/
    int addApplyRecords(TXietongSuppliesApplyRecord applyRecord);

    int updateapplyRecord(TXietongSuppliesApplyRecord applyRecords);

    List<TXietongSuppliesApplyRecord> queryhandleDetails(@Param("id") String id);

    /*int updateSupplyRecords(@Param("id")String id);*/

    int deleteSupplyApplyRecords(@Param("id") String id);

    int addToRepository(TXietongSuppliesApplyRecord toRepository);


    TXietongSuppliesApplyRecord queryBanGongXiangqing(@Param("id") String id, @Param("ownerId") String ownerId);

    TXietongSuppliesApplyRecord queryBanGongXiangqing1(@Param("id") String id, @Param("ownerId") String ownerId);

    Integer queryPucharseStatus(@Param("id") String id, @Param("ownerId") String ownerId);

    int updateapplyRecordCaiGouYuan(TXietongSuppliesApplyRecord applyRecords);

    int updateapplyRecord1(TXietongSuppliesApplyRecord applyRecords);

    Integer queryOpinion(@Param("id") String id, @Param("ownerId") String bangongshiId);

    String queryRecordId(@Param("applyId") String applyId, @Param("ownerId") String ownerId);

    int updateapplyRecordById(@Param("id") String id);

    String queryRecordIdBanGong(@Param("applyId") String applyId, @Param("ownerId") String ownerId);


    List<TXietongSuppliesApplyRecord> queryApplyRecords(@Param("ownerId") String ownerId, @Param("id") String id);

    int updateOfficerRecord(TXietongSuppliesApplyRecord record);

    List<TXietongSuppliesApplyRecord> querySupplyApplyRecord(@Param("ownerId") String ownerId);

    List<TXietongSuppliesApplyRecord> querySupplyApplyRecord2(@Param("ownerId") String ownerId, @Param("rowNum") Integer rowNum, @Param("pageCount") Integer pageCount);

    int updateBanGongshiStatus(@Param("id") String id, @Param("nextPeopleId") String nextPeopleId);

    int queryStatus(@Param("id") String id, @Param("ownerId") String ownerId);

    int updateApplyStatus(@Param("id") String id, @Param("applyId") String applyId);

    String queryRecordCaiGouId(@Param("id") String id, @Param("caigouyuanId") String caigouyuanId);
}