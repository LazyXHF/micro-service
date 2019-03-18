package com.portjs.base.entity;

import com.portjs.base.util.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class InternalPact extends BaseEntity {
    private String id;

    private Date uploadTime;//上传时间

    private String uploader;//上传人

    private String uploaderName;//上传人姓名

    private String involvedUnit;//涉及单位

    private String signState;//签订状态

    private String name;//合同名称

    private String tradeNames;//厂商名称

    private String fileType;//文件类型

    private Double fileSize;//文件大小

    private String fileUrl;//上传位置

    private String companyName;

    private String stageName;

    private String projectId;//项目id与internal_project对应

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

    private String enable;

    private String projectLifeType;

    private static final long serialVersionUID = 1L;
}