package com.portjs.base.dao;

import com.portjs.base.entity.TDepartment;
import com.portjs.base.entity.TUserDepartment;
import com.portjs.base.entity.TUserDepartmentExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TUserDepartmentMapper {
    int countByExample(TUserDepartmentExample example);

    int deleteByExample(TUserDepartmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUserDepartment record);

    int insertSelective(TUserDepartment record);

    List<TUserDepartment> selectByExample(TUserDepartmentExample example);

    TUserDepartment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUserDepartment record, @Param("example") TUserDepartmentExample example);

    int updateByExample(@Param("record") TUserDepartment record, @Param("example") TUserDepartmentExample example);

    int updateByPrimaryKeySelective(TUserDepartment record);

    int updateByPrimaryKey(TUserDepartment record);


}