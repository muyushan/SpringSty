package com.sane.pkg.controller;

import com.github.pagehelper.PageInfo;
import com.sane.pkg.beans.*;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.service.StorageProductService;
import com.sane.pkg.utils.ExportExcel;
import com.sun.deploy.net.HttpResponse;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
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

    @RequestMapping("adjustQuantity")
    @ResponseBody
    public MsgBean adjustStorageProductQuantity(StorageProductUD storageProductUD) {
        MsgBean msgBean=null;
        try {
            msgBean = storageProductService.adjustStorageProductQuantity(storageProductUD);
        } catch (Exception ex) {
            msgBean=new MsgBean();
            msgBean.setCode(MsgBean.FAIL);
            msgBean.setMessage(ExceptionUtils.getMessage(ex));
        }
        return  msgBean;
    }

    @RequestMapping("toChangeLogPage")
    public  String toChangeLogPage(){
        return  "storageProduct/changeLog";
    }
    @ResponseBody
    @RequestMapping("queryChageLog")
    public  Map<String,Object> queryChangeLog(ProductInfoParam productInfoParam){
        Map<String,Object> resultMap=new HashMap<String,Object>();
        productInfoParam.setNeedPager(true);
        PageInfo<StorageInOutRecordUD> pageInfo=storageProductService.queryChangeLog(productInfoParam);
        resultMap.put("code","0");
        resultMap.put("msg","");
        resultMap.put("count",pageInfo.getTotal());
        resultMap.put("data",pageInfo.getList());
        return  resultMap;
    }

    public  void  exportChangeLog(List<Integer> idList, HttpServletResponse response){

        ProductInfoParam productInfoParam=new ProductInfoParam();
        productInfoParam.setNeedPager(false);
        productInfoParam.setIdList(idList);
        PageInfo<StorageInOutRecordUD> pageInfo=storageProductService.queryChangeLog(productInfoParam);
       String[] title={


       };
        ExportExcel.exportData(pageInfo.getList(),title,"库存变更记录",response);

    }
}
