package com.portjs.base.dao;

import com.portjs.base.entity.ProjectBudget;
import com.portjs.base.entity.ProjectBudgetExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProjectBudgetMapper {
    int countByExample(ProjectBudgetExample example);

    int deleteByExample(ProjectBudgetExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProjectBudget record);

    int insertSelective(ProjectBudget record);

    List<ProjectBudget> selectByExample(ProjectBudgetExample example);

    ProjectBudget selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProjectBudget record, @Param("example") ProjectBudgetExample example);

    int updateByExample(@Param("record") ProjectBudget record, @Param("example") ProjectBudgetExample example);

    int updateByPrimaryKeySelective(ProjectBudget record);

    int updateByPrimaryKey(ProjectBudget record);
}