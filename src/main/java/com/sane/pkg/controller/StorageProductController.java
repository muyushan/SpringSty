package com.sane.pkg.controller;

import com.github.pagehelper.PageInfo;
import com.sane.pkg.beans.ProductInfoParam;
import com.sane.pkg.beans.ProductInfoUD;
import com.sane.pkg.beans.StorageProduct;
import com.sane.pkg.beans.StorageProductUD;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.service.StorageProductService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("storageProduct")
public class StorageProductController {
    @Autowired
    private StorageProductService storageProductService;
    @RequestMapping("mainPage")
    public  String storageProductMainPage(){
        return "storageProduct/storageMain";
    }

    @ResponseBody
    @RequestMapping("query")
    public Map<String,Object> quereyStorageProduct(ProductInfoParam productInfoParam){
        Map<String,Object> resultMap=new HashMap<String,Object>();
        PageInfo<StorageProductUD> storageProductUDPageInfo=storageProductService.query(productInfoParam);
        resultMap.put("code","0");
        resultMap.put("msg","");
        resultMap.put("count",storageProductUDPageInfo.getTotal());
        resultMap.put("data",storageProductUDPageInfo.getList());
        return  resultMap;
    }
    @RequestMapping("add")
    @ResponseBody
    public MsgBean addStorageProduct(StorageProductUD storageProduct){

        MsgBean msgBean=new MsgBean();
        try {
            msgBean=storageProductService.addStorageProduct(storageProduct);
        }catch (Exception ex){
            msgBean.setMessage(ExceptionUtils.getMessage(ex));
            msgBean.setCode(MsgBean.FAIL);
        }
        return msgBean;
    }
}
