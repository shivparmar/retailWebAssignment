package org.example.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nagarro
 * @since January 23, 2020
 */
public class Cart {

    private int cartId;
    private User user;
    private List<CartItem> cartItems;
    private double totalAmount;
    private double discountPercent;
    private double finalAmount;

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    public Cart(int cartId, User user) {
        this.cartId = cartId;
        this.user = user;
        this.cartItems = new ArrayList<>();
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }
}
