package com.project.mgt.util;

import com.project.mgt.entity.TXietongUser;

import java.util.ArrayList;
import java.util.List;

public class DepartmentAndUser {
    public String id ;
    public String parent_id;
    public String partmentName;
    public String label;
    public int sort;
    public List<DepartmentTree> children = new ArrayList<>();
    public List<TXietongUser> users;

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

    public String getPartmentName() {
        return partmentName;
    }

    public void setPartmentName(String partmentName) {
        this.partmentName = partmentName;
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

    public List<DepartmentTree> getChildren() {
        return children;
    }

    public void setChildren(List<DepartmentTree> children) {
        this.children = children;
    }

    public List<TXietongUser> getUsers() {
        return users;
    }

    public void setUsers(List<TXietongUser> users) {
        this.users = users;
    }
}
