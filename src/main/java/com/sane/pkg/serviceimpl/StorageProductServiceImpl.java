package com.sane.pkg.serviceimpl;

import com.sane.pkg.beans.StorageProduct;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.dao.mappers.StorageProductMapper;
import com.sane.pkg.exceptions.BizException;
import com.sane.pkg.service.StorageProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StorageProductServiceImpl implements StorageProductService {

    @Autowired
    private StorageProductMapper storageProductMapper;
   @Transactional(rollbackFor = {BizException.class,Exception.class})
    @Override
    public MsgBean addStorageProduct(StorageProduct storageProduct) throws BizException, Exception {
        storageProductMapper.insertSelective(storageProduct);
       return null;
    }
}
