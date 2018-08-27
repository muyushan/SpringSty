package com.sane.pkg.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sane.pkg.beans.*;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.dao.mappers.BaseListItemMapper;
import com.sane.pkg.dao.mappers.ProductInfoMapper;
import com.sane.pkg.dao.mappers.udmappers.BaseProductInfoUDMappper;
import com.sane.pkg.exceptions.BizException;
import com.sane.pkg.service.BaseProductInfoService;
import com.sane.pkg.utils.SessionUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BaseProductInfoServiceImpl implements BaseProductInfoService {
    @Autowired
    private ProductInfoMapper productInfoMapper;
    @Autowired
    private BaseProductInfoUDMappper productInfoUDMapper;
    @Autowired
    private BaseListItemMapper baseListItemMapper;
    //饮品
    private static  final  String CATEGORY_BERVERAGE="AGAA";
    //原料
    private static  final  String CATEGORY_MATERIAL="AGAB";
    @Override
    public MsgBean addBaseProductInfo(ProductInfo productInfo) throws BizException, Exception {
        MsgBean msgBean=new MsgBean();
        msgBean.setCode(MsgBean.SUCCESS);
        productInfo.setCreator(SessionUtil.getCurrentUserInfo());
        productInfo.setCreateDate(new Date());
        productInfo.setProductCode(productInfo.getProductCode().toUpperCase());
        baseProductValidate(productInfo);
        productInfoMapper.insertSelective(productInfo);
        return msgBean;
    }

    @Override
    public PageInfo<ProductInfoUD> queryProductInfo(ProductInfoParam productInfoParam) {

        if(productInfoParam.isNeedPager()){
            PageHelper.startPage(productInfoParam.getPage(),productInfoParam.getLimit());
        }
        PageInfo<ProductInfoUD> pageInfo=new PageInfo<ProductInfoUD>(productInfoUDMapper.queryProductInfoByParam(productInfoParam));
        return pageInfo;
    }

    @Override
    public MsgBean updateBaseProductInfo(ProductInfo productInfo) throws BizException, Exception {
        if(productInfo.getProductId()==null){
            throw  new BizException("没有主见ID信息无法修改记录");
        }
        baseProductValidate(productInfo);
        productInfoMapper.updateByPrimaryKeySelective(productInfo);
        MsgBean msgBean=new MsgBean();
        msgBean.setCode(MsgBean.SUCCESS);
        return msgBean;
    }

    private void   baseProductValidate(ProductInfo productInfo) throws BizException{
        if(StringUtils.isEmpty(productInfo.getProductCode())){
            throw  new BizException("请填写物料名称选择相关物料属性信息");
        }
        if(productInfo.getProductCategory()==null||productInfo.getProductCategory().equals(Integer.parseInt("-1"))){
            throw  new BizException("请选择物料所属类别");
        }
        if(StringUtils.isEmpty(productInfo.getProductName())){
            throw  new BizException("请填写物料名称");
        }
        BaseListItem baseListItem=baseListItemMapper.selectByPrimaryKey(productInfo.getProductCategory());
        if(baseListItem.getListValue().equals(CATEGORY_BERVERAGE)){
            if(productInfo.getFlavour()==null||productInfo.getFlavour().equals(Integer.parseInt("-1"))){
                throw  new BizException("请选择口味");
            }
        }
        if(productInfo.getSpecification()==null||productInfo.getSpecification().equals(Integer.parseInt("-1"))){
            throw  new BizException("请选择规格");
        }
        if(productInfo.getPackageSpecification()==null||productInfo.getPackageSpecification().equals(Integer.parseInt("-1"))){
            throw  new BizException("请选择包装规格");
        }
        ProductInfoCriteria productInfoCriteria=new ProductInfoCriteria();
        ProductInfoCriteria.Criteria productInfoCriteriaSql=productInfoCriteria.createCriteria();
        productInfoCriteriaSql.andProductCodeEqualTo(productInfo.getProductCode());
        productInfoCriteriaSql.andProductNameEqualTo(productInfo.getProductName());
        if(productInfo.getProductId()!=null){
            productInfoCriteriaSql.andProductIdNotEqualTo(productInfo.getProductId());
        }
        int count=productInfoMapper.countByExample(productInfoCriteria);
        if(count>0){
            throw  new BizException("已经存在同名同类基础物料信息，请确认。");
        }
    }
}
