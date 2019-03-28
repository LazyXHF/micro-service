package com.portjs.base.vo;

import com.portjs.base.entity.BugDetails;
import com.portjs.base.entity.InternalProject;

import java.util.List;
import java.util.Map;

public class BugSearchDO {
    private List<InternalProject> projects;

    private List<Project> projectList;

    private List<Bug> bugDetailsList;

    private Map situation;


    public List<Bug> getBugDetailsList() {
        return bugDetailsList;
    }

    public void setBugDetailsList(List<Bug> bugDetailsList) {
        this.bugDetailsList = bugDetailsList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public List<InternalProject> getProjects() {
        return projects;
    }

    public void setProjects(List<InternalProject> projects) {
        this.projects = projects;
    }

    public Map getSituation() {
        return situation;
    }

    public void setSituation(Map situation) {
        this.situation = situation;
    }
}
