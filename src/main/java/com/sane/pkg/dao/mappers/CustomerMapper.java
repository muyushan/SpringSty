package com.sane.pkg.dao.mappers;

import com.sane.pkg.beans.Customer;
import com.sane.pkg.beans.CustomerCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {
    int countByExample(CustomerCriteria example);

    int deleteByExample(CustomerCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(Customer record);

    int insertSelective(Customer record);

    List<Customer> selectByExample(CustomerCriteria example);

    Customer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerCriteria example);

    int updateByExample(@Param("record") Customer record, @Param("example") CustomerCriteria example);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
}