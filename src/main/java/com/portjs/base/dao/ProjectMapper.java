package com.portjs.base.dao;

import com.portjs.base.entity.Project;
import com.portjs.base.entity.ProjectApplication;
import com.portjs.base.entity.ProjectExample;
import com.portjs.base.vo.FlashProject;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
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

    void updateProjectById(@Param("projectCode") String projectCode, @Param("schedule") String schedule, @Param("status")
            String status, @Param("projectId") String projectId);

    List<Project> queryProjectAllInfo(@Param("projectCode") String projectCode, @Param("projectName") String projectName,
                                      @Param("createTime") String createTime, @Param("projectType") String projectType,
                                      @Param("projectManager") String projectManager,
                                      @Param("leval") String leval, @Param("status") String status,
                                      @Param("rownum") Integer rowNum, @Param("pagecount") Integer pageCount);

    int queryProjectAllInfoCount(@Param("projectCode") String projectCode, @Param("projectName") String projectName,
                                 @Param("createTime") String createTime, @Param("projectType") String projectType,
                                 @Param("projectManager") String projectManager,
                                 @Param("leval") String leval, @Param("status") String status);

    Project queryProjectDetails(@Param("id") String id, @Param("projectType") String projectType);

    /**
     * 问题沟通所需下拉框接口
     *
     * @return
     */
    @Select("select id,project_name,project_type,project_code,schedule from project")
    List<FlashProject> selectProjectAll();

    Project queryProjectDetails2(@Param("id") String id, @Param("projectType") String projectType);

    List<Project> queryProjectAllExceptionInfo(@Param("projectCode") String projectCode,
                                               @Param("projectName") String projectName,
                                               @Param("projectTime") String projectTime,
                                               @Param("projectType") String projectType,
                                               @Param("invertor") String invertor,
                                               @Param("organization") String organization,
                                               @Param("schedule") String schedule,
                                               @Param("rownum") Integer rowNum,
                                               @Param("pagecount") Integer pageCount);

    int queryProjectAllInfoExceptionCount(@Param("projectCode") String projectCode,
                                          @Param("projectName") String projectName,
                                          @Param("projectTime") String projectTime,
                                          @Param("projectType") String projectType,
                                          @Param("invertor") String invertor, @Param("organization") String organization,
                                          @Param("schedule") String schedule);

    String selectByStatus();

    int selectapplicationByYearError(String toString);

    List<String> queryYears();

    List<Project> queryNotInproject();

    List<Project> selectapplicationByYear(String toString);

    List<Project> selectByCreateMonth(@Param("userId") String userId,@Param("createTime") String createTime);

    List<Project> queryProjectByMonth(@Param("projectCode") String projectCode, @Param("projectName") String projectName,
                                      @Param("projectType") String projectType, @Param("leval") String leval,
                                      @Param("projectManager") String projectManager,
                                      @Param("status") String status, @Param("createTime") String createTime ,@Param("id")String projectId);
}