package com.portjs.base.entity;

import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BugDetails  {
    private String id;

    private String projectId;//项目id

    private String bugNumber;//bug编号

    private String projectedName;//项目名称

    private String type;//bug类型

    private String modules;//bug所处模块（下拉框配置）

    private String title;//bug标题

    private String content;//bug内容

    private String priority;//处理优先级

    private String status;//bug缺陷等级

    private String versionNumber;//项目版本号

    private String fileUrl;//文件路径

    private String designatedPersion;//指派人

    private String accepter;//提单人

    private Date acceptTime;//提单日期

    private Date bugCreateTime;//bug创建时间

    private Date endTime;//结单日期

    private String solution;//解决方案

    private Integer solutionResult;//bug解决结果

    private String remark;//备注

    private Integer result;//处理结果

    private String backup1;//bug出现概率

    private String backup2;

    private String backup3;

    private String backup4;

    private String backup5;

    private String backup6;

    private String backup7;

    private String backup8;

    private String backup9;

    private String backup10;

    private String backup11;

    private String backup12;

    private String backup13;

    private String backup14;

    private String backup15;

    private String reappearMethod;//重现方法

    //从表得状态
    private String rstatus;

    private String sf;



    public String getRstatus() {
        return rstatus;
    }

    public void setRstatus(String rstatus) {
        this.rstatus = rstatus;
    }

    public String getSf() {
        return sf;
    }

    public void setSf(String sf) {
        this.sf = sf;
    }

    @OneToMany
    private List<BugDetailsRecord> bugDetailsRecordList;


    public List<BugDetailsRecord> getBugDetailsRecordList() {
        return bugDetailsRecordList;
    }

    public void setBugDetailsRecordList(List<BugDetailsRecord> bugDetailsRecordList) {
        this.bugDetailsRecordList = bugDetailsRecordList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getBugNumber() {
        return bugNumber;
    }

    public void setBugNumber(String bugNumber) {
        this.bugNumber = bugNumber == null ? null : bugNumber.trim();
    }

    public String getProjectedName() {
        return projectedName;
    }

    public void setProjectedName(String projectedName) {
        this.projectedName = projectedName == null ? null : projectedName.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getModules() {
        return modules;
    }

    public void setModules(String modules) {
        this.modules = modules == null ? null : modules.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority == null ? null : priority.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber == null ? null : versionNumber.trim();
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }

    public String getDesignatedPersion() {
        return designatedPersion;
    }

    public void setDesignatedPersion(String designatedPersion) {
        this.designatedPersion = designatedPersion == null ? null : designatedPersion.trim();
    }

    public String getAccepter() {
        return accepter;
    }

    public void setAccepter(String accepter) {
        this.accepter = accepter == null ? null : accepter.trim();
    }

    public Date getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(Date acceptTime) {
        this.acceptTime = acceptTime;
    }

    public Date getBugCreateTime() {
        return bugCreateTime;
    }

    public void setBugCreateTime(Date bugCreateTime) {
        this.bugCreateTime = bugCreateTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution == null ? null : solution.trim();
    }

    public Integer getSolutionResult() {
        return solutionResult;
    }

    public void setSolutionResult(Integer solutionResult) {
        this.solutionResult = solutionResult;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
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

    public String getBackup11() {
        return backup11;
    }

    public void setBackup11(String backup11) {
        this.backup11 = backup11 == null ? null : backup11.trim();
    }

    public String getBackup12() {
        return backup12;
    }

    public void setBackup12(String backup12) {
        this.backup12 = backup12 == null ? null : backup12.trim();
    }

    public String getBackup13() {
        return backup13;
    }

    public void setBackup13(String backup13) {
        this.backup13 = backup13 == null ? null : backup13.trim();
    }

    public String getBackup14() {
        return backup14;
    }

    public void setBackup14(String backup14) {
        this.backup14 = backup14 == null ? null : backup14.trim();
    }

    public String getBackup15() {
        return backup15;
    }

    public void setBackup15(String backup15) {
        this.backup15 = backup15 == null ? null : backup15.trim();
    }

    public String getReappearMethod() {
        return reappearMethod;
    }

    public void setReappearMethod(String reappearMethod) {
        this.reappearMethod = reappearMethod == null ? null : reappearMethod.trim();
    }
}