package com.portjs.base.entity;

import com.portjs.base.util.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 项目立项
 */
@Data
public class Approval extends BaseEntity{
    private String id;

    private String projectId;//项目id

    private Date creatTime;//创建时间

    private String creater;//创建人

    private Date updateTime;//更新时间

    private String updater;//更新人

    private String enable;

    private String backUp1;

    private String backUp2;

    private String backUp3;

    private String backUp4;

    private String backUp5;

    private String backUp6;

    private String backUp7;

    private String backUp8;

    private String backUp9;

    private String backUp10;

    private String unit;//涉及单位

    private String method;//招标方式

    private Date calibrationTime;//定标时间

    private String successfulBidder;//中标厂商

    private BigDecimal amount;//中标金额

    private String biddingContent;//招标内容

    private Date planStartTime;//计划开始时间

    private Date planEndTime;//计划结束时间

    private Date actualStartTime;//实际开始时间

    private Date actualEndTime;//实际结束时间

    private static final long serialVersionUID = 1L;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getBackUp1() {
		return backUp1;
	}

	public void setBackUp1(String backUp1) {
		this.backUp1 = backUp1;
	}

	public String getBackUp2() {
		return backUp2;
	}

	public void setBackUp2(String backUp2) {
		this.backUp2 = backUp2;
	}

	public String getBackUp3() {
		return backUp3;
	}

	public void setBackUp3(String backUp3) {
		this.backUp3 = backUp3;
	}

	public String getBackUp4() {
		return backUp4;
	}

	public void setBackUp4(String backUp4) {
		this.backUp4 = backUp4;
	}

	public String getBackUp5() {
		return backUp5;
	}

	public void setBackUp5(String backUp5) {
		this.backUp5 = backUp5;
	}

	public String getBackUp6() {
		return backUp6;
	}

	public void setBackUp6(String backUp6) {
		this.backUp6 = backUp6;
	}

	public String getBackUp7() {
		return backUp7;
	}

	public void setBackUp7(String backUp7) {
		this.backUp7 = backUp7;
	}

	public String getBackUp8() {
		return backUp8;
	}

	public void setBackUp8(String backUp8) {
		this.backUp8 = backUp8;
	}

	public String getBackUp9() {
		return backUp9;
	}

	public void setBackUp9(String backUp9) {
		this.backUp9 = backUp9;
	}

	public String getBackUp10() {
		return backUp10;
	}

	public void setBackUp10(String backUp10) {
		this.backUp10 = backUp10;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Date getCalibrationTime() {
		return calibrationTime;
	}

	public void setCalibrationTime(Date calibrationTime) {
		this.calibrationTime = calibrationTime;
	}

	public String getSuccessfulBidder() {
		return successfulBidder;
	}

	public void setSuccessfulBidder(String successfulBidder) {
		this.successfulBidder = successfulBidder;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getBiddingContent() {
		return biddingContent;
	}

	public void setBiddingContent(String biddingContent) {
		this.biddingContent = biddingContent;
	}

	public Date getPlanStartTime() {
		return planStartTime;
	}

	public void setPlanStartTime(Date planStartTime) {
		this.planStartTime = planStartTime;
	}

	public Date getPlanEndTime() {
		return planEndTime;
	}

	public void setPlanEndTime(Date planEndTime) {
		this.planEndTime = planEndTime;
	}

	public Date getActualStartTime() {
		return actualStartTime;
	}

	public void setActualStartTime(Date actualStartTime) {
		this.actualStartTime = actualStartTime;
	}

	public Date getActualEndTime() {
		return actualEndTime;
	}

	public void setActualEndTime(Date actualEndTime) {
		this.actualEndTime = actualEndTime;
	}
    
    
}