package com.portjs.base.entity;

import java.util.Date;
import java.util.List;

public class TXietongMeetingroom {
    private String id;

    private Integer building;

    private String floor;

    private String roomNum;

    private String roomDescription;

    private Integer isdelete;

    private Date createtime;

    private String roomName;

    private Integer type;

    private String remark;

    private Integer status;
    
    private String palce;
    
    private String apply;
    
    private String galleryful;
    
    private List<TXietongMrApply> mrApply;
    
    
    public List<TXietongMrApply> getMrApply() {
		return mrApply;
	}

	public void setMrApply(List<TXietongMrApply> mrApply) {
		this.mrApply = mrApply;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getBuilding() {
        return building;
    }

    public void setBuilding(Integer building) {
        this.building = building;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor == null ? null : floor.trim();
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum == null ? null : roomNum.trim();
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription == null ? null : roomDescription.trim();
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

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName == null ? null : roomName.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

	public String getPalce() {
		return palce;
	}

	public void setPalce(String palce) {
		this.palce = palce;
	}

	public String getApply() {
		return apply;
	}

	public void setApply(String apply) {
		this.apply = apply;
	}

	public String getGalleryful() {
		return galleryful;
	}

	public void setGalleryful(String galleryful) {
		this.galleryful = galleryful;
	}

	@Override
	public String toString() {
		return "TXietongMeetingroom [id=" + id + ", building=" + building + ", floor=" + floor + ", roomNum=" + roomNum
				+ ", roomDescription=" + roomDescription + ", isdelete=" + isdelete + ", createtime=" + createtime
				+ ", roomName=" + roomName + ", type=" + type + ", remark=" + remark + ", status=" + status + ", palce="
				+ palce + ", apply=" + apply + ", galleryful=" + galleryful + ", mrApply=" + mrApply + "]";
	}
    
    
}