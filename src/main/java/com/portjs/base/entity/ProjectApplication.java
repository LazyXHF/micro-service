package com.portjs.base.entity;

import java.util.Date;

public class ProjectApplication {
    private String id;

    private String projectCode;

    private String projectName;

    private String projectType;

    private String leval;

    private String projectDesc;

    private String organization;

    private String range1;

    private Date kickoffDate;

    private String creater;

    private Date createTime;

    private Date updateTime;

    private String enable;

    private String fileUrl;


    private String backUp9;

    private String status;

    private String isApprover;

    public String getIsApprover() {
        return isApprover;
    }

    public void setIsApprover(String isApprover) {
        this.isApprover = isApprover;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private TWorkflowstep workflowstep;

    public TWorkflowstep getWorkflowstep() {
        return workflowstep;
    }

    public void setWorkflowstep(TWorkflowstep workflowstep) {
        this.workflowstep = workflowstep;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode == null ? null : projectCode.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType == null ? null : projectType.trim();
    }

    public String getLeval() {
        return leval;
    }

    public void setLeval(String leval) {
        this.leval = leval == null ? null : leval.trim();
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc == null ? null : projectDesc.trim();
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization == null ? null : organization.trim();
    }

    public String getRange1() {
        return range1;
    }

    public void setRange1(String range1) {
        this.range1 = range1 == null ? null : range1.trim();
    }

    public Date getKickoffDate() {
        return kickoffDate;
    }

    public void setKickoffDate(Date kickoffDate) {
        this.kickoffDate = kickoffDate;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable == null ? null : enable.trim();
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }


    public String getBackUp9() {
        return backUp9;
    }

    public void setBackUp9(String backUp9) {
        this.backUp9 = backUp9 == null ? null : backUp9.trim();
    }
}