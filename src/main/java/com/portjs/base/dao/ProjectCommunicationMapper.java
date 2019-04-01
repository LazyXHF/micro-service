package com.portjs.base.dao;

import com.portjs.base.entity.InternalPersionResource;
import com.portjs.base.entity.ProjectCommunication;
import com.portjs.base.util.ResponseMessage;
import org.apache.ibatis.annotations.Param;
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
    int projectCommunicationCounts(@Param("projectId")String projectId,@Param("classification")String classification ,@Param("priority")String priority,
                                   @Param("sponsor") String sponsor,@Param("phase") String phase);
    /**
     * 对项目问题的分页并模糊查询
     * @param projectId
     * @param classification
     * @param priority
     * @param sponsor
     * @param phase
     * @param rowNum
     * @param pageCount
     * @return
     */
    List<InternalPersionResource> queryProjectCommunicationInfo(@Param("projectId")String projectId,@Param("classification")String classification ,@Param("priority")String priority,
                                                                @Param("sponsor") String sponsor,@Param("phase") String phase,@Param("rowNum") Integer rowNum,@Param("pageCount") Integer pageCount);


    /**
     * 批量软删除
     * @param ids
     * @return
     */
    int insertDeleteTime(@Param("id") List<String> ids);




}