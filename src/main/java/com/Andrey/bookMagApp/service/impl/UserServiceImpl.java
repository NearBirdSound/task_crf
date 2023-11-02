package com.Andrey.bookMagApp.service.impl;

import com.Andrey.bookMagApp.dao.impl.UserDAOimpl;
import com.Andrey.bookMagApp.model.User;
import com.Andrey.bookMagApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAOimpl userDAOimpl;

    @Autowired
    public UserServiceImpl(UserDAOimpl userDAOimpl) {
        this.userDAOimpl = userDAOimpl;
    }

    //Get User By Discount

    @Override
    public List<User> getUsersByDiscount(double discount) {
        return this.userDAOimpl.getUsersByDiscount(discount);
    }

    //CRUD operation

    @Override
    public List<User> getAll() {
        return this.userDAOimpl.getAll();
    }

    @Override
    public User getById(long id) {
        return this.userDAOimpl.getById(id);
    }

    @Override
    public long add(User entity) {
        return this.userDAOimpl.add(entity);
    }

    @Override
    public void update(User entity) {
        this.userDAOimpl.update(entity);
    }
    @Override
    public void delete(long id) {
        this.userDAOimpl.delete(id);
    }
}
