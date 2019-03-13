package com.portjs.base.dao;

import com.portjs.base.entity.TXietongAgendaHuman;
import com.portjs.base.entity.TXietongAgendaHumanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TXietongAgendaHumanMapper {
    int countByExample(TXietongAgendaHumanExample example);

    int deleteByExample(TXietongAgendaHumanExample example);

    int deleteByPrimaryKey(String id);

    int insert(TXietongAgendaHuman record);

    int insertSelective(TXietongAgendaHuman record);

    List<TXietongAgendaHuman> selectByExample(TXietongAgendaHumanExample example);

    TXietongAgendaHuman selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TXietongAgendaHuman record, @Param("example") TXietongAgendaHumanExample example);

    int updateByExample(@Param("record") TXietongAgendaHuman record, @Param("example") TXietongAgendaHumanExample example);

    int updateByPrimaryKeySelective(TXietongAgendaHuman record);

    int updateByPrimaryKey(TXietongAgendaHuman record);
	
	List<TXietongAgendaHuman> selectByParticipantValue(@Param("participant_value") String participant_value,
                                                       @Param("rowNum") int RowNum,
                                                       @Param("pageCount") int pageCount);
}