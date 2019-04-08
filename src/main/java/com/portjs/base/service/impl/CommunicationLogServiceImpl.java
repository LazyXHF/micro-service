package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.CommunicationLogMapper;
import com.portjs.base.entity.CommunicationLog;
import com.portjs.base.entity.ProjectCommunication;
import com.portjs.base.service.CommunicationLogService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.CommunicationLogDO;
import com.portjs.base.vo.CommunicationLogRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CommunicationLogServiceImpl implements CommunicationLogService {
    ResponseMessage responseMessage = null;

    @Autowired
    CommunicationLogMapper communicationLogMapper;

    /**
     * 批量删除
     * @param ids
     * @return
     */
    /*@Override
    public ResponseMessage deleteCommunicationLogs(List<String> ids) {
        int count = 0;
        try {

            //如果pre_message 有值的话根据 pre_message的值去删除
            for(int j = 0 ; j < ids.size() ; j++ ) {
                CommunicationLog communicationLog = communicationLogMapper.selectByPrimaryKey(ids.get(j));
                String preMessage = communicationLog.getPreMessage();
                if (ids.get(j) == preMessage) {
                    //删除回复的留言信息
                    communicationLogMapper.deleteCommunicationLogPreMessage(preMessage);
                }
            }
            count =  communicationLogMapper.deleteCommunicationLogs(ids);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(count==0){
            return new ResponseMessage(Code.CODE_ERROR,"删除失败！",count);
        }
        return  new ResponseMessage(Code.CODE_OK,"删除成功！",count);
    }*/

    /**
     * 查询问题沟通记录信息
     * @param communicationId
     * @return
     */
    @Override
    public ResponseMessage queryCommunicationLog(String communicationId) {
        List<CommunicationLog> communicationLogs = communicationLogMapper.queryCommunicationLog(communicationId);
         if(CollectionUtils.isEmpty(communicationLogs)){
            return new ResponseMessage(Code.CODE_ERROR,"查询问题沟通记录信息失败！",communicationLogs);
         }
        /*for(int i = 0 ; i<communicationLogs.size(); i++) {
            //String preMessage = communicationLogs.get(i).getPreMessage();
            String id = communicationLogs.get(i).getId();
            //if (!StringUtils.isEmpty(preMessage)) {
                //String id = preMessage;
                CommunicationLog communicationLog = communicationLogMapper.selectBypreMessage(id);
                communicationLogs.add(communicationLog);
            //}
        }*/
        return new ResponseMessage(Code.CODE_OK,"查询问题沟通记录信息成功！",communicationLogs);

    }
    /**
     * 查询问题沟通记录再回复信息
     * @param id  数据id
     * @return
     */
    @Override
    public ResponseMessage queryCommunicationLogs(String id) {
        CommunicationLog communicationLog = communicationLogMapper.selectByPrimaryKey(id);
        //根据id查询出来一条数据，然后根据这条数据的preMessage去查询此条数据回复的那条数据
        List<CommunicationLog> communicationLogs = null;
        String preMessage = communicationLog.getPreMessage();
        if (!StringUtils.isEmpty(preMessage)) {
            String ids = preMessage;

            communicationLogs = communicationLogMapper.queryCommunicationLogs(ids);
        }
        return new ResponseMessage(Code.CODE_OK,"查询问题沟通记录信息成功！",communicationLogs);
    }

    /**
     * 修改记录信息
     * @param record
     * @return
     */
    @Override
    public ResponseMessage updateByPrimaryKeySelective(CommunicationLog record) {
        if(StringUtils.isEmpty(record.getId())){
            return new ResponseMessage(Code.CODE_ERROR,"修改信息时未选中信息！");
        }
        int i = communicationLogMapper.updateByPrimaryKeySelective(record);
        if(i==0){
            return new ResponseMessage(Code.CODE_ERROR,"修改信息失败！",i);

        }
        return new ResponseMessage(Code.CODE_OK,"修改信息成功！",i);
    }
    /**
     * 添加记录信息
     * @param record
     * @return
     */
    @Override
    public ResponseMessage insertCommunicationLogSelective(CommunicationLog record) {
        //如果前端传来了一个id的话意味着前端选中了一条言论要回复他，那么就生产一条新数据并把这个id存入新数据的preMessage
        //反之，意味着是一条新数据产生，那么除preMessage外全存进去
        if(StringUtils.isEmpty(record.getId())){
            record.setId(UUID.randomUUID().toString());
            Date date = new Date();//获得系统时间.
            SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
            String nowTime = sdf.format(date);
            Date time = null;
            try {
                time = sdf.parse(nowTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            record.setReplytime(time);//回复时间
            if(StringUtils.isEmpty(record.getCommunicationId())){
                return new ResponseMessage(Code.CODE_ERROR,"添加问题沟通记录信息时未传问题的id！","问题id："+record.getCommunicationId());
            }
            int i = communicationLogMapper.insertCommunicationLogSelective(record);
            if(i==0){
                return new ResponseMessage(Code.CODE_ERROR,"添加问题沟通记录信息失败！",i);
            }
            return new ResponseMessage(Code.CODE_OK,"添加问题沟通记录信息成功！",i);

        }else {
            record.setPreMessage(record.getId());
            record.setId(UUID.randomUUID().toString());
            Date date = new Date();//获得系统时间.
            SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
            String nowTime = sdf.format(date);
            Date time = null;
            try {
                time = sdf.parse(nowTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            record.setReplytime(time);//回复时间
            if(StringUtils.isEmpty(record.getCommunicationId())){
                return new ResponseMessage(Code.CODE_ERROR,"添加问题沟通记录信息时未传问题的id！","问题id："+record.getCommunicationId());
            }
            int i = communicationLogMapper.insertCommunicationLogSelective(record);
            if(i==0){
                return new ResponseMessage(Code.CODE_ERROR,"添加问题沟通记录信息失败！",i);
            }
            return new ResponseMessage(Code.CODE_OK,"添加问题沟通记录信息成功！",i);
        }


    }

}
