package com.portjs.base.entity;

import com.portjs.base.util.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 招标的采购清单
 */
@Data
public class TenderApplicationVo extends BaseEntity{
    private String projectCode;//项目编号

    private String projectName;//项目名称

    private Integer requestId;//采购申请单id

    private String tenderNum;//采购申请单单号（PR+YYMMDD+2位流水码）

    private String projectId;//项目id

    private String method;//采购方式1:公开招标、2:邀请招标、

    private String dept;//采购部门

    private Date applyDate;//申请日期

    private BigDecimal amount;//采购预算(万元)

}