package com.nagarro.poc.retail.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.poc.retail.model.Product;

/**
 * @author Nagarro
 * @since January 28, 2020
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    Product findByProductId(long productId);

}
