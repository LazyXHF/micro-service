package com.portjs.base.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.portjs.base.util.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class PurchaseList extends BaseEntity {
    private String id;

    private String requestId;//采购申请表

    private String projectId;//项目id

    @Excel(name = "品名", orderNum = "1")
    private String name;//品名

    @Excel(name = "品牌", orderNum = "2")
    private String brand;//品牌

    @Excel(name = "型号", orderNum = "3")
    private String model;//型号

    @Excel(name = "规格", orderNum = "4")
    private String spec;//规格

    @Excel(name = "数量", orderNum = "5")
    private BigDecimal quantity;//数量

    @Excel(name = "单位", orderNum = "6")
    private  String unit;//单位

    @Excel(name = "需求说明", orderNum = "8")
    private String content;//需求说明

    @Excel(name = "需求人", orderNum = "7")
    private String demander;//需求人

    private String creater;//创建人

    private Date createTime;//创建时间

    private Date updateTime;//更新时间

    private Date deleteTime;//删除时间（软删除标记）

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

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDemander() {
        return demander;
    }

    public void setDemander(String demander) {
        this.demander = demander == null ? null : demander.trim();
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
}