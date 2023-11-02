package com.Andrey.bookMagApp.service.impl;

import com.Andrey.bookMagApp.dao.impl.AuthorDAOimpl;
import com.Andrey.bookMagApp.model.Author;
import com.Andrey.bookMagApp.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDAOimpl authorDAOimpl;

    @Autowired
    public AuthorServiceImpl(AuthorDAOimpl authorDAOimpl) {
        this.authorDAOimpl = authorDAOimpl;
    }

    @Override
    public List<Author> getAll() {
        return this.authorDAOimpl.getAll();
    }


    @Override
    public Author getById(long id) {
        return this.authorDAOimpl.getById(id);
    }


    @Override
    public long add(Author entity) {
        return this.authorDAOimpl.add(entity);
    }


    @Override
    public void update(Author entity) {
        this.authorDAOimpl.update(entity);
    }

    @Override
    public void delete(long id) {
        this.authorDAOimpl.delete(id);
    }
}
