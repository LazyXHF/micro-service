package com.portjs.base.dao;

import com.portjs.base.entity.TTraceLog;
import com.portjs.base.entity.TTraceLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TTraceLogMapper {
    int countByExample(TTraceLogExample example);

    int deleteByExample(TTraceLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TTraceLog record);

    int insertSelective(TTraceLog record);

    List<TTraceLog> selectByExample(TTraceLogExample example);

    TTraceLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TTraceLog record, @Param("example") TTraceLogExample example);

    int updateByExample(@Param("record") TTraceLog record, @Param("example") TTraceLogExample example);

    int updateByPrimaryKeySelective(TTraceLog record);

    int updateByPrimaryKey(TTraceLog record);
}