package com.sane.pkg.controller;

import com.github.pagehelper.PageInfo;
import com.sane.pkg.beans.BaseListItem;
import com.sane.pkg.beans.BaseListType;
import com.sane.pkg.beans.BaseListTypeParam;
import com.sane.pkg.service.BaseListItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("baseListItem")
public class BaseListItemController {
    @Autowired
    private BaseListItemService baseListItemService;

    @RequestMapping("/baseListItemPage")
    public String showBaseListItemPage(){
        return "baseListType/baseListItemPage";
    }

    @ResponseBody
    @RequestMapping("queryBaseListItem")
    public Map<String,Object> queryBaseListItem(BaseListTypeParam baseListTypeParam){
        PageInfo<BaseListItem> pageInfo=new PageInfo<BaseListItem>();
        pageInfo=baseListItemService.queryBaseListItem(baseListTypeParam);
        Map<String,Object> result=new HashMap<String,Object>();
        result.put("code","0");
        result.put("msg","");
        result.put("count",pageInfo.getTotal());
        result.put("data",pageInfo.getList());
        return  result;
    }
}
