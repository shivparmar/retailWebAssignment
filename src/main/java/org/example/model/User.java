package org.example.model;

import java.util.Date;

/**
 * @author Nagarro
 * @since January 23, 2020
 */
public class User {


    private Integer userId;
    private String username;
    private UserType userType;
    private Date registrationDate;

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
