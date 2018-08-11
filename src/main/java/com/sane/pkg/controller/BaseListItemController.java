package com.sane.pkg.controller;

import com.github.pagehelper.PageInfo;
import com.sane.pkg.beans.BaseListItem;
import com.sane.pkg.beans.BaseListType;
import com.sane.pkg.beans.BaseListTypeParam;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.service.BaseListItemService;
import com.sane.pkg.utils.SessionUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

    @ResponseBody
    @RequestMapping("add")
    public MsgBean addListItem(BaseListItem baseListItem){
       MsgBean msgBean=null;
        try {
          String userName=  SessionUtil.getCurrentUserInfo();
          baseListItem.setCreatdate(new Date());
          baseListItem.setCreator(userName);
            msgBean=baseListItemService.addBaseListItem(baseListItem);
        } catch (Exception e) {
            msgBean.setMessage(MsgBean.FAIL);
            msgBean.setMessage("异常："+ ExceptionUtils.getMessage(e));
        }
        return  msgBean;
    }
    @RequestMapping("edit")
    @ResponseBody
    public MsgBean editListItem(BaseListItem baseListItem){
        MsgBean msgBean=new MsgBean();
        if(baseListItem.getListid()==null){
            msgBean.setCode(MsgBean.FAIL);
            msgBean.setMessage("唯一ID为空无法修改数据");
            return  msgBean;
        }

        if(baseListItem.getListvalue()==null){
            msgBean.setCode(MsgBean.FAIL);
            msgBean.setMessage("字典项值不能为空");
            return  msgBean;
        }
        if(StringUtils.isEmpty(baseListItem.getListname())){
            msgBean.setCode(MsgBean.FAIL);
            msgBean.setMessage("字典项名称不能为空");
            return  msgBean;
        }
        try {
            baseListItem.setModifier(SessionUtil.getCurrentUserInfo());
            baseListItem.setModifydate(new Date());
           msgBean= baseListItemService.editBaseListItem(baseListItem);
        } catch (Exception e) {
            msgBean.setCode(MsgBean.FAIL);
            msgBean.setMessage(ExceptionUtils.getMessage(e));
        }
        return msgBean;

    }

    @ResponseBody
    @RequestMapping("delete")
    public MsgBean deleteBaseListItem(@RequestParam(value="idList[]") List<Integer> idList){
        MsgBean msgBean=new MsgBean();

        try {
            msgBean=baseListItemService.deleteBaseListItem(idList);
        } catch (Exception e) {
            msgBean.setCode(MsgBean.FAIL);
            msgBean.setMessage(ExceptionUtils.getMessage(e));
        }

        return  msgBean;
    }
}
