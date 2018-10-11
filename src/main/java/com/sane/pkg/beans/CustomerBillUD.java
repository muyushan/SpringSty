package com.sane.pkg.beans;

public class CustomerBillUD extends  CustomerBill {
    private String customerName;
    private String customerPhone;
    private String customerAddress;
    private String billStatusTxt;
    private Double residualQuantity;


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getBillStatusTxt() {
        return billStatusTxt;
    }

    public void setBillStatusTxt(String billStatusTxt) {
        this.billStatusTxt = billStatusTxt;
    }

    public Double getResidualQuantity() {
        return residualQuantity;
    }

    public void setResidualQuantity(Double residualQuantity) {
        this.residualQuantity = residualQuantity;
    }
}
