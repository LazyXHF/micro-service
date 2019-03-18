package com.portjs.base.entity;

import com.portjs.base.util.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 项目立项
 */
@Data
public class Approval extends BaseEntity{
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

    private String unit;//涉及单位

    private String method;//招标方式

    private Date calibrationTime;//定标时间

    private String successfulBidder;//中标厂商

    private BigDecimal amount;//中标金额

    private String biddingContent;//招标内容

    private Date planStartTime;//计划开始时间

    private Date planEndTime;//计划结束时间

    private Date actualStartTime;//实际开始时间

    private Date actualEndTime;//实际结束时间

    private static final long serialVersionUID = 1L;
}