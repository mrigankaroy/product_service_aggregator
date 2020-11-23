package com.myRetail.test.productaggregator.service;

import com.myRetail.test.productaggregator.entity.ProductDetails;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = GetProductDetailsService.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class GetProductDetailsServiceTest {

    @MockBean
    private RestTemplate restTemplate;

    @MockBean
    private URLService urlService;

    @Autowired
    private GetProductDetailsService getProductDetailsService;

    @Test
    public void getProductDetailsTest() throws ExecutionException, InterruptedException {
        ProductDetails mockProductDetails = new ProductDetails();
        mockProductDetails.setProductId("123");

        Mockito.when(restTemplate.getForObject(
                "http://localhost:18080/product?id=123&amp;country=USD", ProductDetails.class))
                .thenReturn(mockProductDetails);
        when(urlService.getProductDetailsURL("123", "USD")).thenReturn("http://localhost:18080/product?id=123&amp;country=USD");

        CompletableFuture<ProductDetails> productDetails = getProductDetailsService.getProductDetails("123", "USD");
        ProductDetails responseProductDetails =  productDetails.get();
        assertEquals(mockProductDetails,responseProductDetails);
    }

    @Test
    public void getProductDetailsErrorTest() throws ExecutionException, InterruptedException {
        ProductDetails mockProductDetails = new ProductDetails();
        mockProductDetails.setProductId("123");

        Mockito.when(restTemplate.getForObject(
                "http://localhost:18080/product?id=123&amp;country=USD", ProductDetails.class))
                .thenThrow(new Exception("Mock message"));
        when(urlService.getProductDetailsURL("123", "USD")).thenReturn("http://localhost:18080/product?id=123&amp;country=USD");

        CompletableFuture<ProductDetails> productDetails = getProductDetailsService.getProductDetails("123", "USD");
        ProductDetails responseProductDetails =  productDetails.get();
        assertEquals(mockProductDetails,responseProductDetails);
    }


}
