package com.portjs.base.entity;

import java.io.Serializable;
import java.util.Date;

public class ProjectCommunication implements Serializable {
    private String id;

    private String projectId;//所属项目id

    private String sponsor;//发起人

    private String phase;//项目阶段

    private String priority;//优先级

    private String classification;//问题分类

    private String title;//标题

    private String content;//内容

    private String fileUrl;//文件路径

    private Date createTime;//创建时间

    private Date deleteTime;//删除时间（软删除）

    private String status;

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

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor == null ? null : sponsor.trim();
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase == null ? null : phase.trim();
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority == null ? null : priority.trim();
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification == null ? null : classification.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getBackup1() {
        return backup1;
    }

    public void setBackup1(String backup1) {
        this.backup1 = backup1 == null ? null : backup1.trim();
    }

    public String getBackup2() {
        return backup2;
    }

    public void setBackup2(String backup2) {
        this.backup2 = backup2 == null ? null : backup2.trim();
    }

    public String getBackup3() {
        return backup3;
    }

    public void setBackup3(String backup3) {
        this.backup3 = backup3 == null ? null : backup3.trim();
    }

    public String getBackup4() {
        return backup4;
    }

    public void setBackup4(String backup4) {
        this.backup4 = backup4 == null ? null : backup4.trim();
    }

    public String getBackup5() {
        return backup5;
    }

    public void setBackup5(String backup5) {
        this.backup5 = backup5 == null ? null : backup5.trim();
    }

    public String getBackup6() {
        return backup6;
    }

    public void setBackup6(String backup6) {
        this.backup6 = backup6 == null ? null : backup6.trim();
    }

    public String getBackup7() {
        return backup7;
    }

    public void setBackup7(String backup7) {
        this.backup7 = backup7 == null ? null : backup7.trim();
    }

    public String getBackup8() {
        return backup8;
    }

    public void setBackup8(String backup8) {
        this.backup8 = backup8 == null ? null : backup8.trim();
    }

    public String getBackup9() {
        return backup9;
    }

    public void setBackup9(String backup9) {
        this.backup9 = backup9 == null ? null : backup9.trim();
    }

    public String getBackup10() {
        return backup10;
    }

    public void setBackup10(String backup10) {
        this.backup10 = backup10 == null ? null : backup10.trim();
    }
}