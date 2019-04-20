package com.portjs.base.dao;

import com.portjs.base.entity.BusinessConfiguration;
import com.portjs.base.entity.ProjectCommunication;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.FlashProject;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectCommunicationMapper {
    int deleteByPrimaryKey(String id);

    int insert(ProjectCommunication record);

    int insertSelective(ProjectCommunication record);

    ProjectCommunication selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProjectCommunication record);

    int updateByPrimaryKey(ProjectCommunication record);

    /**
     * 对项目问题的统计
     * @param projectId
     * @param classification
     * @param priority
     * @param sponsor
     * @param phase
     * @return
     */
    int projectCommunicationCounts(@Param("projectId") String projectId, @Param("classification") String classification, @Param("priority") String priority,
                                   @Param("sponsor") String sponsor, @Param("phase") String phase);
    /**
     * 对项目问题的分页并模糊查询
     * @param projectId
     * @param classification
     * @param priority
     * @param sponsor
     * @param phase
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<ProjectCommunication> queryProjectCommunicationInfo(@Param("projectId") String projectId, @Param("classification") String classification, @Param("priority") String priority,
                                                             @Param("sponsor") String sponsor, @Param("phase") String phase, @Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);


    /**
     * 批量软删除
     * @param ids
     * @return
     */
    int updateDeleteTime(@Param("id") List<String> ids);

    /**
     * 添加
     * @param record
     * @return
     */
    int insertProjectCommunicationSelective(ProjectCommunication record);

    /**
     * 查询总数
     * @param record
     * @return
     */
    int  queryProjectCommunicatisCount(ProjectCommunication record);

    /**
     * 分页查询
     * @param record
     * @return
     */
    List<ProjectCommunication> queryProjectCommunicatisByPage(ProjectCommunication record);


    ProjectCommunication queryProjectCommunicationById(@Param("id") String id);
}