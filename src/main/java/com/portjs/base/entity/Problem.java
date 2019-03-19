package com.portjs.base.entity;

import com.portjs.base.util.BaseEntity;
import lombok.Data;
import java.util.Date;

/**
 * 项目问题
 */
@Data
public class Problem extends BaseEntity {
    private String id;

    private String projectId;//项目id

    private Date creatTime;//创建时间

    private String creater;//创建人

    private Date updateTime;//更新时间

    private String updater;//更新人

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

    private String backUp10;

    private String describes;//问题描述

    private String solution;//解决方案

    private String problemType;//问题分类

    private Date proposedTime;//提出时间

    private String problemPriority;//问题优先级

    private String proposer;//提出人

    private String solve;//是否解决

    private static final long serialVersionUID = 1L;
}