package org.example.service;

import org.example.exception.ApplicationException;
import org.example.model.Cart;
import org.example.model.Product;

/**
 * @author Nagarro
 * @since January 23, 2020
 */
public interface OrderService {

        void addProduct(Cart cart, Product product, int quantity);

        void removeProduct(Cart cart, Product product) throws ApplicationException;

        void updateProductQuantity(Cart cart, Product product, int quantity);
}
