package com.portjs.base.entity;

import org.apache.ibatis.type.Alias;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by dengshuangzhen on 2019\2\17 0017
 */
@Entity
@Table(name = "t_xietong_agenda_process")
@Alias(value = "TXietongAgendaProcess")
public class TXietongAgendaProcess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private Integer isdelete;

    private Integer status;

    private Date createtime;

    private String createrId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId;
    }

    @Override
    public String toString() {
        return "TXietongAgendaProcess{" +
                "id='" + id + '\'' +
                ", isdelete=" + isdelete +
                ", status=" + status +
                ", createtime=" + createtime +
                ", createrId='" + createrId + '\'' +
                '}';
    }
}
