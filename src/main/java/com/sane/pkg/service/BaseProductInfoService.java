package com.sane.pkg.service;

import com.sane.pkg.beans.ProductInfo;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.exceptions.BizException;

public interface BaseProductInfoService {
    public MsgBean addBaseProductInfo(ProductInfo productInfo) throws BizException,Exception;
}
