package com.sane.pkg.searchable;

import net.sf.ehcache.Element;
import net.sf.ehcache.search.attribute.DynamicAttributesExtractor;

import java.util.HashMap;
import java.util.Map;

public class DynacExtrator implements DynamicAttributesExtractor {
    public Map<String, Long> attributesFor(Element element) {
        Map<String,Long> attrMap=new HashMap<String, Long>();
        attrMap.put("hitCount",element.getHitCount());
        return attrMap;
    }
}
