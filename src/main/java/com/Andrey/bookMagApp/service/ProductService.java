package com.Andrey.bookMagApp.service;

import com.Andrey.bookMagApp.model.Product;

import java.util.List;

public interface ProductService {
    // get products by id_author
    List<Product> getProductsByAuthorId(long authorId);
    //CRUD operation
    List<Product> getAll();
    Product getById(long productId);
    long add(Product product);
    void update(Product product);
    void delete(long productId);
}