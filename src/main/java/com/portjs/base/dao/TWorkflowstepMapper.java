package com.portjs.base.dao;

import com.portjs.base.entity.TWorkflowstep;
import com.portjs.base.entity.TWorkflowstepExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TWorkflowstepMapper {
    int countByExample(TWorkflowstepExample example);

    int deleteByExample(TWorkflowstepExample example);

    int deleteByPrimaryKey(String id);

    int insert(TWorkflowstep record);

    int insertSelective(TWorkflowstep record);

    List<TWorkflowstep> selectByExampleWithBLOBs(TWorkflowstepExample example);

    List<TWorkflowstep> selectByExample(TWorkflowstepExample example);

    TWorkflowstep selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TWorkflowstep record, @Param("example") TWorkflowstepExample example);

    int updateByExampleWithBLOBs(@Param("record") TWorkflowstep record, @Param("example") TWorkflowstepExample example);

    int updateByExample(@Param("record") TWorkflowstep record, @Param("example") TWorkflowstepExample example);

    int updateByPrimaryKeySelective(TWorkflowstep record);

    int updateByPrimaryKeyWithBLOBs(TWorkflowstep record);

    int updateByPrimaryKey(TWorkflowstep record);

    Integer isApproveingId(@Param("id") String id,@Param("ownerId") String ownerId);

    List<TWorkflowstep> queryProjectRecords(@Param("id") String id);


    List<TWorkflowstep> queryNotReviewProject(@Param("id") String id);

    TWorkflowstep toApprove(@Param("id") String id, @Param("ownerId") String ownerId);
}