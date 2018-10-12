package com.sane.pkg.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sane.pkg.beans.*;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.dao.mappers.CustomerBillDetailMapper;
import com.sane.pkg.dao.mappers.CustomerBillMapper;
import com.sane.pkg.dao.mappers.udmappers.CustomerBillUDMapper;
import com.sane.pkg.service.CustomerBillService;
import com.sane.pkg.service.SeedSevice;
import com.sane.pkg.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service
public class CustomerBillServiceImpl implements CustomerBillService {
    @Autowired
    private CustomerBillMapper customerBillMapper;
    @Autowired
    private CustomerBillDetailMapper customerBillDetailMapper;
    @Autowired
    private CustomerBillUDMapper customerBillUDMapper;
    @Autowired
    private SeedSevice seedService;
    @Transactional(rollbackFor = Exception.class)
    @Override
    public MsgBean createCustomerBill(CustomerBill customerBill, List<CustomerBillDetail> customerBillDetailList) throws Exception {
       String billCode=seedService.getNewSeedValue("B",9);
        MsgBean msgBean=new MsgBean();
        CustomerBillCriteria customerBillCriteria=new CustomerBillCriteria();
        CustomerBillCriteria.Criteria criteria=customerBillCriteria.createCriteria();
        criteria.andStorageProductBillCodeEqualTo(billCode);
        List<CustomerBill> customerBillList=customerBillMapper.selectByExample(customerBillCriteria);
        if(!CollectionUtils.isEmpty(customerBillList)){
            msgBean.setCode(MsgBean.FAIL);
            msgBean.setMessage("已经存在了单据号："+billCode+"的出库单");
            return  msgBean;
        }

       customerBill.setCreator(SessionUtil.getCurrentUserInfo());
       customerBill.setCreateDate(new Date());
       customerBill.setStorageProductBillCode(billCode);
       Double sumQuantity=0d;
       for(CustomerBillDetail customerBillDetail:customerBillDetailList){
           customerBillDetail.setStorageProductBillCode(billCode);
          sumQuantity+= customerBillDetail.getQuantity();
          customerBillDetailMapper.insertSelective(customerBillDetail);
       }
        customerBill.setQuantity(sumQuantity);
        customerBill.setOutQuantity(0d);
        customerBillMapper.insertSelective(customerBill);
        msgBean.setCode(MsgBean.SUCCESS);
        return msgBean;
    }

    @Override
    public PageInfo<CustomerBillUD> selectCustomBill(CustomerBillParam customerBill) {
        PageHelper.startPage(customerBill.getPage(),customerBill.getLimit());
        PageInfo<CustomerBillUD> pageInfo=new PageInfo<CustomerBillUD>(customerBillUDMapper.queryCustomerBillList(customerBill));
        return pageInfo;
    }

    @Override
    public PageInfo<CustomerBillDetailUD> queryCustomerDetailByBillCode(String billCode) {

       PageInfo<CustomerBillDetailUD> customerBillDetailUDPageInfo=new PageInfo<CustomerBillDetailUD>(customerBillUDMapper.queryCustomerBillDetail(billCode)) ;

       return customerBillDetailUDPageInfo;
    }

    @Override
    public MsgBean editCustomerBill(CustomerBill customerBill, List<CustomerBillDetail> customerBillDetailList) throws Exception {


        return null;
    }
}
