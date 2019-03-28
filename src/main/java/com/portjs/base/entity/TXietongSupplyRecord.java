package com.portjs.base.entity;

import java.util.Date;

public class TXietongSupplyRecord {
    private String id;

    private String supplyId;

    private String supplyName;

    private String supplyType;

    private String receiptorId;

    private String receiptorDepartId;

    private String reamark;

    private Integer isdelete;

    private Date createtime;

    private int amount;

    private String receiptorName;

    private String receiptorDepartName;

    private String recordCreatorId;

    private String recordCreatorName;

    private Integer allAmount;
    private Double allPrice;

    public Double getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(Double allPrice) {
        this.allPrice = allPrice;
    }

    //  0: 1 :2
    private Integer Interfacetype;

    /*x轴的值*/
    private String x;

    private  String littleValue;

    private Integer size;

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getLittleValue() {
        return littleValue;
    }

    public void setLittleValue(String littleValue) {
        this.littleValue = littleValue;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getInterfacetype() {
        return Interfacetype;
    }

    public void setInterfacetype(Integer interfacetype) {
        Interfacetype = interfacetype;
    }

    public Integer getAllAmount() {
        return allAmount;
    }

    public void setAllAmount(Integer allAmount) {
        this.allAmount = allAmount;
    }
    private String ym;

    public String getYm() {
        return ym;
    }

    public void setYm(String ym) {
        this.ym = ym;
    }
    private String departMent;

    public String getDepartMent() {
        return departMent;
    }

    public void setDepartMent(String departMent) {
        this.departMent = departMent;
    }

    public String getRecordCreatorId() {
        return recordCreatorId;
    }

    public void setRecordCreatorId(String recordCreatorId) {
        this.recordCreatorId = recordCreatorId;
    }

    public String getRecordCreatorName() {
        return recordCreatorName;
    }

    public void setRecordCreatorName(String recordCreatorName) {
        this.recordCreatorName = recordCreatorName;
    }

    private Double price;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(String supplyId) {
        this.supplyId = supplyId == null ? null : supplyId.trim();
    }

    public String getSupplyName() {
        return supplyName;
    }

    public void setSupplyName(String supplyName) {
        this.supplyName = supplyName == null ? null : supplyName.trim();
    }

    public String getSupplyType() {
        return supplyType;
    }

    public void setSupplyType(String supplyType) {
        this.supplyType = supplyType == null ? null : supplyType.trim();
    }

    public String getReceiptorId() {
        return receiptorId;
    }

    public void setReceiptorId(String receiptorId) {
        this.receiptorId = receiptorId == null ? null : receiptorId.trim();
    }

    public String getReceiptorDepartId() {
        return receiptorDepartId;
    }

    public void setReceiptorDepartId(String receiptorDepartId) {
        this.receiptorDepartId = receiptorDepartId == null ? null : receiptorDepartId.trim();
    }

    public String getReamark() {
        return reamark;
    }

    public void setReamark(String reamark) {
        this.reamark = reamark == null ? null : reamark.trim();
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getReceiptorName() {
        return receiptorName;
    }

    public void setReceiptorName(String receiptorName) {
        this.receiptorName = receiptorName == null ? null : receiptorName.trim();
    }

    public String getReceiptorDepartName() {
        return receiptorDepartName;
    }

    public void setReceiptorDepartName(String receiptorDepartName) {
        this.receiptorDepartName = receiptorDepartName == null ? null : receiptorDepartName.trim();
    }
}