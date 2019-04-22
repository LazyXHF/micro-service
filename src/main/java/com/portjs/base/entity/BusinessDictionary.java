package com.portjs.base.entity;

public class BusinessDictionary {
    private String id;

    private String projectSchedule;

    private String projectNode;

    private String projectNodeName;

    private Integer sort;

    private String alternate1;

    private String alternate2;

    private String alternate3;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProjectSchedule() {
        return projectSchedule;
    }

    public void setProjectSchedule(String projectSchedule) {
        this.projectSchedule = projectSchedule == null ? null : projectSchedule.trim();
    }

    public String getProjectNode() {
        return projectNode;
    }

    public void setProjectNode(String projectNode) {
        this.projectNode = projectNode == null ? null : projectNode.trim();
    }

    public String getProjectNodeName() {
        return projectNodeName;
    }

    public void setProjectNodeName(String projectNodeName) {
        this.projectNodeName = projectNodeName == null ? null : projectNodeName.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getAlternate1() {
        return alternate1;
    }

    public void setAlternate1(String alternate1) {
        this.alternate1 = alternate1 == null ? null : alternate1.trim();
    }

    public String getAlternate2() {
        return alternate2;
    }

    public void setAlternate2(String alternate2) {
        this.alternate2 = alternate2 == null ? null : alternate2.trim();
    }

    public String getAlternate3() {
        return alternate3;
    }

    public void setAlternate3(String alternate3) {
        this.alternate3 = alternate3 == null ? null : alternate3.trim();
    }
}