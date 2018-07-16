package com.sane.pkg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("baseListItem")
public class BaseListItemController {
    @RequestMapping("/baseListItemPage")
    public String showBaseListItemPage(){
        return "baseListType/baseListItemPage";
    }
}
