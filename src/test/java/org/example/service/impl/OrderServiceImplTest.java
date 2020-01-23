package org.example.service.impl;

import static org.junit.Assert.*;

import org.example.exception.ApplicationException;
import org.example.model.Cart;
import org.example.model.Category;
import org.example.model.Product;
import org.example.model.ProductType;
import org.example.model.User;
import org.example.model.UserType;
import org.example.service.OrderService;
import org.example.util.DiscountCalculator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * @author Nagarro
 * @since January 23, 2020
 */
public class OrderServiceImplTest {

    @Test
    public void addProduct() {

        UserType employee = new UserType(1, "employee", 30);
        UserType affiliate = new UserType(2, "affiliate", 10);
        UserType normalCustomer = new UserType(3, "normal", 0);

        User employeeUser = new User(1, "Shiv", employee, new Date());
        User affiliateUser = new User(2, "affiliateUser", affiliate, new Date());
        User user1 = new User(3, "user1", normalCustomer, new Date());
        User user2 = new User(4, "user1", normalCustomer, new Date(System.currentTimeMillis() - DiscountCalculator.TWO_YEAR_TIME_IN_MILLI));

        ProductType productType1 = new ProductType(1, Category.ELECTRONICS);
        ProductType productType2 = new ProductType(1, Category.FASHION);
        ProductType productType3 = new ProductType(1, Category.GROCERY);
        Product product1 = new Product(1, "TV", productType1, 200.0);
        Product product2 = new Product(1, "Mobile", productType1, 220.0);
        Product product3 = new Product(1, "Jean", productType2, 35.0);
        Product product4 = new Product(1, "Oil", productType3, 15.0);
        Product product5 = new Product(1, "Atta", productType3, 45.0);

        Cart cart = new Cart(1, employeeUser);

        OrderService orderService = new OrderServiceImpl();
        orderService.addProduct(cart, product1, 1 );
        Assert.assertEquals(1, cart.getCartItems().size());
    }

    @Test
    public void removeProduct() throws ApplicationException {

        UserType employee = new UserType(1, "employee", 30);
        UserType affiliate = new UserType(2, "affiliate", 10);
        UserType normalCustomer = new UserType(3, "normal", 0);

        User employeeUser = new User(1, "Shiv", employee, new Date());
        User affiliateUser = new User(2, "affiliateUser", affiliate, new Date());
        User user1 = new User(3, "user1", normalCustomer, new Date());
        User user2 = new User(4, "user1", normalCustomer, new Date(System.currentTimeMillis() - DiscountCalculator.TWO_YEAR_TIME_IN_MILLI));

        ProductType productType1 = new ProductType(1, Category.ELECTRONICS);
        ProductType productType2 = new ProductType(1, Category.FASHION);
        ProductType productType3 = new ProductType(1, Category.GROCERY);
        Product product1 = new Product(1, "TV", productType1, 200.0);
        Product product2 = new Product(1, "Mobile", productType1, 220.0);
        Product product3 = new Product(1, "Jean", productType2, 35.0);
        Product product4 = new Product(1, "Oil", productType3, 15.0);
        Product product5 = new Product(1, "Atta", productType3, 45.0);

        Cart cart = new Cart(1, employeeUser);

        OrderService orderService = new OrderServiceImpl();
        orderService.addProduct(cart, product1, 1 );
        orderService.addProduct(cart, product2, 1 );
        Assert.assertEquals(2, cart.getCartItems().size());
        orderService.removeProduct(cart, product2);
        Assert.assertEquals(1, cart.getCartItems().size());

    }

    @Test
    public void updateProductQuantity() {
        UserType employee = new UserType(1, "employee", 30);
        UserType affiliate = new UserType(2, "affiliate", 10);
        UserType normalCustomer = new UserType(3, "normal", 0);

        User employeeUser = new User(1, "Shiv", employee, new Date());
        User affiliateUser = new User(2, "affiliateUser", affiliate, new Date());
        User user1 = new User(3, "user1", normalCustomer, new Date());
        User user2 = new User(4, "user1", normalCustomer, new Date(System.currentTimeMillis() - DiscountCalculator.TWO_YEAR_TIME_IN_MILLI));

        ProductType productType1 = new ProductType(1, Category.ELECTRONICS);
        ProductType productType2 = new ProductType(1, Category.FASHION);
        ProductType productType3 = new ProductType(1, Category.GROCERY);
        Product product1 = new Product(1, "TV", productType1, 200.0);
        Product product2 = new Product(1, "Mobile", productType1, 220.0);
        Product product3 = new Product(1, "Jean", productType2, 35.0);
        Product product4 = new Product(1, "Oil", productType3, 15.0);
        Product product5 = new Product(1, "Atta", productType3, 45.0);

        Cart cart = new Cart(1, employeeUser);

        OrderService orderService = new OrderServiceImpl();
        orderService.addProduct(cart, product1, 1 );
        orderService.addProduct(cart, product2, 1 );
        Assert.assertEquals(2, cart.getCartItems().size());
        orderService.updateProductQuantity(cart, product1, 2);
        Assert.assertEquals(2, cart.getCartItems().size());
    }
}