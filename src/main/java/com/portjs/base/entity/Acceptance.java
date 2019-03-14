package com.portjs.base.entity;

import com.portjs.base.util.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * 项目建设
 */
@Data
public class Acceptance extends BaseEntity {
    private String id;

    private String projectId;//项目id

    private String acceptanceForm;//验收形式

    private String acceptanceMethod;//验收方式

    private String acceptanceCharge;//验收负责人

    private Date completionTime;//计划完成日期

    private Date experimentalTime;//实验收时间

    private String problem;//遗留问题

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

    private Date creatTime;//创建时间

    private String creater;//创建人

    private Date updateTime;//更新时间

    private String updater;//更新人

    private static final long serialVersionUID = 1L;
}