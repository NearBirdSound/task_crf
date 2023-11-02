package com.Andrey.bookMagApp.model;

import java.math.BigDecimal;
/**
 * Класс-сущность пользователя.
 */
public class User {
    private long userId;
    private String userName;
    private BigDecimal discount;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }


}
