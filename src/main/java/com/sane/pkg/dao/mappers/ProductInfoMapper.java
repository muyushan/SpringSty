package com.sane.pkg.dao.mappers;

import com.sane.pkg.beans.ProductInfo;
import com.sane.pkg.beans.ProductInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductInfoMapper {
    int countByExample(ProductInfoCriteria example);

    int deleteByExample(ProductInfoCriteria example);

    int deleteByPrimaryKey(Integer productId);

    int insert(ProductInfo record);

    int insertSelective(ProductInfo record);

    List<ProductInfo> selectByExample(ProductInfoCriteria example);

    ProductInfo selectByPrimaryKey(Integer productId);

    int updateByExampleSelective(@Param("record") ProductInfo record, @Param("example") ProductInfoCriteria example);

    int updateByExample(@Param("record") ProductInfo record, @Param("example") ProductInfoCriteria example);

    int updateByPrimaryKeySelective(ProductInfo record);

    int updateByPrimaryKey(ProductInfo record);
}