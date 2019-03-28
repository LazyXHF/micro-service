package com.portjs.base.dao;

import com.portjs.base.entity.ProjectMembers;
import com.portjs.base.entity.ProjectMembersExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectMembersMapper {
    int countByExample(ProjectMembersExample example);

    int deleteByExample(ProjectMembersExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProjectMembers record);

    int insertSelective(ProjectMembers record);

    List<ProjectMembers> selectByExample(ProjectMembersExample example);

    ProjectMembers selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProjectMembers record, @Param("example") ProjectMembersExample example);

    int updateByExample(@Param("record") ProjectMembers record, @Param("example") ProjectMembersExample example);

    int updateByPrimaryKeySelective(ProjectMembers record);

    int updateByPrimaryKey(ProjectMembers record);
}