package com.sane.pkg.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sane.pkg.beans.BaseListItem;
import com.sane.pkg.beans.BaseListItemCriteria;
import com.sane.pkg.beans.BaseListTypeParam;
import com.sane.pkg.dao.mappers.BaseListItemMapper;
import com.sane.pkg.service.BaseListItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseListItemServiceImpl implements BaseListItemService {
    @Autowired
    private BaseListItemMapper baseListItemMapper;
    @Override
    public PageInfo<BaseListItem> queryBaseListItem(BaseListTypeParam baseListTypeParam) {

        BaseListItemCriteria baseListItemCriteria=new BaseListItemCriteria();
        BaseListItemCriteria.Criteria criteria= baseListItemCriteria.createCriteria();
        if(baseListTypeParam.getTypeid()!=null){
            criteria.andTypeidEqualTo(Short.parseShort(baseListTypeParam.getTypeid().toString()));
        }
        PageHelper.startPage(baseListTypeParam.getPage(),baseListTypeParam.getLimit());
        PageInfo pageInfo=new PageInfo(baseListItemMapper.selectByExample(baseListItemCriteria));
        return pageInfo;
    }
}
