package com.portjs.base.dao;

import com.portjs.base.entity.TXietongSupplyRecord;
import com.portjs.base.entity.TXietongSupplyRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

//领用记录并没有使用这个类  使用的是BanGongManager.dao
@Repository
public interface TXietongSupplyRecordMapper {
    int getRecordCount(@Param("supplyName") String supplyName, @Param("receiptorName") String receiptorName);

    List<TXietongSupplyRecord> getSupplyRecordList(@Param("supplyId") String supplyId, @Param("supplyType") String supplyType);

    int countByExample(TXietongSupplyRecordExample example);

    int deleteByExample(TXietongSupplyRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(TXietongSupplyRecord record);

    int insertSelective(TXietongSupplyRecord record);

    List<TXietongSupplyRecord> selectByExample(TXietongSupplyRecordExample example);

    TXietongSupplyRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TXietongSupplyRecord record, @Param("example") TXietongSupplyRecordExample example);

    int updateByExample(@Param("record") TXietongSupplyRecord record, @Param("example") TXietongSupplyRecordExample example);

    int updateByPrimaryKeySelective(TXietongSupplyRecord record);

    int updateByPrimaryKey(TXietongSupplyRecord record);
    //暂时没写  等后续添加
    int addRecords(TXietongSupplyRecord record);

    int addSupplyRecord(TXietongSupplyRecord supplyRecord);

    int deleteSupplyRecord(@Param("name") String name, @Param("type") String type);

    List<TXietongSupplyRecord> queryAllSupplyNames();

    List<TXietongSupplyRecord> querySupplyRecord(@Param("supplyName") String supplyName, @Param("departName") String departName, @Param("ym") String ym);

    List<TXietongSupplyRecord> queryAllDepartNames();


    List<String> querySupplyYears();
}