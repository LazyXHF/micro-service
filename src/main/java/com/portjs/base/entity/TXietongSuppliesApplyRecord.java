package com.portjs.base.entity;

import java.util.Date;

public class TXietongSuppliesApplyRecord {
    private String id;

    private String applyId;

    private String ownerId;

    private String recComment;

    private Date createtime;

    private Integer isdelete;

    private Integer status;

    private Integer iscc;

    private Date dealTime;

    private String creatorId;

    private String creatorName;

    private Integer isParallel;

    private Integer opinion;

    private Integer isRead;

    private String ownerName;
    //新加的部门名称
    private String departName;

    //新增采购员处理状态
    //0：未采购  1：已采购
    private Integer pucharseStatus;

    private int applyType;

    //发起请求类型：0：用品审批，1：用品发放，2：采购申请
    public int getApplyType() {
        return applyType;
    }

    public void setApplyType(int applyType) {
        this.applyType = applyType;
    }

    public Integer getPucharseStatus() {
        return pucharseStatus;
    }

    public void setPucharseStatus(Integer pucharseStatus) {
        this.pucharseStatus = pucharseStatus;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId == null ? null : applyId.trim();
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId == null ? null : ownerId.trim();
    }

    public String getRecComment() {
        return recComment;
    }

    public void setRecComment(String recComment) {
        this.recComment = recComment == null ? null : recComment.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIscc() {
        return iscc;
    }

    public void setIscc(Integer iscc) {
        this.iscc = iscc;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName == null ? null : creatorName.trim();
    }

    public Integer getIsParallel() {
        return isParallel;
    }

    public void setIsParallel(Integer isParallel) {
        this.isParallel = isParallel;
    }

    public Integer getOpinion() {
        return opinion;
    }

    public void setOpinion(Integer opinion) {
        this.opinion = opinion;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }
}