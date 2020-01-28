package com.nagarro.poc.retail.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.poc.retail.model.Cart;
import com.nagarro.poc.retail.model.CartItem;

/**
 * @author Nagarro
 * @since January 28, 2020
 */
@Repository
public interface CartItemRepository extends CrudRepository<CartItem, Integer> {

}
