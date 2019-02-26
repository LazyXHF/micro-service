package com.project.mgt.dao;

import com.project.mgt.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TXietongRoleMapper {
    int countByExample(TXietongRoleExample example);

    int deleteByExample(TXietongRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(TXietongRole record);

    int insertSelective(TXietongRoleWithBLOBs record);

    List<TXietongRoleWithBLOBs> selectByExampleWithBLOBs(TXietongRoleExample example);

    List<TXietongRole> selectByExample(TXietongRoleExample example);

    TXietongRoleWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TXietongRoleWithBLOBs record, @Param("example") TXietongRoleExample example);

    int updateByExampleWithBLOBs(@Param("record") TXietongRoleWithBLOBs record, @Param("example") TXietongRoleExample example);

    int updateByExample(@Param("record") TXietongRole record, @Param("example") TXietongRoleExample example);

    int updateByPrimaryKeySelective(TXietongRoleWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TXietongRoleWithBLOBs record);

    int updateByPrimaryKey(TXietongRole record);


    //查询所有角色 (不分页)
    List<TXietongRole> findAllRole();
    //查询所有角色分页
    List<TXietongRole> findAllRolePage(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
    //根据角色名称查询
    List<TXietongRole> findRoleByNamePage(@Param("name") String name, @Param("status") String status, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    //根据角色名称查询角色
    List<TXietongRole> findRoleAllByName(@Param("name") String name, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    //查询角色总体数
    int roleCount();

     // 根据用户名查找对应的角色数目
    int roleCountByName(String name);
    int roleCountByNameAndStatus(@Param("name") String name, @Param("status") String status);

    //根据角色名称查询角色
    TXietongRole findRoleByName(String name);


    //角色启用/禁用
    int enOrDisRole(@Param("status") int status, @Param("rid") String rid);

    //角色的删除
    int deleteRoleByRid(String rid);


    //根据角色rid查询该角色下的用户
    List<TXietongUser> findUsersByRid(@Param("rid") String rid, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    //根据角色rid查询该角色下的用户的数目
    int countUserByRid(String rid);

    //角色更新时间
    int updateTime(@Param("date") Date date, @Param("rid") String rid);

    //根据角色id得到所属菜单
    List<TXietongMenuButton> findMenuButtonsByRoleName(@Param("cname") String cname, @Param("id") String id);


    //根据角色状态查询角色数据
    List<TXietongRole> selectRoleByStatus(@Param("status") String status, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);


    //根据角色状态查询角色数量
    int countRoleByStatus(String status);


    //==================================================================================>一人多角色


    //根据多个角色id获取菜单
    List<TXietongMenuButton> findMenuButtonsByRoleIds(@Param("cname") String cname, @Param("rids") List<String> rids);


}