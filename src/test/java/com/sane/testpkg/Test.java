package com.sane.testpkg;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.core.spi.service.LocalPersistenceService;
import org.ehcache.impl.config.persistence.DefaultPersistenceConfiguration;
import org.ehcache.impl.persistence.DefaultLocalPersistenceService;

import java.io.File;

public class Test {
    @org.junit.Test
    public  void test1(){
        CacheManager cacheManager= CacheManagerBuilder.newCacheManagerBuilder().withCache("preConfigured", CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class,String.class, ResourcePoolsBuilder.heap(10))).build();
        cacheManager.init();
        Cache preConfigured=cacheManager.getCache("preConfigured",Long.class,String.class);
        preConfigured.put(1L,"SANE");
        preConfigured.put(1L,"SANE MU");
        System.out.println(preConfigured.get(1L));
        System.out.println(preConfigured.containsKey(1L));
        System.out.println(preConfigured.get(2L));


    }

    public  void test2(){
        LocalPersistenceService persistenceService=new DefaultLocalPersistenceService(new DefaultPersistenceConfiguration(new File("/Users/lixiuli/Documents/cache")));

//        CacheManager cacheManager= CacheManagerBuilder.newCacheManagerBuilder().withCache("preConfigured", CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class,String.class, ResourcePoolsBuilder.(10))).build();

    }
}
