package com.myRetail.test.productaggregator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetails implements Serializable {
    private String productId;
    private String name;
    private String description;
    private String currencyCode;
    private ProductPrice currentPrice;
}
