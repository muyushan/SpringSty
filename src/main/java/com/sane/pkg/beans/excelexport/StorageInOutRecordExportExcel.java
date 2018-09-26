package com.sane.pkg.beans.excelexport;

import com.sane.pkg.beans.commons.ExcelExportField;

import java.util.Date;

public class StorageInOutRecordExportExcel {

    @ExcelExportField(displayName = "出入库单号",fieldType = ExcelExportField.FieldType.STRING)
    private String inOutCode;
    @ExcelExportField(displayName = "物料名",fieldType = ExcelExportField.FieldType.STRING)
    private String productName;
    @ExcelExportField(displayName = "物料编码",fieldType = ExcelExportField.FieldType.STRING)
    private String productCode;
    @ExcelExportField(displayName = "库存类型",fieldType = ExcelExportField.FieldType.STRING)
    private String storageTypeTxt;
    @ExcelExportField(displayName = "出/入库",fieldType = ExcelExportField.FieldType.STRING)
    private String inOutType;
    @ExcelExportField(displayName = "调整数量",fieldType = ExcelExportField.FieldType.INT)
    private Integer quantity;
    @ExcelExportField(displayName = "调整前数量",fieldType = ExcelExportField.FieldType.INT)
    private Integer formerQuantity;
    @ExcelExportField(displayName = "产品类别",fieldType = ExcelExportField.FieldType.STRING)
    private String productCategoryTxt;
    @ExcelExportField(displayName = "口味",fieldType = ExcelExportField.FieldType.STRING)
    private String flavourTxt;
    @ExcelExportField(displayName = "规格",fieldType = ExcelExportField.FieldType.STRING)
    private String specificationTxt;
    @ExcelExportField(displayName = "包装规格",fieldType = ExcelExportField.FieldType.STRING)
    private String packageSpecificationTxt;
    @ExcelExportField(displayName = "单位",fieldType = ExcelExportField.FieldType.STRING)
    private String unitTxt;
    @ExcelExportField(displayName = "包装单位",fieldType = ExcelExportField.FieldType.STRING)
    private String packageUnitTxt;
    @ExcelExportField(displayName = "操作时间",fieldType = ExcelExportField.FieldType.DATETIME)
    private Date   createDate;
    @ExcelExportField(displayName = "操作人",fieldType = ExcelExportField.FieldType.STRING)
    private String creator;
    @ExcelExportField(displayName = "备注",fieldType = ExcelExportField.FieldType.STRING)
    private String remark;

    public String getInOutCode() {
        return inOutCode;
    }

    public void setInOutCode(String inOutCode) {
        this.inOutCode = inOutCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getInOutType() {
        return inOutType;
    }

    public void setInOutType(String inOutType) {
        this.inOutType = inOutType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategoryTxt() {
        return productCategoryTxt;
    }

    public void setProductCategoryTxt(String productCategoryTxt) {
        this.productCategoryTxt = productCategoryTxt;
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

    public String getStorageTypeTxt() {
        return storageTypeTxt;
    }

    public void setStorageTypeTxt(String storageTypeTxt) {
        this.storageTypeTxt = storageTypeTxt;
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
        this.creator = creator;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getFormerQuantity() {
        return formerQuantity;
    }

    public void setFormerQuantity(Integer formerQuantity) {
        this.formerQuantity = formerQuantity;
    }
}
