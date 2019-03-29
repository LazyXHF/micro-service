package com.portjs.base.entity;

import java.util.Date;

public class InternalAttachment {
    private String id;

    private Date uploadTime;//上传时间

    private String uploader;//上传人

    private String modifer;//修改人

    private Date modifyTime;//修改时间

    private String relateddomain;//对应的业务模块

    private String fileUrl;//上传路径

    private String fileModule;//对应的文件类目

    private String relateddomainId;//业务单id

    private String fileType;//文件类型

    private String fileName;//文件名

    private Double fileSize;//文件大小

    private String enable;//可用"1"不可用"0"

    private String sort;//排序

    private String backUp2;

    private String backUp3;

    private String backUp4;

    private String backUp5;

    private String backUp6;

    private String backUp7;

    private String backUp8;

    private String backUp9;

    private String backUp10;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader == null ? null : uploader.trim();
    }

    public String getModifer() {
        return modifer;
    }

    public void setModifer(String modifer) {
        this.modifer = modifer == null ? null : modifer.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getRelateddomain() {
        return relateddomain;
    }

    public void setRelateddomain(String relateddomain) {
        this.relateddomain = relateddomain == null ? null : relateddomain.trim();
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }

    public String getFileModule() {
        return fileModule;
    }

    public void setFileModule(String fileModule) {
        this.fileModule = fileModule == null ? null : fileModule.trim();
    }

    public String getRelateddomainId() {
        return relateddomainId;
    }

    public void setRelateddomainId(String relateddomainId) {
        this.relateddomainId = relateddomainId == null ? null : relateddomainId.trim();
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public Double getFileSize() {
        return fileSize;
    }

    public void setFileSize(Double fileSize) {
        this.fileSize = fileSize;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable == null ? null : enable.trim();
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    public String getBackUp2() {
        return backUp2;
    }

    public void setBackUp2(String backUp2) {
        this.backUp2 = backUp2 == null ? null : backUp2.trim();
    }

    public String getBackUp3() {
        return backUp3;
    }

    public void setBackUp3(String backUp3) {
        this.backUp3 = backUp3 == null ? null : backUp3.trim();
    }

    public String getBackUp4() {
        return backUp4;
    }

    public void setBackUp4(String backUp4) {
        this.backUp4 = backUp4 == null ? null : backUp4.trim();
    }

    public String getBackUp5() {
        return backUp5;
    }

    public void setBackUp5(String backUp5) {
        this.backUp5 = backUp5 == null ? null : backUp5.trim();
    }

    public String getBackUp6() {
        return backUp6;
    }

    public void setBackUp6(String backUp6) {
        this.backUp6 = backUp6 == null ? null : backUp6.trim();
    }

    public String getBackUp7() {
        return backUp7;
    }

    public void setBackUp7(String backUp7) {
        this.backUp7 = backUp7 == null ? null : backUp7.trim();
    }

    public String getBackUp8() {
        return backUp8;
    }

    public void setBackUp8(String backUp8) {
        this.backUp8 = backUp8 == null ? null : backUp8.trim();
    }

    public String getBackUp9() {
        return backUp9;
    }

    public void setBackUp9(String backUp9) {
        this.backUp9 = backUp9 == null ? null : backUp9.trim();
    }

    public String getBackUp10() {
        return backUp10;
    }

    public void setBackUp10(String backUp10) {
        this.backUp10 = backUp10 == null ? null : backUp10.trim();
    }
}