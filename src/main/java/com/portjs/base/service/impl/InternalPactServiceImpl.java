package com.portjs.base.service.impl;

import com.portjs.base.dao.InternalPactMapper;
import com.portjs.base.dao.InternalProjectMapper;
import com.portjs.base.entity.InternalPact;
import com.portjs.base.service.InternalPactService;
import com.portjs.base.util.Code;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.StringUtils.StringUtils;
import com.portjs.base.util.UserUtils;
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
        page.setList(list);

        responseMessage = new ResponseMessage(Code.CODE_OK,"查询成功！",page);

        return responseMessage;
    }

    /**
     * 插入合同信息
     * @param record
     * @return
     */
    @Override
    public ResponseMessage insertSelective(InternalPact record) {
//        InternalPact internalPact = new InternalPact();
        record.setId(UUID.randomUUID().toString());

        int i  = internalPactMapper.insertSelective(record);
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
    public ResponseMessage updateByPrimaryKeySelective(InternalPact record) {
        int count = 0;
        try {
            if(StringUtils.isEmpty(record.getId())){
                return new ResponseMessage(Code.CODE_ERROR , "更新项目开发模块,id未传");
            }
            record.setUploader(UserUtils.getCurrentUser().getId());
            count =  internalPactMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(count==0){
            return new ResponseMessage(Code.CODE_ERROR,"更新失败！",count);
        }
        return new ResponseMessage(Code.CODE_OK,"更新成功！",count);
    }
}
