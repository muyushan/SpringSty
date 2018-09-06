package com.sane.pkg.controller;

import com.sane.pkg.beans.StorageProduct;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.service.StorageProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("storageProduct")
public class StorageProductController {
    @Autowired
    private StorageProductService storageProductService;
    @RequestMapping("mainPage")
    public  String storageProductMainPage(){
        return "storageProduct/storageMain";
    }

    @RequestMapping("add")
    @ResponseBody
    public MsgBean addStorageProduct(StorageProduct storageProduct){

        MsgBean msgBean=new MsgBean();
        return msgBean;
    }
}