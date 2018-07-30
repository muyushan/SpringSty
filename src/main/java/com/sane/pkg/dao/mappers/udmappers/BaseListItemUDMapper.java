package com.sane.pkg.dao.mappers.udmappers;

import com.sane.pkg.beans.BaseListItemUD;

import java.util.List;

public interface BaseListItemUDMapper {
    List<BaseListItemUD> queryBaseListItemByTypeId(Integer typeId);
}
