package com.portjs.base.entity;

import java.util.Date;

public class TXietongAgendaRecord {
    private String id;

    private Integer isdelete;

    private Date createtime;

    private String rstatus;

    private String agendaProcessId;

    private String comment;

    private String ownerId;

    private Date dealTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getRstatus() {
        return rstatus;
    }

    public void setRstatus(String rstatus) {
        this.rstatus = rstatus == null ? null : rstatus.trim();
    }

    public String getAgendaProcessId() {
        return agendaProcessId;
    }

    public void setAgendaProcessId(String agendaProcessId) {
        this.agendaProcessId = agendaProcessId == null ? null : agendaProcessId.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId == null ? null : ownerId.trim();
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }
}