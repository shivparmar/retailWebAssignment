package com.nagarro.poc.retail.service.impl;

import com.nagarro.poc.retail.exception.ApplicationException;
import com.nagarro.poc.retail.model.Cart;
import com.nagarro.poc.retail.model.CartItem;
import com.nagarro.poc.retail.model.Product;
import com.nagarro.poc.retail.service.OrderService;

/**
 * @author Nagarro
 * @since January 23, 2020
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public void addProduct(Cart cart, Product product, int quantity) {
        cart.getCartItems().add(new CartItem(product, quantity));
    }

    @Override
    public void removeProduct(Cart cart, Product product) throws ApplicationException {
        CartItem removableCartItem = null;
        for (CartItem cartItem: cart.getCartItems() ) {
            if (cartItem.getProduct().getProductId() == product.getProductId()){
                removableCartItem = cartItem;
            }
        }
        if (removableCartItem!=null){
            cart.getCartItems().remove(removableCartItem);
        } else {
            throw new ApplicationException("Error101", "Item not available");
        }
    }

    @Override
    public void updateProductQuantity(Cart cart, Product product, int quantity) {
        for (CartItem cartItem: cart.getCartItems() ) {
            if (cartItem.getProduct().getProductId() == product.getProductId()){
                cartItem.setQuantity(quantity);
            }
        }

    }
}
