package com.sane.testpkg;


import com.sane.pkg.beans.User;
import com.sane.pkg.searchable.DynacExtrator;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.search.Attribute;
import net.sf.ehcache.search.Query;
import net.sf.ehcache.search.Result;
import net.sf.ehcache.search.Results;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.Resource;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Set;

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
    @org.junit.Test

    public  void test3(){

        File file= null;
        try {
            file = ResourceUtils.getFile("classpath:config/ehcache.xml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        CacheManager cacheManager=CacheManager.create(file.getAbsolutePath());
        Cache cache=cacheManager.getCache("userCache6");
        cache.registerDynamicAttributesExtractor(new DynacExtrator());
        listSearchableAttrs(cache);
        User user=new User();
        user.setEmailPhone("18301130217");
        cache.put(new Element("1",user));
        System.out.println("==========");
        listSearchableAttrs(cache);
    }

    private  void listSearchableAttrs(Cache cache){

        Set<Attribute> attributeSet=cache.getSearchAttributes();
        for(Attribute attribute:attributeSet){
            System.out.println("----"+attribute.getAttributeName());

        }
    }

    @org.junit.Test
    public  void testSearch(){

        File file= null;
        try {
            file = ResourceUtils.getFile("classpath:config/ehcache.xml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        CacheManager cacheManager=CacheManager.create(file.getAbsolutePath());
        Cache userCache=cacheManager.getCache("userCache6");
        User user;
        for(int i=0;i<20;i++){
            user=new User();
            user.setEmailPhone("1830113021"+i);
            user.setStatusCode(i%2);
            Element element=new Element(user.getEmailPhone(),user);
            userCache.put(element);
        }

        Query query=userCache.createQuery();
        Attribute<String> emailPhoneAttr=userCache.getSearchAttribute("emailPhone");
        query=query.addCriteria(emailPhoneAttr.eq("18301130217"));
        query=query.includeValues().includeKeys().includeAttribute(emailPhoneAttr);
        Results results=query.execute();
        if(!CollectionUtils.isEmpty(results.all())){

            List<Result> resultList=results.all();
            for(Result result:resultList){
                System.out.println(result.getKey());
                System.out.println(result.getValue().toString());

            }
        }
        System.out.println(results.size());
    }
}
