package com.sane.pkg.service;

import com.github.pagehelper.PageInfo;
import com.sane.pkg.beans.BaseListType;
import com.sane.pkg.beans.commons.MsgBean;

import java.util.List;
import java.util.Map;

public interface BaseListTypeService {

    public MsgBean addBaseListType(BaseListType baseListType) throws  Exception;
    public MsgBean editBaseListType(BaseListType baseListType);
    public PageInfo<BaseListType> queryBaseListType(BaseListType baseListType, Integer pageSize, Integer pageNo);
    public MsgBean deleteBaseListType(List<Integer> idList) throws Exception;
}
