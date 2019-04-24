package com.portjs.base.dao;

import com.portjs.base.entity.TUser;
import com.portjs.base.entity.TUserExample;
import com.portjs.base.vo.UserRoleDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TUserMapper {
    int countByExample(TUserExample example);

    int deleteByExample(TUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(TUser record);

    int insertSelective(TUser record);

    List<TUser> selectByExample(TUserExample example);

    TUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByExample(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);

    //登录验证
    TUser loginUserByAccount(String account);


    //查找最大的sort
    int selectMaxSort();



    //查询用户信息
    List<TUser> selectUserByLoginNameOrDepartmentId(@Param("loginName") String loginName, @Param("departmentId") String departmentId, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
    int selectUserCountByLoginNameOrDepartmentId(@Param("loginName") String loginName, @Param("departmentId") String departmentId);


    //查询用户角色部门
     UserRoleDO selectUserAndRoleAndDepartmentByUid(String uid);

     //排序
    int updateSortByUid(@Param("sort") int sort, @Param("uid") String uid);



//    List<TUser> selectUserByDepartmentId(String did);
    String selectById(@Param("id") String id);

    List<TUser> queryUserInfo();

    List<TUser> selectUserByRoleId(@Param("rid")String rid);

    String queryUserNameByUserId(@Param("actionUserId") String actionUserId);


    //多部门查询用户
    List<TUser> selectUserByLoginNameAndDepartmentIds(@Param("loginName") String loginName, @Param("departmentId") String departmentId, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
    int selectUserCountByLoginNameAndDepartmentIds(@Param("loginName") String loginName, @Param("departmentId") String departmentId);



    //根据角色id和部门id查询用户
    List<TUser> selectUserByDidAndRids(@Param("did") String did, @Param("rid") String rid);


    UserRoleDO selectUserAndRoleAndDepartmentByUids(@Param("uid") String rid);

}