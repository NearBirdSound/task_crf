package com.Andrey.bookMagApp.dao;

import java.util.List;

public interface GenericCrudDAO<T> {
    List<T> getAll();
    T getById(long id);
    long add(T entity);
    void update(T entity);
    void delete(long id);
}
