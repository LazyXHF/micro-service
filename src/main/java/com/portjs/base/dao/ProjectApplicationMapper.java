package com.portjs.base.dao;

import com.portjs.base.entity.ProjectApplication;
import com.portjs.base.entity.ProjectApplicationExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
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

    int updateProject(ProjectApplication projectApplication);



    int queryProjectCount(@Param("projectCode") String projectCode, @Param("projectType") String projectType, @Param("creater") String creater, @Param("status") String stepDesc);

    List<ProjectApplication> queryProject(@Param("projectCode") String projectCode, @Param("projectType") String projectType, @Param("creater") String creater, @Param("status") String stepDesc,@Param("rowNum")Integer rowNum,@Param("pageCount")Integer pageCount);


    ProjectApplication queryProjectBase(@Param("id") String id);

    int queryProjectPersonsCount(@Param("id") String id);

    List<ProjectApplication> queryProjectPersons(@Param("id") String id);

    int deleteProject(@Param("id") String id);
}