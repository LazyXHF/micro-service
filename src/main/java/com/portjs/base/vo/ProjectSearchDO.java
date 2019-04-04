package com.portjs.base.vo;

import com.portjs.base.entity.BusinessConfiguration;

import java.util.List;
import java.util.Map;

public class ProjectSearchDO {

    // private List<com.portjs.base.entity.Project> projects;

    private List<FlashProject> projectList;

    private List<BusinessConfiguration> businessConfigurationList;

    private Map situation;

    public List<BusinessConfiguration> getBusinessConfigurationList() {
        return businessConfigurationList;
    }

    public void setBusinessConfigurationList(List<BusinessConfiguration> businessConfigurationList) {
        this.businessConfigurationList = businessConfigurationList;
    }

    /*public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }*/

    public List<FlashProject> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<FlashProject> projectList) {
        this.projectList = projectList;
    }

    public Map getSituation() {
        return situation;
    }

    public void setSituation(Map situation) {
        this.situation = situation;
    }
}
