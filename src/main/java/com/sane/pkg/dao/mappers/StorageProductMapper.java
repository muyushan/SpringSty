package com.sane.pkg.dao.mappers;

import com.sane.pkg.beans.StorageProduct;
import com.sane.pkg.beans.StorageProductCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StorageProductMapper {
    int countByExample(StorageProductCriteria example);

    int deleteByExample(StorageProductCriteria example);

    int deleteByPrimaryKey(Integer storageProductId);

    int insert(StorageProduct record);

    int insertSelective(StorageProduct record);

    List<StorageProduct> selectByExample(StorageProductCriteria example);

    StorageProduct selectByPrimaryKey(Integer storageProductId);

    int updateByExampleSelective(@Param("record") StorageProduct record, @Param("example") StorageProductCriteria example);

    int updateByExample(@Param("record") StorageProduct record, @Param("example") StorageProductCriteria example);

    int updateByPrimaryKeySelective(StorageProduct record);

    int updateByPrimaryKey(StorageProduct record);
}