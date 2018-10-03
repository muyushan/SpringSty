package com.sane.pkg.service;

import com.github.pagehelper.PageInfo;
import com.sane.pkg.beans.CustomerInfo;
import com.sane.pkg.beans.CustomerInfoParam;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.exceptions.BizException;

import java.util.List;

public interface CustomerService {
    public MsgBean addOrEditCustomer(CustomerInfo customerInfo)throws  Exception;
    public PageInfo<CustomerInfo> quereyCustomInfo(CustomerInfoParam customerInfo);
    public  MsgBean deleteCustomerIn(List<Integer> idList)throws BizException;
}
