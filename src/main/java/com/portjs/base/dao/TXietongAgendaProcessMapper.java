package com.portjs.base.dao;

import com.portjs.base.entity.TXietongAgendaProcess;
import com.portjs.base.entity.TXietongAgendaProcessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by dengshuangzhen on 2019\2\17 0017
 */
@Repository
public interface    TXietongAgendaProcessMapper {
    int countByExample(TXietongAgendaProcessExample example);

    int deleteByExample(TXietongAgendaProcessExample example);

    int deleteByPrimaryKey(String id);

    int insert(TXietongAgendaProcess record);

    int insertSelective(TXietongAgendaProcess record);

    List<TXietongAgendaProcess> selectByExample(TXietongAgendaProcessExample example);

    TXietongAgendaProcess selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TXietongAgendaProcess record, @Param("example") TXietongAgendaProcessExample example);

    int updateByExample(@Param("record") TXietongAgendaProcess record, @Param("example") TXietongAgendaProcessExample example);

    int updateByPrimaryKeySelective(TXietongAgendaProcess record);

    int updateByPrimaryKey(TXietongAgendaProcess record);

    int insertProcess(TXietongAgendaProcess process);

    int updateProcess(@Param("agenda_process_id") String agenda_process_id, @Param("status") String status);
}