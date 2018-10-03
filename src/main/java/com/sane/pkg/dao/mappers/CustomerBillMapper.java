package com.sane.pkg.dao.mappers;

import com.sane.pkg.beans.CustomerBill;
import com.sane.pkg.beans.CustomerBillCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerBillMapper {
    int countByExample(CustomerBillCriteria example);

    int deleteByExample(CustomerBillCriteria example);

    int deleteByPrimaryKey(Integer storageProductBillId);

    int insert(CustomerBill record);

    int insertSelective(CustomerBill record);

    List<CustomerBill> selectByExample(CustomerBillCriteria example);

    CustomerBill selectByPrimaryKey(Integer storageProductBillId);

    int updateByExampleSelective(@Param("record") CustomerBill record, @Param("example") CustomerBillCriteria example);

    int updateByExample(@Param("record") CustomerBill record, @Param("example") CustomerBillCriteria example);

    int updateByPrimaryKeySelective(CustomerBill record);

    int updateByPrimaryKey(CustomerBill record);
}