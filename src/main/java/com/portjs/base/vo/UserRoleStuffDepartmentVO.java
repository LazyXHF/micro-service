package com.portjs.base.vo;

import com.portjs.base.entity.TStuff;
import com.portjs.base.entity.TUser;

import java.util.List;

/**
 * 员工和部门
 */
public class UserRoleStuffDepartmentVO {
    //用户信息
    private TUser user;
    //角色id
    private List<String> rids;
    //员工人员信息
    private TStuff stuff;
    //部门id
    private List<String> dids;


    public TUser getUser() {
        return user;
    }

    public void setUser(TUser user) {
        this.user = user;
    }

    public List<String> getRids() {
        return rids;
    }

    public void setRids(List<String> rids) {
        this.rids = rids;
    }

    public TStuff getStuff() {
        return stuff;
    }

    public void setStuff(TStuff stuff) {
        this.stuff = stuff;
    }

    public List<String> getDids() {
        return dids;
    }

    public void setDids(List<String> dids) {
        this.dids = dids;
    }
}
