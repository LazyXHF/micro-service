package com.portjs.base.entity;

import java.util.Date;

public class InternalWorkflowstep {
    private String id;

    private String relateddomain;

    private String relateddomainId;

    private String prestepId;

    private String stepDesc;

    private String actionuserId;

    private Date actionTime;

    private Integer actionResult;

    private String fileUrl;

    private String fileDescription;

    private String actionComment;

    private Date deleteTime;

    private String status;

    private String projectCoding;

    private String backup3;

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

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription == null ? null : fileDescription.trim();
    }

    public String getActionComment() {
        return actionComment;
    }

    public void setActionComment(String actionComment) {
        this.actionComment = actionComment == null ? null : actionComment.trim();
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

    public String getProjectCoding() {
        return projectCoding;
    }

    public void setProjectCoding(String projectCoding) {
        this.projectCoding = projectCoding == null ? null : projectCoding.trim();
    }

    public String getBackup3() {
        return backup3;
    }

    public void setBackup3(String backup3) {
        this.backup3 = backup3 == null ? null : backup3.trim();
    }
}