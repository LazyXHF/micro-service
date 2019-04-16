package com.portjs.base.vo;

import com.portjs.base.entity.TMenuResource;

import java.util.ArrayList;
import java.util.List;

public class MenuResourceTree {

    public String id ;
    public String parent_id;
    public String label;
    public int sort;
    public List<MenuResourceTree> children = new ArrayList<>();
    public int leaf;
    public  String icon;
    public  String path;
    public String grade;
    public Integer isMenuResource;
//    public List<TXietongMenuResource> menuResources;


    public MenuResourceTree() {
    }

    public MenuResourceTree(TMenuResource menuResource){
        id = menuResource.getId();
        parent_id = menuResource.getParentId();
        label = menuResource.getName();
        sort = menuResource.getSort();
        leaf = menuResource.getLeaf();
        icon = menuResource.getIcon();
        path = menuResource.getPath();
        grade = menuResource.getGrade();
        isMenuResource = menuResource.getResourceMenu();
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

    public List<MenuResourceTree> getChildren() {
        return children;
    }

    public void setChildren(List<MenuResourceTree> children) {
        this.children = children;
    }

    public int getLeaf() {
        return leaf;
    }

    public void setLeaf(int leaf) {
        this.leaf = leaf;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
