package com.portjs.base.entity;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

//@Data?
public class InternalProject implements Serializable {
    private String id;

    private Date createTime;

    private String creater;

    private Date modifyTime;

    private String modifer;

    private String type;

    private String name;

    private String leader;

    private String leaderName;

    private String leaderTell;

    private String status;

    private String responsibleUnit;

    private String responsibleUnitId;

    private String range;

    private String meeting;

    private String content;

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

    private String project_type;

    private List<InternalPersionResource> list;

    /*public InternalPersionResource getInternalPersionResource1() {
        return internalPersionResource1;
    }

    public void setInternalPersionResource1(InternalPersionResource internalPersionResource1) {
        this.internalPersionResource1 = internalPersionResource1;
    }*/



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

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
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

    public String getProject_type() {
        return project_type;
    }

    public void setProject_type(String project_type) {
        this.project_type = project_type;
    }

    public List<InternalPersionResource> getList() {
        return list;
    }

    public void setList(List<InternalPersionResource> list) {
        this.list = list;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private static final long serialVersionUID = 1L;

}