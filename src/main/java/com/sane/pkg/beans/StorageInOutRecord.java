package com.sane.pkg.beans;

import java.util.Date;

public class StorageInOutRecord {
    private Integer inOutID;

    private String inOutCode;

    private String productCode;

    private Integer quantity;

    private Integer formerQuantity;

    private String storageType;

    private String inOutType;

    private Date createDate;

    private String creator;

    private String remark;

    public Integer getInOutID() {
        return inOutID;
    }

    public void setInOutID(Integer inOutID) {
        this.inOutID = inOutID;
    }

    public String getInOutCode() {
        return inOutCode;
    }

    public void setInOutCode(String inOutCode) {
        this.inOutCode = inOutCode == null ? null : inOutCode.trim();
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getFormerQuantity() {
        return formerQuantity;
    }

    public void setFormerQuantity(Integer formerQuantity) {
        this.formerQuantity = formerQuantity;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType == null ? null : storageType.trim();
    }

    public String getInOutType() {
        return inOutType;
    }

    public void setInOutType(String inOutType) {
        this.inOutType = inOutType == null ? null : inOutType.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}