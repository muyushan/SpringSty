package com.sane.pkg.service;

import com.github.pagehelper.PageInfo;
import com.sane.pkg.beans.BaseListItem;
import com.sane.pkg.beans.BaseListTypeParam;

public interface BaseListItemService {
    public PageInfo<BaseListItem> queryBaseListItem(BaseListTypeParam baseListTypeParam);
}
