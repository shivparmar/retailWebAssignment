package com.nagarro.poc.retail.controller;


import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.nagarro.poc.retail.model.Cart;
import com.nagarro.poc.retail.model.Category;
import com.nagarro.poc.retail.model.Product;
import com.nagarro.poc.retail.model.ProductType;
import com.nagarro.poc.retail.model.User;
import com.nagarro.poc.retail.model.UserType;
import com.nagarro.poc.retail.service.CheckoutService;
import com.nagarro.poc.retail.service.OrderService;
import com.nagarro.poc.retail.service.impl.CheckoutServiceImpl;
import com.nagarro.poc.retail.service.impl.OrderServiceImpl;
import com.nagarro.poc.retail.util.DiscountCalculator;

import java.util.Date;

/**
 * @author Nagarro
 * @since January 28, 2020
 */
@SpringBootTest
@AutoConfigureMockMvc
public class CheckoutControllerTest {

    @Autowired
    private MockMvc mvc;


    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
    }

    @Test
    public void checkout() {
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
        orderService.addProduct(cart, product3, 1 );
        orderService.addProduct(cart, product4, 1 );
        orderService.addProduct(cart, product5, 1 );

        CheckoutService checkoutService = new CheckoutServiceImpl();

        System.out.println("Total Amount payable is : " + checkoutService.calculateFinalAmountToPaid(cart));
    }
}