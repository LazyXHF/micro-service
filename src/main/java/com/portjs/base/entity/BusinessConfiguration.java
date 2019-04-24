package com.portjs.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class BusinessConfiguration {
    private String id;

    private String projectType;

    private String schedule;

    private String node;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    private String creator;

    private String modifier;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date deleteTime;

    private String projectSchedule;

    private String projectId;

    private String projectNode;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date predictStarttime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date pridectEndtime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date actualStarttime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date actualEndtime;

    private String proNode;

    private String projectNodeName;

    private String projectStatus;

    private String content;

    private String projectName;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getProNode() {
        return proNode;
    }

    public void setProNode(String proNode) {
        this.proNode = proNode;
    }

    public String getProjectNodeName() {
        return projectNodeName;
    }

    public void setProjectNodeName(String projectNodeName) {
        this.projectNodeName = projectNodeName;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType == null ? null : projectType.trim();
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule == null ? null : schedule.trim();
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node == null ? null : node.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
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

    public String getProjectSchedule() {
        return projectSchedule;
    }

    public void setProjectSchedule(String projectSchedule) {
        this.projectSchedule = projectSchedule == null ? null : projectSchedule.trim();
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getProjectNode() {
        return projectNode;
    }

    public void setProjectNode(String projectNode) {
        this.projectNode = projectNode == null ? null : projectNode.trim();
    }

    public Date getPredictStarttime() {
        return predictStarttime;
    }

    public void setPredictStarttime(Date predictStarttime) {
        this.predictStarttime = predictStarttime;
    }

    public Date getPridectEndtime() {
        return pridectEndtime;
    }

    public void setPridectEndtime(Date pridectEndtime) {
        this.pridectEndtime = pridectEndtime;
    }

    public Date getActualStarttime() {
        return actualStarttime;
    }

    public void setActualStarttime(Date actualStarttime) {
        this.actualStarttime = actualStarttime;
    }

    public Date getActualEndtime() {
        return actualEndtime;
    }

    public void setActualEndtime(Date actualEndtime) {
        this.actualEndtime = actualEndtime;
    }
}