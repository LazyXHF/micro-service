package com.portjs.base.dao;

import com.portjs.base.entity.SpringSession;
import com.portjs.base.entity.SpringSessionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpringSessionMapper {
    int countByExample(SpringSessionExample example);

    int deleteByExample(SpringSessionExample example);

    int deleteByPrimaryKey(String primaryId);

    int insert(SpringSession record);

    int insertSelective(SpringSession record);

    List<SpringSession> selectByExample(SpringSessionExample example);

    SpringSession selectByPrimaryKey(String primaryId);

    int updateByExampleSelective(@Param("record") SpringSession record, @Param("example") SpringSessionExample example);

    int updateByExample(@Param("record") SpringSession record, @Param("example") SpringSessionExample example);

    int updateByPrimaryKeySelective(SpringSession record);

    int updateByPrimaryKey(SpringSession record);
}