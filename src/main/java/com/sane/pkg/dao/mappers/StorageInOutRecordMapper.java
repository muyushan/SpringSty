package com.sane.pkg.dao.mappers;

import com.sane.pkg.beans.StorageInOutRecord;
import com.sane.pkg.beans.StorageInOutRecordCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StorageInOutRecordMapper {
    int countByExample(StorageInOutRecordCriteria example);

    int deleteByExample(StorageInOutRecordCriteria example);

    int deleteByPrimaryKey(Integer inOutID);

    int insert(StorageInOutRecord record);

    int insertSelective(StorageInOutRecord record);

    List<StorageInOutRecord> selectByExample(StorageInOutRecordCriteria example);

    StorageInOutRecord selectByPrimaryKey(Integer inOutID);

    int updateByExampleSelective(@Param("record") StorageInOutRecord record, @Param("example") StorageInOutRecordCriteria example);

    int updateByExample(@Param("record") StorageInOutRecord record, @Param("example") StorageInOutRecordCriteria example);

    int updateByPrimaryKeySelective(StorageInOutRecord record);

    int updateByPrimaryKey(StorageInOutRecord record);
}