package com.sane.pkg.searchable;

import com.sane.pkg.beans.User;
import net.sf.ehcache.Element;
import net.sf.ehcache.search.Attribute;
import net.sf.ehcache.search.attribute.AttributeExtractor;
import net.sf.ehcache.search.attribute.AttributeExtractorException;

import java.util.Properties;

public class UserAttribuateExtrator implements AttributeExtractor {

    public Object attributeFor(Element element, String s) throws AttributeExtractorException {

        User user= (User) element.getObjectValue();
        return  user.getEmailPhone();

    }

    public UserAttribuateExtrator(Properties properties){
       String a= properties.getProperty("a");
       String b= properties.getProperty("b");
       System.out.println("a:"+a);
       System.out.println("b:"+b);
    }
}
