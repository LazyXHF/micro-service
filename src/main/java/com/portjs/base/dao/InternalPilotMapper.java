package com.portjs.base.dao;

import com.portjs.base.entity.InternalPilot;
import org.springframework.stereotype.Repository;

/**
 * InternalPilotMapper
 * 项目生命周期节点之---
 * 试点实施（试运行）
 */
@Repository
public interface InternalPilotMapper {
    int deleteByPrimaryKey(String id);

    int insert(InternalPilot record);

    int insertSelective(InternalPilot record);

    InternalPilot selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(InternalPilot record);

    int updateByPrimaryKey(InternalPilot record);
}