package com.sane.pkg.beans;

import java.util.Date;

public class CustomerBill {
    private Integer storageProductBillId;

    private String storageProductBillCode;

    private Double quantity;

    private Double totalPrice;

    private String customerCode;

    private String billStatus;

    private Double outQuantity;

    private Date createDate;

    private String creator;

    private Date modifyDate;

    private String modifyer;

    public Integer getStorageProductBillId() {
        return storageProductBillId;
    }

    public void setStorageProductBillId(Integer storageProductBillId) {
        this.storageProductBillId = storageProductBillId;
    }

    public String getStorageProductBillCode() {
        return storageProductBillCode;
    }

    public void setStorageProductBillCode(String storageProductBillCode) {
        this.storageProductBillCode = storageProductBillCode == null ? null : storageProductBillCode.trim();
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode == null ? null : customerCode.trim();
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus == null ? null : billStatus.trim();
    }

    public Double getOutQuantity() {
        return outQuantity;
    }

    public void setOutQuantity(Double outQuantity) {
        this.outQuantity = outQuantity;
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

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyer() {
        return modifyer;
    }

    public void setModifyer(String modifyer) {
        this.modifyer = modifyer == null ? null : modifyer.trim();
    }
}