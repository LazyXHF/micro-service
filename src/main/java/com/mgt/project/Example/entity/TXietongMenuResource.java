package com.mgt.project.Example.entity;

import java.util.List;

public class TXietongMenuResource {
    private String id;

    private String key;

    private String url;

    private String parentid;

    private String values;

    private Integer isdelete;

    private String icon;

    private String name;

    private String bid;

    private List<TXietongRole> roles;
    private List<TXietongMenuResource> children;


    public List<TXietongMenuResource> getChildren() {
        return children;
    }

    public void setChildren(List<TXietongMenuResource> children) {
        this.children = children;
    }

    public List<TXietongRole> getRoles() {
        return roles;
    }

    public void setRoles(List<TXietongRole> roles) {
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    public String getValue() {
        return values;
    }

    public void setValue(String values) {
        this.values = values == null ? null : values.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid == null ? null : bid.trim();
    }


}