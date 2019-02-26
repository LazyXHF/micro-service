package com.project.mgt.dao;

import com.project.mgt.entity.TXietongUserDepartments;
import com.project.mgt.entity.TXietongUserDepartmentsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TXietongUserDepartmentsMapper {
    int countByExample(TXietongUserDepartmentsExample example);

    int deleteByExample(TXietongUserDepartmentsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TXietongUserDepartments record);

    int insertSelective(TXietongUserDepartments record);

    List<TXietongUserDepartments> selectByExample(TXietongUserDepartmentsExample example);

    TXietongUserDepartments selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TXietongUserDepartments record, @Param("example") TXietongUserDepartmentsExample example);

    int updateByExample(@Param("record") TXietongUserDepartments record, @Param("example") TXietongUserDepartmentsExample example);

    int updateByPrimaryKeySelective(TXietongUserDepartments record);

    int updateByPrimaryKey(TXietongUserDepartments record);


    //根据用户的id和部门的id查找部门
    List<TXietongUserDepartments> selectUserAndDepartment(@Param("uid") String uid, @Param("did") String did);

    //根据用户的id和部门的删除部门
    int deleteUserAndDepartment(@Param("uid") String uid, @Param("did") String did);
}