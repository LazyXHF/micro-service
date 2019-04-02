package com.portjs.base.dao;

import com.portjs.base.entity.Project;
import com.portjs.base.entity.ProjectExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProjectMapper {
    int countByExample(ProjectExample example);

    int deleteByExample(ProjectExample example);

    int deleteByPrimaryKey(String id);

    int insert(Project record);

    int insertSelective(Project record);

    List<Project> selectByExample(ProjectExample example);

    Project selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Project record, @Param("example") ProjectExample example);

    int updateByExample(@Param("record") Project record, @Param("example") ProjectExample example);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

    int isHaveProject(@Param("projectId") String projectId);

    void addProject(Project project);

    Project queryProjectById(@Param("projectId") String projectId);

    void updateProjectById(@Param("projectId") String projectId,@Param("schedule") String schedule,@Param("status") String status);
}