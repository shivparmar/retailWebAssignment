package com.nagarro.poc.retail.controller;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.poc.retail.model.Cart;
import com.nagarro.poc.retail.model.CartItem;
import com.nagarro.poc.retail.model.Product;
import com.nagarro.poc.retail.repository.CartItemRepository;

/**
 * @author Nagarro
 * @since January 28, 2020
 */
@RestController
@RequestMapping(value = "/order/")
public class OrderController {

    Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private CartItemRepository cartItemRepository;

    @GetMapping("add/{cartId}/{productId}/{quantity}")
    public Integer addProductToCart(@RequestParam Integer cartId, @RequestParam Integer productId, @RequestParam Integer quantity) {
        Integer cartItemId = null;
        try {
            LOGGER.debug("Adding product {} with quantity {} for cart id {}", productId, quantity, cartId);
            Cart cart = new Cart();
            cart.setCartId(cartId);
            Product product = new Product();
            product.setProductId(productId);
            CartItem cartItem = new CartItem();
            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
            cartItemId = cartItemRepository.save(cartItem).getId();
        } catch (HibernateException e) {
            LOGGER.error("Unable to add product in cart", e);
        }
        return cartItemId;
    }

}
