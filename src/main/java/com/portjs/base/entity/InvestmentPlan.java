package com.portjs.base.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.portjs.base.util.BaseEntity;
import com.sun.istack.internal.NotNull;

import java.math.BigDecimal;
import java.util.Date;

public class InvestmentPlan extends BaseEntity {
    private String id;

    @Excel(name = "计划编号", orderNum = "0")
    private String planNum;

    private String projectId;

    @Excel(name = "项目名称", orderNum = "2")
    private String projectName;

    @Excel(name = "项目分类", orderNum = "1")
    private String projectType;

    @Excel(name = "项目简介", orderNum = "3")
    private String projectDesc;

    @Excel(name = "责任单位", orderNum = "4")
    private String organization;

    @Excel(name = "投资主体", orderNum = "5")
    private String investor;

    @Excel(name = "投资金额(万元)", orderNum = "6")
    private BigDecimal amount;



    @Excel(name = "建设方式", orderNum = "7")
    private String constructionMode;

    @Excel(name = "备注", orderNum = "8")
    private String remark;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private int rowNum;
    private int pageCount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        if(amount==null){
            BigDecimal decimal = new BigDecimal(0);
            decimal=decimal.setScale(3, BigDecimal.ROUND_HALF_UP);
            this.amount = decimal;
        }else {
            this.amount = amount;
        }

    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPlanNum() {
        return planNum;
    }

    public void setPlanNum(String planNum) {
        this.planNum = planNum == null ? null : planNum.trim();
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
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

    public String getInvestor() {
        return investor;
    }

    public void setInvestor(String investor) {
        this.investor = investor == null ? null : investor.trim();
    }

    public String getConstructionMode() {
        return constructionMode;
    }

    public void setConstructionMode(String constructionMode) {
        this.constructionMode = constructionMode == null ? null : constructionMode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }
}