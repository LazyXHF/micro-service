package com.portjs.base.dao;

import com.portjs.base.entity.Project;
import com.portjs.base.entity.ProjectExample;
import com.portjs.base.vo.FlashProject;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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

    List<Project> queryProjectAllInfo(@Param("projectCode") String projectCode,@Param("projectName") String projectName,@Param("organization") String organization,@Param("projectType") String projectType,@Param("creatorName") String creatorName,@Param("schedule") String schedule,@Param("rownum") Integer rowNum, @Param("pagecount") Integer pageCount);

    int queryProjectAllInfoCount(@Param("projectCode") String projectCode,@Param("projectName") String projectName,@Param("organization") String organization,@Param("projectType") String projectType,@Param("creator") String creator,@Param("schedule") String schedule);

    Project queryProjectDetails(@Param("id") String id,@Param("projectType") String projectType);

    /**
     * 问题沟通所需下拉框接口
     * @return
     */
    @Select("select id,project_name,project_type,schedule from project")
    List<FlashProject> selectProjectAll();
}