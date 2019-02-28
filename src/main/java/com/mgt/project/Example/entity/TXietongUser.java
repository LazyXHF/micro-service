package com.mgt.project.Example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

//用户实体类
public class TXietongUser implements UserDetails {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public String toString() {
		return "TXietongUser [id=" + id + ", loginName=" + loginName
				+ ", departmentid=" + departmentid + ", nameCn=" + nameCn
				+ ", password=" + password + ", isdelete=" + isdelete
				+ ", createtime=" + createtime + ", sort=" + sort + ", status="
				+ status + ", birth=" + birth + ", politicalAff="
				+ politicalAff + ", telphone=" + telphone + ", cellphone="
				+ cellphone + ", topContacts=" + topContacts + ", sex=" + sex
				+ ", empNum=" + empNum + ", roles=" + roles + "]";
	}

	private String id;

    private String loginName;

    private String departmentid;
    private String departmentName;
    private String roleName;
    private String rid;
    private String nameCn;

    private String password;

    private Short isdelete;

    private Date createtime;

    private Integer sort;

    //1 可用  0 不可用
    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    private Date birth;

    private Integer politicalAff;

    private String telphone;

    private String cellphone;

    private String topContacts;

    private Integer sex;

    private String empNum;

    private List<TXietongRole> roles;

    private List<TXietongUser> users;
    //职级
    private String ext1;
    //职务
    private String ext2;


    //昵称首字母拼写
    private String ext3;


    //判断是否是处事负责人
    private String ext4;

    //判断是否是收发文审核人
    private String ext5;


    //是否是后勤
    @Column(name = "ext6")
    private String ext6;
    private String ext7;
    private String ext8;
    private String ext9;
    private String ext10;


    public String getExt6() {
        return ext6;
    }

    public void setExt6(String ext6) {
        this.ext6 = ext6;
    }

    public String getExt7() {
        return ext7;
    }

    public void setExt7(String ext7) {
        this.ext7 = ext7;
    }

    public String getExt8() {
        return ext8;
    }

    public void setExt8(String ext8) {
        this.ext8 = ext8;
    }

    public String getExt9() {
        return ext9;
    }

    public void setExt9(String ext9) {
        this.ext9 = ext9;
    }

    public String getExt10() {
        return ext10;
    }

    public void setExt10(String ext10) {
        this.ext10 = ext10;
    }

    //判断是否是处事负责人
    private String isLeader;

    public String getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(String isLeader) {
        this.isLeader = isLeader;
    }

    //部门领导id
    private String departmentLeadId;

    public String getDepartmentLeadId() {
        return departmentLeadId;
    }

    public void setDepartmentLeadId(String departmentLeadId) {
        this.departmentLeadId = departmentLeadId;
    }

    public String getExt4() {
        return ext4;
    }

    public void setExt4(String ext4) {
        this.ext4 = ext4;
    }

    public String getExt5() {
        return ext5;
    }

    public void setExt5(String ext5) {
        this.ext5 = ext5;
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }

    //角色状态
    private String rstatus;

    //部门状态
    private String dstatus;

    public String getRstatus() {
        return rstatus;
    }

    public void setRstatus(String rstatus) {
        this.rstatus = rstatus;
    }

    public String getDstatus() {
        return dstatus;
    }

    public void setDstatus(String dstatus) {
        this.dstatus = dstatus;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public void setRoles(List<TXietongRole> roles) {
        this.roles = roles;
    }

    public List<TXietongUser> getUsers() {
        return users;
    }

    public void setUsers(List<TXietongUser> users) {
        this.users = users;
    }

    public List<TXietongRole> getRoles() {
        return roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid == null ? null : departmentid.trim();
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn == null ? null : nameCn.trim();
    }



    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Short getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Short isdelete) {
        this.isdelete = isdelete;
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getPoliticalAff() {
        return politicalAff;
    }

    public void setPoliticalAff(Integer politicalAff) {
        this.politicalAff = politicalAff;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone == null ? null : cellphone.trim();
    }

    public String getTopContacts() {
        return topContacts;
    }

    public void setTopContacts(String topContacts) {
        this.topContacts = topContacts == null ? null : topContacts.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmpNum() {
        return empNum;
    }

    public String getPassword() {
        return password;
    }

    public void setEmpNum(String empNum) {

        this.empNum = empNum == null ? null : empNum.trim();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (roles == null){
            return authorities;
        }
        for (TXietongRole role : roles){
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }
    @Override
    public String getUsername() {
        return loginName;
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
}