package com.nagarro.poc.retail.service.impl;

import org.springframework.stereotype.Service;

import com.nagarro.poc.retail.model.Cart;
import com.nagarro.poc.retail.model.CartItem;
import com.nagarro.poc.retail.model.Category;
import com.nagarro.poc.retail.service.CheckoutService;
import com.nagarro.poc.retail.util.DiscountCalculator;

/**
 * @author Nagarro
 * @since January 23, 2020
 */
@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Override
    public double calculateDiscount(Cart cart) {
        double discount = 0.0;
        int userDiscountPercent = DiscountCalculator.calculateDiscount(cart.getUser());

        for (CartItem cartItem: cart.getCartItems()){
            if (Category.GROCERY != cartItem.getProduct().getProductType().getCategory() && userDiscountPercent > 0){
                discount += (cartItem.getProduct().getPrice() * cartItem.getQuantity()) * userDiscountPercent / 100;
            }
        }
        return discount;
    }

    @Override
    public double calculateTotalAmount(Cart cart) {
        double totalAmount = 0.0;
        for (CartItem cartItem: cart.getCartItems()){
            totalAmount += cartItem.getProduct().getPrice() * cartItem.getQuantity();
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
