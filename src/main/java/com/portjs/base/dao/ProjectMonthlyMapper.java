package com.portjs.base.dao;

import com.portjs.base.entity.ProjectMonthly;
import com.portjs.base.entity.ProjectMonthlyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectMonthlyMapper {
    int countByExample(ProjectMonthlyExample example);

    int deleteByExample(ProjectMonthlyExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProjectMonthly record);

    int insertSelective(ProjectMonthly record);

    List<ProjectMonthly> selectByExample(ProjectMonthlyExample example);

    ProjectMonthly selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProjectMonthly record, @Param("example") ProjectMonthlyExample example);

    int updateByExample(@Param("record") ProjectMonthly record, @Param("example") ProjectMonthlyExample example);

    int updateByPrimaryKeySelective(ProjectMonthly record);

    int updateByPrimaryKey(ProjectMonthly record);

    List<ProjectMonthly> queryProjectMonthByProjectId(@Param("projectId") String projectId);

    ProjectMonthly selectByprojectIdAndSchedule(@Param("projectId") String projectId,
                                                @Param("projectSchedule") String projectSchedule);

    List<ProjectMonthly> selectByprojectManagerId(@Param("projectManagerId") String projectManagerId,
                                                  @Param("monthNum") String monthNum,
                                                  @Param("projectId") String projectId);
}