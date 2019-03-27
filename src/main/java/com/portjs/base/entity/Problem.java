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
    //项目id
    private String projectId;
    //创建时间
    private Date creatTime;
    //创建人
    private String creater;
    //更新时间
    private Date updateTime;
    //更新人
    private String updater;

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
    //问题描述
    private String describes;
    //解决方案
    private String solution;
    //问题分类
    private String problemType;
    //提出时间
    private Date proposedTime;
    //问题优先级
    private String problemPriority;
    //提出人
    private String proposer;
    //是否解决
    private String solve;

    private static final long serialVersionUID = 1L;
}