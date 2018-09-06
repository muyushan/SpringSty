package com.sane.pkg.serviceimpl;

import com.sane.pkg.beans.SeedTable;
import com.sane.pkg.dao.mappers.SeedTableMapper;
import com.sane.pkg.dao.mappers.udmappers.SeedTableUDMapper;
import com.sane.pkg.service.SeedSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SeedServiceImpl implements SeedSevice{
    @Autowired
    private SeedTableMapper seedTableMapper;
    @Autowired
    private SeedTableUDMapper seedTableUDMapper;
    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public String getNewSeedValue(String moudle, Integer length) throws Exception {

       int count=seedTableUDMapper.growUpSeedValue(moudle);
       if(count==0){
           SeedTable seedTable=new SeedTable();
           seedTable.setSeedMoudle(moudle);
           seedTable.setSeedValue(1L);
           seedTableMapper.insertSelective(seedTable);
       }
        SeedTable seedTable=seedTableMapper.selectByPrimaryKey(moudle);
       String result=moudle+String.format("%0"+length+"d",seedTable.getSeedValue());
        return result;

    }
}
