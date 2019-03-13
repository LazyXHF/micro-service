package com.portjs.base.entity;

public class TXietongUserMinisterRelation {
    private String id;

    private String ministerId;

    private String visualId;

    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMinisterId() {
        return ministerId;
    }

    public void setMinisterId(String ministerId) {
        this.ministerId = ministerId == null ? null : ministerId.trim();
    }

    public String getVisualId() {
        return visualId;
    }

    public void setVisualId(String visualId) {
        this.visualId = visualId == null ? null : visualId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}