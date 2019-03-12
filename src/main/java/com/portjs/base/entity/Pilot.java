package com.portjs.base.entity;

import com.portjs.base.util.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目建设试点实施
 */
@Data
public class Pilot extends BaseEntity {
    private String id;

    private String projectId;//项目id

   private Date planStartTime;//计划开始时间

    private Date planEndTime;//计划结束时间

    private Date actualStartTime;//实际开始时间

    private Date actualEndTime;//实际结束时间

    private Date testPassTime;//试运行测试完成时间

    private Date lineTime;//上线试运行时间

    private Date testTime;//试运行验收时间

    private String testPerson;//试点实施人员

    private String testUnit;//试点实施单位

    private String testLeader;//试点实施负责人

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

    private static final long serialVersionUID = 1L;
}