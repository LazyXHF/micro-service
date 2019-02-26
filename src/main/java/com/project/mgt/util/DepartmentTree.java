package com.project.mgt.util;

import com.project.mgt.entity.TXietongDepartment;
import com.project.mgt.entity.TXietongUser;

import java.util.ArrayList;
import java.util.List;

public class DepartmentTree {
    public String id ;
    public String parent_id;
    public String partmentName;
    public String label;
    public int sort;
    public String lead_id;
    public String fu_id;
    public String leadName;
    public String viceName;
    public List<DepartmentTree> children = new ArrayList<>();
    public List<TXietongUser> users;


    public String getPartmentName() {
        return partmentName;
    }

    public void setPartmentName(String partmentName) {
        this.partmentName = partmentName;
    }

    public String getLead_id() {
        return lead_id;
    }

    public void setLead_id(String lead_id) {
        this.lead_id = lead_id;
    }

    public String getFu_id() {
        return fu_id;
    }

    public void setFu_id(String fu_id) {
        this.fu_id = fu_id;
    }

    public String getLeadName() {
        return leadName;
    }

    public void setLeadName(String leadName) {
        this.leadName = leadName;
    }

    public String getViceName() {
        return viceName;
    }

    public void setViceName(String viceName) {
        this.viceName = viceName;
    }

    public List<TXietongUser> getUsers() {
        return users;
    }

    public void setUsers(List<TXietongUser> users) {
        this.users = users;
    }

    public DepartmentTree(TXietongDepartment department) {
        id = department.getId();
        label = department.getName();
        parent_id = department.getParentId();
        sort= department.getSort();
        leaf = department.getIsleaf();
        partmentName = department.getParentName();
        lead_id = department.getLeaderId();
        fu_id = department.getViceLeaderId();
        users = department.getUsers();
        leadName = department.getLeaderName();
        viceName = department.getViceName();
    }


    public int leaf;

    public int getLeaf() {
        return leaf;
    }

    public void setLeaf(int leaf) {
        this.leaf = leaf;
    }

    public DepartmentTree() {
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

    public List<DepartmentTree> getChildren() {
        return children;
    }

    public void setChildren(List<DepartmentTree> children) {
        this.children = children;
    }


}
