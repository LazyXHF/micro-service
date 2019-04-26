package com.portjs.base.dao;

import com.portjs.base.entity.TRole;
import com.portjs.base.entity.TRoleExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TRoleMapper {
    int countByExample(TRoleExample example);

    int deleteByExample(TRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(TRole record);

    int insertSelective(TRole record);

    List<TRole> selectByExample(TRoleExample example);

    TRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TRole record, @Param("example") TRoleExample example);

    int updateByExample(@Param("record") TRole record, @Param("example") TRoleExample example);

    int updateByPrimaryKeySelective(TRole record);

    int updateByPrimaryKey(TRole record);


    //根据角色名查找角色分页
    List<TRole> selectRoleByRoleName(@Param("roleName") String roleName, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
    int selectRoleByRoleNameCount(@Param("roleName") String roleName);


    //角色中最大的值
    int selectMaxSort();

    //通过用户查角色
    List<TRole> selectRoleByUserId(@Param("userId") String userId);
}