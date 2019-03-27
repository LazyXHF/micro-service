package com.portjs.base.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 生命周期
 */
@Data
public class Life implements Serializable {
    private String id;

    private String projectId;//项目id

    private String node;//节点1.立项2.合同签订3.需求分析4.开发测试5.试运行6验收

    private String status;//状态1.滞后2.即将到期3.已完成

    private Date createTime;//创建时间

    private String creator;//创建人

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

    private Date updateTime;//更新时间

    private String updater;//更新人

    private String enable;

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

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
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
    
    
    
}