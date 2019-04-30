package com.portjs.base.entity;

import java.util.Date;

public class TStuff {
    private String id;

    private String name;

    private String sex;

    private String birthday;

    private String degree;

    private String tel;

    private String mobile;

    private String email;

    private String photo;

    private String status;

    private String createUser;

    private Date createTime;

    private String modifyUser;

    private Date modifyTime;

    private Date deleteTime;

    private String pingyin;

    private String remakes1;

    private String remakes2;

    private String remakes3;

    private String remakes4;

    private Date remakes5;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree == null ? null : degree.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser == null ? null : modifyUser.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getPingyin() {
        return pingyin;
    }

    public void setPingyin(String pingyin) {
        this.pingyin = pingyin == null ? null : pingyin.trim();
    }

    public String getRemakes1() {
        return remakes1;
    }

    public void setRemakes1(String remakes1) {
        this.remakes1 = remakes1 == null ? null : remakes1.trim();
    }

    public String getRemakes2() {
        return remakes2;
    }

    public void setRemakes2(String remakes2) {
        this.remakes2 = remakes2 == null ? null : remakes2.trim();
    }

    public String getRemakes3() {
        return remakes3;
    }

    public void setRemakes3(String remakes3) {
        this.remakes3 = remakes3 == null ? null : remakes3.trim();
    }

    public String getRemakes4() {
        return remakes4;
    }

    public void setRemakes4(String remakes4) {
        this.remakes4 = remakes4 == null ? null : remakes4.trim();
    }

    public Date getRemakes5() {
        return remakes5;
    }

    public void setRemakes5(Date remakes5) {
        this.remakes5 = remakes5;
    }
}