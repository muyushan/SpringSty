package com.sane.pkg.beans;

public class ProductInfo {
    private Integer productId;

    private String productCode;

    private String productName;

    private Integer productCategory;

    private Integer flavour;

    private Integer unit;

    private Integer packageUnit;

    private Float weight;

    private Float volume;

    private Integer hasBarCode;

    private String barCode;

    private Integer specification;

    private Integer packageSpecification;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Integer getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Integer productCategory) {
        this.productCategory = productCategory;
    }

    public Integer getFlavour() {
        return flavour;
    }

    public void setFlavour(Integer flavour) {
        this.flavour = flavour;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Integer getPackageUnit() {
        return packageUnit;
    }

    public void setPackageUnit(Integer packageUnit) {
        this.packageUnit = packageUnit;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getVolume() {
        return volume;
    }

    public void setVolume(Float volume) {
        this.volume = volume;
    }

    public Integer getHasBarCode() {
        return hasBarCode;
    }

    public void setHasBarCode(Integer hasBarCode) {
        this.hasBarCode = hasBarCode;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode == null ? null : barCode.trim();
    }

    public Integer getSpecification() {
        return specification;
    }

    public void setSpecification(Integer specification) {
        this.specification = specification;
    }

    public Integer getPackageSpecification() {
        return packageSpecification;
    }

    public void setPackageSpecification(Integer packageSpecification) {
        this.packageSpecification = packageSpecification;
    }
}