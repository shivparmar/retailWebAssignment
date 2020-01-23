package org.example.service.impl;

import org.example.model.Cart;
import org.example.model.CartItem;
import org.example.model.Category;
import org.example.service.CheckoutService;
import org.example.util.DiscountCalculator;

/**
 * @author Nagarro
 * @since January 23, 2020
 */
public class CheckoutServiceImpl implements CheckoutService {

    @Override
    public double calculateDiscount(Cart cart) {
        double discount = 0.0;
        int userDiscountPercent = DiscountCalculator.calculateDiscount(cart.getUser());

        for (CartItem cartItem: cart.getCartItems()){
            if (Category.GROCERY != cartItem.getProduct().getProductType().getCategory() && userDiscountPercent > 0){
                discount += cartItem.getTotalAmount() * userDiscountPercent / 100;
            }
        }
        return discount;
    }

    @Override
    public double calculateTotalAmount(Cart cart) {
        double totalAmount = 0.0;
        for (CartItem cartItem: cart.getCartItems()){
            totalAmount += cartItem.getTotalAmount();
        }
        return totalAmount;
    }

    /**
     *
     * @param cart c
     *
     * @return final ammount
     */
    @Override
    public double calculateFinalAmountToPaid(Cart cart) {
        double totalPayableAmount = calculateTotalAmount(cart) - calculateDiscount(cart);

        // Calculate $5 off
        int amountDiscount = (int) (totalPayableAmount / 100);
        if (amountDiscount> 0 ){
            totalPayableAmount = totalPayableAmount - (amountDiscount * 5);
        }
        return totalPayableAmount;
    }
}
