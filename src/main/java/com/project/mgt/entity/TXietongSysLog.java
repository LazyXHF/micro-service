package com.project.mgt.entity;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_xietong_sys_log")
@Alias(value = "TXietongSysLog")
public class TXietongSysLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private Integer isdelete;
@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date exittime;

    private String lasttime;
    @Column(name = "operator_name")
    private String operatorName;
    @Column(name = "operator_id")
    private String operatorId;
    @Column(name = "request_url")
    private String requestUrl;
    @Column(name = "method_name")
    private String methodName;
    @Column(name = "method_info")
    private String methodInfo;
    @Column(name = "request_message")
    private String requestMessage;
    @Column(name = "response_message")
    private String responseMessage;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getExittime() {
        return exittime;
    }

    public void setExittime(Date exittime) {
        this.exittime = exittime;
    }

    public String getLasttime() {
        return lasttime;
    }

    public void setLasttime(String lasttime) {
        this.lasttime = lasttime == null ? null : lasttime.trim();
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl == null ? null : requestUrl.trim();
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodInfo() {
        return methodInfo;
    }

    public void setMethodInfo(String methodInfo) {
        this.methodInfo = methodInfo;
    }

    public String getRequestMessage() {
        return requestMessage;
    }

    public void setRequestMessage(String requestMessage) {
        this.requestMessage = requestMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}