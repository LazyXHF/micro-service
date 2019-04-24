package com.portjs.base.dao;

import com.portjs.base.entity.ProjectClarificaiton;
import com.portjs.base.entity.ProjectClarificaitonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectClarificaitonMapper {
    int countByExample(ProjectClarificaitonExample example);

    int deleteByExample(ProjectClarificaitonExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProjectClarificaiton record);

    int insertSelective(ProjectClarificaiton record);

    List<ProjectClarificaiton> selectByExample(ProjectClarificaitonExample example);

    ProjectClarificaiton selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProjectClarificaiton record, @Param("example") ProjectClarificaitonExample example);

    int updateByExample(@Param("record") ProjectClarificaiton record, @Param("example") ProjectClarificaitonExample example);

    int updateByPrimaryKeySelective(ProjectClarificaiton record);

    int updateByPrimaryKey(ProjectClarificaiton record);

    /**
     * 分页并模糊查询
     * @param projectCode
     * @param projectName
     * @param projectManager
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<ProjectClarificaiton> queryByPage(@Param("projectCode")String projectCode,@Param("projectName")String projectName,@Param("projectManager")String projectManager,
                                           @Param("pageNo")Integer pageNo,@Param("pageSize")Integer pageSize);

    int countsByProjectClarification(@Param("projectCode")String projectCode,@Param("projectName")String projectName,@Param("projectManager")String projectManager);

    /**
     * 批量软删除
     * @param ids
     * @return
     */
    int updateDeleteTimeByIds(@Param("id") List<String> ids);

}