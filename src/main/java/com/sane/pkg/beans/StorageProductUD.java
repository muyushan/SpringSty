package com.sane.pkg.beans;

public class StorageProductUD extends StorageProduct {
    private  String remark;
    private  String typeTxt;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    private ProductInfoUD productInfoUD;

    public ProductInfoUD getProductInfoUD() {
        return productInfoUD;
    }

    public void setProductInfoUD(ProductInfoUD productInfoUD) {
        this.productInfoUD = productInfoUD;
    }

    public String getTypeTxt() {
        return typeTxt;
    }

    public void setTypeTxt(String typeTxt) {
        this.typeTxt = typeTxt;
    }
}
