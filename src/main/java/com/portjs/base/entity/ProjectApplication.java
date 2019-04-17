package com.portjs.base.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ProjectApplication {
    private String id;

    private String investmentId;

    private String projectCode;

    private String projectId;

    private String projectName;

    private String projectType;

    private String investor;

    private String organization;

    private String leval;

    private BigDecimal investmentAmount;

    private String range1;

    private BigDecimal applicationAmount;

    private String projectDesc;

    private Date kickoffDate;

    private String remark;

    private String creater;

    private Date createTime;

    private Date updateTime;

    private String enable;

    private String fileUrl;

    private String status;

    private String isDelete;

    private String isApprover;


    private String isRight;

    public String getIsRight() {
        return isRight;
    }

    public void setIsRight(String isRight) {
        this.isRight = isRight;
    }

    //投资计划编号   连表字段
    private String planNum;


    private String   constructionMode;

    public String getConstructionMode() {
        return constructionMode;
    }

    public void setConstructionMode(String constructionMode) {
        this.constructionMode = constructionMode;
    }

    public String getPlanNum() {
        return planNum;
    }

    public void setPlanNum(String planNum) {
        this.planNum = planNum;
    }

    private TWorkflowstep workflowstep;

    public TWorkflowstep getWorkflowstep() {
        return workflowstep;
    }

    public void setWorkflowstep(TWorkflowstep workflowstep) {
        this.workflowstep = workflowstep;
    }

    public String getIsApprover() {
        return isApprover;
    }

    public void setIsApprover(String isApprover) {
        this.isApprover = isApprover;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getInvestmentId() {
        return investmentId;
    }

    public void setInvestmentId(String investmentId) {
        this.investmentId = investmentId == null ? null : investmentId.trim();
    }

    public String getProjectCode() {
        return projectCode;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
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

    public String getInvestor() {
        return investor;
    }

    public void setInvestor(String investor) {
        this.investor = investor == null ? null : investor.trim();
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization == null ? null : organization.trim();
    }

    public String getLeval() {
        return leval;
    }

    public void setLeval(String leval) {
        this.leval = leval == null ? null : leval.trim();
    }

    public BigDecimal getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(BigDecimal investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public String getRange1() {
        return range1;
    }

    public void setRange1(String range1) {
        this.range1 = range1 == null ? null : range1.trim();
    }

    public BigDecimal getApplicationAmount() {
        return applicationAmount;
    }

    public void setApplicationAmount(BigDecimal applicationAmount) {
        if(applicationAmount==null){
            BigDecimal decimal = new BigDecimal(0);
            decimal=decimal.setScale(3, BigDecimal.ROUND_HALF_UP);
            this.applicationAmount = decimal;
        }else {
            this.applicationAmount = applicationAmount;
        }
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc == null ? null : projectDesc.trim();
    }

    public Date getKickoffDate() {
        return kickoffDate;
    }

    public void setKickoffDate(Date kickoffDate) {
        this.kickoffDate = kickoffDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }
}