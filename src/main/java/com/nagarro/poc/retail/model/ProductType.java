package com.nagarro.poc.retail.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Nagarro
 * @since January 23, 2020
 */
@Entity
public class ProductType {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer productTypeId;

    @Enumerated(EnumType.STRING)
    private Category category;

    public ProductType() {
    }

    public ProductType(Integer productTypeId, Category category) {
        this.productTypeId = productTypeId;
        this.category = category;
    }

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
