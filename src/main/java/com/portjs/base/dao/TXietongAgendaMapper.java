package com.portjs.base.dao;

import com.portjs.base.entity.TXietongAgenda;
import com.portjs.base.entity.TXietongAgendaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface TXietongAgendaMapper {
    int countByExample(TXietongAgendaExample example);

    int deleteByExample(TXietongAgendaExample example);

    int deleteByPrimaryKey(String id);

    int insert(TXietongAgenda record);

    int insertSelective(TXietongAgenda record);

    List<TXietongAgenda> selectByExample(TXietongAgendaExample example);

    TXietongAgenda selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TXietongAgenda record, @Param("example") TXietongAgendaExample example);

    int updateByExample(@Param("record") TXietongAgenda record, @Param("example") TXietongAgendaExample example);

    int updateByPrimaryKeySelective(TXietongAgenda record);

    int updateByPrimaryKey(TXietongAgenda record);

    List<TXietongAgenda> selectAgendaByIdAndTime(TXietongAgenda agenda);

    List<TXietongAgenda> selectAgendaByTime(TXietongAgenda agenda);

    int selectAgenda(TXietongAgenda agenda);
}