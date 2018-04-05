package com.sane.testpkg;


import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

public class Test {
    @org.junit.Test
    public  void test1(){
      CacheManager cacheManager=CacheManager.create();

        Cache cache=new Cache("testCache", 5000, false, false, 5, 2);



        Element element=new Element("key1","value1");
        cache.put(element);
        cacheManager.addCache(cache);
      System.out.println(cacheManager.getCacheNames().length);



    }
@org.junit.Test
    public  void test2(){

    try {
       File file= ResourceUtils.getFile("classpath:config/ehcache.xml");
        CacheManager cacheManager=CacheManager.create(file.getAbsolutePath());
        Cache sampleCache1=cacheManager.getCache("sampleCache1");
        for(int i=0;i<15;i++){
            Element element=new Element("key"+i,"value"+i);
            sampleCache1.put(element);
        }
        System.out.println(cacheManager.getName());
        for(String str:cacheManager.getCacheNames()){

            System.out.println(str);
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }


    }
}
