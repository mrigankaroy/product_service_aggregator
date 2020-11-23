package com.myRetail.test.productaggregator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPrice implements Serializable {
    private String productId;
    private double price;
    private String currencyCode;
    private int version;
}
