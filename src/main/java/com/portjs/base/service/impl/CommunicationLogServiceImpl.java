package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.CommunicationLogMapper;
import com.portjs.base.dao.TTodoMapper;
import com.portjs.base.dao.TUserMapper;
import com.portjs.base.entity.CommunicationLog;
import com.portjs.base.entity.MenuTree;
import com.portjs.base.entity.ProjectCommunication;
import com.portjs.base.entity.TTodo;
import com.portjs.base.service.CommunicationLogService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.CommunicationLogDO;
import com.portjs.base.vo.CommunicationLogRecord;
import io.netty.util.internal.StringUtil;
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

    @Autowired
    TUserMapper tUserMapper;

    @Autowired
    TTodoMapper todoMapper;

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

        //查询回复父节点
        List<CommunicationLog> communicationLogs = communicationLogMapper.selectDendrogram(communicationId);
        if(CollectionUtils.isEmpty(communicationLogs)){
            return new ResponseMessage(Code.CODE_ERROR,"查询问题沟通记录信息失败！");
        }
        LinkedList linkedList = new LinkedList();
        for (CommunicationLog o : communicationLogs) {
            //查询回复子节点
            List<CommunicationLog> communicationLogList = communicationLogMapper.selectByPreMessage(o.getId());
            communicationLogList.add(o);
            MenuTree menuTree = new MenuTree();
            MenuTree tree = getMenuTree(communicationLogList, menuTree);
            linkedList.add(tree);
        }


        /*List<CommunicationLog> communicationLogs = communicationLogMapper.queryCommunicationLog(communicationId);
         if(CollectionUtils.isEmpty(communicationLogs)){
            return new ResponseMessage(Code.CODE_ERROR,"查询问题沟通记录信息失败！",communicationLogs);
         }*/
        /*for(int i = 0 ; i<communicationLogs.size(); i++) {
            //String preMessage = communicationLogs.get(i).getPreMessage();
            String id = communicationLogs.get(i).getId();
            //if (!StringUtils.isEmpty(preMessage)) {
                //String id = preMessage;
                CommunicationLog communicationLog = communicationLogMapper.selectBypreMessage(id);
                communicationLogs.add(communicationLog);
            //}
        }*/
        return new ResponseMessage(Code.CODE_OK,"查询问题沟通记录信息成功！",linkedList);

    }

    //获得指标树内部方法
    private MenuTree getMenuTree(List<CommunicationLog> logs, MenuTree menuTree) {
        Map<String, MenuTree> trees = new LinkedHashMap<>();
        for (CommunicationLog log : logs) {
            trees.put(log.getId(), new MenuTree(log));
        }
        for (Map.Entry<String, MenuTree> entry : trees.entrySet()) {
            if (!StringUtil.isNullOrEmpty(entry.getValue().getParent_id())) {
                try {
                    trees.get(entry.getValue().getParent_id()).getChildren().add(entry.getValue());
                } catch (Exception e) {
                    System.out.println(entry.getKey() + "   " + entry.getValue() + "   " + entry.getValue().getParent_id());
                }

            } else {
                menuTree = entry.getValue();
            }
        }
        return menuTree;
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

        //添加一条数据时，改变之前添加到todo表里的数据状态，根据当前登录人id，并判断是否和todo表里的ReceiverId相同，相同则改变此数据status的状态改为1
        List<TTodo> tTodos = todoMapper.queryTodoInfos();
        TTodo todo = new TTodo();
        for (int i = 0; i <tTodos.size() ; i++) {
            String receiverId = tTodos.get(i).getReceiverId();
            String backup1 = record.getBackup1();//当前登录人（回复人）id
            if(receiverId.equals(backup1)){
                todoMapper.updateStatusByCommunicationLog(receiverId,record.getCommunicationId());
            }
        }
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
