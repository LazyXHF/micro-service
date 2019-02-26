package com.project.mgt.dao;

import com.project.mgt.entity.TXietongUserRole;
import com.project.mgt.entity.TXietongUserRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TXietongUserRoleMapper {
    int countByExample(TXietongUserRoleExample example);

    int deleteByExample(TXietongUserRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TXietongUserRole record);

    int insertSelective(TXietongUserRole record);

    List<TXietongUserRole> selectByExample(TXietongUserRoleExample example);

    TXietongUserRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TXietongUserRole record, @Param("example") TXietongUserRoleExample example);

    int updateByExample(@Param("record") TXietongUserRole record, @Param("example") TXietongUserRoleExample example);

    int updateByPrimaryKeySelective(TXietongUserRole record);

    int updateByPrimaryKey(TXietongUserRole record);

    TXietongUserRole findUserRoleByUid(String uid);

    int updateUserRoleRidByUid(@Param("uid") String uid, @Param("rid") String rid);

    //根据角色的去改变关联表中的可用状态
    int updateUserAndRoleStatus(@Param("rid") String rid, @Param("status") String status);


    //根据角色的id查找是否存在用户信息
    List<TXietongUserRole> selectUserRole(String rid);


    //根据用户的id修改status状态
    int updateStatusByUid(String uid);


    List<TXietongUserRole> selectUserRoleByUidAndRid(@Param("uid") String uid, @Param("rid") String rid);

    int deleteUserRoleByUidAndRid(@Param("uid") String uid, @Param("rid") String rid);

    //根据角色的id查询该角色下的用户id
    List<String> selectUserIdByRoleId(String rid);

    //根据用户的id删除角色关联
    int deleteUserRoleStatus(String uid);
}