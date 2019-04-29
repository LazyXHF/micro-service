package com.portjs.base.dao;

import com.portjs.base.entity.InternalWorkflowstep;
import com.portjs.base.entity.InternalWorkflowstepExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InternalWorkflowstepMapper {
    int countByExample(InternalWorkflowstepExample example);

    int deleteByExample(InternalWorkflowstepExample example);

    int deleteByPrimaryKey(String id);

    int insert(InternalWorkflowstep record);

    int insertSelective(InternalWorkflowstep record);

    List<InternalWorkflowstep> selectByExample(InternalWorkflowstepExample example);

    InternalWorkflowstep selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") InternalWorkflowstep record, @Param("example") InternalWorkflowstepExample example);

    int updateByExample(@Param("record") InternalWorkflowstep record, @Param("example") InternalWorkflowstepExample example);

    int updateByPrimaryKeySelective(InternalWorkflowstep record);

    int updateByPrimaryKey(InternalWorkflowstep record);
}