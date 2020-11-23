package com.myRetail.test.productaggregator.service;

import com.myRetail.test.productaggregator.entity.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class GetProductDetailsService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private URLService urlService;

    @Async
    public CompletableFuture<ProductDetails> getProductDetails(String productId, String currencyCode) {
        String url = urlService.getProductDetailsURL(productId, currencyCode);
        ProductDetails response = restTemplate.getForObject(url, ProductDetails.class);
        return CompletableFuture.completedFuture(response);
    }
}
