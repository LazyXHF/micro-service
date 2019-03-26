package com.portjs.base.service.impl;

import com.portjs.base.dao.InternalPersionResourceMapper;
import com.portjs.base.dao.InternalProjectMapper;
import com.portjs.base.entity.InternalPersionResource;
import com.portjs.base.entity.InternalProject;
import com.portjs.base.service.InternalPersionResourceService;
import com.portjs.base.util.Code;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@Service
public class InternalPersionResourceServiceImpl implements InternalPersionResourceService {
    ResponseMessage responseMessage = null;
    private String message = "";
    private Integer code;
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
        record.setEnable("0");
        int i = 0;
        try {
            if(StringUtils.isEmpty(record.getProjectId())){
                return new ResponseMessage(Code.CODE_ERROR , "添加项目人员信息,项目id未传");
            }
            i = internalPersionResourceMapper.insertPersionInfo(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(i==0){
            return new ResponseMessage(Code.CODE_ERROR,"添加失败！",i);
        }
        return  new ResponseMessage(Code.CODE_OK,"添加成功！",i);
    }

    /**
     * 根据id查询人员信息
     * @param id
     * @return
     */
    @Override
    public ResponseMessage selectByPrimaryKey(String id) {
        InternalPersionResource internalPersionResource = internalPersionResourceMapper.selectByPrimaryKey(id);
//        if(internalPersionResource==null){
//            return new ResponseMessage(Code.CODE_ERROR,"查询失败！",internalPersionResource);
//        }

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
            count = internalPersionResourceMapper.updatePersionInfo(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(count==0){
            return new ResponseMessage(Code.CODE_ERROR,"更新失败！",count);
        }
        return new ResponseMessage(Code.CODE_OK,"更新成功！",count);
    }

    /**
     * 批量删除人员信息(软删除)
     * @param ids
     * @return
     */
    @Override
    public ResponseMessage updatePersionInfoByIds(List<String> ids) {
        int count = 0;
        try {
            count =  internalPersionResourceMapper.updatePersionInfoByIds(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"删除成功":"删除失败";
        code=count>0? Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);

    }

    /**
     * 根据项目id查询人员信息并分页
     * @param projectId
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public ResponseMessage queryAllPersionInfo(String projectId, int pageNo, int pageSize) {
        Page<InternalPersionResource> page = new Page<>();
        int totalCount = internalPersionResourceMapper.persionCounts(projectId);
        page.init(totalCount,pageNo,pageSize);
        List<InternalPersionResource> list = internalPersionResourceMapper.queryAllPersionInfo(projectId, page.getRowNum(), page.getPageCount());
        page.setList(list);

        responseMessage = new ResponseMessage(Code.CODE_OK,"查询成功！",page);

        return responseMessage;

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
