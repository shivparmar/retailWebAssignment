package com.nagarro.poc.retail.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.poc.retail.model.ProductType;

/**
 * @author Nagarro
 * @since January 28, 2020
 */
@Repository
public interface ProductTypeRepository extends CrudRepository<ProductType, Integer> {

}
