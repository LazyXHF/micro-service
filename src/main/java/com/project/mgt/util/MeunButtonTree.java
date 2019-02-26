package com.project.mgt.util;

import com.project.mgt.entity.TXietongMenuButton;
import com.project.mgt.entity.TXietongMenuResource;

import java.util.ArrayList;
import java.util.List;

public class MeunButtonTree {
    public String id ;
    public String parent_id;
    public String label;
    public int sort;
    public List<MeunButtonTree> children = new ArrayList<>();
    public int leaf;
    public  String icon;
    public  String path;
    public String grade;
    public List<TXietongMenuResource> menuResources;


    public MeunButtonTree() {
    }

    public MeunButtonTree(TXietongMenuButton menuButton) {
        id = menuButton.getId();
        label = menuButton.getName();
        parent_id = menuButton.getParentId();
        sort= menuButton.getSort();
        leaf = menuButton.getIsleaf();
        icon = menuButton.getIcon();
        path = menuButton.getPath();
        grade = menuButton.getGrade();
        menuResources = menuButton.getMenuResources();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public List<MeunButtonTree> getChildren() {
        return children;
    }

    public void setChildren(List<MeunButtonTree> children) {
        this.children = children;
    }
}
