package com.sane.pkg.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sane.pkg.beans.*;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.dao.mappers.StorageInOutRecordMapper;
import com.sane.pkg.dao.mappers.StorageProductMapper;
import com.sane.pkg.dao.mappers.udmappers.StorageProductUDMapper;
import com.sane.pkg.exceptions.BizException;
import com.sane.pkg.service.SeedSevice;
import com.sane.pkg.service.StorageProductService;
import com.sane.pkg.utils.SessionUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class StorageProductServiceImpl implements StorageProductService {

    private  static  int CODE_LENGTH=8;
    @Autowired
    private StorageProductMapper storageProductMapper;
    @Autowired
    private StorageInOutRecordMapper storageInOutRecordMapper;
    @Autowired
    private SeedSevice seedSevice;
    @Autowired
    private StorageProductUDMapper storageProductUDMapper;
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
       msgBean.setCode(MsgBean.SUCCESS);
       return msgBean;
    }

    @Override
    public PageInfo<StorageProductUD> query(ProductInfoParam productInfoParam) {
        PageHelper.startPage(productInfoParam.getPage(),productInfoParam.getLimit());
       PageInfo<StorageProductUD> pageInfo=new PageInfo<StorageProductUD>(storageProductUDMapper.queryStorageProductByProductCode(productInfoParam.getProductCode()));
        return pageInfo;
    }

    @Transactional(rollbackFor ={ BizException.class,Exception.class})
    @Override
    public MsgBean adjustStorageProductQuantity(StorageProductUD storageProductUD) throws BizException, Exception {
       MsgBean msgBean=new MsgBean();
       if(storageProductUD.getStorageProductId()==null){
           msgBean.setCode(MsgBean.FAIL);
           msgBean.setMessage("调整库存的记录ID为空无法进行调整操作");
           return  msgBean;
       }
      StorageProduct storageProduct= storageProductMapper.selectByPrimaryKey(storageProductUD.getStorageProductId());
       if(storageProduct==null){
           msgBean.setCode(MsgBean.FAIL);
           msgBean.setMessage("调整库存的查询不到对应的库存信息无法调整");
           return  msgBean;
       }
       if(StringUtils.isEmpty(storageProductUD.getChangeType())){
           msgBean.setCode(MsgBean.FAIL);
           msgBean.setMessage("调整类型不能为空");
           return  msgBean;
       }
       if(StringUtils.isEmpty(storageProductUD.getRemark())){
           msgBean.setCode(MsgBean.FAIL);
           msgBean.setMessage("库存调整的备注说明不能为空");
           return  msgBean;
       }
       if(storageProductUD.getQuantity()==null){
           msgBean.setCode(MsgBean.FAIL);
           msgBean.setMessage("请输入要调整的数量值");
           return  msgBean;
       }
       Double changeQuantyty=storageProductUD.getQuantity();
       if(storageProductUD.getChangeType().toUpperCase().equals("OUT")){
           if(storageProductUD.getQuantity()>storageProduct.getQuantity()){
               msgBean.setCode(MsgBean.FAIL);
               msgBean.setMessage("当前库存数量为："+storageProduct.getQuantity()+"不能满足调减"+storageProductUD.getQuantity());
               return  msgBean;
           }
           changeQuantyty=0-storageProductUD.getQuantity();
       }

       int count=storageProductUDMapper.adjustStorageProductQuantity(storageProduct.getStorageProductId(),changeQuantyty);
       StorageInOutRecord storageInOutRecord=new StorageInOutRecord();
       storageInOutRecord.setInOutType(storageProductUD.getChangeType());
       storageInOutRecord.setCreateDate(new Date());
       storageInOutRecord.setCreator(SessionUtil.getCurrentUserInfo());
       storageInOutRecord.setFormerQuantity(storageProduct.getQuantity().intValue());
       storageInOutRecord.setInOutCode(seedSevice.getNewSeedValue("S",CODE_LENGTH));
       storageInOutRecord.setProductCode(storageProduct.getProductCode());
       storageInOutRecord.setQuantity(storageProductUD.getQuantity().intValue());
       storageInOutRecord.setStorageType(storageProduct.getType());
       storageInOutRecord.setRemark("库存调整:"+storageProductUD.getRemark());
       storageInOutRecordMapper.insertSelective(storageInOutRecord);
       msgBean.setCode(MsgBean.SUCCESS);
       return msgBean;
    }

    @Override
    public PageInfo<StorageInOutRecordUD>queryChangeLog(ProductInfoParam productInfoParam) {
       if(productInfoParam.isNeedPager()){
           PageHelper.startPage(productInfoParam.getPage(),productInfoParam.getLimit());
       }

        PageInfo<StorageInOutRecordUD> pageInfo= new PageInfo<StorageInOutRecordUD>(storageProductUDMapper.queryStorageInOutRecode(productInfoParam));
        return pageInfo;
    }
}
