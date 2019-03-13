package com.portjs.base.dao;

import com.portjs.base.entity.InternalDesign;
import org.springframework.stereotype.Repository;

/**
 * InternalDesignMapper
 * 项目生命周期节点之---
 * 项目建设设计（需求设计）
 */
@Repository
public interface InternalDesignMapper {
    int deleteByPrimaryKey(String id);

    int insert(InternalDesign record);

    int insertSelective(InternalDesign record);

    InternalDesign selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(InternalDesign record);

    int updateByPrimaryKeyWithBLOBs(InternalDesign record);

    int updateByPrimaryKey(InternalDesign record);
}