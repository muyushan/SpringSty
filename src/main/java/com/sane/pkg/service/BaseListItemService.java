package com.sane.pkg.service;

import com.github.pagehelper.PageInfo;
import com.sane.pkg.beans.BaseListItem;
import com.sane.pkg.beans.BaseListTypeParam;
import com.sane.pkg.beans.commons.MsgBean;

public interface BaseListItemService {
    public PageInfo<BaseListItem> queryBaseListItem(BaseListTypeParam baseListTypeParam);
    public MsgBean addBaseListItem(BaseListItem baseListItem);
}
