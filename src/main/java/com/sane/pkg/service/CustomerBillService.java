package com.sane.pkg.service;

import com.github.pagehelper.PageInfo;
import com.sane.pkg.beans.*;
import com.sane.pkg.beans.commons.MsgBean;

import java.util.List;

public interface CustomerBillService {
    public MsgBean createCustomerBill(CustomerBill customerBill, List<CustomerBillDetail> customerBillDetailList)throws Exception;
    public PageInfo<CustomerBillUD> selectCustomBill(CustomerBillParam customerBill);
    public  PageInfo<CustomerBillDetailUD> queryCustomerDetailByBillCode(String billCode);
}
