package com.portjs.base.dao;

import com.portjs.base.entity.TRoleMenu;
import com.portjs.base.entity.TRoleMenuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TRoleMenuMapper {
    int countByExample(TRoleMenuExample example);

    int deleteByExample(TRoleMenuExample example);

    int deleteByPrimaryKey(String id);

    int insert(TRoleMenu record);

    int insertSelective(TRoleMenu record);

    List<TRoleMenu> selectByExample(TRoleMenuExample example);

    TRoleMenu selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TRoleMenu record, @Param("example") TRoleMenuExample example);

    int updateByExample(@Param("record") TRoleMenu record, @Param("example") TRoleMenuExample example);

    int updateByPrimaryKeySelective(TRoleMenu record);

    int updateByPrimaryKey(TRoleMenu record);
}