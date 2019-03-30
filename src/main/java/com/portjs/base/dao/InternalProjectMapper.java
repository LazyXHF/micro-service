package com.portjs.base.dao;

import com.portjs.base.entity.InternalProject;
import com.portjs.base.vo.Project;
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

    /**
     * 查询项目编号
     * @return
     */
    List<InternalProject> queryProjectNums();


    InternalProject selectByPrimaryKey(InternalProject internalProject);

    /**
     * 更新项目信息（报表页面）
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(InternalProject record);

    /**
     * 更新项目信息（项目概览）
     * @param internalProject
     * @return
     */
    int updateSelective(InternalProject internalProject);

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
    int projectCount(@Param("id") String id);

    /**
     * 根据record对象查询列表
     * @param record
     * @return
     */
    List<InternalProject> selectListByBackup1(InternalProject record);

    /**
     * 分页查询列表
     * @param
     * @return
     */
    List<InternalProject> selectListsByBackup1(@Param("createTime")String createTime,@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    /**
     * 查询所有在建项目并分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<InternalProject> queryConstructionProjects(@Param("id")List<String> id,@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    /**
     * 分页查询支持对象全查询
     * @param record
     * @return
     */
    List<InternalProject> queryProjectsByLoginer(InternalProject record);

    /**
     * 条件分页
     * @param record
     * @return
     */
    int queryByPage(InternalProject record);
    @Select("select name,id from internal_project")
    List<Project> selectProjectAll();

    //查询在建项目的存在哪些年份
    String selectCreateTime(@Param("projectId")List<String>list);
    //查询对应年份的项目总数
    int selectAbuildingProject(@Param("niandu")String niandu,@Param("projectId")List<String>list);
}