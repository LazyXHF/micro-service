package com.portjs.base.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ProjectBudget {
    private String id;

    private String applicationId;

    private String projectId;

    private BigDecimal laborCost;

    private String remark1;

    private BigDecimal directInput;

    private String remark2;

    private BigDecimal depreciationCost;

    private String remark3;

    private BigDecimal amortizationCharge;

    private String remark4;

    private BigDecimal designFee;

    private String remark5;

    private BigDecimal debugFee;

    private String remark6;

    private BigDecimal outsourcingCost;

    private String remark7;

    private BigDecimal otherFee;

    private String remark8;

    private BigDecimal total;

    private Date createTime;

    private String creator;

    private String modifier;

    private Date updateTime;

    private Date deleteTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId == null ? null : applicationId.trim();
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(BigDecimal laborCost) {
        if(laborCost==null){
            BigDecimal decimal = new BigDecimal(0);
            decimal=decimal.setScale(3, BigDecimal.ROUND_HALF_UP);
            this.laborCost = decimal;
        }else {
            this.laborCost = laborCost;
        }
        /*this.laborCost = laborCost;*/
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1 == null ? null : remark1.trim();
    }

    public BigDecimal getDirectInput() {
        return directInput;
    }

    public void setDirectInput(BigDecimal directInput) {
        if(directInput==null){
            BigDecimal decimal = new BigDecimal(0);
            decimal=decimal.setScale(3, BigDecimal.ROUND_HALF_UP);
            this.directInput = decimal;
        }else {
            this.directInput = directInput;
        }
        /*this.directInput = directInput;*/
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }

    public BigDecimal getDepreciationCost() {
        return depreciationCost;
    }

    public void setDepreciationCost(BigDecimal depreciationCost) {
        if(depreciationCost==null){
            BigDecimal decimal = new BigDecimal(0);
            decimal=decimal.setScale(3, BigDecimal.ROUND_HALF_UP);
            this.depreciationCost = decimal;
        }else {
            this.depreciationCost = depreciationCost;
        }
        /*this.depreciationCost = depreciationCost;*/
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }

    public BigDecimal getAmortizationCharge() {
        return amortizationCharge;
    }

    public void setAmortizationCharge(BigDecimal amortizationCharge) {
        if(amortizationCharge==null){
            BigDecimal decimal = new BigDecimal(0);
            decimal=decimal.setScale(3, BigDecimal.ROUND_HALF_UP);
            this.amortizationCharge = decimal;
        }else {
            this.amortizationCharge = amortizationCharge;
        }
        /*this.amortizationCharge = amortizationCharge;*/
    }

    public String getRemark4() {
        return remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4 == null ? null : remark4.trim();
    }

    public BigDecimal getDesignFee() {
        return designFee;
    }

    public void setDesignFee(BigDecimal designFee) {
        if(designFee==null){
            BigDecimal decimal = new BigDecimal(0);
            decimal=decimal.setScale(3, BigDecimal.ROUND_HALF_UP);
            this.designFee = decimal;
        }else {
            this.designFee = designFee;
        }
        /*this.designFee = designFee;*/
    }

    public String getRemark5() {
        return remark5;
    }

    public void setRemark5(String remark5) {
        this.remark5 = remark5 == null ? null : remark5.trim();
    }

    public BigDecimal getDebugFee() {
        return debugFee;
    }

    public void setDebugFee(BigDecimal debugFee) {
        if(debugFee==null){
            BigDecimal decimal = new BigDecimal(0);
            decimal=decimal.setScale(3, BigDecimal.ROUND_HALF_UP);
            this.debugFee = decimal;
        }else {
            this.debugFee = debugFee;
        }
        /*this.debugFee = debugFee;*/
    }

    public String getRemark6() {
        return remark6;
    }

    public void setRemark6(String remark6) {
        this.remark6 = remark6 == null ? null : remark6.trim();
    }

    public BigDecimal getOutsourcingCost() {
        return outsourcingCost;
    }

    public void setOutsourcingCost(BigDecimal outsourcingCost) {
        if(outsourcingCost==null){
            BigDecimal decimal = new BigDecimal(0);
            decimal=decimal.setScale(3, BigDecimal.ROUND_HALF_UP);
            this.outsourcingCost = decimal;
        }else {
            this.outsourcingCost = outsourcingCost;
        }
        /*this.outsourcingCost = outsourcingCost;*/
    }

    public String getRemark7() {
        return remark7;
    }

    public void setRemark7(String remark7) {
        this.remark7 = remark7 == null ? null : remark7.trim();
    }

    public BigDecimal getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(BigDecimal otherFee) {
        if(otherFee==null){
            BigDecimal decimal = new BigDecimal(0);
            decimal=decimal.setScale(3, BigDecimal.ROUND_HALF_UP);
            this.otherFee = decimal;
        }else {
            this.otherFee = otherFee;
        }
        /*this.otherFee = otherFee;*/
    }

    public String getRemark8() {
        return remark8;
    }

    public void setRemark8(String remark8) {
        this.remark8 = remark8 == null ? null : remark8.trim();
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        if(total==null){
            BigDecimal decimal = new BigDecimal(0);
            decimal=decimal.setScale(3, BigDecimal.ROUND_HALF_UP);
            this.total = decimal;
        }else {
            this.total = total;
        }
        /*this.total = total;*/
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }
}