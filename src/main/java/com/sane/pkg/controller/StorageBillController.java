package com.sane.pkg.controller;

import com.sane.pkg.beans.CustomerBill;
import com.sane.pkg.beans.CustomerBillDetail;
import com.sane.pkg.beans.commons.MsgBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("storagebill")
@Controller
public class StorageBillController {
    @RequestMapping("mainPage")
   public  String mainPage(){
       return "storageBill/storageBill";
   }
   @RequestMapping("addStorageBill")
   @ResponseBody
   public MsgBean createSaleBill(CustomerBill customerBill, @RequestParam("customerBillDetailList[]") List<CustomerBillDetail> customerBillDetailList){

    MsgBean msgBean=new MsgBean();
    return  msgBean;
   }
}
