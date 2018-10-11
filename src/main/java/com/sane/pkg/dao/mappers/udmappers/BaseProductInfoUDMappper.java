package com.sane.pkg.dao.mappers.udmappers;

import com.sane.pkg.beans.ProductInfo;
import com.sane.pkg.beans.ProductInfoUD;

import java.util.List;

public interface BaseProductInfoUDMappper {
    public List<ProductInfoUD> queryProductInfoByParam(ProductInfo productInfo);
}
