package com.myRetail.test.productaggregator.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = URLService.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class URLServiceTest {

    @Autowired
    private URLService urlService;

    @Test
    public void getProductDetailsURLTest() {
        String url = urlService.getProductDetailsURL("123", "USD");
        assertEquals("http://localhost:18080/product?id=123&amp;country=USD",url);
    }
    @Test
    public void getProductPriceURLTest() {
        String url = urlService.getProductPriceURL("123", "USD");
        assertEquals("http://localhost:28080/productPrice?id=123&amp;country=USD",url);
    }
}
