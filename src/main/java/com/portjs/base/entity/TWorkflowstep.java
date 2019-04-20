package com.portjs.base.entity;

import java.util.Date;

public class TWorkflowstep {
    private String id;

    private String relateddomain;//业务

    private String relateddomainId;//业务单id

    private String prestepId;//上一步流程

    private String stepDesc;//流程描述

    private String actionuserId;//处理人id

    private Date actionTime;//处理时间

    private Integer actionResult;//处理结果

    private String fileUrl;//文件路径

    private String actionComment;//处理意见

    private String enable;

    private String status;//状态 0 ： 未完成   1：已完成

    private String backup3;//

    private String backUp7;//处理人名字

    private String backUp8;

    private String backUp9;

    private String fileDescription;

    private  String bstatus;

    private String userName;

    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBstatus() {
        return bstatus;
    }

    public void setBstatus(String bstatus) {
        this.bstatus = bstatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRelateddomain() {
        return relateddomain;
    }

    public void setRelateddomain(String relateddomain) {
        this.relateddomain = relateddomain == null ? null : relateddomain.trim();
    }

    public String getRelateddomainId() {
        return relateddomainId;
    }

    public void setRelateddomainId(String relateddomainId) {
        this.relateddomainId = relateddomainId == null ? null : relateddomainId.trim();
    }

    public String getPrestepId() {
        return prestepId;
    }

    public void setPrestepId(String prestepId) {
        this.prestepId = prestepId == null ? null : prestepId.trim();
    }

    public String getStepDesc() {
        return stepDesc;
    }

    public void setStepDesc(String stepDesc) {
        this.stepDesc = stepDesc == null ? null : stepDesc.trim();
    }

    public String getActionuserId() {
        return actionuserId;
    }

    public void setActionuserId(String actionuserId) {
        this.actionuserId = actionuserId == null ? null : actionuserId.trim();
    }

    public Date getActionTime() {
        return actionTime;
    }

    public void setActionTime(Date actionTime) {
        this.actionTime = actionTime;
    }

    public Integer getActionResult() {
        return actionResult;
    }

    public void setActionResult(Integer actionResult) {
        this.actionResult = actionResult;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }

    public String getActionComment() {
        return actionComment;
    }

    public void setActionComment(String actionComment) {
        this.actionComment = actionComment == null ? null : actionComment.trim();
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable == null ? null : enable.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getBackup3() {
        return backup3;
    }

    public void setBackup3(String backup3) {
        this.backup3 = backup3 == null ? null : backup3.trim();
    }

    public String getBackUp7() {
        return backUp7;
    }

    public void setBackUp7(String backUp7) {
        this.backUp7 = backUp7 == null ? null : backUp7.trim();
    }

    public String getBackUp8() {
        return backUp8;
    }

    public void setBackUp8(String backUp8) {
        this.backUp8 = backUp8 == null ? null : backUp8.trim();
    }

    public String getBackUp9() {
        return backUp9;
    }

    public void setBackUp9(String backUp9) {
        this.backUp9 = backUp9 == null ? null : backUp9.trim();
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription == null ? null : fileDescription.trim();
    }
}