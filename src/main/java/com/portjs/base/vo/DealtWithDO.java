package com.portjs.base.vo;

import com.alibaba.fastjson.JSONArray;

/**
 * 待办封装实体类
 */
public class DealtWithDO {
    private String id;//todo表的id
    private String sendId;//发送人的id
    private String sendName;//发送人的名字
//    private String receiveId;//接受人的Id
//    private String receiveName;//接受人的名字
    private String priority; //优先级
    private String relatedDomain;//相应业务模块名称
    private String relatedId;//相应业务的id
    private String todoType;//待办类型
    private String status;//待办状态
    private String stepDesc;//待办描述
    private String receivedArray;//接受人字符串JSON数组

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSendId() {
        return sendId;
    }

    public void setSendId(String sendId) {
        this.sendId = sendId;
    }

    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getRelatedDomain() {
        return relatedDomain;
    }

    public void setRelatedDomain(String relatedDomain) {
        this.relatedDomain = relatedDomain;
    }

    public String getRelatedId() {
        return relatedId;
    }

    public void setRelatedId(String relatedId) {
        this.relatedId = relatedId;
    }

    public String getTodoType() {
        return todoType;
    }

    public void setTodoType(String todoType) {
        this.todoType = todoType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStepDesc() {
        return stepDesc;
    }

    public void setStepDesc(String stepDesc) {
        this.stepDesc = stepDesc;
    }

    public String getReceivedArray() {
        return receivedArray;
    }

    public void setReceivedArray(String receivedArray) {
        this.receivedArray = receivedArray;
    }
}
