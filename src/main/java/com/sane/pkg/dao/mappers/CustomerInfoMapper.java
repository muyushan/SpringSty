package com.sane.pkg.dao.mappers;

import com.sane.pkg.beans.CustomerInfo;
import com.sane.pkg.beans.CustomerInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerInfoMapper {
    int countByExample(CustomerInfoCriteria example);

    int deleteByExample(CustomerInfoCriteria example);

    int deleteByPrimaryKey(Integer customerId);

    int insert(CustomerInfo record);

    int insertSelective(CustomerInfo record);

    List<CustomerInfo> selectByExample(CustomerInfoCriteria example);

    CustomerInfo selectByPrimaryKey(Integer customerId);

    int updateByExampleSelective(@Param("record") CustomerInfo record, @Param("example") CustomerInfoCriteria example);

    int updateByExample(@Param("record") CustomerInfo record, @Param("example") CustomerInfoCriteria example);

    int updateByPrimaryKeySelective(CustomerInfo record);

    int updateByPrimaryKey(CustomerInfo record);
}