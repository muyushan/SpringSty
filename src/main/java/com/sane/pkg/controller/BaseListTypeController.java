package com.sane.pkg.controller;

import com.github.pagehelper.PageInfo;
import com.sane.pkg.beans.BaseListType;
import com.sane.pkg.beans.BaseListTypeParam;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.service.BaseListTypeService;
import com.sane.pkg.utils.SessionUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("baseListType")
public class BaseListTypeController {

    @Autowired
    private BaseListTypeService baseListTypeService;
    @RequestMapping("showMainPage")
    public String showMainPage(){
        return "baseListType/baseListTypeMainPage";
    }

    @RequestMapping("queryBaseListType")
    @ResponseBody
    public Map<String,Object>queryBalistTypePage(BaseListTypeParam param){
        PageInfo<BaseListType> pageInfo=new PageInfo<BaseListType>();
        pageInfo=baseListTypeService.queryBaseListType(param,param.getLimit(),param.getPage());
        if(param.isShowAll()){
            BaseListType all=new BaseListType();
            all.setTypename("全部");
            all.setTypeid(-1);
            pageInfo.getList().add(0,all);
        }
        Map<String,Object> result=new HashMap<String,Object>();
        result.put("code","0");
        result.put("msg","");
        result.put("count",pageInfo.getTotal());
        result.put("data",pageInfo.getList());
        return  result;
    }
    @RequestMapping("/add")
    @ResponseBody
    public MsgBean addBaseListType(BaseListType baseListType, HttpServletRequest request){
        MsgBean msgBean=null;
        try {
          String userName=SessionUtil.getCurrentUserInfo(request);
          baseListType.setCreatdate(new Date());
          baseListType.setCreator(userName);
          msgBean=baseListTypeService.addBaseListType(baseListType);

        } catch (Exception e) {
            msgBean=new MsgBean();
            msgBean.setCode(MsgBean.FAIL);
            msgBean.setMessage(ExceptionUtils.getMessage(e));
        }
        return msgBean;
    }
    @RequestMapping("/edit")
    @ResponseBody
    public MsgBean editBaseListType(BaseListType baseListType, HttpServletRequest request){
        MsgBean msgBean=null;
        try {
            String userName=SessionUtil.getCurrentUserInfo(request);
            baseListType.setModifydate(new Date());
            baseListType.setModifier(userName);
            msgBean=baseListTypeService.editBaseListType(baseListType);
        } catch (Exception e) {
            msgBean=new MsgBean();
            msgBean.setCode(MsgBean.FAIL);
            msgBean.setMessage(ExceptionUtils.getMessage(e));
        }
        return msgBean;
    }
    @ResponseBody
    @RequestMapping("delete")
    public MsgBean deleteBaseLstType(@RequestParam(value="idList[]") List<Integer>idList){

        MsgBean msgBean=new MsgBean();
        try {
           msgBean= baseListTypeService.deleteBaseListType(idList);
        } catch (Exception e) {
            msgBean.setCode("500");
            msgBean.setMessage(ExceptionUtils.getMessage(e));
        }
        return  msgBean;
    }
}
