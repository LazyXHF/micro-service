package com.portjs.base.dao;

import com.portjs.base.entity.TXietongAgendaRecord;
import com.portjs.base.entity.TXietongAgendaRecordExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TXietongAgendaRecordMapper {
    int countByExample(TXietongAgendaRecordExample example);

    int deleteByExample(TXietongAgendaRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(TXietongAgendaRecord record);

    int insertSelective(TXietongAgendaRecord record);

    List<TXietongAgendaRecord> selectByExample(TXietongAgendaRecordExample example);

    TXietongAgendaRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TXietongAgendaRecord record, @Param("example") TXietongAgendaRecordExample example);

    int updateByExample(@Param("record") TXietongAgendaRecord record, @Param("example") TXietongAgendaRecordExample example);

    int updateByPrimaryKeySelective(TXietongAgendaRecord record);

    int updateByPrimaryKey(TXietongAgendaRecord record);
}