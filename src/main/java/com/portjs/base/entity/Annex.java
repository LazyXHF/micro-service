package com.portjs.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.portjs.base.util.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gumingyang
 * 附件
 */
@Data
public class Annex extends BaseEntity {
    private String id;

    private Date uploadTime;//上传时间

    private String uploader;//上传人

    private String modifer;//修改人

    private Date modifyTime;//修改时间

    private String node;//1:开发2:设计3:试点实施4:立项

    private String fileUrl;//上传路径

    private String fileModule;//节点下的模块

    private String fileType;//文件类型

    private String fileName;//文件名

    private Double fileSize;//文件大小

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