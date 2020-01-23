package org.example.service;

import org.example.model.Cart;

/**
 * @author Nagarro
 * @since January 23, 2020
 */
public interface CheckoutService {

    double calculateDiscount(Cart cart);
    double calculateTotalAmount(Cart cart);
    double calculateFinalAmountToPaid(Cart cart);
}
