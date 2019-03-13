package com.portjs.base.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class InternalProject implements Serializable {
    private String id;

    private Date createTime;

    private String creater;

    private Date modifyTime;

    private String modifer;

    private String type;

    private String name;

    private String leader;

    private String leaderName;

    private String leaderTell;

    private String status;

    private String responsibleUnit;

    private String responsibleUnitId;

    private String range;

    private String meeting;

    private String content;

    private String enable;

    private String backUp1;

    private String backUp2;

    private String backUp3;

    private String backUp4;

    private String backUp5;

    private String backUp6;

    private String backUp7;

    private String backUp8;

    private String backUp9;

    private String projectType;

    private List<InternalPersionResource> list;

    /*public InternalPersionResource getInternalPersionResource1() {
        return internalPersionResource1;
    }

    public void setInternalPersionResource1(InternalPersionResource internalPersionResource1) {
        this.internalPersionResource1 = internalPersionResource1;
    }*/

    private static final long serialVersionUID = 1L;

}