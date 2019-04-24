package com.portjs.base.entity;

import java.util.Date;

/**
 * @author: daiyueyuan
 * @date: 2019/4/24 14:26
 * @description:
 */
public class ProjectVo {
    private String projectName;
    private String projectId;
    private String projectSchedule;
    private String content;
    private Date predictStarttime;
    private Date predictEndtime;
//    private String schedule;
    private String projectCode;
    private String projectType;
    private String leval;
    private String projectManager;
    private String status;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getLeval() {
        return leval;
    }

    public void setLeval(String leval) {
        this.leval = leval;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectSchedule() {
        return projectSchedule;
    }

    public void setProjectSchedule(String projectSchedule) {
        this.projectSchedule = projectSchedule;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPredictStarttime() {
        return predictStarttime;
    }

    public void setPredictStarttime(Date predictStarttime) {
        this.predictStarttime = predictStarttime;
    }

    public Date getPredictEndtime() {
        return predictEndtime;
    }

    public void setPredictEndtime(Date predictEndtime) {
        this.predictEndtime = predictEndtime;
    }

//    public String getSchedule() {
//        return schedule;
//    }
//
//    public void setSchedule(String schedule) {
//        this.schedule = schedule;
//    }
}
