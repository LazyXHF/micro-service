package com.mgt.project.Example.entity;

import java.util.Date;
import java.util.List;

public class TXietongDepartment {
    private String id;

    private String name;

    private String parentId;
    private String parentName;

    private Short isdelete;

    private Date createtime;

    private Integer sort;

    private String leaderId;

    private String viceLeaderId;

    private String leaderName;
    private String viceName;

    private String lstatus;
    private String vstatus;

    private String pingyin;


    private List<String> userIds;

    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }

    public String getPingyin() {
        return pingyin;
    }

    public void setPingyin(String pingyin) {
        this.pingyin = pingyin;
    }

    public String getLstatus() {
        return lstatus;
    }

    public void setLstatus(String lstatus) {
        this.lstatus = lstatus;
    }

    public String getVstatus() {
        return vstatus;
    }

    public void setVstatus(String vstatus) {
        this.vstatus = vstatus;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getViceName() {
        return viceName;
    }

    public void setViceName(String viceName) {
        this.viceName = viceName;
    }

    private Integer isleaf;

    List<TXietongUser> users;

    public List<TXietongUser> getUsers() {
        return users;
    }

    public void setUsers(List<TXietongUser> users) {
        this.users = users;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public Short getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Short isdelete) {
        this.isdelete = isdelete;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
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

    public String getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId == null ? null : leaderId.trim();
    }

    public String getViceLeaderId() {
        return viceLeaderId;
    }

    public void setViceLeaderId(String viceLeaderId) {
        this.viceLeaderId = viceLeaderId == null ? null : viceLeaderId.trim();
    }

    public Integer getIsleaf() {
        return isleaf;
    }

    public void setIsleaf(Integer isleaf) {
        this.isleaf = isleaf;
    }


    @Override
    public String toString() {
        return "TXietongDepartment{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", parentId='" + parentId + '\'' +
                ", isdelete=" + isdelete +
                ", createtime=" + createtime +
                ", sort=" + sort +
                ", leaderId='" + leaderId + '\'' +
                ", viceLeaderId='" + viceLeaderId + '\'' +
                ", isleaf=" + isleaf +
                '}';
    }


}