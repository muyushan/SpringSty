package com.sane.pkg.dao.mappers.udmappers;

import com.sane.pkg.beans.CustomerBillDetailUD;
import com.sane.pkg.beans.CustomerBillParam;
import com.sane.pkg.beans.CustomerBillUD;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerBillUDMapper {
    public List<CustomerBillUD> queryCustomerBillList(CustomerBillParam customerBill);
    public List<CustomerBillDetailUD>queryCustomerBillDetail(@Param("billCode") String billCode);
}
