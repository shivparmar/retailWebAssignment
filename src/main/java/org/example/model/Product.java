package org.example.model;

/**
 * @author Nagarro
 * @since January 23, 2020
 */
public class Product {

    private int productId;
    private String productName;
    private ProductType productType;
    private Double price;


    public Product(int productId, String productName, ProductType productType, Double price) {
        this.productId = productId;
        this.productName = productName;
        this.productType = productType;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
