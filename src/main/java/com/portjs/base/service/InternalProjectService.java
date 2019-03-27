package com.portjs.base.service;

import com.portjs.base.entity.InternalProject;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface InternalProjectService {
    /**
     * 查询所有项目和关联人员信息
     * @return
     */
    Page<InternalProject> selectAllProjectInfo(String id ,int pageNo, int pageSize);

    /**
     * 查询所有项目数据信息
     * @return
     */
    Page<InternalProject> queryAllProjectInfo(int pageNo, int pageSize);

    Page<Map<String,Object>> queryAllProjectInfos(int pageNo, int pageSize);

    /**
     * 插入项目信息
     * @param record
     * @return
     */
    ResponseMessage insertProjectInfo(InternalProject record);
    /**
     * 插入项目概览信息
     * @param
     * @return
     */
    ResponseMessage insertProjectInfoOverview(InternalProject internalProject);
    /**
     * 更新项目信息
     * @param record
     * @return
     */
    ResponseMessage updateByPrimaryKeySelective(InternalProject record);


    /**
     * 更新项目信息（项目概览）
     * @param record
     * @return
     */
    ResponseMessage updateSelective(InternalProject record);


    ResponseMessage selectByPrimaryKey(InternalProject internalProject);

    /**
     * 根据对象查询列表
     * @param record
     * @return
     */
    List<Map<String,Object>> selectListByBackup1(InternalProject record);


    /**
     * 分页查询今年项目列表
     * @param
     * @return
     */
    ResponseMessage selectListsByBackup1(String createTime, int pageNo, int pageSize);


    /**
     * 查询所有在建项目并分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    ResponseMessage queryConstructionProjects(List<String> id ,int pageNo,  int pageSize);
    ResponseMessage  queryAllProjects();
    /**
     * 项目概览保存
     */
    ResponseMessage updatesProject(String responseBody);
}
