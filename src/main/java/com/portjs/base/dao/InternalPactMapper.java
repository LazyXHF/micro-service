package com.portjs.base.dao;

import com.portjs.base.entity.InternalPact;
import com.portjs.base.util.ResponseMessage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * InternalPactMapper
 * 项目生命周期节点之---
 * 合同备案表（合同签订）
 */
@Repository
public interface InternalPactMapper {
    /**
     * 批量删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(@Param("ids") List<String> id);

    /**
     * 添加合同信息
     * @param record
     * @return
     */
    int insertPact(InternalPact record);

    int insertSelective(InternalPact record);

    List<InternalPact> selectByPrimaryKey(InternalPact record);

    int updateByPrimaryKeySelective(InternalPact record);

    int updateByPrimaryKey(InternalPact record);

    /**
     * 根据项目id去合同表查询相关合同信息
     * @param id  项目id
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<InternalPact> queryAllPacts(@Param("id") String id, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    /**
     * 不同条件统计合同条数信息
     * @return
     */
    int pactCount();


}