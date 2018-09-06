package com.sane.testpkg;




import com.github.pagehelper.PageInfo;
import com.sane.pkg.beans.BaseListItem;
import com.sane.pkg.beans.BaseListTypeParam;
import com.sane.pkg.exceptions.BizException;
import com.sane.pkg.service.BaseListItemService;
import com.sane.pkg.service.SeedSevice;
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
    private SeedSevice seedSevice;
    @org.junit.Test
    public  void test1(){
        try {
           String reult= seedSevice.getNewSeedValue("S",9);
           System.out.println(reult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
