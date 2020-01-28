package com.nagarro.poc.retail.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Nagarro
 * @since January 23, 2020
 */
@Entity
public class UserType {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer userTypeId;
    private String userType;
    private Integer discount;

    public UserType() {
    }

    public UserType(Integer userTypeId, String userType, Integer discount) {
        this.userTypeId = userTypeId;
        this.userType = userType;
        this.discount = discount;
    }

    public Integer getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }

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
