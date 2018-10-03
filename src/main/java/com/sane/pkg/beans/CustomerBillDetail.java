package com.sane.pkg.beans;

public class CustomerBillDetail {
    private Integer billDetailId;

    private String storageProductBillCode;

    private String productCode;

    private Double quantity;

    private Double outQuantity;

    public Integer getBillDetailId() {
        return billDetailId;
    }

    public void setBillDetailId(Integer billDetailId) {
        this.billDetailId = billDetailId;
    }

    public String getStorageProductBillCode() {
        return storageProductBillCode;
    }

    public void setStorageProductBillCode(String storageProductBillCode) {
        this.storageProductBillCode = storageProductBillCode == null ? null : storageProductBillCode.trim();
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getOutQuantity() {
        return outQuantity;
    }

    public void setOutQuantity(Double outQuantity) {
        this.outQuantity = outQuantity;
    }
}