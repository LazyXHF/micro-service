package com.portjs.base.dao;

import com.portjs.base.entity.InternalProject;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InternalProjectMapper{
    int deleteByPrimaryKey(String id);

    int insert(InternalProject record);

    /**
     * 添加项目信息
     * @param record
     * @return
     */
    int insertSelective(InternalProject record);

    InternalProject selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(InternalProject record);

    int updateByPrimaryKey(InternalProject record);

    /**
     * 提供项目id的接口（查询所有项目信息）
     * @return
     */
    @Select("select * from internal_project")
    InternalProject queryProject();

    /**
     * 查询所有项目数据信息(项目信息监控接口)
     * @return
     */
    List<InternalProject> queryAllProjectInfo(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    /**
     * 统计所有项目条数
     * @return
     */
    int projectCounts();
    /**
     * 根据查询项目数据和相关人员信息
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<InternalProject> selectAllProjectInfo(@Param("id") String id, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    /**
     * 统计项目信息条数包含关联人员条数
     * @return
     */
    int projectCount();


}