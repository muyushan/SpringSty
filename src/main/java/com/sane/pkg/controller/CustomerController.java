package com.sane.pkg.controller;

import com.github.pagehelper.PageInfo;
import com.sane.pkg.beans.CustomerInfo;
import com.sane.pkg.beans.CustomerInfoParam;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.exceptions.BizException;
import com.sane.pkg.service.CustomerService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @RequestMapping("mainPage")
    public  String mainPage(){
        return "customer/customerMain";
    }
    @RequestMapping("addOredit")
    @ResponseBody
    public MsgBean addOrUpdateCustomerInfo(CustomerInfo customerInfo){
        MsgBean msgBean= null;
        try {
            msgBean = customerService.addOrEditCustomer(customerInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msgBean;
    }

    @ResponseBody
    @RequestMapping("query")
    public Map<String,Object> queryCustomerInfo(CustomerInfoParam customerInfo){
        Map<String,Object> resultMap=new HashMap<String, Object>();
        PageInfo<CustomerInfo> customerInfoPageInfo=customerService.quereyCustomInfo(customerInfo);
        resultMap.put("code","0");
        resultMap.put("msg","");
        resultMap.put("count",customerInfoPageInfo.getTotal());
        resultMap.put("data",customerInfoPageInfo.getList());
        return  resultMap;
    }


    @RequestMapping("delete")
    @ResponseBody
    public  MsgBean deleteCustomerInfo(@RequestParam("idList[]") List<Integer> idList){
        MsgBean msgBean=null;
        try {
            msgBean=customerService.deleteCustomerIn(idList);
        } catch (BizException e) {
          msgBean=new MsgBean();
          msgBean.setCode(MsgBean.FAIL);
          msgBean.setMessage(ExceptionUtils.getMessage(e));
        }
        return  msgBean;
    }
}
