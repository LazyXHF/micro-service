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

    private String projectId;

    private Date creatTime;

    private String creater;

    private Date updateTime;

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

    private String describe;

    private String solution;

    private String problemType;

    private Date proposedTime;

    private String problemPriority;

    private String proposer;

    private String solve;

    private static final long serialVersionUID = 1L;
}