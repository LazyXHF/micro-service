package com.portjs.base.dao;

import com.portjs.base.entity.Design;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignMapper {
    int deleteByPrimaryKey(String id);

    int insert(Design record);

    int insertSelective(Design record);

    Design selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Design record);

    int updateByPrimaryKey(Design record);
}