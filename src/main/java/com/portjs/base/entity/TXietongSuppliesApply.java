package com.portjs.base.entity;

import java.security.PrivateKey;
import java.util.Date;
import java.util.List;

public class TXietongSuppliesApply {
    private String id;

    private String status;

    private Integer isdelete;

    private Date createtime;

    private String nextApprover;

    private String nextApproverId;

    private Date endtime;

    private String supplyType;

    private String supplyId;

    private String applyId;

    private String applyName;

    private String applyDepId;

    private String applyDepName;

    private Integer applyCount;

    private Integer officerStatus;

    public Integer getOfficerStatus() {
        return officerStatus;
    }

    public void setOfficerStatus(Integer officerStatus) {
        this.officerStatus = officerStatus;
    }

    private String content;

    private String nextRecordIds;

    private String supplyName;

    private String ownerId;
    //新加字段  请求类型  采购还是申领
    private String arStatus;
    //新加字段  库存管理员状态
    private Integer repositoryStatus;

    //从表字段
    private String reccommnet;

    private Integer aropinion;

    private Integer ariscc;

    private String category;

    private String categoryId;

    private Integer code;

    private  Integer isApplying;


    private String ownerName;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Integer getIsApplying() {
        return isApplying;
    }

    public void setIsApplying(Integer isApplying) {
        this.isApplying = isApplying;
    }

    private List<TXietongSuppliesApplyRecord> suppliesApplyRecords ;

    public List<TXietongSuppliesApplyRecord> getSuppliesApplyRecords() {
        return suppliesApplyRecords;
    }

    public void setSuppliesApplyRecords(List<TXietongSuppliesApplyRecord> suppliesApplyRecords) {
        this.suppliesApplyRecords = suppliesApplyRecords;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getAriscc() {
        return ariscc;
    }

    public void setAriscc(Integer ariscc) {
        this.ariscc = ariscc;
    }
    private Integer arApplyType;

    public Integer getArApplyType() {
        return arApplyType;
    }

    public void setArApplyType(Integer arApplyType) {
        this.arApplyType = arApplyType;
    }

    private String pstatus;

    private String rstatus;

    private String bstatus;

    //查询办公室意见
    private Integer opinion;

    //使用人
    private String user;

    private String userId;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getOpinion() {
        return opinion;
    }

    public void setOpinion(Integer opinion) {
        this.opinion = opinion;
    }

    public String getBstatus() {
        return bstatus;
    }

    public void setBstatus(String bstatus) {
        this.bstatus = bstatus;
    }

    public String getRstatus() {
        return rstatus;
    }

    public void setRstatus(String rstatus) {
        this.rstatus = rstatus;
    }

    public String getPstatus() {
        return pstatus;
    }

    public void setPstatus(String pstatus) {
        this.pstatus = pstatus;
    }

    public Integer getAropinion() {
        return aropinion;
    }

    public void setAropinion(Integer aropinion) {
        this.aropinion = aropinion;
    }

    public String getReccommnet() {
        return reccommnet;
    }

    public void setReccommnet(String reccommnet) {
        this.reccommnet = reccommnet;
    }

    public Integer getRepositoryStatus() {
        return repositoryStatus;
    }

    public void setRepositoryStatus(Integer repositoryStatus) {
        this.repositoryStatus = repositoryStatus;
    }

    public String getArStatus() {
        return arStatus;
    }

    public void setArStatus(String arStatus) {
        this.arStatus = arStatus;
    }

    private String requestType;

    private Integer stock;

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    private  TXietongSuppliesApplyRecord record;


    public TXietongSuppliesApplyRecord getRecord() {
        return record;
    }

    public void setRecord(TXietongSuppliesApplyRecord record) {
        this.record = record;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getNextApprover() {
        return nextApprover;
    }

    public void setNextApprover(String nextApprover) {
        this.nextApprover = nextApprover == null ? null : nextApprover.trim();
    }

    public String getNextApproverId() {
        return nextApproverId;
    }

    public void setNextApproverId(String nextApproverId) {
        this.nextApproverId = nextApproverId == null ? null : nextApproverId.trim();
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getSupplyType() {
        return supplyType;
    }

    public void setSupplyType(String supplyType) {
        this.supplyType = supplyType == null ? null : supplyType.trim();
    }

    public String getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(String supplyId) {
        this.supplyId = supplyId == null ? null : supplyId.trim();
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId == null ? null : applyId.trim();
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName == null ? null : applyName.trim();
    }

    public String getApplyDepId() {
        return applyDepId;
    }

    public void setApplyDepId(String applyDepId) {
        this.applyDepId = applyDepId == null ? null : applyDepId.trim();
    }

    public String getApplyDepName() {
        return applyDepName;
    }

    public void setApplyDepName(String applyDepName) {
        this.applyDepName = applyDepName == null ? null : applyDepName.trim();
    }

    public Integer getApplyCount() {
        return applyCount;
    }

    public void setApplyCount(Integer applyCount) {
        this.applyCount = applyCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getNextRecordIds() {
        return nextRecordIds;
    }

    public void setNextRecordIds(String nextRecordIds) {
        this.nextRecordIds = nextRecordIds == null ? null : nextRecordIds.trim();
    }

    public String getSupplyName() {
        return supplyName;
    }

    public void setSupplyName(String supplyName) {
        this.supplyName = supplyName == null ? null : supplyName.trim();
    }
}