package com.project.mgt.dao;

import com.project.mgt.entity.TXietongDaiBanRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: daiyueyuan
 * @date: 2019/1/24 10:43
 * @description:
 */

@Repository
public interface TXietongDaiBanRecordMapper {
    //创建代办提醒
    int insertDaibanRecord(TXietongDaiBanRecord daiBanRecord);

    //创建催办代办提醒
    int insertDaibanRecord2(TXietongDaiBanRecord daiBanRecord);

    //查询代办提醒总条数
    int selectDaibanRecordCount(@Param("ownerId") String ownerId);

    //查询代办提醒
    List<TXietongDaiBanRecord> selectDaibanRecords(@Param("ownerId") String ownerId, @Param("rowNum") Integer rowNum,
                                                   @Param("pageCount") Integer pageCount);

    //修改代办状态
    int updateStatus(@Param("recordId") String recordId);

    //修改催办状态
    int updateisUrgent(@Param("recordId") String recordId);
}
