package com.portjs.base.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TenderApplication {
    private String id;

    private Integer requestId;

    private String tenderNum;

    private String projectId;

    private String method;

    private String organization;

    private String dept;

    private Date openDate;

    private String remark;

    private String status;

    private String tenderUrl;

    private String supplier;

    private Date bidDate;

    private BigDecimal amount;

    private String bidUrl;

    private String creater;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private String review;

    private String backUp1;

    private String backUp2;

    private String backUp3;

    private String backUp4;

    private String backUp5;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public String getTenderNum() {
        return tenderNum;
    }

    public void setTenderNum(String tenderNum) {
        this.tenderNum = tenderNum == null ? null : tenderNum.trim();
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization == null ? null : organization.trim();
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept == null ? null : dept.trim();
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getTenderUrl() {
        return tenderUrl;
    }

    public void setTenderUrl(String tenderUrl) {
        this.tenderUrl = tenderUrl == null ? null : tenderUrl.trim();
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
    }

    public Date getBidDate() {
        return bidDate;
    }

    public void setBidDate(Date bidDate) {
        this.bidDate = bidDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getBidUrl() {
        return bidUrl;
    }

    public void setBidUrl(String bidUrl) {
        this.bidUrl = bidUrl == null ? null : bidUrl.trim();
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

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review == null ? null : review.trim();
    }

    public String getBackUp1() {
        return backUp1;
    }

    public void setBackUp1(String backUp1) {
        this.backUp1 = backUp1 == null ? null : backUp1.trim();
    }

    public String getBackUp2() {
        return backUp2;
    }

    public void setBackUp2(String backUp2) {
        this.backUp2 = backUp2 == null ? null : backUp2.trim();
    }

    public String getBackUp3() {
        return backUp3;
    }

    public void setBackUp3(String backUp3) {
        this.backUp3 = backUp3 == null ? null : backUp3.trim();
    }

    public String getBackUp4() {
        return backUp4;
    }

    public void setBackUp4(String backUp4) {
        this.backUp4 = backUp4 == null ? null : backUp4.trim();
    }

    public String getBackUp5() {
        return backUp5;
    }

    public void setBackUp5(String backUp5) {
        this.backUp5 = backUp5 == null ? null : backUp5.trim();
    }
}