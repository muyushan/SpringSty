package com.sane.pkg.controller;

import com.sane.pkg.beans.CustomerBill;
import com.sane.pkg.beans.CustomerBillDetail;
import com.sane.pkg.beans.commons.MsgBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("storagebill")
@Controller
public class StorageBillController {
    @RequestMapping("mainPage")
   public  String mainPage(){
       return "storageBill/storageBill";
   }
   @RequestMapping("addStorageBill")
   public MsgBean createSaleBill(CustomerBill customerBill, List<CustomerBillDetail> customerBillDetailList){

    MsgBean msgBean=new MsgBean();
    return  msgBean;
   }
}
