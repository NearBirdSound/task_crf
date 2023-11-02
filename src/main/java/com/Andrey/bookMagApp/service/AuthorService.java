package com.Andrey.bookMagApp.service;

import com.Andrey.bookMagApp.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAll();
    Author getById(long id);
    long add(Author entity);
    void update(Author entity);
    void delete(long id);

}
