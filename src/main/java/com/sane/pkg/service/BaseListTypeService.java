package com.sane.pkg.service;

import com.github.pagehelper.PageInfo;
import com.sane.pkg.beans.BaseListType;
import com.sane.pkg.beans.commons.MsgBean;

import java.util.Map;

public interface BaseListTypeService {

    public MsgBean addBaseListType(BaseListType baseListType);
    public PageInfo<BaseListType> queryBaseListType(BaseListType baseListType, Integer pageSize, Integer pageNo);
}
