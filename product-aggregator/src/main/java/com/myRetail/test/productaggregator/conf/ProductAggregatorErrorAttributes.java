package com.myRetail.test.productaggregator.conf;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

public class ProductAggregatorErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> objectMap = super.getErrorAttributes(webRequest, includeStackTrace);
        objectMap.put("Application","product-aggregator");
        return  objectMap;
    }
}
