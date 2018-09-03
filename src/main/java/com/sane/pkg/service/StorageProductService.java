package com.sane.pkg.service;

import com.sane.pkg.beans.StorageProduct;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.exceptions.BizException;

public interface StorageProductService {

    public MsgBean addStorageProduct(StorageProduct storageProduct) throws BizException,Exception;
}
