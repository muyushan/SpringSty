package com.sane.pkg.dao.mappers.udmappers;

import com.sane.pkg.beans.BaseListItemUD;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseListItemUDMapper {
    List<BaseListItemUD> queryBaseListItemByTypeId(@Param("typeid") Integer typeId);
}
