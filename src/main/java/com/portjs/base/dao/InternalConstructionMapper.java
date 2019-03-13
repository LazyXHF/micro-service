package com.portjs.base.dao;

import com.portjs.base.entity.InternalConstruction;
import org.springframework.stereotype.Repository;

/**
 * internalConstrucation
 * 项目生命周期节点之---
 * 项目建设开发（开发测试）
 */
@Repository
public interface InternalConstructionMapper {
    int deleteByPrimaryKey(String id);

    int insert(InternalConstruction record);

    int insertSelective(InternalConstruction record);

    InternalConstruction selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(InternalConstruction record);

    int updateByPrimaryKeyWithBLOBs(InternalConstruction record);

    int updateByPrimaryKey(InternalConstruction record);
}