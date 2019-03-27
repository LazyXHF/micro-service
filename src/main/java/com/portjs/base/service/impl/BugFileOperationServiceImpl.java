package com.portjs.base.service.impl;

import com.portjs.base.dao.BugFileOperationMapper;
import com.portjs.base.entity.BugFileOperation;
import com.portjs.base.service.BugFileOperationService;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BugFileOperationServiceImpl implements BugFileOperationService {
    ResponseMessage responseMessage;

    @Autowired
    BugFileOperationMapper bugFileOperationMapper;

    @Override
    public ResponseMessage deleteByPrimaryKey(String id) {
        return null;
    }

    @Override
    public ResponseMessage insertSelective(BugFileOperation record) {

        record.setId(UUID.randomUUID().toString());

       /* Date date = new Date();
        record.setRecordTime(date);*/

       /* int i = 0;
        try {
            if(StringUtils.isEmpty(record.getBugId())){
                return new ResponseMessage(Code.CODE_ERROR , "添加Bug审批信息,Bug id未传");
            }
            if(StringUtils.isEmpty(record.getCreaterId())){
                record.setCreaterId(UserUtils.getCurrentUser().getId());
            }
            i = bugDetailsRecordMapper.insertSelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(i==0){
            return new ResponseMessage(Code.CODE_ERROR,"添加失败！",i);
        }
        return  new ResponseMessage(Code.CODE_OK,"添加成功！",i);
*/
        return null;
    }

    @Override
    public ResponseMessage selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public ResponseMessage updateByPrimaryKeySelective(BugFileOperation record) {
        return null;
    }

}
