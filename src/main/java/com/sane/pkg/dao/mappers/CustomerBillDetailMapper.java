package com.sane.pkg.dao.mappers;

import com.sane.pkg.beans.CustomerBillDetail;
import com.sane.pkg.beans.CustomerBillDetailCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerBillDetailMapper {
    int countByExample(CustomerBillDetailCriteria example);

    int deleteByExample(CustomerBillDetailCriteria example);

    int deleteByPrimaryKey(Integer billDetailId);

    int insert(CustomerBillDetail record);

    int insertSelective(CustomerBillDetail record);

    List<CustomerBillDetail> selectByExample(CustomerBillDetailCriteria example);

    CustomerBillDetail selectByPrimaryKey(Integer billDetailId);

    int updateByExampleSelective(@Param("record") CustomerBillDetail record, @Param("example") CustomerBillDetailCriteria example);

    int updateByExample(@Param("record") CustomerBillDetail record, @Param("example") CustomerBillDetailCriteria example);

    int updateByPrimaryKeySelective(CustomerBillDetail record);

    int updateByPrimaryKey(CustomerBillDetail record);
}