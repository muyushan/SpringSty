package com.sane.pkg.service;

import com.sane.pkg.beans.CustomerInfo;
import com.sane.pkg.beans.commons.MsgBean;

public interface CustomerService {
    public MsgBean addOrEditCustomer(CustomerInfo customerInfo);
}
