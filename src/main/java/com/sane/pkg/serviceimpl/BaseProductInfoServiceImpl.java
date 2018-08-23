package com.sane.pkg.serviceimpl;

import com.sane.pkg.beans.ProductInfo;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.dao.mappers.ProductInfoMapper;
import com.sane.pkg.exceptions.BizException;
import com.sane.pkg.service.BaseProductInfoService;
import com.sane.pkg.utils.SessionUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BaseProductInfoServiceImpl implements BaseProductInfoService {
    @Autowired
    private ProductInfoMapper productInfoMapper;
    @Override
    public MsgBean addBaseProductInfo(ProductInfo productInfo) throws BizException, Exception {
        MsgBean msgBean=new MsgBean();
        msgBean.setCode(MsgBean.SUCCESS);
        productInfo.setCreator(SessionUtil.getCurrentUserInfo());
        productInfo.setCreateDate(new Date());
        if(StringUtils.isEmpty(productInfo.getProductCode())){
            throw  new BizException("请填写物料名称选择相关物料属性信息");
        }
        if(StringUtils.isEmpty(productInfo.getProductName())){
            throw  new BizException("请填写物料名称");
        }
        if(productInfo.getFlavour()==null||productInfo.getFlavour().equals(Integer.parseInt("-1"))){
            throw  new BizException("请选择口味");
        }
        productInfoMapper.insertSelective(productInfo);
        return msgBean;
    }
}
