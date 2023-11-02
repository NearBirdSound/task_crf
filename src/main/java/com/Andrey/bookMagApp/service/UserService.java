package com.Andrey.bookMagApp.service;

import com.Andrey.bookMagApp.model.User;

import java.util.List;

public interface UserService{
    List<User> getUsersByDiscount(double discount);
    List<User> getAll();
    User getById(long id);
    long add(User entity);
    void update(User entity);
    void delete(long id);
}
