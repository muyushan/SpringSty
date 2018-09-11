package com.sane.pkg.dao.mappers.udmappers;

import com.sane.pkg.beans.StorageProductUD;

import java.util.List;

public interface StorageProductUDMapper {
    public List<StorageProductUD> queryStorageProductByProductCode(String productCode);
}
