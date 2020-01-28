package com.nagarro.poc.retail.service;

import com.nagarro.poc.retail.exception.ApplicationException;
import com.nagarro.poc.retail.model.Cart;
import com.nagarro.poc.retail.model.Product;

/**
 * @author Nagarro
 * @since January 23, 2020
 */
public interface OrderService {

        void addProduct(Cart cart, Product product, int quantity);

        void removeProduct(Cart cart, Product product) throws ApplicationException;

        void updateProductQuantity(Cart cart, Product product, int quantity);
}
