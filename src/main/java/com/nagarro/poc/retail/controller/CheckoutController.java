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
import com.nagarro.poc.retail.repository.CartRepository;
import com.nagarro.poc.retail.service.CheckoutService;

import java.util.Optional;

/**
 * @author Nagarro
 * @since January 28, 2020
 */
@RestController
@RequestMapping("/checkout/")
public class CheckoutController {

    Logger LOGGER = LoggerFactory.getLogger(CheckoutController.class);

    @Autowired
    private CheckoutService checkoutService;

    @Autowired
    private CartRepository cartRepository;

    @GetMapping("discount/{cartId}")
    public Double discount(@RequestParam Integer cartId) {
        Double discount = null;
        try {
            LOGGER.info("Checking out cart with cartId :{}", cartId);
            Optional<Cart> cart = cartRepository.findById(cartId);
            discount = checkoutService.calculateDiscount(cart.get());
        }catch (HibernateException e){
            LOGGER.error("Unable to calculate discount ", e);
        }
        return discount;
    }


    @GetMapping("total/{cartId}")
    public Double total(@RequestParam Integer cartId) {
        Double discount = null;
        try {
            LOGGER.info("Checking out cart with cartId :{}", cartId);
            Optional<Cart> cart = cartRepository.findById(cartId);
            discount = checkoutService.calculateTotalAmount(cart.get());
        }catch (HibernateException e){
            LOGGER.error("Unable to calculate discount ", e);
        }
        return discount;
    }

    @GetMapping("payable/{cartId}")
    public Double payable(@RequestParam Integer cartId) {
        Double discount = null;
        try {
            LOGGER.info("Checking out cart with cartId :{}", cartId);
            Optional<Cart> cart = cartRepository.findById(cartId);
            discount = checkoutService.calculateFinalAmountToPaid(cart.get());
        }catch (HibernateException e){
            LOGGER.error("Unable to calculate discount ", e);
        }
        return discount;
    }

}
