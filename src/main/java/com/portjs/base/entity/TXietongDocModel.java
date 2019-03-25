package com.portjs.base.entity;

import org.apache.ibatis.type.Alias;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_xietong_doc_model")
@Alias(value = "TXietongDocModel")
public class TXietongDocModel {
	private static final long serialVersionUID = -8304467058421560175L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String docName;

    private String docDescription;

    private String downloadPath;

    private Integer downloadTimes;

    private Integer isdelete;

    private Date createtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName == null ? null : docName.trim();
    }

    public String getDocDescription() {
        return docDescription;
    }

    public void setDocDescription(String docDescription) {
        this.docDescription = docDescription == null ? null : docDescription.trim();
    }

    public String getDownloadPath() {
        return downloadPath;
    }

    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath == null ? null : downloadPath.trim();
    }

    public Integer getDownloadTimes() {
        return downloadTimes;
    }

    public void setDownloadTimes(Integer downloadTimes) {
        this.downloadTimes = downloadTimes;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}