package com.mgt.project.Example.entity;

public class TXietongDictionary {
    private String id;

    private String typeCode;

    private String typeDesc;

    private String mainValue;

    private String midValue;

    private String subValue;

    private String valueSort;

    private String valueDesc;

    private String remark;

    private String typeId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode == null ? null : typeCode.trim();
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc == null ? null : typeDesc.trim();
    }

    public String getMainValue() {
        return mainValue;
    }

    public void setMainValue(String mainValue) {
        this.mainValue = mainValue == null ? null : mainValue.trim();
    }

    public String getMidValue() {
        return midValue;
    }

    public void setMidValue(String midValue) {
        this.midValue = midValue == null ? null : midValue.trim();
    }

    public String getSubValue() {
        return subValue;
    }

    public void setSubValue(String subValue) {
        this.subValue = subValue == null ? null : subValue.trim();
    }

    public String getValueSort() {
        return valueSort;
    }

    public void setValueSort(String valueSort) {
        this.valueSort = valueSort == null ? null : valueSort.trim();
    }

    public String getValueDesc() {
        return valueDesc;
    }

    public void setValueDesc(String valueDesc) {
        this.valueDesc = valueDesc == null ? null : valueDesc.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    @Override
    public String toString() {
        return "TXietongDictionary{" +
                "id='" + id + '\'' +
                ", typeCode='" + typeCode + '\'' +
                ", typeDesc='" + typeDesc + '\'' +
                ", mainValue='" + mainValue + '\'' +
                ", midValue='" + midValue + '\'' +
                ", subValue='" + subValue + '\'' +
                ", valueSort='" + valueSort + '\'' +
                ", valueDesc='" + valueDesc + '\'' +
                ", remark='" + remark + '\'' +
                ", typeId='" + typeId + '\'' +
                '}';
    }
}