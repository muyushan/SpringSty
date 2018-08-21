package com.sane.pkg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/baseProductInfo")
public class BaseProductInfoController {
    @RequestMapping("baseProductInfoPage")
    public String showBaseProductInfoPage(){
        return "baseProductInfo/baseProductInfo";
    }
}
