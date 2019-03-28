package com.portjs.base.service.impl;

import com.portjs.base.dao.BugDetailsRecordMapper;
import com.portjs.base.entity.BugDetailsRecord;
import com.portjs.base.service.BugDetailsRecordService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BugDetailsRecordServiceImpl implements BugDetailsRecordService {
    ResponseMessage responseMessage;


    @Autowired
    BugDetailsRecordMapper bugDetailsRecordMapper;
    /**
     * 根据id删除bug审批信息（可批量删除）
     * @param ids
     * @return
     */
    @Override
    public ResponseMessage deleteByPrimaryKey(List<String> ids) {
        int count = 0;
        try {
            count =  bugDetailsRecordMapper.deleteByPrimaryKey(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(count==0){
            return new ResponseMessage(Code.CODE_ERROR,"添加失败！",count);
        }
        return  new ResponseMessage(Code.CODE_OK,"添加成功！",count);

    }

    /**
     * 添加审批意见
     * @param record
     * @return
     */
    @Override
    public ResponseMessage insertSelective(BugDetailsRecord record) {
        record.setId(UUID.randomUUID().toString());

        Date date = new Date();
        //SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        record.setRecordTime(date);

        int i = 0;
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
    }

    /**
     * 根据自身id查询Bug 审批信息
     * @param id
     * @return
     */
    @Override
    public ResponseMessage selectByPrimaryKey(String id) {
        BugDetailsRecord bugDetailsRecord = bugDetailsRecordMapper.selectByPrimaryKey(id);
        if(StringUtils.isEmpty(bugDetailsRecord)){
            return new ResponseMessage(Code.CODE_ERROR,"添加失败！",bugDetailsRecord);
        }
        return  new ResponseMessage(Code.CODE_OK,"添加成功！",bugDetailsRecord);
    }

    /**
     * 根据Bug ID查询Bug审批信息
     * @param bugDetailsRecord
     * @return
     */
    @Override
    public ResponseMessage queryBugRecordByBugId(BugDetailsRecord bugDetailsRecord) {
        List<BugDetailsRecord> list = null;
        try {
            if(StringUtils.isEmpty(bugDetailsRecord.getBugId())){
                return new ResponseMessage(Code.CODE_ERROR , "根据Bug id查询Bug审批信息,Bug id未传");
            }
            list = bugDetailsRecordMapper.queryBugRecordByBugId(bugDetailsRecord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(CollectionUtils.isEmpty(list)){
            return new ResponseMessage(Code.CODE_ERROR,"查询失败！",list);
        }
        return  new ResponseMessage(Code.CODE_OK,"查询成功！",list);
    }
    /**
     * 更新Bug审批信息
     * @param record
     * @return
     */
    @Override
    public ResponseMessage updateByPrimaryKeySelective(BugDetailsRecord record) {
        int count = 0;
        try {
            if(StringUtils.isEmpty(record.getId())){
                return new ResponseMessage(Code.CODE_ERROR , "更新项目Bug审批模块,id未传");
            }
            count = bugDetailsRecordMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(count==0){
            return new ResponseMessage(Code.CODE_ERROR,"更新失败！",count);
        }
        return new ResponseMessage(Code.CODE_OK,"更新成功！",count);
    }


}
