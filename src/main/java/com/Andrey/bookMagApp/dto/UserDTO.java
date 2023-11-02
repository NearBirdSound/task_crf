package com.Andrey.bookMagApp.dto;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class UserDTO {
    @NotNull
    private long userId;
    @NotNull
    private String userName;

    @DecimalMin("0.00")
    @DecimalMax("0.05")
    private BigDecimal discount;

    public UserDTO() {
    }

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

    @Override
    public String toString() {
        return "Id пользователя = " + userId + ", Имя пользователя = " + userName + ", скидка = " + discount + '\'';
    }

}
