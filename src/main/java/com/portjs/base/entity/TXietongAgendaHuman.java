package com.portjs.base.entity;

import java.util.Date;
import java.util.List;

public class TXietongAgendaHuman {
    private String id;

    private Integer isdelete;

    private Date createtime;

    private String participantId;

    private String participantValue;

    private Integer amPm;

    private String agendaId;

    private Date beginTime;

    private List<TXietongAgenda> list;

    public List<TXietongAgenda> getList() {
        return list;
    }

    public void setList(List<TXietongAgenda> list) {
        this.list = list;
    }

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

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId == null ? null : participantId.trim();
    }

    public String getParticipantValue() {
        return participantValue;
    }

    public void setParticipantValue(String participantValue) {
        this.participantValue = participantValue == null ? null : participantValue.trim();
    }

    public Integer getAmPm() {
        return amPm;
    }

    public void setAmPm(Integer amPm) {
        this.amPm = amPm;
    }

    public String getAgendaId() {
        return agendaId;
    }

    public void setAgendaId(String agendaId) {
        this.agendaId = agendaId == null ? null : agendaId.trim();
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }
}