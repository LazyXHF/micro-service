package com.portjs.base.entity;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Repository
public class BugDetailsRecord {
    private String id;

    private String bugId;//bug表关联id

    private String createrId;//创建人id

    private String fileUrl;//文件路径

    private String remark;//审核备注信息

    private Integer repeatCount;//重复次数

    private Integer status;//审核状态

    private String ownerId;//所属开发人员id

    private Integer isAgree;//是否同意处理方式（0：同意  1：不同意）

    private Date recordTime;//记录创建时间

    private String backup1;

    private String backup2;

    private String backup3;

    private String backup4;

    private String backup5;

    private String backup6;

    private String backup7;

    private String backup8;

    private String backup9;

    private String backup10;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBugId() {
        return bugId;
    }

    public void setBugId(String bugId) {
        this.bugId = bugId;
    }

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(Integer repeatCount) {
        this.repeatCount = repeatCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getIsAgree() {
        return isAgree;
    }

    public void setIsAgree(Integer isAgree) {
        this.isAgree = isAgree;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getBackup1() {
        return backup1;
    }

    public void setBackup1(String backup1) {
        this.backup1 = backup1;
    }

    public String getBackup2() {
        return backup2;
    }

    public void setBackup2(String backup2) {
        this.backup2 = backup2;
    }

    public String getBackup3() {
        return backup3;
    }

    public void setBackup3(String backup3) {
        this.backup3 = backup3;
    }

    public String getBackup4() {
        return backup4;
    }

    public void setBackup4(String backup4) {
        this.backup4 = backup4;
    }

    public String getBackup5() {
        return backup5;
    }

    public void setBackup5(String backup5) {
        this.backup5 = backup5;
    }

    public String getBackup6() {
        return backup6;
    }

    public void setBackup6(String backup6) {
        this.backup6 = backup6;
    }

    public String getBackup7() {
        return backup7;
    }

    public void setBackup7(String backup7) {
        this.backup7 = backup7;
    }

    public String getBackup8() {
        return backup8;
    }

    public void setBackup8(String backup8) {
        this.backup8 = backup8;
    }

    public String getBackup9() {
        return backup9;
    }

    public void setBackup9(String backup9) {
        this.backup9 = backup9;
    }

    public String getBackup10() {
        return backup10;
    }

    public void setBackup10(String backup10) {
        this.backup10 = backup10;
    }
}