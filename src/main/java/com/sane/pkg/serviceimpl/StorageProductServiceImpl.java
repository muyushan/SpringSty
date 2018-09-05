package com.sane.pkg.serviceimpl;

import com.sane.pkg.beans.StorageInOutRecord;
import com.sane.pkg.beans.StorageProduct;
import com.sane.pkg.beans.StorageProductCriteria;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.dao.mappers.StorageProductMapper;
import com.sane.pkg.exceptions.BizException;
import com.sane.pkg.service.StorageProductService;
import com.sane.pkg.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class StorageProductServiceImpl implements StorageProductService {

    @Autowired
    private StorageProductMapper storageProductMapper;
   @Transactional(rollbackFor = {BizException.class,Exception.class})
    @Override
    public MsgBean addStorageProduct(StorageProduct storageProduct) throws BizException, Exception {
       MsgBean msgBean=new MsgBean();
       StorageProductCriteria storageProductCriteria=new StorageProductCriteria();
       StorageProductCriteria.Criteria storageProductCriteriaSql=storageProductCriteria.createCriteria();
       storageProductCriteriaSql.andProductCodeEqualTo(storageProduct.getProductCode());
       storageProductCriteriaSql.andTypeEqualTo(storageProduct.getType());
       int count=storageProductMapper.countByExample(storageProductCriteria);
       if(count>0){
           msgBean.setCode(MsgBean.FAIL);
           msgBean.setMessage("该物料的此类型库存已经存在无需再次创建");
           return  msgBean;

       }
       StorageInOutRecord storageInOutRecord=new StorageInOutRecord();
       storageInOutRecord.setCreateDate(new Date());
       storageInOutRecord.setCreator(SessionUtil.getCurrentUserInfo());
       storageInOutRecord.setFormerQuantity(0);
       storageInOutRecord.setQuantity(storageProduct.getQuantity().intValue());
       storageInOutRecord.setInOutType("IN");
       storageInOutRecord.setInOutCode("");

        storageProductMapper.insertSelective(storageProduct);
       return msgBean;
    }
}
