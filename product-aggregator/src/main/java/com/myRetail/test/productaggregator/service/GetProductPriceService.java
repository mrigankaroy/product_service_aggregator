package com.myRetail.test.productaggregator.service;

import com.myRetail.test.productaggregator.entity.ProductPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class GetProductPriceService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private URLService urlService;

    @Async
    public CompletableFuture<ProductPrice> getProductPrice(String productId, String currencyCode) {
        String url = urlService.getProductPriceURL(productId, currencyCode);
        ProductPrice response = restTemplate.getForObject(url, ProductPrice.class);
        return CompletableFuture.completedFuture(response);
    }
}
