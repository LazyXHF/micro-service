package com.mgt.project.Example.entity;

import java.util.Date;
import java.util.List;

public class TXietongMenuButton {
    private String id;
    private String name;
    private String parentId;
    private Integer isdelete;
    private Date createtime;
    private Integer sort;
    private Integer isleaf;
    private String path;
    private String icon;
    private String grade;
    private List<TXietongMenuResource> menuResources;

    public List<TXietongMenuResource> getMenuResources() {
        return menuResources;
    }

    public void setMenuResources(List<TXietongMenuResource> menuResources) {
        this.menuResources = menuResources;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIsleaf() {
        return isleaf;
    }

    public void setIsleaf(Integer isleaf) {
        this.isleaf = isleaf;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}