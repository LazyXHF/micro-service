package com.portjs.base.dao;

import com.portjs.base.entity.CommunicationLog;

public interface CommunicationLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(CommunicationLog record);

    int insertSelective(CommunicationLog record);

    CommunicationLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CommunicationLog record);

    int updateByPrimaryKey(CommunicationLog record);
}