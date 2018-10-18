package com.sane.pkg.controller;

import com.github.pagehelper.PageInfo;
import com.sane.pkg.beans.*;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.service.CustomerBillService;
import org.apache.commons.lang3.StringUtils;
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

@RequestMapping("storagebill")
@Controller
public class StorageBillController {
    public   static String BILLSTATUS_AJAA="AJAA";
    public   static String BILLSTATUS_AJAB="AJAB";
    public   static String BILLSTATUS_AJAD="AJAD";
    @Autowired
    private CustomerBillService customerBillService;

    @RequestMapping("mainPage")
    public String mainPage() {
        return "storageBill/storageBill";
    }

    @RequestMapping("addOrEditStorageBill")
    @ResponseBody
    public MsgBean createSaleBill(@RequestBody StorageBillParam param) {
        MsgBean msgBean = new MsgBean();
        CustomerBill customerBill = param.getCustomerBill();
        List<CustomerBillDetail> customerBillDetailList = param.getCustomerBillDetailList();
        if(StringUtils.isEmpty(customerBill.getStorageProductBillCode())){
            customerBill.setBillStatus(BILLSTATUS_AJAA);
            try {
                msgBean = customerBillService.createCustomerBill(customerBill, customerBillDetailList);
            } catch (Exception e) {
                e.printStackTrace();
                msgBean.setMessage(ExceptionUtils.getMessage(e));
                msgBean.setCode(MsgBean.FAIL);
            }
        }else {
            try {
                msgBean=customerBillService.editCustomerBill(customerBill,customerBillDetailList);
            } catch (Exception e) {
                msgBean.setCode(MsgBean.FAIL);
                msgBean.setMessage(ExceptionUtils.getMessage(e));
            }
        }
        return msgBean;
    }

    @RequestMapping("queryStorageBill")
    @ResponseBody
    public Map<String, Object> queryStorageBill(CustomerBillParam customerBillParam) {
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
    public Map<String, Object> queryStorageBillDetail(String billCode) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        PageInfo<CustomerBillDetailUD> pageInfo = customerBillService.queryCustomerDetailByBillCode(billCode);
        resultMap.put("code", "0");
        resultMap.put("msg", "");
        resultMap.put("count", pageInfo.getTotal());
        resultMap.put("data", pageInfo.getList());
        return resultMap;
    }

    @RequestMapping("auditSaleBill")
    @ResponseBody
    public MsgBean auditSaleBill(@RequestParam("billCodeList[]") List<String> billCodeList){

        MsgBean msgBean=new MsgBean();
        try {
         msgBean=   customerBillService.auditCustomerBill(billCodeList);
        } catch (Exception e) {
            msgBean.setCode(MsgBean.FAIL);
            msgBean.setMessage(ExceptionUtils.getMessage(e));
        }
        return  msgBean;
    }
    @RequestMapping("antiAuditSaleBill")
    @ResponseBody
    public MsgBean antiAuditSaleBill(@RequestParam("billCodeList[]") List<String> billCodeList){

        MsgBean msgBean=new MsgBean();
        try {
            msgBean=   customerBillService.antiAuditSaleBill(billCodeList);
        } catch (Exception e) {
            msgBean.setCode(MsgBean.FAIL);
            msgBean.setMessage(ExceptionUtils.getMessage(e));
        }
        return  msgBean;
    }
    @ResponseBody
    @RequestMapping("queryBillByCode")
    public CustomerBillUD queryBillByCode(String billCode){
        CustomerBillUD customerBill=null;
        try{
            CustomerBillParam customerBillParam=new CustomerBillParam();
            customerBillParam.setStorageProductBillCode(billCode);
            PageInfo<CustomerBillUD>pageInfo=customerBillService.selectCustomBill(customerBillParam);
            customerBill=pageInfo.getList().get(0);
        }
        catch (Exception e){
            return customerBill;
        }
        return  customerBill;


    }

    @ResponseBody
    @RequestMapping("confirmBillByCode")
    public MsgBean customerBillConfirm (@RequestParam("billCodeList[]")List<String> billCodeList){
        MsgBean msgBean=new MsgBean();
        try {
            msgBean=   customerBillService.customerBillConfirm(billCodeList);
        } catch (Exception e) {
            msgBean.setCode(MsgBean.FAIL);
            msgBean.setMessage(ExceptionUtils.getMessage(e));
        }
        return  msgBean;
    }
}

