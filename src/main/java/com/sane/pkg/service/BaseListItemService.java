package com.sane.pkg.service;

import com.github.pagehelper.PageInfo;
import com.sane.pkg.beans.BaseListItem;
import com.sane.pkg.beans.BaseListItemExcel;
import com.sane.pkg.beans.BaseListTypeParam;
import com.sane.pkg.beans.commons.MsgBean;

import java.util.List;

public interface BaseListItemService {
    public PageInfo<BaseListItem> queryBaseListItem(BaseListTypeParam baseListTypeParam);
    public MsgBean addBaseListItem(BaseListItem baseListItem) throws Exception;
    public MsgBean editBaseListItem(BaseListItem baseListItem)throws Exception;
    public MsgBean deleteBaseListItem(List<Integer> idList)throws Exception;
    public MsgBean uploadBaseListItem(List<BaseListItemExcel> baseListItemExcels)throws Exception;
}
