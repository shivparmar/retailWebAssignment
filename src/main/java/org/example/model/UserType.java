package org.example.model;

/**
 * @author Nagarro
 * @since January 23, 2020
 */
public class UserType {

    private int userTypeId;
    private String userType;
    private int discount;

    public UserType(int userTypeId, String userType, int discount) {
        this.userTypeId = userTypeId;
        this.userType = userType;
        this.discount = discount;
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
