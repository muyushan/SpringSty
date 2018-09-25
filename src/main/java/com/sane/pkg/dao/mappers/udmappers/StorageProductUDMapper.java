package com.sane.pkg.dao.mappers.udmappers;

import com.sane.pkg.beans.ProductInfoParam;
import com.sane.pkg.beans.StorageInOutRecordUD;
import com.sane.pkg.beans.StorageProductUD;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StorageProductUDMapper {
    public List<StorageProductUD> queryStorageProductByProductCode(@Param("productCode") String productCode);
    public  int adjustStorageProductQuantity(@Param("storageProductId") Integer storageProductId,@Param("quantity") Double quantity);
    public  List<StorageInOutRecordUD> queryStorageInOutRecode(ProductInfoParam productInfoParam);
}
