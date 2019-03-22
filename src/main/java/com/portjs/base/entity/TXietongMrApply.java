package com.portjs.base.entity;

import org.apache.ibatis.type.Alias;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_xietong_mr_apply")
@Alias(value = "TXietongMrApply")
public class TXietongMrApply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String status;

    private Integer isdelete;

    private Date createtime;

    private String nextApprover;

    private String nextApproverId;

    private Date endtime;

    private String nextRecordIds;

    private String applyId;

    private String applyName;

    private String applyDepId;

    private String applyDepName;

    private String content;

    private String mrResId;
    
    private Date begintime;
    
    private String meetingName;
    
    private String meetingId;
    
    private String time_cell;
    
    private String meetingLeader;
    
    private String meetingPersonnel;
    
    private Integer seatCard;
    
    private Integer teaWater;
    
    private Integer projector;
    
    private Integer microphone;
    
    private String filePath;
     
    private String mrRecordId;
    
    private String attendance;
    
    @Transient
    private List<TXietongMrApplyRecord> applyRecord;

    @Transient
    private Date mendtime;

    @Transient
    private String rstatus;
    
    

    public List<TXietongMrApplyRecord> getApplyRecord() {
		return applyRecord;
	}

	public void setApplyRecord(List<TXietongMrApplyRecord> applyRecord) {
		this.applyRecord = applyRecord;
	}

	public String getAttendance() {
		return attendance;
	}

	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}

	public String getMeetingLeader() {
		return meetingLeader;
	}

	public void setMeetingLeader(String meetingLeader) {
		this.meetingLeader = meetingLeader;
	}

	public String getMeetingPersonnel() {
		return meetingPersonnel;
	}

	public void setMeetingPersonnel(String meetingPersonnel) {
		this.meetingPersonnel = meetingPersonnel;
	}

	public Integer getSeatCard() {
		return seatCard;
	}

	public void setSeatCard(Integer seatCard) {
		this.seatCard = seatCard;
	}

	public Integer getTeaWater() {
		return teaWater;
	}

	public void setTeaWater(Integer teaWater) {
		this.teaWater = teaWater;
	}

	public Integer getProjector() {
		return projector;
	}

	public void setProjector(Integer projector) {
		this.projector = projector;
	}

	public Integer getMicrophone() {
		return microphone;
	}

	public void setMicrophone(Integer microphone) {
		this.microphone = microphone;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getMrRecordId() {
		return mrRecordId;
	}

	public void setMrRecordId(String mrRecordId) {
		this.mrRecordId = mrRecordId;
	}
	
	

	public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getMendtime() {
        return mendtime;
    }

    public void setMendtime(Date mendtime) {
        this.mendtime = mendtime;
    }

    public String getRstatus() {
        return rstatus;
    }

    public void setRstatus(String rstatus) {
        this.rstatus = rstatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public String getNextApprover() {
        return nextApprover;
    }

    public void setNextApprover(String nextApprover) {
        this.nextApprover = nextApprover == null ? null : nextApprover.trim();
    }

    public String getNextApproverId() {
        return nextApproverId;
    }

    public void setNextApproverId(String nextApproverId) {
        this.nextApproverId = nextApproverId == null ? null : nextApproverId.trim();
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getNextRecordIds() {
        return nextRecordIds;
    }

    public void setNextRecordIds(String nextRecordIds) {
        this.nextRecordIds = nextRecordIds == null ? null : nextRecordIds.trim();
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId == null ? null : applyId.trim();
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName == null ? null : applyName.trim();
    }

    public String getApplyDepId() {
        return applyDepId;
    }

    public void setApplyDepId(String applyDepId) {
        this.applyDepId = applyDepId == null ? null : applyDepId.trim();
    }

    public String getApplyDepName() {
        return applyDepName;
    }

    public void setApplyDepName(String applyDepName) {
        this.applyDepName = applyDepName == null ? null : applyDepName.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getMrResId() {
        return mrResId;
    }

    public void setMrResId(String mrResId) {
        this.mrResId = mrResId == null ? null : mrResId.trim();
    }

	public String getMeetingName() {
		return meetingName;
	}

	public void setMeetingName(String meetingName) {
		this.meetingName = meetingName;
	}

	public String getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
	}

	public String getTime_cell() {
		return time_cell;
	}

	public void setTime_cell(String time_cell) {
		this.time_cell = time_cell;
	}
    
    
}