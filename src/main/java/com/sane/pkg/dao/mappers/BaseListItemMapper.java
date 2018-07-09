package com.sane.pkg.dao.mappers;

import com.sane.pkg.beans.BaseListItem;
import com.sane.pkg.beans.BaseListItemCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseListItemMapper {
    int countByExample(BaseListItemCriteria example);

    int deleteByExample(BaseListItemCriteria example);

    int deleteByPrimaryKey(Integer listid);

    int insert(BaseListItem record);

    int insertSelective(BaseListItem record);

    List<BaseListItem> selectByExample(BaseListItemCriteria example);

    BaseListItem selectByPrimaryKey(Integer listid);

    int updateByExampleSelective(@Param("record") BaseListItem record, @Param("example") BaseListItemCriteria example);

    int updateByExample(@Param("record") BaseListItem record, @Param("example") BaseListItemCriteria example);

    int updateByPrimaryKeySelective(BaseListItem record);

    int updateByPrimaryKey(BaseListItem record);
}