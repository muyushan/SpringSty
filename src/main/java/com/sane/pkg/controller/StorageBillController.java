package com.sane.pkg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("storagebill")
@Controller
public class StorageBillController {
    @RequestMapping("mainPage")
   public  String mainPage(){
       return "storageBill/storageBill";
   }
}
