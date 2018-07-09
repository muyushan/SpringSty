package com.sane.pkg.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sane.pkg.beans.BaseListType;
import com.sane.pkg.beans.BaseListTypeCriteria;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.dao.mappers.BaseListTypeMapper;
import com.sane.pkg.service.BaseListTypeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BaseListTypeServiceImpl implements BaseListTypeService {

    @Autowired
    private BaseListTypeMapper baseListTypeMapper;
    @Override
    public MsgBean addBaseListType(BaseListType baseListType) {
        MsgBean msgBean=new MsgBean();
        if(StringUtils.isEmpty(baseListType.getTypename())){
            msgBean.setMessage(MsgBean.FAIL);
            msgBean.setMessage("基础字典类型不能为空");
            return  msgBean;
        }
        baseListTypeMapper.insertSelective(baseListType);
        msgBean.setCode(MsgBean.SUCCESS);
        return msgBean;
    }

    @Override
    public PageInfo<BaseListType> queryBaseListType(BaseListType baseListType, Integer pageSize, Integer pageNo) {
        BaseListTypeCriteria baseListTypeCriteria=new BaseListTypeCriteria();
        BaseListTypeCriteria.Criteria criteria=baseListTypeCriteria.createCriteria();
        if(StringUtils.isNotEmpty(baseListType.getTypename())){
           criteria.andTypenameLike("%"+baseListType.getTypename()+"%");
       }
        PageHelper.startPage(pageNo,pageSize);
       PageInfo pageInfo=new PageInfo(baseListTypeMapper.selectByExample(baseListTypeCriteria));
       return pageInfo;
    }
}
