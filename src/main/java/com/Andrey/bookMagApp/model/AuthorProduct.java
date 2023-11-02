package com.Andrey.bookMagApp.model;

/**
 * Класс-сущность многие ко многим автор - продукт.
 */

public class AuthorProduct {
    private long authorId;
    private long productId;

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
