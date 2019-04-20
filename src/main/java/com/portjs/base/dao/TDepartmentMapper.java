package com.portjs.base.dao;

import com.portjs.base.entity.TDepartment;
import com.portjs.base.entity.TDepartmentExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TDepartmentMapper {
    int countByExample(TDepartmentExample example);

    int deleteByExample(TDepartmentExample example);

    int deleteByPrimaryKey(String id);

    int insert(TDepartment record);

    int insertSelective(TDepartment record);

    List<TDepartment> selectByExample(TDepartmentExample example);

    TDepartment selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TDepartment record, @Param("example") TDepartmentExample example);

    int updateByExample(@Param("record") TDepartment record, @Param("example") TDepartmentExample example);

    int updateByPrimaryKeySelective(TDepartment record);

    int updateByPrimaryKey(TDepartment record);


    int selectSortMax();

    List<TDepartment> selectAllDepartment();


    List<TDepartment> selectAllDepartmentTree(String name);


    int SortDepartment(@Param("sort") int sort, @Param("id") String id);

    //查找所有部门 可用的部门
    List<TDepartment> findAllDepartment();

    @Select("SELECT * FROM t_department d LEFT JOIN t_user_department ud ON d.`ID` = ud.`d_id`  WHERE ud.`u_id` =#{uid}")
    List<TDepartment> selectDepartmentByUid(String uid);


}