package com.sane.pkg.serviceimpl;

import com.github.pagehelper.PageInfo;
import com.sane.pkg.beans.CustomerInfo;
import com.sane.pkg.beans.CustomerInfoCriteria;
import com.sane.pkg.beans.CustomerInfoParam;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.dao.mappers.CustomerInfoMapper;
import com.sane.pkg.exceptions.BizException;
import com.sane.pkg.service.CustomerService;
import com.sane.pkg.service.SeedSevice;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerInfoMapper customerInfoMapper;
    @Autowired
    private SeedSevice seedSevice;
    @Transactional(rollbackFor = Exception.class)
    @Override
    public MsgBean addOrEditCustomer(CustomerInfo customerInfo)throws Exception {
        MsgBean msgBean=new MsgBean();
        int count=0;
        if(customerInfo.getCustomerId()!=null){
            count= customerInfoMapper.updateByPrimaryKeySelective(customerInfo);
        }else{
            String customerCode=seedSevice.getNewSeedValue("C",3);
            customerInfo.setCustomerCode(customerCode);
            count=customerInfoMapper.insertSelective(customerInfo);
        }
        if(count>0){
            msgBean.setCode(MsgBean.SUCCESS);
        }else{
            msgBean.setCode(MsgBean.FAIL);
            msgBean.setMessage("数据库更新失败");
        }
        return msgBean;
    }

    @Override
    public PageInfo<CustomerInfo> quereyCustomInfo(CustomerInfoParam customerInfo) {
        CustomerInfoCriteria customerInfoCriteria=new CustomerInfoCriteria();
        CustomerInfoCriteria.Criteria criteria=customerInfoCriteria.createCriteria();
        if(StringUtils.isNotEmpty(customerInfo.getCustomerName())){
            criteria.andCustomerNameLike("%"+customerInfo.getCustomerName()+"%");
        }
        if(StringUtils.isNotEmpty(customerInfo.getCustomerPhone())){
            criteria.andCustomerPhoneLike("%"+customerInfo.getCustomerPhone()+"%");
        }
        PageInfo<CustomerInfo> customerInfoPageInfo=new PageInfo<CustomerInfo>(customerInfoMapper.selectByExample(customerInfoCriteria));
        return customerInfoPageInfo;
    }

    @Transactional(rollbackFor ={BizException.class,Exception.class})
    @Override
    public MsgBean deleteCustomerIn(List<Integer> idList) throws BizException{
        CustomerInfoCriteria customerInfoCriteria=new CustomerInfoCriteria();
        CustomerInfoCriteria.Criteria criteria=customerInfoCriteria.createCriteria();
       MsgBean msgBean=new MsgBean();
       if(CollectionUtils.isEmpty(idList)){
           msgBean.setCode(MsgBean.FAIL);
           msgBean.setMessage("要删除的客户ID不能为空");
           return  msgBean;
       }
       criteria.andCustomerIdIn(idList);
       int count=customerInfoMapper.deleteByExample(customerInfoCriteria);
       if(count!=idList.size()){
           throw  new BizException("要删除的客户信息和实际删除的不一致，请重试。");
       }
       msgBean.setCode(MsgBean.SUCCESS);
        return msgBean;
    }
}