package com.portjs.base.dao;

import com.portjs.base.entity.TXietongAgenda;
import com.portjs.base.entity.TXietongAgendaRelease;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dengshuangzhen on 2019\1\31 0031
 */
@Repository
public interface TXietongAgendaReleaseMapper {
    int deleteRelease(TXietongAgenda agenda);

    int insert(TXietongAgenda agenda1);

    List<TXietongAgendaRelease> selectAgendaByTime(TXietongAgendaRelease agendaRelease);
}
