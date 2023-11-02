package com.Andrey.bookMagApp.service;

import com.Andrey.bookMagApp.model.AuthorProduct;

import java.util.List;

public interface AuthorProductService {
    List<AuthorProduct> getAll();
    long add(AuthorProduct entity);
    void delete(long authorId, long productId);

}
