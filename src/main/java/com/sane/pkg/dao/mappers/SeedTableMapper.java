package com.sane.pkg.dao.mappers;

import com.sane.pkg.beans.SeedTable;
import com.sane.pkg.beans.SeedTableCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SeedTableMapper {
    int countByExample(SeedTableCriteria example);

    int deleteByExample(SeedTableCriteria example);

    int deleteByPrimaryKey(String seedMoudle);

    int insert(SeedTable record);

    int insertSelective(SeedTable record);

    List<SeedTable> selectByExample(SeedTableCriteria example);

    SeedTable selectByPrimaryKey(String seedMoudle);

    int updateByExampleSelective(@Param("record") SeedTable record, @Param("example") SeedTableCriteria example);

    int updateByExample(@Param("record") SeedTable record, @Param("example") SeedTableCriteria example);

    int updateByPrimaryKeySelective(SeedTable record);

    int updateByPrimaryKey(SeedTable record);
}