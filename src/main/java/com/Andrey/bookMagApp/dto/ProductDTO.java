package com.Andrey.bookMagApp.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProductDTO {
    @NotNull
    private long productId;
    @NotNull
    private String productType;
    @NotNull
    private String title;
    @DecimalMin("0.00")
    private BigDecimal purchasePrice;
    @DecimalMin("0.00")
    private BigDecimal markup;
    @Min(0)
    private int quantityProducts;

    public ProductDTO() {
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getMarkup() {
        return markup;
    }

    public void setMarkup(BigDecimal markup) {
        this.markup = markup;
    }

    public int getQuantityProducts() {
        return quantityProducts;
    }

    public void setQuantityProducts(int quantityProducts) {
        this.quantityProducts = quantityProducts;
    }

    @Override
    public String toString() {
        return "Id продукта=" + productId +
                ", Тип = " + productType +
                ", Название = " + title +
                ", Цена = " + purchasePrice +
                ", Наценка = " + markup +
                ", Количество = " + quantityProducts + '\'';
    }

    public String taskString() {
        return "Id продукта=" + productId +
                ", Тип = " + productType +
                ", Название = " + title +
                ", Цена = " + purchasePrice + '\'';
    }


}
