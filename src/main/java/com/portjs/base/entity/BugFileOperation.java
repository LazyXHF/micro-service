package com.portjs.base.entity;

import java.io.Serializable;

public class BugFileOperation implements Serializable {
    private String id;

    private String bugId;

    private String fileName;

    private Double fileSize;

    private String fileStatus;

    private String backup1;

    private String backup2;

    private String backup3;

    private String backup4;

    private String backup5;

    private String backup6;

    private String backup7;

    private String backup8;

    private String backup9;

    private String backup10;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBugId() {
        return bugId;
    }

    public void setBugId(String bugId) {
        this.bugId = bugId == null ? null : bugId.trim();
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

    public String getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(String fileStatus) {
        this.fileStatus = fileStatus == null ? null : fileStatus.trim();
    }

    public String getBackup1() {
        return backup1;
    }

    public void setBackup1(String backup1) {
        this.backup1 = backup1 == null ? null : backup1.trim();
    }

    public String getBackup2() {
        return backup2;
    }

    public void setBackup2(String backup2) {
        this.backup2 = backup2 == null ? null : backup2.trim();
    }

    public String getBackup3() {
        return backup3;
    }

    public void setBackup3(String backup3) {
        this.backup3 = backup3 == null ? null : backup3.trim();
    }

    public String getBackup4() {
        return backup4;
    }

    public void setBackup4(String backup4) {
        this.backup4 = backup4 == null ? null : backup4.trim();
    }

    public String getBackup5() {
        return backup5;
    }

    public void setBackup5(String backup5) {
        this.backup5 = backup5 == null ? null : backup5.trim();
    }

    public String getBackup6() {
        return backup6;
    }

    public void setBackup6(String backup6) {
        this.backup6 = backup6 == null ? null : backup6.trim();
    }

    public String getBackup7() {
        return backup7;
    }

    public void setBackup7(String backup7) {
        this.backup7 = backup7 == null ? null : backup7.trim();
    }

    public String getBackup8() {
        return backup8;
    }

    public void setBackup8(String backup8) {
        this.backup8 = backup8 == null ? null : backup8.trim();
    }

    public String getBackup9() {
        return backup9;
    }

    public void setBackup9(String backup9) {
        this.backup9 = backup9 == null ? null : backup9.trim();
    }

    public String getBackup10() {
        return backup10;
    }

    public void setBackup10(String backup10) {
        this.backup10 = backup10 == null ? null : backup10.trim();
    }
}