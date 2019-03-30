package com.portjs.base.dao;

import com.portjs.base.entity.InternalApproval;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * InternalApproval
 * 项目生命周期节点之---
 * 项目立项
 */
@Repository
public interface InternalApprovalMapper {
    int deleteByPrimaryKey(String id);

    int insert(InternalApproval record);

    int insertSelective(InternalApproval record);

    InternalApproval selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(InternalApproval record);

    int updateByPrimaryKeyWithBLOBs(InternalApproval record);

    int updateByPrimaryKey(InternalApproval record);

    /**
     * 统计今年新增项目条数
     * @return
     */
    int newIncreaseProjectCount();

    /**
     * 统计今年新增项目总金额
     * @return
     */
    BigDecimal newIncreaseProjectAmountCount();

    //查询在建项目的存在最小年份
    String selectCreateTime(@Param("projectId")List<String>list);

    //查询对应年份的项目金额
    double selectAbuildingProject(@Param("niandu")String niandu, @Param("projectId")List<String>list);
}