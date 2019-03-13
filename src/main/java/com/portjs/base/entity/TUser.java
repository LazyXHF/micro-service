package com.portjs.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class TUser implements UserDetails {
    private static final long serialVersionUID = 3882059233003896308L;


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

    private String nameCn;

    public List<TUser> getUsers() {
        return users;
    }

    public void setUsers(List<TUser> users) {
        this.users = users;
    }

    private List<TUser> users;


    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    private List<TRole> roles;



    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<TRole> getRoles() {
        return roles;
    }

    public void setRoles(List<TRole> roles) {
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount == null ? null : loginAccount.trim();
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
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
        this.historyPassword = historyPassword == null ? null : historyPassword.trim();
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
        this.duty = duty == null ? null : duty.trim();
    }

    public String getDutyLev() {
        return dutyLev;
    }

    public void setDutyLev(String dutyLev) {
        this.dutyLev = dutyLev == null ? null : dutyLev.trim();
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum == null ? null : phonenum.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getPingyin() {
        return pingyin;
    }

    public void setPingyin(String pingyin) {
        this.pingyin = pingyin == null ? null : pingyin.trim();
    }

    public String getReserved1() {
        return reserved1;
    }

    public void setReserved1(String reserved1) {
        this.reserved1 = reserved1 == null ? null : reserved1.trim();
    }

    public String getReserved2() {
        return reserved2;
    }

    public void setReserved2(String reserved2) {
        this.reserved2 = reserved2 == null ? null : reserved2.trim();
    }

    public String getReserved3() {
        return reserved3;
    }

    public void setReserved3(String reserved3) {
        this.reserved3 = reserved3 == null ? null : reserved3.trim();
    }

    public String getReserved4() {
        return reserved4;
    }

    public void setReserved4(String reserved4) {
        this.reserved4 = reserved4 == null ? null : reserved4.trim();
    }

    public String getReserved5() {
        return reserved5;
    }

    public void setReserved5(String reserved5) {
        this.reserved5 = reserved5 == null ? null : reserved5.trim();
    }

    public String getReserved6() {
        return reserved6;
    }

    public void setReserved6(String reserved6) {
        this.reserved6 = reserved6 == null ? null : reserved6.trim();
    }

    public String getReserved7() {
        return reserved7;
    }

    public void setReserved7(String reserved7) {
        this.reserved7 = reserved7 == null ? null : reserved7.trim();
    }

    public String getReserved8() {
        return reserved8;
    }

    public void setReserved8(String reserved8) {
        this.reserved8 = reserved8 == null ? null : reserved8.trim();
    }

    public String getReserved9() {
        return reserved9;
    }

    public void setReserved9(String reserved9) {
        this.reserved9 = reserved9 == null ? null : reserved9.trim();
    }

    public String getReserved10() {
        return reserved10;
    }

    public void setReserved10(String reserved10) {



        this.reserved10 = reserved10 == null ? null : reserved10.trim();
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (roles == null){
            return authorities;
        }
        for (TRole role : roles){
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return loginPassword;
    }

    @Override
    public String getUsername() {
        return loginAccount;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        if (status == 1){
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "TUser{" +
                "id='" + id + '\'' +
                ", loginAccount='" + loginAccount + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", loginName='" + loginName + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", createtime=" + createtime +
                ", sort=" + sort +
                ", status=" + status +
                ", lastLoginTime=" + lastLoginTime +
                ", lastUpdPasswdTime=" + lastUpdPasswdTime +
                ", passwordModifyCycle=" + passwordModifyCycle +
                ", historyPassword='" + historyPassword + '\'' +
                ", passwdWrongCount=" + passwdWrongCount +
                ", birthDate=" + birthDate +
                ", sex=" + sex +
                ", duty='" + duty + '\'' +
                ", dutyLev='" + dutyLev + '\'' +
                ", phonenum='" + phonenum + '\'' +
                ", telephone='" + telephone + '\'' +
                ", pingyin='" + pingyin + '\'' +
                ", reserved1='" + reserved1 + '\'' +
                ", reserved2='" + reserved2 + '\'' +
                ", reserved3='" + reserved3 + '\'' +
                ", reserved4='" + reserved4 + '\'' +
                ", reserved5='" + reserved5 + '\'' +
                ", reserved6='" + reserved6 + '\'' +
                ", reserved7='" + reserved7 + '\'' +
                ", reserved8='" + reserved8 + '\'' +
                ", reserved9='" + reserved9 + '\'' +
                ", reserved10='" + reserved10 + '\'' +
                ", roles=" + roles +
                '}';
    }
}