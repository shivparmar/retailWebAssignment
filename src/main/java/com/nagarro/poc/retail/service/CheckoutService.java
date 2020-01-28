package com.nagarro.poc.retail.service;

import com.nagarro.poc.retail.model.Cart;

/**
 * @author Nagarro
 * @since January 23, 2020
 */
public interface CheckoutService {

    double calculateDiscount(Cart cart);

    double calculateTotalAmount(Cart cart);

    double calculateFinalAmountToPaid(Cart cart);
}
