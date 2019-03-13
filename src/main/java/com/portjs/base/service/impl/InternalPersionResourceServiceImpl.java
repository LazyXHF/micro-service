package com.portjs.base.service.impl;

import com.portjs.base.dao.InternalPersionResourceMapper;
import com.portjs.base.dao.InternalProjectMapper;
import com.portjs.base.entity.InternalPersionResource;
import com.portjs.base.entity.InternalProject;
import com.portjs.base.service.InternalPersionResourceService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Service
public class InternalPersionResourceServiceImpl implements InternalPersionResourceService {
    ResponseMessage responseMessage = null;
    @Autowired
    InternalPersionResourceMapper internalPersionResourceMapper;

    @Autowired
    InternalProjectMapper internalProjectMapper;

    /**
     * 添加人员信息
     * @param record
     * @return
     */
    @Override
    public ResponseMessage insertPersionInfo(InternalPersionResource record) {
        record.setId(UUID.randomUUID().toString());
        int i = internalPersionResourceMapper.insertPersionInfo(record);
        if(i==0){
            return new ResponseMessage(Code.CODE_ERROR,"添加失败！",i);
        }
        return responseMessage;
    }

    /**
     * 根据id查询人员信息
     * @param id
     * @return
     */
    @Override
    public ResponseMessage selectByPrimaryKey(String id) {
        InternalPersionResource internalPersionResource = internalPersionResourceMapper.selectByPrimaryKey(id);
        if(internalPersionResource==null){
            return new ResponseMessage(Code.CODE_ERROR,"查询失败！",internalPersionResource);
        }

        return new ResponseMessage(Code.CODE_OK,"查询成功！",internalPersionResource);
    }

    /**
     * 更新人员信息
     * @param record
     * @return
     */
    @Override
    public ResponseMessage updatePersionInfo(InternalPersionResource record) {
        int count = 0;
        try {
            if(com.portjs.base.util.StringUtils.StringUtils.isEmpty(record.getId())){
                return new ResponseMessage(Code.CODE_ERROR , "更新项目开发模块,id未传");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(count==0){
            return new ResponseMessage(Code.CODE_ERROR,"更新失败！",count);
        }
        return new ResponseMessage(Code.CODE_OK,"更新成功！",count);
    }

    /**
     * 根据id删除人员信息
     * @param id
     * @return
     */
    @Override
    public ResponseMessage deleteByPrimaryKey(String id) {
        int i = internalPersionResourceMapper.deleteByPrimaryKey(id);
        if(i==0){
            return new ResponseMessage(Code.CODE_ERROR,"删除失败！",i);
        }
        return new ResponseMessage(Code.CODE_OK,"删除成功",i);
    }


}
