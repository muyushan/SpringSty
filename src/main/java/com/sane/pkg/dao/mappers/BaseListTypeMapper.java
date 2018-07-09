package com.sane.pkg.dao.mappers;

import com.sane.pkg.beans.BaseListType;
import com.sane.pkg.beans.BaseListTypeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseListTypeMapper {
    int countByExample(BaseListTypeCriteria example);

    int deleteByExample(BaseListTypeCriteria example);

    int deleteByPrimaryKey(Integer typeid);

    int insert(BaseListType record);

    int insertSelective(BaseListType record);

    List<BaseListType> selectByExample(BaseListTypeCriteria example);

    BaseListType selectByPrimaryKey(Integer typeid);

    int updateByExampleSelective(@Param("record") BaseListType record, @Param("example") BaseListTypeCriteria example);

    int updateByExample(@Param("record") BaseListType record, @Param("example") BaseListTypeCriteria example);

    int updateByPrimaryKeySelective(BaseListType record);

    int updateByPrimaryKey(BaseListType record);
}