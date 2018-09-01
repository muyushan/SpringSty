package com.sane.pkg.beans;

public class StorageProduct {
    private Integer storageProductId;

    private String productCode;

    private Double placeholderQuantity;

    private Double quantity;

    private Integer type;

    public Integer getStorageProductId() {
        return storageProductId;
    }

    public void setStorageProductId(Integer storageProductId) {
        this.storageProductId = storageProductId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public Double getPlaceholderQuantity() {
        return placeholderQuantity;
    }

    public void setPlaceholderQuantity(Double placeholderQuantity) {
        this.placeholderQuantity = placeholderQuantity;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}