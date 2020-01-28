package com.nagarro.poc.retail.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Nagarro
 * @since January 28, 2020
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    private String username;
    private Integer userTypeId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }
}
