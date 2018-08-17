package com.sane.pkg.controller;

import com.github.pagehelper.PageInfo;
import com.sane.pkg.beans.BaseListItem;
import com.sane.pkg.beans.BaseListItemExcel;
import com.sane.pkg.beans.BaseListType;
import com.sane.pkg.beans.BaseListTypeParam;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.exceptions.BizException;
import com.sane.pkg.service.BaseListItemService;
import com.sane.pkg.utils.ExcelUtil;
import com.sane.pkg.utils.SessionUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("baseListItem")
public class BaseListItemController {
    private Log logger= LogFactory.getLog(getClass());
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


    @RequestMapping("upload")
    @ResponseBody
    public MsgBean uploadBaseListItem(@RequestPart("excelFile")MultipartFile excelFile, HttpServletRequest request){
        MsgBean msgBean= new MsgBean();
        try{
            InputStream inputStream=excelFile.getInputStream();
            List<BaseListItemExcel> listItemExcels= ExcelUtil.readExcel(inputStream,excelFile, BaseListItemExcel.class);
            msgBean=baseListItemService.uploadBaseListItem(listItemExcels);
        }catch (BizException bizException){
            msgBean.setCode(MsgBean.FAIL);
            msgBean.setMessage(ExceptionUtils.getMessage(bizException));
        }
        catch (Exception ex){
           msgBean.setCode(MsgBean.FAIL);
           msgBean.setMessage(ExceptionUtils.getMessage(ex));
        }
        return  msgBean;
    }
}
