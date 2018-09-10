package com.sane.testpkg;




import com.sane.pkg.service.SeedSevice;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
