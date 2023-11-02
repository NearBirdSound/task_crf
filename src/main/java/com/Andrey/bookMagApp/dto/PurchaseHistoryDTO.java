package com.Andrey.bookMagApp.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class PurchaseHistoryDTO {
    @NotNull
    private int purchaseId;
    @NotNull
    private long userId;
    @NotNull
    private long productId;
    @Min(1)
    private int quantity;
    @DecimalMin("0.00")
    private BigDecimal cost;
    @NotNull
    private String purchaseDate;

    public PurchaseHistoryDTO() {
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Id заказа= " + purchaseId + ", Id пользователя = " + userId + ", Id продукта =" + productId +
                ", количество =" + quantity + ", цена =" + cost + ", дата ='" + purchaseDate + '\'';
    }
}
