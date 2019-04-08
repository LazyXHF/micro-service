package com.portjs.base.dao;

import com.portjs.base.entity.TenderApplication;

public interface TenderApplicationMapper {
    int deleteByPrimaryKey(String id);

    int insert(TenderApplication record);

    int insertSelective(TenderApplication record);

    TenderApplication selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TenderApplication record);

    int updateByPrimaryKey(TenderApplication record);
}