package com.sane.pkg.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sane.pkg.beans.BaseListType;
import com.sane.pkg.beans.BaseListTypeCriteria;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.dao.mappers.BaseListTypeMapper;
import com.sane.pkg.exceptions.BizException;
import com.sane.pkg.service.BaseListTypeService;
import com.sane.pkg.utils.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.TRANSACTION_REQUIRED;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BaseListTypeServiceImpl implements BaseListTypeService {

    @Autowired
    private BaseListTypeMapper baseListTypeMapper;
    @Override
    @Transactional(propagation = Propagation.NESTED)
    public MsgBean addBaseListType(BaseListType baseListType) throws Exception {
        MsgBean msgBean=new MsgBean();
        if(StringUtils.isEmpty(baseListType.getTypeName())){
            msgBean.setMessage(MsgBean.FAIL);
            msgBean.setMessage("基础字典类型名称不能为空");
            return  msgBean;
        }
        BaseListTypeCriteria baseListTypeCriteria=new BaseListTypeCriteria();
        BaseListTypeCriteria.Criteria criteria=baseListTypeCriteria.createCriteria();
        criteria.andTypeNameEqualTo(baseListType.getTypeName());
        int count=baseListTypeMapper.countByExample(baseListTypeCriteria);
        if(count>0){
            msgBean.setMessage("已经存在了该类型字典，请更换名字");
            msgBean.setCode("500");
        }else{
            baseListTypeCriteria.clear();
            criteria= baseListTypeCriteria.createCriteria();
            baseListTypeCriteria.setOrderByClause("TypeID DESC");
            baseListTypeCriteria.setLimitStart(0);
            baseListTypeCriteria.setLimitEnd(1);
           List<BaseListType> baseListTypeList= baseListTypeMapper.selectByExample(baseListTypeCriteria);
             String nextCode="";
            if (CollectionUtils.isEmpty(baseListTypeList)){
                nextCode =CommonUtil.generageNextCode("","");
            }else{
                BaseListType last=baseListTypeList.get(0);
                nextCode =CommonUtil.generageNextCode(last.getTypeValue().substring(0,1),last.getTypeValue().substring(1,2));
            }
            baseListType.setTypeValue(nextCode);
            baseListTypeMapper.insertSelective(baseListType);
            msgBean.setCode(MsgBean.SUCCESS);
        }
        return msgBean;
    }

    @Override
    public PageInfo<BaseListType> queryBaseListType(BaseListType baseListType, Integer pageSize, Integer pageNo) {
        BaseListTypeCriteria baseListTypeCriteria=new BaseListTypeCriteria();
        BaseListTypeCriteria.Criteria criteria=baseListTypeCriteria.createCriteria();
        if(StringUtils.isNotEmpty(baseListType.getTypeName())){
           criteria.andTypeNameLike("%"+baseListType.getTypeName()+"%");
       }
        PageHelper.startPage(pageNo,pageSize);
       PageInfo pageInfo=new PageInfo(baseListTypeMapper.selectByExample(baseListTypeCriteria));
       return pageInfo;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public MsgBean deleteBaseListType(List<Integer> idList) throws Exception{
       MsgBean msgBean=new MsgBean();
        BaseListTypeCriteria baseListTypeCriteria=new BaseListTypeCriteria();
        BaseListTypeCriteria.Criteria criteria= baseListTypeCriteria.createCriteria();
        criteria.andTypeIDIn(idList);
        int count=baseListTypeMapper.deleteByExample(baseListTypeCriteria);
        if(count!=idList.size()){
            throw  new Exception("删除失败");
        }else{
            msgBean.setCode("200");
        }
        return msgBean;
    }

    @Override
    public MsgBean editBaseListType(BaseListType baseListType) {
        MsgBean msgBean=new MsgBean();
        BaseListTypeCriteria baseListTypeCriteria=new BaseListTypeCriteria();
        BaseListTypeCriteria.Criteria criteria=baseListTypeCriteria.createCriteria();
        criteria.andTypeIDNotEqualTo(baseListType.getTypeID());
        criteria.andTypeNameEqualTo(baseListType.getTypeName());
        int count=baseListTypeMapper.countByExample(baseListTypeCriteria);
        if(count>0){
            msgBean.setCode("500");
            msgBean.setMessage("字典类型已经存在，请更换名称");
            return  msgBean;
        }
        baseListTypeMapper.updateByPrimaryKeySelective(baseListType);
        msgBean.setCode("200");
        return msgBean;
    }
}
