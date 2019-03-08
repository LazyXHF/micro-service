package com.portjs.base.entity;

import com.portjs.base.util.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Design extends BaseEntity {

    private String id;

    private String projectId;//项目id

    private String unit;//设计单位

    private Date planStartTime;//计划开始时间

    private Date planEndTime;//计划结束时间

    private Date actualStartTime;//实际开始时间

    private Date actualEndTime;//实际结束时间

    private Date reviewTime;//评审时间

    private String enable;//数据是否可用0可用1不可用默认0

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