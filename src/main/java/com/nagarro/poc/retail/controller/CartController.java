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
import com.nagarro.poc.retail.model.User;
import com.nagarro.poc.retail.repository.CartRepository;

/**
 * @author Nagarro
 * @since January 28, 2020
 */
@RestController
@RequestMapping(value = "/cart/")
public class CartController {

    Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private CartRepository cartRepository;

    @GetMapping("create/{userId}")
    public Integer createCard(@RequestParam Integer userId) {
        Integer cartId = null;
        try {
            LOGGER.info("Creating new cart for user {}", userId);
            Cart cart = new Cart();
            User user = new User();
            user.setUserId(userId);
            cart.setUser(user);
            Cart cartModel = cartRepository.save(cart);
            LOGGER.info("Creating new cart for user {}", userId);
            cartId = cartModel.getCartId();
        } catch (HibernateException e) {
            LOGGER.error("Unable to create cart", e);
        }
        return cartId;

    }

    @GetMapping("delete/{cartId}")
    public void deleteCard(@RequestParam Integer cartId) {
        try {
            LOGGER.info("Deleting a cart {}", cartId);
            cartRepository.deleteById(cartId);
            LOGGER.debug("cart {} has been deleted", cartId);
        } catch (HibernateException e) {
            LOGGER.error("Unable to create cart", e);
        }

    }
}
