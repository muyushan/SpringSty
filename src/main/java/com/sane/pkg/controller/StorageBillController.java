package com.sane.pkg.controller;

import com.github.pagehelper.PageInfo;
import com.sane.pkg.beans.*;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.service.CustomerBillService;
import com.sane.pkg.utils.SessionUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("storagebill")
@Controller
public class StorageBillController {
    @Autowired
    private CustomerBillService customerBillService;
    @RequestMapping("mainPage")
   public  String mainPage(){
       return "storageBill/storageBill";
   }
   @RequestMapping("addStorageBill")
   @ResponseBody
   public MsgBean createSaleBill(@RequestBody SorageBillParam param){
       CustomerBill customerBill=param.getCustomerBill();
       customerBill.setBillStatus("AJAA");
       List<CustomerBillDetail> customerBillDetailList=param.getCustomerBillDetailList();
       MsgBean msgBean=new MsgBean();
       try {
           msgBean=customerBillService.createCustomerBill(customerBill,customerBillDetailList);
       } catch (Exception e) {
           e.printStackTrace();
           msgBean.setMessage(ExceptionUtils.getMessage(e));
           msgBean.setCode(MsgBean.FAIL);
       }
    return  msgBean;
   }
@RequestMapping("queryStorageBill")
@ResponseBody
   public Map<String,Object> queryStorageBill(CustomerBillParam customerBillParam) {
    Map<String, Object> resultMap = new HashMap<String, Object>();
    PageInfo<CustomerBillUD> customerBillUDPageInfo = customerBillService.selectCustomBill(customerBillParam);
    resultMap.put("code", "0");
    resultMap.put("msg", "");
    resultMap.put("count", customerBillUDPageInfo.getTotal());
    resultMap.put("data", customerBillUDPageInfo.getList());
    return resultMap;
}
@ResponseBody
@RequestMapping("queryStorageBillDetail")
private  Map<String,Object>queryStorageBillDetail(String billCode){
Map<String,Object> resultMap=new HashMap<String,Object>();
PageInfo<CustomerBillDetailUD> pageInfo=customerBillService.queryCustomerDetailByBillCode(billCode);
    resultMap.put("code", "0");
    resultMap.put("msg", "");
    resultMap.put("count", pageInfo.getTotal());
    resultMap.put("data", pageInfo.getList());
return  resultMap;
}
   }

