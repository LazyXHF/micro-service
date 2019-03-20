package com.portjs.base.dao;

import com.portjs.base.entity.TXietongAgenda;
import com.portjs.base.entity.TXietongAgendaRelease;
import com.portjs.base.entity.TXietongAgendaReleaseExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dengshuangzhen on 2019\1\31 0031
 */
@Repository
public interface TXietongAgendaReleaseMapper {
    int countByExample(TXietongAgendaReleaseExample example);

    int deleteByExample(TXietongAgendaReleaseExample example);

    int deleteByPrimaryKey(String id);

    int insert(TXietongAgendaRelease record);

    int insertSelective(TXietongAgendaRelease record);

    List<TXietongAgendaRelease> selectByExample(TXietongAgendaReleaseExample example);

    TXietongAgendaRelease selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TXietongAgendaRelease record, @Param("example") TXietongAgendaReleaseExample example);

    int updateByExample(@Param("record") TXietongAgendaRelease record, @Param("example") TXietongAgendaReleaseExample example);

    int updateByPrimaryKeySelective(TXietongAgendaRelease record);

    int updateByPrimaryKey(TXietongAgendaRelease record);

    List<TXietongAgendaRelease> selectAgendaByTime(TXietongAgendaRelease agendaRelease);

}
