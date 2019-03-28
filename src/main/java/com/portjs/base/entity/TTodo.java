package com.portjs.base.entity;

import java.util.Date;

public class TTodo {
    private String id;

    private String currentstepId;

    private String stepDesc;

    private String relateddomain;

    private String relateddomainId;

    private String senderId;

    private Date senderTime;

    private String receiverId;

    private String todoType;

    private Date actiontime;

    private String enable;

    private String status;

    private String backup2;

    private String backup3;

    private String backUp7;

    private String backUp8;

    private String backUp9;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCurrentstepId() {
        return currentstepId;
    }

    public void setCurrentstepId(String currentstepId) {
        this.currentstepId = currentstepId == null ? null : currentstepId.trim();
    }

    public String getStepDesc() {
        return stepDesc;
    }

    public void setStepDesc(String stepDesc) {
        this.stepDesc = stepDesc == null ? null : stepDesc.trim();
    }

    public String getRelateddomain() {
        return relateddomain;
    }

    public void setRelateddomain(String relateddomain) {
        this.relateddomain = relateddomain == null ? null : relateddomain.trim();
    }

    public String getRelateddomainId() {
        return relateddomainId;
    }

    public void setRelateddomainId(String relateddomainId) {
        this.relateddomainId = relateddomainId == null ? null : relateddomainId.trim();
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId == null ? null : senderId.trim();
    }

    public Date getSenderTime() {
        return senderTime;
    }

    public void setSenderTime(Date senderTime) {
        this.senderTime = senderTime;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId == null ? null : receiverId.trim();
    }

    public String getTodoType() {
        return todoType;
    }

    public void setTodoType(String todoType) {
        this.todoType = todoType == null ? null : todoType.trim();
    }

    public Date getActiontime() {
        return actiontime;
    }

    public void setActiontime(Date actiontime) {
        this.actiontime = actiontime;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable == null ? null : enable.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getBackup2() {
        return backup2;
    }

    public void setBackup2(String backup2) {
        this.backup2 = backup2 == null ? null : backup2.trim();
    }

    public String getBackup3() {
        return backup3;
    }

    public void setBackup3(String backup3) {
        this.backup3 = backup3 == null ? null : backup3.trim();
    }

    public String getBackUp7() {
        return backUp7;
    }

    public void setBackUp7(String backUp7) {
        this.backUp7 = backUp7 == null ? null : backUp7.trim();
    }

    public String getBackUp8() {
        return backUp8;
    }

    public void setBackUp8(String backUp8) {
        this.backUp8 = backUp8 == null ? null : backUp8.trim();
    }

    public String getBackUp9() {
        return backUp9;
    }

    public void setBackUp9(String backUp9) {
        this.backUp9 = backUp9 == null ? null : backUp9.trim();
    }
}