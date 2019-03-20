package com.portjs.base.entity;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_xietong_agenda")
@Alias(value = "TXietongAgenda")
public class TXietongAgenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    private String meetingSubject;

    private String meetingPlace;

    private String remark;

    private Integer isdelete;

    private Date createtime;

    private Integer amPm;

    private Integer ispublish;

    private String createrid;

    private String type;

    @Transient
    private List<TXietongAgendaHuman> list;

    @Transient
    private TUser user;
    @Transient
    private Integer pageNum;//当前页数
    @Transient
    private Integer pageCount;//每页显示记录数



    public List<TXietongAgendaHuman> getList() {
        return list;
    }

    public void setList(List<TXietongAgendaHuman> list) {
        this.list = list;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
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

    public Integer getIspublish() {
        return ispublish;
    }

    public void setIspublish(Integer ispublish) {
        this.ispublish = ispublish;
    }

    public String getCreaterid() {
        return createrid;
    }

    public void setCreaterid(String createrid) {
        this.createrid = createrid == null ? null : createrid.trim();
    }

    public TUser getUser() {
        return user;
    }

    public void setUser(TUser user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}