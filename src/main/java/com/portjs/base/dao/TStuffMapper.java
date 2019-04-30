package com.portjs.base.dao;

import com.portjs.base.entity.TStuff;
import com.portjs.base.entity.TStuffExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TStuffMapper {
    int countByExample(TStuffExample example);

    int deleteByExample(TStuffExample example);

    int deleteByPrimaryKey(String id);

    int insert(TStuff record);

    int insertSelective(TStuff record);

    List<TStuff> selectByExample(TStuffExample example);

    TStuff selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TStuff record, @Param("example") TStuffExample example);

    int updateByExample(@Param("record") TStuff record, @Param("example") TStuffExample example);

    int updateByPrimaryKeySelective(TStuff record);

    int updateByPrimaryKey(TStuff record);
}