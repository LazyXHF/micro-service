package com.portjs.base.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.portjs.base.entity.TDepartment;
import com.portjs.base.entity.TRole;
import com.portjs.base.entity.TUser;

import java.util.Date;
import java.util.List;

/**
 * 用户角色部门
 */
public class UserRoleDO  {



    private String id;

    private String loginAccount;

    private String loginPassword;

    private String loginName;

    private String departmentId;
    //部门名字
    private String departmentName;

    private Date createtime;

    private Integer sort;

    private Integer status;

    private Date lastLoginTime;

    private Date lastUpdPasswdTime;

    private Integer passwordModifyCycle;

    private String historyPassword;

    private Integer passwdWrongCount;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    private Integer sex;

    private String duty;

    private String dutyLev;

    private String phonenum;

    private String telephone;

    private String pingyin;


    private String nameCn;



    private String reserved1;

    private String reserved2;

    private String reserved3;

    private String reserved4;

    private String reserved5;

    private String reserved6;

    private String reserved7;

    private String reserved8;

    private String reserved9;

    private String reserved10;




    private String isLeader;
    private List<TRole> roles;

    private List<TDepartment> departments;

    //部门负责人名字
    private String leaderId;
//    //部门负责人id
//    private String leaderName;


    public List<TDepartment> getDepartments() {
        return departments;
    }

    public void setDepartments(List<TDepartment> departments) {
        this.departments = departments;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getLeaderId() {
        return leaderId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getLastUpdPasswdTime() {
        return lastUpdPasswdTime;
    }

    public void setLastUpdPasswdTime(Date lastUpdPasswdTime) {
        this.lastUpdPasswdTime = lastUpdPasswdTime;
    }

    public Integer getPasswordModifyCycle() {
        return passwordModifyCycle;
    }

    public void setPasswordModifyCycle(Integer passwordModifyCycle) {
        this.passwordModifyCycle = passwordModifyCycle;
    }

    public String getHistoryPassword() {
        return historyPassword;
    }

    public void setHistoryPassword(String historyPassword) {
        this.historyPassword = historyPassword;
    }

    public Integer getPasswdWrongCount() {
        return passwdWrongCount;
    }

    public void setPasswdWrongCount(Integer passwdWrongCount) {
        this.passwdWrongCount = passwdWrongCount;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getDutyLev() {
        return dutyLev;
    }

    public void setDutyLev(String dutyLev) {
        this.dutyLev = dutyLev;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPingyin() {
        return pingyin;
    }

    public void setPingyin(String pingyin) {
        this.pingyin = pingyin;
    }

    public String getReserved1() {
        return reserved1;
    }

    public void setReserved1(String reserved1) {
        this.reserved1 = reserved1;
    }

    public String getReserved2() {
        return reserved2;
    }

    public void setReserved2(String reserved2) {
        this.reserved2 = reserved2;
    }

    public String getReserved3() {
        return reserved3;
    }

    public void setReserved3(String reserved3) {
        this.reserved3 = reserved3;
    }

    public String getReserved4() {
        return reserved4;
    }

    public void setReserved4(String reserved4) {
        this.reserved4 = reserved4;
    }

    public String getReserved5() {
        return reserved5;
    }

    public void setReserved5(String reserved5) {
        this.reserved5 = reserved5;
    }

    public String getReserved6() {
        return reserved6;
    }

    public void setReserved6(String reserved6) {
        this.reserved6 = reserved6;
    }

    public String getReserved7() {
        return reserved7;
    }

    public void setReserved7(String reserved7) {
        this.reserved7 = reserved7;
    }

    public String getReserved8() {
        return reserved8;
    }

    public void setReserved8(String reserved8) {
        this.reserved8 = reserved8;
    }

    public String getReserved9() {
        return reserved9;
    }

    public void setReserved9(String reserved9) {
        this.reserved9 = reserved9;
    }

    public String getReserved10() {
        return reserved10;
    }

    public void setReserved10(String reserved10) {
        this.reserved10 = reserved10;
    }

    public String getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(String isLeader) {
        this.isLeader = isLeader;
    }

    public List<TRole> getRoles() {
        return roles;
    }

    public void setRoles(List<TRole> roles) {
        this.roles = roles;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId;
    }
}
