package com.sane.pkg.service;

import com.github.pagehelper.PageInfo;
import com.sane.pkg.beans.ProductInfoParam;
import com.sane.pkg.beans.StorageProduct;
import com.sane.pkg.beans.StorageProductUD;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.exceptions.BizException;

public interface StorageProductService {

    public MsgBean addStorageProduct(StorageProductUD storageProduct) throws BizException,Exception;

    public PageInfo<StorageProductUD> query(ProductInfoParam productInfoParam);
}
