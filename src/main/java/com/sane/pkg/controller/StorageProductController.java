package com.sane.pkg.controller;

import com.sane.pkg.beans.commons.MsgBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("storageProduct")
public class StorageProductController {
    @RequestMapping("mainPage")
    public  String storageProductMainPage(){
        return "storageProduct/storageMain";
    }

    @RequestMapping("add")
    @ResponseBody
    public MsgBean addStorageProduct(){

        MsgBean msgBean=new MsgBean();
        return msgBean;
    }
}
