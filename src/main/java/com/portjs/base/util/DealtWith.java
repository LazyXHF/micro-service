package com.portjs.base.util;

import com.alibaba.fastjson.JSON;
import com.portjs.base.dao.TTodoMapper;
import com.portjs.base.entity.TTodo;
import com.portjs.base.vo.DealtWithDO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class DealtWith {

    @Autowired
    private TTodoMapper tTodoMapper;


    //使用对象传参
    public  int dealtWithMethodDO(DealtWithDO dealtWithDO){
        int j = 0;
        //获取前台传来的json对象数组
        JSONArray jsonArray = JSONArray.fromObject(dealtWithDO.getReceivedArray());
        //遍历json数组中的对象
        for (int i=0;i<jsonArray.size();i++){
            TTodo todo = new TTodo();
            JSONObject object = jsonArray.getJSONObject(i);
            String id = UUID.randomUUID().toString();
            //接收人id
            String receviedId = object.getString("nameId");
            //接受人的姓名
            String receviedName = object.getString("name");
            String sendId = dealtWithDO.getSendId();
            String sendName = dealtWithDO.getSendName();
            String priority = dealtWithDO.getPriority();
            String releatedDomain = dealtWithDO.getRelatedDomain();
            String releatedId  = dealtWithDO.getRelatedId();
            String todoType = dealtWithDO.getTodoType();
            String status = "0";
            String stepDesc = dealtWithDO.getStepDesc()+"存在问题,需要您的回复!";


            //封装实体类
            todo.setId(id);
            todo.setSenderId(sendId);//发送人id
            todo.setSenderTime(new Date());//发送时间
            todo.setReceiverId(receviedId);//接收人id（被提醒人）
            todo.setRelateddomain(releatedDomain);//对应的业务模块
            todo.setRelateddomainId(releatedId);//把当前新建问题id存入待办表里
            todo.setTodoType(todoType);//待办类型
            todo.setStatus(status);//0为待办未完成状态
            todo.setBackup3(priority);//优先级
            todo.setStepDesc(stepDesc);
            todo.setBackUp7(sendName);//发起人姓名
            j += tTodoMapper.insertSelective(todo);
        }

        return j;
    }

    /**
     *
     * @param jsonArray 前台传来的json数组
     * @param sendName 发送人的姓名
     * @param sendId 发送人的id
     * @param releatedDomain 对应的业务模块
     * @param releatedId 对应的业务模块Id
     * @param todoType 待办类型
     * @param stepDesc 待办描述
     * @param priority 优先级
     * @return
     */
    public int dealtWithMethodStringArray(String jsonArray,String sendName,String sendId, String releatedDomain,
                                          String releatedId,String todoType,String stepDesc,String priority){
        int j = 0;
       // 获取前台传来的json对象数组
        JSONArray jsonArrays = JSONArray.fromObject(jsonArray);
        for (int i=0;i<jsonArrays.size();i++){
            TTodo todo = new TTodo();
            JSONObject object = jsonArrays.getJSONObject(i);
            String id = UUID.randomUUID().toString();

            //接收人id
            String receviedsId = object.getString("nameId");
            //接受人的姓名
            String receviedsName = object.getString("name");
            //封装实体类
            todo.setId(id);
            todo.setSenderId(sendId);//发送人id
            todo.setSenderTime(new Date());//发送时间
            todo.setReceiverId(receviedsId);//接收人id（被提醒人）
            todo.setRelateddomain(releatedDomain);//对应的业务模块
            todo.setRelateddomainId(releatedId);//把当前新建问题id存入待办表里
            todo.setTodoType(todoType);//待办类型
            todo.setStatus("0");//0为待办未完成状态
            todo.setBackup3(priority);//优先级
            todo.setStepDesc(stepDesc);
            todo.setBackUp7(sendName);//发起人姓名
            j += tTodoMapper.insertSelective(todo);
        }
        return j;


    }
}
