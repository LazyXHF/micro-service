package com.portjs.base.dao;

import com.portjs.base.entity.TUserDepartment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TUserDepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TUserDepartment record);

    int insertSelective(TUserDepartment record);

    TUserDepartment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TUserDepartment record);

    int updateByPrimaryKey(TUserDepartment record);

    /**
     * 根据当前登录人id查找其所在部门
     * @return uId 当前登录人id
     */
    TUserDepartment findTUserDepartmentMapper(@Param("uId")String uId);

}