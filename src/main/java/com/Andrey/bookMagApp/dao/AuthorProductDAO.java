package com.Andrey.bookMagApp.dao;

import java.util.List;

public interface AuthorProductDAO<T> {
    List<T> getAll();
    T getById(long author_id,long product_id);
    long add(T entity);
    void update(long id, T entity);
    void delete(long author_id,long product_id);
}
