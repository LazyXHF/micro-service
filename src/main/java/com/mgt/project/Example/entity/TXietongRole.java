package com.mgt.project.Example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class TXietongRole implements Serializable {
    private static final long serialVersionUID = 4624483415144419328L;
    private String id;

    private String roleFlag;

    private String name;

    private String code;

    private String decription;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Integer isdelete;

    List<TXietongUser> users;

    List<TXietongMenuButton> menuButtons;

    public List<TXietongMenuButton> getMenuButtons() {
        return menuButtons;
    }

    public void setMenuButtons(List<TXietongMenuButton> menuButtons) {
        this.menuButtons = menuButtons;
    }

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

    public String getRoleFlag() {
        return roleFlag;
    }

    public void setRoleFlag(String roleFlag) {
        this.roleFlag = roleFlag == null ? null : roleFlag.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription == null ? null : decription.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}