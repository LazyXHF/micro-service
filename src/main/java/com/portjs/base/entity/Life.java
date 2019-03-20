package com.portjs.base.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 生命周期
 */
@Data
public class Life implements Serializable {
    private String id;

    private String projectId;//项目id

    private String node;//节点1.立项2.合同签订3.需求分析4.开发测试5.试运行6验收

    private String status;//状态1.滞后2.即将到期3.已完成

    private Date createTime;//创建时间

    private String creator;//创建人

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

    private Date updateTime;//更新时间

    private String updater;//更新人

    private String enable;

    private static final long serialVersionUID = 1L;
}