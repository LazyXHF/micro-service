package com.portjs.base.vo;

public class PageVo {
    private int pageNo;
    private int pageSize;
    private String object;
    private String departmentId;
    private String uid;
    private String currentTime;
    private String name;
    private String involvedUnit;
    private String tradeNames;
    private String signState;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInvolvedUnit() {
        return involvedUnit;
    }

    public void setInvolvedUnit(String involvedUnit) {
        this.involvedUnit = involvedUnit;
    }

    public String getTradeNames() {
        return tradeNames;
    }

    public void setTradeNames(String tradeNames) {
        this.tradeNames = tradeNames;
    }

    public String getSignState() {
        return signState;
    }

    public void setSignState(String signState) {
        this.signState = signState;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "PageVo{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", object='" + object + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", uid='" + uid + '\'' +
                ", currentTime='" + currentTime + '\'' +
                '}';
    }
}
