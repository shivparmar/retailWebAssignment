package com.nagarro.poc.retail.util;

import com.nagarro.poc.retail.model.User;

/**
 * @author Nagarro
 * @since January 23, 2020
 */
public interface DiscountCalculator {


    static int calculateDiscount(User user) {
        int discount = 0;
        if (user.getUserType().getDiscount() > 0) {
            discount = user.getUserType().getDiscount();
        } else if (isOldCustomer(user)) {
            discount = 5;
        }
        return discount;
    }

    long TWO_YEAR_TIME_IN_MILLI = 63072000000L;

    static boolean isOldCustomer(User user) {
        boolean isOld = false;
        long currentTimeInMilli = System.currentTimeMillis();
        if (currentTimeInMilli - user.getRegistrationDate().getTime() > TWO_YEAR_TIME_IN_MILLI) {
            isOld = true;
        }
        return isOld;
    }

}
