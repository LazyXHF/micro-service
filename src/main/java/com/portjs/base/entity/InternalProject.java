package com.portjs.base.entity;

import com.portjs.base.util.BaseEntity;
import com.portjs.base.util.Page;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class InternalProject extends BaseEntity{
    private String id;

    private Date createTime;//创建时间

    private String creater;//创建人

    private Date modifyTime;//修改时间

    private String modifer;//修改人

    private String type;//项目等级

    private String name;//项目名称

    private String leader;//负责人

    private String leaderName;//负责人姓名

    private String leaderTell;//负责人联系方式

    private String status;//项目状态

    private String responsibleUnit;//责任单位

    private String responsibleUnitId;//责任单位id

    private String ranges;//实施范围

    private String meeting;//启动会

    private String content;//项目内容

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

    private String projectType;//项目类型
    
    private Page<InternalPersionResource> page;
    
    private List<InternalTodo> internalToDo;
    
    private List<InternalWorkflowstep>internalWorkflowstep;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifer() {
        return modifer;
    }

    public void setModifer(String modifer) {
        this.modifer = modifer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getLeaderTell() {
        return leaderTell;
    }

    public void setLeaderTell(String leaderTell) {
        this.leaderTell = leaderTell;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponsibleUnit() {
        return responsibleUnit;
    }

    public void setResponsibleUnit(String responsibleUnit) {
        this.responsibleUnit = responsibleUnit;
    }

    public String getResponsibleUnitId() {
        return responsibleUnitId;
    }

    public void setResponsibleUnitId(String responsibleUnitId) {
        this.responsibleUnitId = responsibleUnitId;
    }

    public String getRanges() {
        return ranges;
    }

    public void setRanges(String ranges) {
        this.ranges = ranges;
    }

    public String getMeeting() {
        return meeting;
    }

    public void setMeeting(String meeting) {
        this.meeting = meeting;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

	public Page<InternalPersionResource> getPage() {
		return page;
	}

	public void setPage(Page<InternalPersionResource> page) {
		this.page = page;
	}

	public List<InternalTodo> getInternalToDo() {
		return internalToDo;
	}

	public void setInternalToDo(List<InternalTodo> internalToDo) {
		this.internalToDo = internalToDo;
	}

	public List<InternalWorkflowstep> getInternalWorkflowstep() {
		return internalWorkflowstep;
	}

	public void setInternalWorkflowstep(List<InternalWorkflowstep> internalWorkflowstep) {
		this.internalWorkflowstep = internalWorkflowstep;
	}
    
}