package com.project.mgt.vo;

import com.project.mgt.entity.TXietongUser;

import java.util.List;

public class UserRoleDeparmentsVO {
    private TXietongUser tXietongUser;
    private String rid;
    private List<StatusVO> dids;
    private List<String> rids;
    private String isLeader;

    public String getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(String isLeader) {
        this.isLeader = isLeader;
    }

    public List<String> getRids() {
        return rids;
    }

    public void setRids(List<String> rids) {
        this.rids = rids;
    }

    public TXietongUser gettXietongUser() {
        return tXietongUser;
    }

    public void settXietongUser(TXietongUser tXietongUser) {
        this.tXietongUser = tXietongUser;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public List<StatusVO> getDids() {
        return dids;
    }

    public void setDids(List<StatusVO> dids) {
        this.dids = dids;
    }
}
