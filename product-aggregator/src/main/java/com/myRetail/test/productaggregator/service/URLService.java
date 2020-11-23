package com.myRetail.test.productaggregator.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class URLService {

    @Value("${product.details.url.template:http://localhost:18080/product?id=%s&amp;country=%s}")
    private String productDetailsTemplate;

    @Value("${product.price.url.template:http://localhost:28080/productPrice?id=%s&amp;country=%s}")
    private String productPriceDetailsTemplate;

    @Value("${product.default.currency:USD}")
    private String defaultCurrencyCode;


    public String getProductDetailsURL(String productId, String currencyCode) {
        return String.format(productDetailsTemplate, productId, currencyCode);
    }

    public String getProductPriceURL(String productId, String currencyCode) {
        return String.format(productPriceDetailsTemplate, productId, currencyCode);
    }
}
