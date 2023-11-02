package com.Andrey.bookMagApp.model;

import java.math.BigDecimal;
/**
 * Класс-сущность продукта.
 */
public class Product {
    private long productId;
    private String productType;
    private String title;
    private BigDecimal purchasePrice;
    private BigDecimal markup;
    private int quantityProducts;

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
}
