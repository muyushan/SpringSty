package com.sane.pkg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("storageProduct")
public class StorageProductController {
    @RequestMapping("mainPage")
    public  String storageProductMainPage(){

        return "storageProduct/storageMain";
    }
}
