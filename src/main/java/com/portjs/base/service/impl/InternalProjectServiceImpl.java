package com.portjs.base.service.impl;

import com.portjs.base.dao.InternalProjectMapper;
import com.portjs.base.entity.InternalProject;
import com.portjs.base.service.InternalProjectService;
import com.portjs.base.util.Code;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InternalProjectServiceImpl implements InternalProjectService {

    ResponseMessage responseMessage = null;

    @Autowired
    InternalProjectMapper internalProjectMapper;

    /**
     * 查询所有项目信息和相关人员信息
     * @return
     */
    @Override
    public Page<InternalProject> selectAllProjectInfo(int pageNo, int pageSize) {
        Page<InternalProject> page = new Page<>();
        int totalCount = internalProjectMapper.projectCount();
        page.init(totalCount,pageNo,pageSize);
        List<InternalProject>  list= internalProjectMapper.selectAllProjectInfo(page.getRowNum(),page.getPageCount());
        page.setList(list);
        return page;
    }

    /**
     * 查询所有项目信息
     * @return
     */
    @Override
    public Page<InternalProject> queryAllProjectInfo(int pageNo, int pageSize) {
        Page<InternalProject> page = new Page<>();
        int totalCount = internalProjectMapper.projectCounts();
        page.init(totalCount,pageNo,pageSize);
        List<InternalProject> list = internalProjectMapper.queryAllProjectInfo(page.getRowNum(),page.getPageCount());
        page.setList(list);
        return page;

    }

    /**
     * 添加项目信息和相关人员信息
     * @param record
     * @return
     */
    @Override
    public ResponseMessage insertProjectInfo(InternalProject record) {
        InternalProject internalProject = new InternalProject();
        internalProject.setId(UUID.randomUUID().toString());
        internalProject.setType(record.getType());
        internalProject.setName(record.getName());
        internalProject.setResponsibleUnit(record.getResponsibleUnit());
        internalProject.setRange(record.getRange());
        internalProject.setMeeting(record.getMeeting());
        internalProject.setContent(record.getContent());

        int i  = internalProjectMapper.insertProjectInfo(internalProject);
        if(i==0){
            return new ResponseMessage(Code.CODE_ERROR,"添加失败！",i);
        }
        return new ResponseMessage(Code.CODE_OK,"添加成功！",i);
    }


}