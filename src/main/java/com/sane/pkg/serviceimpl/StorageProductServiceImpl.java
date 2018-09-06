package com.sane.pkg.serviceimpl;

import com.sane.pkg.beans.StorageInOutRecord;
import com.sane.pkg.beans.StorageProduct;
import com.sane.pkg.beans.StorageProductCriteria;
import com.sane.pkg.beans.StorageProductUD;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.dao.mappers.StorageInOutRecordMapper;
import com.sane.pkg.dao.mappers.StorageProductMapper;
import com.sane.pkg.exceptions.BizException;
import com.sane.pkg.service.SeedSevice;
import com.sane.pkg.service.StorageProductService;
import com.sane.pkg.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class StorageProductServiceImpl implements StorageProductService {

    private  static  int CODE_LENGTH=8;
    @Autowired
    private StorageProductMapper storageProductMapper;
    @Autowired
    private StorageInOutRecordMapper storageInOutRecordMapper;
    @Autowired
    private SeedSevice seedSevice;
   @Transactional(rollbackFor = {BizException.class,Exception.class})
    @Override
    public MsgBean addStorageProduct(StorageProductUD storageProduct) throws BizException, Exception {
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
       storageInOutRecord.setProductCode(storageProduct.getProductCode());
       storageInOutRecord.setCreateDate(new Date());
       storageInOutRecord.setCreator(SessionUtil.getCurrentUserInfo());
       storageInOutRecord.setFormerQuantity(0);
       storageInOutRecord.setRemark(storageProduct.getRemark());
       storageInOutRecord.setQuantity(storageProduct.getQuantity().intValue());
       storageInOutRecord.setInOutCode(seedSevice.getNewSeedValue("S",CODE_LENGTH));
       storageInOutRecord.setInOutType("IN");
       storageInOutRecord.setStorageType(storageProduct.getType());
       count=storageProductMapper.insertSelective(storageProduct);
         if(count==0){
             throw  new BizException("库存数据插入失败，请重试");
         }

       count=storageInOutRecordMapper.insertSelective(storageInOutRecord);
       if(count==0){
           throw  new BizException("库存操作记录插入失败，请重试");
       }
       return msgBean;
    }
}
