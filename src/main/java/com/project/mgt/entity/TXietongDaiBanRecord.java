package com.project.mgt.entity;

import org.apache.ibatis.type.Alias;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: daiyueyuan
 * @date: 2019/1/24 10:21
 * @description:
 */
@Entity
@Table(name = "t_xietong_daiban_record")
@Alias(value = "daibanRecord")
public class TXietongDaiBanRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String recordId;
    private String recordContent;
    private String type;
    private String ownerId;
    private int status;
    private Date creatTime;
    private int is_Urgent;
    private String EXT1;
    private String EXT2;
    private String EXT3;
    private String EXT4;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getRecordContent() {
        return recordContent;
    }

    public void setRecordContent(String recordContent) {
        this.recordContent = recordContent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public int getIs_Urgent() {
        return is_Urgent;
    }

    public void setIs_Urgent(int is_Urgent) {
        this.is_Urgent = is_Urgent;
    }

    public String getEXT1() {
        return EXT1;
    }

    public void setEXT1(String EXT1) {
        this.EXT1 = EXT1;
    }

    public String getEXT2() {
        return EXT2;
    }

    public void setEXT2(String EXT2) {
        this.EXT2 = EXT2;
    }

    public String getEXT3() {
        return EXT3;
    }

    public void setEXT3(String EXT3) {
        this.EXT3 = EXT3;
    }

    public String getEXT4() {
        return EXT4;
    }

    public void setEXT4(String EXT4) {
        this.EXT4 = EXT4;
    }

    @Override
    public String toString() {
        return "TXietongDaiBanRecord{" +
                "id='" + id + '\'' +
                ", recordId='" + recordId + '\'' +
                ", recordContent='" + recordContent + '\'' +
                ", type='" + type + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", status=" + status +
                ", creatTime=" + creatTime +
                ", is_Urgent=" + is_Urgent +
                ", EXT1='" + EXT1 + '\'' +
                ", EXT2='" + EXT2 + '\'' +
                ", EXT3='" + EXT3 + '\'' +
                ", EXT4='" + EXT4 + '\'' +
                '}';
    }
}
