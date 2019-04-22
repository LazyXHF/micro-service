package com.portjs.base.entity;

import com.portjs.base.util.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 招标审核
 */
public class TenderApplication extends BaseEntity{
    private String id;

    private String requestId;//采购申请单id

    private String tenderNum;//招标申请单号（ZB+YYMMDD+2位流水码）

    private String projectId;//项目id

    private String method;//招标方式1:公开招标、2:邀请招标、

    private String organization;//招标组织

    private String dept;//实施部门

    private Date openDate;//开标日期

    private String remark;//备注说明

    private String status;//流程状态 0:暂存 1:提交采购申请2:招标办人员审核3:招标办主任审核4:招标委员会审核5;执行董事审核

    private String tenderUrl;//招标文件

    private String supplier;//中标厂商

    private Date bidDate;//定标日期

    private BigDecimal amount;//中标金额

    private String bidUrl;//中标文件

    private String creater;//创建人

    private Date createTime;//创建时间

    private Date updateTime;//更新时间

    private Date deleteTime;//删除时间（软删除标记）

    private String review;//1审核0:退回

    private String backUp1;//项目编码

    private String backUp2;//项目名称

    private String backUp3;//备用字段3

    private String backUp4;//备用字段4

    private String backUp5;//备用字段5

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
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