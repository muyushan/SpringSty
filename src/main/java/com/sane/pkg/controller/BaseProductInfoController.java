package com.sane.pkg.controller;

import com.sane.pkg.beans.ProductInfo;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.service.BaseProductInfoService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/baseProductInfo")
public class BaseProductInfoController {
    @Autowired
    private BaseProductInfoService baseProductInfoService;
    @RequestMapping("baseProductInfoPage")
    public String showBaseProductInfoPage(){
        return "baseProductInfo/baseProductInfo";
    }
    @RequestMapping("add")
    @ResponseBody
    public MsgBean addBaseProductInfo(ProductInfo productInfo){
        MsgBean msgBean=new MsgBean();
        try {
            msgBean=baseProductInfoService.addBaseProductInfo(productInfo);
        } catch (Exception e) {
            msgBean.setCode(MsgBean.FAIL);
            msgBean.setMessage(ExceptionUtils.getMessage(e));
        }
        return  msgBean;
    }
}
