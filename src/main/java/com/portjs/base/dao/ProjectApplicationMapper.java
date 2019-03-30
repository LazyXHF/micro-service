package com.portjs.base.dao;

import com.portjs.base.entity.ProjectApplication;
import com.portjs.base.entity.ProjectApplicationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectApplicationMapper {
    int countByExample(ProjectApplicationExample example);

    int deleteByExample(ProjectApplicationExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProjectApplication record);

    int insertSelective(ProjectApplication record);

    List<ProjectApplication> selectByExample(ProjectApplicationExample example);

    ProjectApplication selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProjectApplication record, @Param("example") ProjectApplicationExample example);

    int updateByExample(@Param("record") ProjectApplication record, @Param("example") ProjectApplicationExample example);

    int updateByPrimaryKeySelective(ProjectApplication record);

    int updateByPrimaryKey(ProjectApplication record);
}