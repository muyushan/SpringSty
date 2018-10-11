package com.sane.pkg.beans;

public class CustomerBillDetailUD extends CustomerBillDetail {
    private  String productName;
    private String flavourTxt;
    private String specificationTxt;
    private String packageSpecificationTxt;
    private String unitTxt;
    private String packageUnitTxt;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getFlavourTxt() {
        return flavourTxt;
    }

    public void setFlavourTxt(String flavourTxt) {
        this.flavourTxt = flavourTxt;
    }

    public String getSpecificationTxt() {
        return specificationTxt;
    }

    public void setSpecificationTxt(String specificationTxt) {
        this.specificationTxt = specificationTxt;
    }

    public String getPackageSpecificationTxt() {
        return packageSpecificationTxt;
    }

    public void setPackageSpecificationTxt(String packageSpecificationTxt) {
        this.packageSpecificationTxt = packageSpecificationTxt;
    }

    public String getUnitTxt() {
        return unitTxt;
    }

    public void setUnitTxt(String unitTxt) {
        this.unitTxt = unitTxt;
    }

    public String getPackageUnitTxt() {
        return packageUnitTxt;
    }

    public void setPackageUnitTxt(String packageUnitTxt) {
        this.packageUnitTxt = packageUnitTxt;
    }
}
