package com.myRetail.test.productaggregator.web.controller;

import com.myRetail.test.productaggregator.entity.ProductDetails;
import com.myRetail.test.productaggregator.service.ProductAggregatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/product")
public class ProductAggregatorController {

    @Autowired
    private ProductAggregatorService productAggregatorService;

    @RequestMapping(path = "/{productId}", method = {RequestMethod.GET},consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> getProductDetails(@PathVariable String productId) throws Exception {
        ProductDetails productDetails = productAggregatorService.getProductDetails(productId, null);
        return ResponseEntity.ok(productDetails);
    }


    @RequestMapping(path = "/{productId}", method = {RequestMethod.PUT},
            consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateProductDetails(@PathVariable String productId,
                                                  @RequestBody ProductDetails productDetails) throws Exception {

        productDetails = productAggregatorService.getProductDetails(productId, null);
        return ResponseEntity.ok(productDetails);
    }


}
