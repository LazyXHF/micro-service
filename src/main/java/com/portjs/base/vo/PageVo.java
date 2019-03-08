package com.portjs.base.vo;

public class PageVo {
    private int pageNo;
    private int pageSize;
    private String object;
    private String departmentId;
    private String uid;
    private String currentTime;

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
