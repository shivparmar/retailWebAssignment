package org.example.model;

/**
 * @author Nagarro
 * @since January 23, 2020
 */
public class ProductType {

    private int productTypeId;
    private Category category;

    public ProductType() {
    }

    public ProductType(int productTypeId, Category category) {
        this.productTypeId = productTypeId;
        this.category = category;
    }

    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
