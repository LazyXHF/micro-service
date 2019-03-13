package com.portjs.base.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class InternalApproval implements Serializable {
    private String id;

    private String projectId;

    private Date creatTime;

    private String creater;

    private Date updateTime;

    private String updater;

    private String enable;

    private Date planStartTime;

    private Date planEndTime;

    private Date actualStartTime;

    private Date actualEndTime;

    private String backUp5;

    private String backUp6;

    private String backUp7;

    private String backUp8;

    private String backUp9;

    private String backUp10;

    private String unit;

    private String method;

    private Date calibrationTime;

    private String successfulBidder;

    private BigDecimal amount;

    private String biddingContent;

    private static final long serialVersionUID = 1L;


}