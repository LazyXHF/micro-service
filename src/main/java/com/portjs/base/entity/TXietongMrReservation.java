package com.portjs.base.entity;

import java.util.Date;

public class TXietongMrReservation {
    private String id;

    private String mrId;

    private Date begintime;

    private Date endtime;

    private String resId;

    private String resName;

    private String resDepId;

    private String resDepName;

    private Integer isdelete;

    private Date createtime;

    private String meetingSubject;

    private String compere;

    private String participants;

    private Integer status;
    
    private String meetingId;
    
    private String meetingName;
    
    private String meetingContent;
    
    private String filepath;
    
    private String meetingSupplies;
    
    private String meetingStatus;
    
    private int issue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMrId() {
        return mrId;
    }

    public void setMrId(String mrId) {
        this.mrId = mrId == null ? null : mrId.trim();
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId == null ? null : resId.trim();
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName == null ? null : resName.trim();
    }

    public String getResDepId() {
        return resDepId;
    }

    public void setResDepId(String resDepId) {
        this.resDepId = resDepId == null ? null : resDepId.trim();
    }

    public String getResDepName() {
        return resDepName;
    }

    public void setResDepName(String resDepName) {
        this.resDepName = resDepName == null ? null : resDepName.trim();
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

    public String getMeetingSubject() {
        return meetingSubject;
    }

    public void setMeetingSubject(String meetingSubject) {
        this.meetingSubject = meetingSubject == null ? null : meetingSubject.trim();
    }

    public String getCompere() {
        return compere;
    }

    public void setCompere(String compere) {
        this.compere = compere == null ? null : compere.trim();
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants == null ? null : participants.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

	public String getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
	}

	public String getMeetingName() {
		return meetingName;
	}

	public void setMeetingName(String meetingName) {
		this.meetingName = meetingName;
	}

	public String getMeetingContent() {
		return meetingContent;
	}

	public void setMeetingContent(String meetingContent) {
		this.meetingContent = meetingContent;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getMeetingSupplies() {
		return meetingSupplies;
	}

	public void setMeetingSupplies(String meetingSupplies) {
		this.meetingSupplies = meetingSupplies;
	}

	public String getMeetingStatus() {
		return meetingStatus;
	}

	public void setMeetingStatus(String meetringStatus) {
		this.meetingStatus = meetringStatus;
	}

	public int getIssue() {
		return issue;
	}

	public void setIssue(int issue) {
		this.issue = issue;
	}
    
}