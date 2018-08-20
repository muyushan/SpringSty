package com.sane.pkg.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sane.pkg.beans.*;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.dao.mappers.BaseListItemMapper;
import com.sane.pkg.dao.mappers.BaseListTypeMapper;
import com.sane.pkg.dao.mappers.udmappers.BaseListItemUDMapper;
import com.sane.pkg.exceptions.BizException;
import com.sane.pkg.service.BaseListItemService;
import com.sane.pkg.service.BaseListTypeService;
import com.sane.pkg.utils.CommonUtil;
import com.sane.pkg.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service
public class BaseListItemServiceImpl implements BaseListItemService {
    @Autowired
    private BaseListItemMapper baseListItemMapper;
    @Autowired
    private BaseListItemUDMapper baseListItemUdMapper;
    @Autowired
    private BaseListTypeMapper baseListTypeMapper;
    @Autowired
    private BaseListTypeService baseListTypeService;
    @Override
    public PageInfo<BaseListItem> queryBaseListItem(BaseListTypeParam baseListTypeParam) {
        PageHelper.startPage(baseListTypeParam.getPage(),baseListTypeParam.getLimit());
        PageInfo pageInfo=new PageInfo(baseListItemUdMapper.queryBaseListItemByTypeId(baseListTypeParam.getTypeID()));
        return pageInfo;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public MsgBean addBaseListItem(BaseListItem baseListItem) throws Exception{
        MsgBean msgBean=new MsgBean();
        if(isRepeat(baseListItem)){
            msgBean.setMessage("字典项重复，不允许添加");
            msgBean.setCode(MsgBean.FAIL);
            return msgBean;
        }
        BaseListType baseListType=baseListTypeMapper.selectByPrimaryKey(baseListItem.getTypeID().intValue());
        BaseListItemCriteria baseListItemCriteria=new BaseListItemCriteria();
        BaseListItemCriteria.Criteria baseListItemCriteriaSql=baseListItemCriteria.createCriteria();
        baseListItemCriteriaSql.andTypeIDEqualTo(baseListItem.getTypeID());
        baseListItemCriteria.setLimitStart(0);
        baseListItemCriteria.setLimitEnd(1);
        baseListItemCriteria.setOrderByClause("ListID DESC");
        List<BaseListItem> baseListItemList=baseListItemMapper.selectByExample(baseListItemCriteria);
        String nextCode="";
        if (CollectionUtils.isEmpty(baseListItemList)){
            nextCode=CommonUtil.generageNextCode("","");
        }else{
            BaseListItem last=baseListItemList.get(0);
            nextCode =CommonUtil.generageNextCode(last.getListValue().substring(2,3),last.getListValue().substring(3,4));
        }
        nextCode=baseListType.getTypeValue()+nextCode;
        baseListItem.setListValue(nextCode);
        int count=baseListItemMapper.insertSelective(baseListItem);

        if(count==1){
            msgBean.setCode(MsgBean.SUCCESS);
        }else{
            msgBean.setCode(MsgBean.FAIL);
            msgBean.setMessage("保存失败，请重试");
        }
        return msgBean;
    }

    @Override
    public MsgBean editBaseListItem(BaseListItem baseListItem) throws Exception {
        MsgBean msgBean=new MsgBean();
        if(isRepeat(baseListItem)){
            msgBean.setCode(MsgBean.FAIL);
            msgBean.setMessage("字典重复了，请重新修改");
            return msgBean;
        }
        baseListItemMapper.updateByPrimaryKeySelective(baseListItem);
        msgBean.setCode(MsgBean.SUCCESS);
        return msgBean;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public MsgBean deleteBaseListItem(List<Integer> idList) throws Exception {
        BaseListItemCriteria baseListItemCriteria =new BaseListItemCriteria();
        BaseListItemCriteria.Criteria baseListItemSQL=baseListItemCriteria.createCriteria();
        baseListItemSQL.andListIDIn(idList);
        int count =baseListItemMapper.deleteByExample(baseListItemCriteria);
        if(count!=idList.size()){
            throw new Exception("删除失败，请重试");
        }
        MsgBean msgBean=new MsgBean();
        msgBean.setCode(MsgBean.SUCCESS);
        return msgBean;
    }

    private  boolean isRepeat(BaseListItem baseListItem){
        BaseListItemCriteria baseListItemCriteria=new BaseListItemCriteria();
        BaseListItemCriteria.Criteria criteria=baseListItemCriteria.createCriteria();
        criteria.andTypeIDEqualTo(baseListItem.getTypeID());
        criteria.andListNameEqualTo(baseListItem.getListName());
        if(baseListItem.getListID()!=null){
            criteria.andListIDNotEqualTo(baseListItem.getListID());
        }
        int count=baseListItemMapper.countByExample(baseListItemCriteria);
        return  count>0;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class,BizException.class})
    public MsgBean uploadBaseListItem(List<BaseListItemExcel> baseListItemExcels) throws Exception {
        MsgBean msgBean=new MsgBean();
        for(BaseListItemExcel baseListItemExcel:baseListItemExcels){
            BaseListItem baseListItem=new BaseListItem();
            baseListItem.setCreator(SessionUtil.getCurrentUserInfo());
            baseListItem.setCreatDate(new Date());
            baseListItem.setListName(baseListItemExcel.getListName());
            baseListItem.setListValue(baseListItemExcel.getListValue());
            BaseListTypeCriteria baseListTypeCriteria=new BaseListTypeCriteria();
            BaseListTypeCriteria.Criteria baseListTypeSql=baseListTypeCriteria.createCriteria();
            baseListTypeSql.andTypeNameEqualTo(baseListItemExcel.getTypeName());
            List<BaseListType> baseListTypeList=baseListTypeMapper.selectByExample(baseListTypeCriteria);
            BaseListType baseListType=null;
            if(CollectionUtils.isEmpty(baseListTypeList)){
                baseListType=new BaseListType();
                baseListType.setCreatDate(new Date());
                baseListType.setCreator(SessionUtil.getCurrentUserInfo());
                baseListType.setTypeName(baseListItemExcel.getTypeName());
                baseListType.setEnaled(Byte.valueOf("1"));
                baseListTypeService.addBaseListType(baseListType);
            }else{
                baseListType=baseListTypeList.get(0);
            }
            baseListItem.setTypeID(baseListType.getTypeID().shortValue());
            msgBean=addBaseListItem(baseListItem);
            if(msgBean.getCode().equals(MsgBean.FAIL)){
                throw new BizException(msgBean.getMessage());
            }

        }
        msgBean.setCode(MsgBean.SUCCESS);
        return msgBean;
    }
}
