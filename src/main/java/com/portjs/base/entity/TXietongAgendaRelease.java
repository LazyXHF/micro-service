package com.portjs.base.entity;

import java.util.Date;
import java.util.List;

public class TXietongAgendaRelease {
    private String id;

    private Date beginTime;

    private Date endTime;

    private String meetingSubject;

    private String meetingPlace;

    private String remark;

    private Integer isdelete;

    private Date createtime;

    private Integer amPm;

    private String createrid;

    private List<TXietongAgendaHuman> list;

    public List<TXietongAgendaHuman> getList() {
        return list;
    }

    public void setList(List<TXietongAgendaHuman> list) {
        this.list = list;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getMeetingSubject() {
        return meetingSubject;
    }

    public void setMeetingSubject(String meetingSubject) {
        this.meetingSubject = meetingSubject == null ? null : meetingSubject.trim();
    }

    public String getMeetingPlace() {
        return meetingPlace;
    }

    public void setMeetingPlace(String meetingPlace) {
        this.meetingPlace = meetingPlace == null ? null : meetingPlace.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public Integer getAmPm() {
        return amPm;
    }

    public void setAmPm(Integer amPm) {
        this.amPm = amPm;
    }

    public String getCreaterid() {
        return createrid;
    }

    public void setCreaterid(String createrid) {
        this.createrid = createrid == null ? null : createrid.trim();
    }
}