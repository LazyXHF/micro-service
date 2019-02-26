package com.project.mgt.dao;

import com.project.mgt.entity.TXietongUser;
import com.project.mgt.entity.TXietongUserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TXietongUserMapper {
    int countByExample(TXietongUserExample example);

    int deleteByExample(TXietongUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(TXietongUser record);

    int insertSelective(TXietongUser record);

    List<TXietongUser> selectByExample(TXietongUserExample example);
    //根据用户id查询用户信息
    TXietongUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TXietongUser record, @Param("example") TXietongUserExample example);

    int updateByExample(@Param("record") TXietongUser record, @Param("example") TXietongUserExample example);

    int updateByPrimaryKeySelective(TXietongUser record);

    int updateByPrimaryKey(TXietongUser record);

    TXietongUser loadUserByUsername(String login_name);

    int selectCount(TXietongUser user);




    //查询所有部门sort中最大的数据
    int selectMaxSort();

    //查询所有用户信息
    List<TXietongUser> findAllUser(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    //用户启用/禁用
    int enOrDisUser(@Param("status") int status, @Param("login_name") String login_name);

    //删除用户根据id
    int deleteUserByLoginName(String id);


    //更具用户姓名查找用户（不包括角色信息）
    TXietongUser selectUserByUserName(String user_name);

    //根据用户名获取当前用户信息（包括角色）selectUserByLikeNamePage
    TXietongUser findUserAndRoleByUserName(String login_name);

    //用户排序
    int updateUserSort(@Param("sort") int sort, @Param("id") String id);
    //获得用户总条数
    int userCount();

    String selectById(@Param("id") String id);



    //用户模糊查找部分也
    List<TXietongUser> selectUserByLikeName(String name);

    //需改密码
    int updatePassword(@Param("password") String password, @Param("uid") String uid);

    //用户模糊查找分页
    List<TXietongUser> selectUserByLikeNamePage(@Param("name") String name, @Param("departmentId") String departmentId, int pageNo, int pageSize);
    int selectUserByLikeNamePageCount(@Param("name") String name, @Param("departmentId") String departmentId);




    int selectUserByDepartmentId(String departmentId);


    int updatePinYin(@Param("pinyin") String pinyin, @Param("id") String id);
    //用户总条数
	int selectTotalCountLikeName(@Param("name") String name, @Param("departmentId") String departmentId);
    //用户信息
	List<TXietongUser> selectUserByNamePage(@Param("name") String name, @Param("departmentId") String departmentId, int pageNo, int pageSize);
    //根据id查询
	TXietongUser selectUserByUserId(String id);

}