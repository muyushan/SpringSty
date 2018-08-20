package com.sane.testpkg;




import com.sane.pkg.exceptions.BizException;
import com.sane.pkg.utils.CommonUtil;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.config.Configuration;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    @org.junit.Test
    public  void test1(){
        try {

           String code= CommonUtil.generageNextCode("CA".substring(0,1),"CA".substring(1,2));
           System.out.println(code);
        }catch (BizException ex){
            System.out.println(ex
            .getMessage());
        }
    }

    @org.junit.Test
    public  void test2(){

    }
}
