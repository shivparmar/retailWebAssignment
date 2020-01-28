package com.nagarro.poc.retail.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import java.util.Date;

/**
 * @author Nagarro
 * @since January 23, 2020
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer userId;
    private String username;

    @OneToOne
    @JoinColumn(name = "userTypeId", referencedColumnName = "userTypeId")
    private UserType userType;
    private Date registrationDate;

    public User() {
    }

    public User(Integer userId, String username, UserType userType, Date registrationDate) {
        this.userId = userId;
        this.username = username;
        this.userType = userType;
        this.registrationDate = registrationDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
