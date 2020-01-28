package com.nagarro.poc.retail.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Nagarro
 * @since January 28, 2020
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserTypeDto {

    private String userType;
    private Integer discount;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
}
