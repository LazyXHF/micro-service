package com.portjs.base.vo;

import com.portjs.base.entity.CommunicationLog;

import java.util.Date;
import java.util.List;

public class CommunicationLogRecord {
    private String id;//留言

    private String communicationId;//沟通问题id

    private String discussant;//回复人

    private Date replytime;//回复时间

    private String preMessage;//回复的留言id

    private String content;//内容

   /* List<CommunicationLog> communicationLogList;

    public List<CommunicationLog> getCommunicationLogList() {
        return communicationLogList;
    }

    public void setCommunicationLogList(List<CommunicationLog> communicationLogList) {
        this.communicationLogList = communicationLogList;
    }*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommunicationId() {
        return communicationId;
    }

    public void setCommunicationId(String communicationId) {
        this.communicationId = communicationId;
    }

    public String getDiscussant() {
        return discussant;
    }

    public void setDiscussant(String discussant) {
        this.discussant = discussant;
    }

    public Date getReplytime() {
        return replytime;
    }

    public void setReplytime(Date replytime) {
        this.replytime = replytime;
    }

    public String getPreMessage() {
        return preMessage;
    }

    public void setPreMessage(String preMessage) {
        this.preMessage = preMessage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
