package com.portjs.base.dao;

import com.portjs.base.entity.TErrcodeInfo;
import com.portjs.base.entity.TErrcodeInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TErrcodeInfoMapper {
    int countByExample(TErrcodeInfoExample example);

    int deleteByExample(TErrcodeInfoExample example);

    int insert(TErrcodeInfo record);

    int insertSelective(TErrcodeInfo record);

    List<TErrcodeInfo> selectByExample(TErrcodeInfoExample example);

    int updateByExampleSelective(@Param("record") TErrcodeInfo record, @Param("example") TErrcodeInfoExample example);

    int updateByExample(@Param("record") TErrcodeInfo record, @Param("example") TErrcodeInfoExample example);

    TErrcodeInfo selectErrorMsg(String errorType, String errorCode);
}