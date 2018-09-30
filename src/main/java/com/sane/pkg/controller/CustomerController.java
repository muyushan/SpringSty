package com.sane.pkg.controller;

import com.sane.pkg.beans.CustomerInfo;
import com.sane.pkg.beans.commons.MsgBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("customer")
public class CustomerController {
    @RequestMapping("mainPage")
    public  String mainPage(){
        return "customer/customerMain";
    }
    @RequestMapping("addOredit")
    public MsgBean addOrUpdateCustomerInfo(CustomerInfo customerInfo){




    }
}
