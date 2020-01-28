package com.nagarro.poc.retail.controller;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.poc.retail.dto.ProductDto;
import com.nagarro.poc.retail.model.Category;
import com.nagarro.poc.retail.model.Product;
import com.nagarro.poc.retail.model.ProductType;
import com.nagarro.poc.retail.repository.ProductRepository;
import com.nagarro.poc.retail.repository.ProductTypeRepository;

/**
 * @author Nagarro
 * @since January 28, 2020
 */
@RestController
@RequestMapping(value = "/product/")
public class ProductController {
    Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @PostMapping("add")
    public Integer addProduct(@RequestBody ProductDto productDto) {
        Integer productId = null;
        try {
            Product product = new Product();
            product.setProductName(productDto.getProductName());
            product.setPrice(productDto.getPrice());
            ProductType productType = new ProductType();
            productType.setProductTypeId(productDto.getProductTypeId());
            product.setProductType(productType);
            LOGGER.info("Adding Product ");
            Product productModel = productRepository.save(product);
            productId = productModel.getProductId();
        } catch (HibernateException e) {
            LOGGER.error("Unable to add product", e);
        }
        return productId;
    }

    @GetMapping("type/add/{category}")
    public Integer addProductType(@RequestParam String category) {
        Integer productId = null;
        try {
            ProductType productType = new ProductType();
            productType.setCategory(Category.valueOf(category));
            LOGGER.info("Adding Product Type");
            ProductType productModel = productTypeRepository.save(productType);
            productId = productModel.getProductTypeId();
        } catch (HibernateException e) {
            LOGGER.error("Unable to add product", e);
        }
        return productId;
    }

}
