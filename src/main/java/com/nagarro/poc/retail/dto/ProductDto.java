package com.nagarro.poc.retail.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Nagarro
 * @since January 28, 2020
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDto {

    private String productName;
    private Integer productTypeId;
    private Double price;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
