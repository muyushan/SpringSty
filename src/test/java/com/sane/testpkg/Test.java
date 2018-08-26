package com.sane.testpkg;




import com.github.pagehelper.PageInfo;
import com.sane.pkg.beans.BaseListItem;
import com.sane.pkg.beans.BaseListTypeParam;
import com.sane.pkg.exceptions.BizException;
import com.sane.pkg.service.BaseListItemService;
import com.sane.pkg.utils.CommonUtil;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.Configuration;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml","classpath:spring/spring-mvc.xml"})
@RunWith(SpringJUnit4ClassRunner.class)

public class Test extends AbstractJUnit4SpringContextTests {
    @Autowired
    private BaseListItemService baseListItemService;
    @org.junit.Test
    public  void test1(){
       System.out.println(getClass().getResource("/config/ehcache-setting.xml").toString());
        CacheManager cacheManager = cacheManager = CacheManager.create(getClass().getResourceAsStream("/config/ehcache-setting.xml"));
        Cache cacheSP = cacheManager.getCache("cacheSP");
        Element element = new Element("key", "val");
        cacheSP.put(element);
        Element result = cacheSP.get("key");
        for(Object key:cacheSP.getKeys()){
            System.out.println(key.toString());

        }
        System.out.println(result.getObjectValue());
    }

    @org.junit.Test
    public  void test2(){
        BaseListTypeParam baseListTypeParam=new BaseListTypeParam();
        baseListTypeParam.setTypeID(35);
        System.out.println("--------------第一次调用---------------------");
        PageInfo<BaseListItem> baseListItemList= baseListItemService.queryBaseListItem(baseListTypeParam);
        baseListTypeParam.setTypeID(36);
        baseListItemList= baseListItemService.queryBaseListItem(baseListTypeParam);

        baseListTypeParam.setTypeID(37);
        baseListItemList= baseListItemService.queryBaseListItem(baseListTypeParam);

        baseListTypeParam.setTypeID(38);
        baseListItemList= baseListItemService.queryBaseListItem(baseListTypeParam);

        baseListTypeParam.setTypeID(39);
        baseListItemList= baseListItemService.queryBaseListItem(baseListTypeParam);

        baseListTypeParam.setTypeID(35);

        System.out.println("--------------第二次调用---------------------");
        baseListItemList= baseListItemService.queryBaseListItem(baseListTypeParam);


    }
}
