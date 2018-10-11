package com.sane.pkg.beans;

import java.util.List;

public class SorageBillParam {
    private  CustomerBill customerBill;
    private List<CustomerBillDetail> customerBillDetailList;

    public CustomerBill getCustomerBill() {
        return customerBill;
    }

    public void setCustomerBill(CustomerBill customerBill) {
        this.customerBill = customerBill;
    }

    public List<CustomerBillDetail> getCustomerBillDetailList() {
        return customerBillDetailList;
    }

    public void setCustomerBillDetailList(List<CustomerBillDetail> customerBillDetailList) {
        this.customerBillDetailList = customerBillDetailList;
    }
}
