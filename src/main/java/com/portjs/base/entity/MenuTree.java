package com.portjs.base.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dengshuangzhen on 2018\11\28 0028
 */
public class MenuTree {
    private String id;
    private String discussant;

    private Date replytime;

    private String parent_id;

    private String content;
    public List<MenuTree> children = new ArrayList<>();
    public MenuTree(){ }
    public MenuTree(CommunicationLog log){
        id = log.getId();
        discussant = log.getDiscussant();
        replytime = log.getReplytime();
        parent_id=log.getPreMessage();
        content=log.getContent();
    }

    public String getDiscussant() {
        return discussant;
    }

    public void setDiscussant(String discussant) {
        this.discussant = discussant;
    }

    public Date getReplytime() {
        return replytime;
    }

    public void setReplytime(Date replytime) {
        this.replytime = replytime;
    }



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<MenuTree> getChildren() {
        return children;
    }

    public void setChildren(List<MenuTree> children) {
        this.children = children;
    }

    public String getId(){return id;}

    public void setId(String id){this.id = id;}

    public String getParent_id(){return parent_id;}

    public void setParent_id(String parent_id){this.parent_id = parent_id;}

    @Override
    public String toString() {
        return "MenuTree{" +
                "id='" + id + '\'' +
                ", discussant='" + discussant + '\'' +
                ", replytime=" + replytime +
                ", parent_id='" + parent_id + '\'' +
                ", content='" + content + '\'' +
                ", children=" + children +
                '}';
    }
}

