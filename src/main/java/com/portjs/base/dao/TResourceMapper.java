package com.portjs.base.dao;

import com.portjs.base.entity.TResource;
import com.portjs.base.entity.TResourceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TResourceMapper {
    int countByExample(TResourceExample example);

    int deleteByExample(TResourceExample example);

    int insert(TResource record);

    int insertSelective(TResource record);

    List<TResource> selectByExample(TResourceExample example);

    int updateByExampleSelective(@Param("record") TResource record, @Param("example") TResourceExample example);

    int updateByExample(@Param("record") TResource record, @Param("example") TResourceExample example);
}