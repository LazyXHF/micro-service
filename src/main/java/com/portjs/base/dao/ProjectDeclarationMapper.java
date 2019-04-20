package com.portjs.base.dao;

import com.portjs.base.entity.ProjectDeclaration;
import com.portjs.base.entity.ProjectDeclarationExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProjectDeclarationMapper {
    int countByExample(ProjectDeclarationExample example);

    int deleteByExample(ProjectDeclarationExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProjectDeclaration record);

    int insertSelective(ProjectDeclaration record);

    List<ProjectDeclaration> selectByExample(ProjectDeclarationExample example);

    ProjectDeclaration selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProjectDeclaration record, @Param("example") ProjectDeclarationExample example);

    int updateByExample(@Param("record") ProjectDeclaration record, @Param("example") ProjectDeclarationExample example);

    int updateByPrimaryKeySelective(ProjectDeclaration record);

    int updateByPrimaryKey(ProjectDeclaration record);
}