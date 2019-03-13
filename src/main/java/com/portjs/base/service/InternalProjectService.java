package com.portjs.base.service;

import com.portjs.base.entity.InternalProject;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;


public interface InternalProjectService {
    /**
     * 查询所有项目和关联人员信息
     * @return
     */
    Page<InternalProject> selectAllProjectInfo(int pageNo, int pageSize);

    /**
     * 查询所有项目数据信息
     * @return
     */
    Page<InternalProject> queryAllProjectInfo(int pageNo, int pageSize);

    /**
     * 插入项目信息
     * @param record
     * @return
     */
    ResponseMessage insertProjectInfo(InternalProject record);



}
