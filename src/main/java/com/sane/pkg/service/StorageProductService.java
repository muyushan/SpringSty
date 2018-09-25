package com.sane.pkg.service;

import com.github.pagehelper.PageInfo;
import com.sane.pkg.beans.ProductInfoParam;
import com.sane.pkg.beans.StorageInOutRecordUD;
import com.sane.pkg.beans.StorageProduct;
import com.sane.pkg.beans.StorageProductUD;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.exceptions.BizException;

import java.util.Map;

public interface StorageProductService {

    public MsgBean addStorageProduct(StorageProductUD storageProduct) throws BizException,Exception;

    public PageInfo<StorageProductUD> query(ProductInfoParam productInfoParam);

    public  MsgBean adjustStorageProductQuantity(StorageProductUD storageProductUD) throws BizException,Exception;

    public PageInfo<StorageInOutRecordUD>queryChangeLog(ProductInfoParam productInfoParam);




}
