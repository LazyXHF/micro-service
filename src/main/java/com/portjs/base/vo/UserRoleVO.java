package com.portjs.base.vo;

import com.portjs.base.entity.TUser;

import java.util.List;

public class UserRoleVO {
    private TUser user ;
    private List<String> rids;
    private List<String> dids;

    public List<String> getDids() {
        return dids;
    }

    public void setDids(List<String> dids) {
        this.dids = dids;
    }

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
}
