package com.myRetail.test.productaggregator.service;

import com.myRetail.test.productaggregator.entity.ProductDetails;
import com.myRetail.test.productaggregator.entity.ProductPrice;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

@Service
public class ProductAggregatorService {

    @Autowired
    private GetProductDetailsService getProductDetailsService;

    @Autowired
    private GetProductPriceService getProductPriceService;

    @HystrixCommand(fallbackMethod = "callStudentServiceAndGetData_Fallback")
    @Cacheable(value = "productCache",keyGenerator = "customKeyGenerator")
    public ProductDetails getProductDetails(String productId, String country) throws Exception {
        CompletableFuture<ProductDetails> productDetails = getProductDetailsService.getProductDetails(productId, country);
        CompletableFuture<ProductPrice> productPrice = getProductPriceService.getProductPrice(productId, country);
        ProductDetails details = null;
        details = productDetails.get();
        if (Objects.nonNull(details)) {
            details.setCurrentPrice(productPrice.get());
        }
        return details;
    }

    @SuppressWarnings("unused")
    private ProductDetails callStudentServiceAndGetData_Fallback(String productId, String country) {
        return new ProductDetails();
    }

}
