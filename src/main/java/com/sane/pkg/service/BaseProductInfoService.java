package com.sane.pkg.service;

import com.github.pagehelper.PageInfo;
import com.sane.pkg.beans.ProductInfo;
import com.sane.pkg.beans.ProductInfoParam;
import com.sane.pkg.beans.ProductInfoUD;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.exceptions.BizException;

public interface BaseProductInfoService {
    public MsgBean addBaseProductInfo(ProductInfo productInfo) throws BizException,Exception;
    public MsgBean updateBaseProductInfo(ProductInfo productInfo) throws BizException,Exception;
    public PageInfo<ProductInfoUD> queryProductInfo(ProductInfoParam productInfoParam);
}
