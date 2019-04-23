package com.portjs.base.dao;

import com.portjs.base.entity.ProjectWeekly;
import com.portjs.base.entity.ProjectWeeklyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectWeeklyMapper {
    int countByExample(ProjectWeeklyExample example);

    int deleteByExample(ProjectWeeklyExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProjectWeekly record);

    int insertSelective(ProjectWeekly record);

    List<ProjectWeekly> selectByExample(ProjectWeeklyExample example);

    ProjectWeekly selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProjectWeekly record, @Param("example") ProjectWeeklyExample example);

    int updateByExample(@Param("record") ProjectWeekly record, @Param("example") ProjectWeeklyExample example);

    int updateByPrimaryKeySelective(ProjectWeekly record);

    int updateByPrimaryKey(ProjectWeekly record);
}