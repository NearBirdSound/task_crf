package com.Andrey.bookMagApp.dto;

import javax.validation.constraints.NotNull;

public class AuthorProductDTO {
    @NotNull
    private long authorId;
    @NotNull
    private long productId;

    public AuthorProductDTO() {
    }

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
