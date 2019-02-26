package com.project.mgt.dao;

import com.project.mgt.entity.TXietongRoleMenu;
import com.project.mgt.entity.TXietongRoleMenuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TXietongRoleMenuMapper {
    int countByExample(TXietongRoleMenuExample example);

    int deleteByExample(TXietongRoleMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TXietongRoleMenu record);

    int insertSelective(TXietongRoleMenu record);

    List<TXietongRoleMenu> selectByExample(TXietongRoleMenuExample example);

    TXietongRoleMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TXietongRoleMenu record, @Param("example") TXietongRoleMenuExample example);

    int updateByExample(@Param("record") TXietongRoleMenu record, @Param("example") TXietongRoleMenuExample example);

    int updateByPrimaryKeySelective(TXietongRoleMenu record);

    int updateByPrimaryKey(TXietongRoleMenu record);


    //根据角色的id和的id删除菜单权限
    int deleteRoleResource(@Param("rid") String rid, @Param("reid") String reid);

    //根据角色的id和按钮的id查询数据
    TXietongRoleMenu findRoleResourceByRidAndBid(@Param("rid") String rid, @Param("reid") String reid);

    int deleteRoleResourceByRoleId(String roleId);


}