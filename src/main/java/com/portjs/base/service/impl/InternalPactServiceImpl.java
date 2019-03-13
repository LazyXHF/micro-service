package com.portjs.base.service.impl;

import com.portjs.base.dao.InternalPactMapper;
import com.portjs.base.dao.InternalProjectMapper;
import com.portjs.base.entity.InternalPact;
import com.portjs.base.service.InternalPactService;
import com.portjs.base.util.Code;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InternalPactServiceImpl implements InternalPactService {
    ResponseMessage responseMessage = null;
    @Autowired
    InternalPactMapper internalPactMapper;

    @Autowired
    InternalProjectMapper internalProjectMapper;

    /**
     * 查询所有合同信息
     * @param id  项目id
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public ResponseMessage queryAllPacts(String id, int pageNo, int pageSize) {
        Page<InternalPact> page = new Page<>();
        int totalCount = internalPactMapper.pactCount();
        page.init(totalCount,pageNo,pageSize);

        List<InternalPact> list = internalPactMapper.queryAllPacts(id, page.getRowNum(), page.getPageCount());

        responseMessage = new ResponseMessage(Code.CODE_OK,"查询成功！",list);

        return responseMessage;
    }

    /**
     * 插入合同信息
     * @param record
     * @return
     */
    @Override
    public ResponseMessage insertPact(InternalPact record) {
//        InternalPact internalPact = new InternalPact();
        record.setId(UUID.randomUUID().toString());

        int i  = internalPactMapper.insertPact(record);
        if(i==0){
            return new ResponseMessage(Code.CODE_ERROR,"添加失败！",i);
        }
        return new ResponseMessage(Code.CODE_OK,"添加成功！",i);
    }

    /**
     * 根据id删除合同信息
     * @param id
     * @return
     */
    @Override
    public ResponseMessage deleteByPrimaryKey(String id) {
        int i = internalPactMapper.deleteByPrimaryKey(id);
        if(i==0){
            return new ResponseMessage(Code.CODE_ERROR,"删除失败！",i);
        }
        return new ResponseMessage(Code.CODE_OK,"删除成功",i);
    }

    /**
     * 根据id查询合同信息
     * @param id
     * @return
     */
    @Override
    public ResponseMessage selectByPrimaryKey(String id) {
        InternalPact internalPact = internalPactMapper.selectByPrimaryKey(id);
        if(internalPact==null){
            return new ResponseMessage(Code.CODE_ERROR,"查询失败！",internalPact);
        }

        return new ResponseMessage(Code.CODE_OK,"查询成功！",internalPact);
    }

    /**
     * 根据id修改合同信息
     * @param record
     * @return
     */
    @Override
    public ResponseMessage updateByPrimaryKey(InternalPact record) {
        int i = internalPactMapper.updateByPrimaryKey(record);
        if(i==0){
            return new ResponseMessage(Code.CODE_ERROR,"更新失败！",i);
        }
        return new ResponseMessage(Code.CODE_OK,"更新成功！",i);
    }
}
