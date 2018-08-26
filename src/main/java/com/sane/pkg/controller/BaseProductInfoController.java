package com.sane.pkg.controller;

import com.github.pagehelper.PageInfo;
import com.sane.pkg.beans.ProductInfo;
import com.sane.pkg.beans.ProductInfoParam;
import com.sane.pkg.beans.ProductInfoUD;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.service.BaseProductInfoService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

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
    @RequestMapping("query")
    @ResponseBody
    public Map<String,Object> quereyBaseProductInfo(ProductInfoParam productInfoParam){
        Map<String,Object> resultMap=new HashMap<String,Object>();
        PageInfo<ProductInfoUD> productInfoUDPageInfo=baseProductInfoService.queryProductInfo(productInfoParam);
        resultMap.put("code","0");
        resultMap.put("msg","");
        resultMap.put("count",productInfoUDPageInfo.getTotal());
        resultMap.put("data",productInfoUDPageInfo.getList());
        return  resultMap;
    }
}
