package com.sane.pkg.serviceimpl;

import com.sane.pkg.beans.CustomerInfo;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.dao.mappers.CustomerInfoMapper;
import com.sane.pkg.service.CustomerService;
import com.sane.pkg.service.SeedSevice;
import org.springframework.beans.factory.annotation.Autowired;

@
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerInfoMapper customerInfoMapper;
    @Autowired
    private SeedSevice seedSevice;
    @Override
    public MsgBean addOrEditCustomer(CustomerInfo customerInfo) {
        int count=0;
        if(customerInfo.getCustomerId()!=null){
          count= customerInfoMapper.updateByPrimaryKey(customerInfo);
        }else{
            count=customerInfoMapper.insertSelective(customerInfo);
        }
        return null;
    }
}
