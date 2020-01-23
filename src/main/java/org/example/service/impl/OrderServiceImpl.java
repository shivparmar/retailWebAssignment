package org.example.service.impl;

import org.example.exception.ApplicationException;
import org.example.model.Cart;
import org.example.model.CartItem;
import org.example.model.Product;
import org.example.service.OrderService;

/**
 * @author Nagarro
 * @since January 23, 2020
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public void addProduct(Cart cart, Product product, int quantity) {
        cart.getCartItems().add(new CartItem(product, quantity, product.getPrice() * quantity));
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
