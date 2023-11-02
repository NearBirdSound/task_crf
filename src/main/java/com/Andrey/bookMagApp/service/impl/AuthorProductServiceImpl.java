package com.Andrey.bookMagApp.service.impl;

import com.Andrey.bookMagApp.dao.impl.AuthorProductDAOimpl;
import com.Andrey.bookMagApp.model.AuthorProduct;
import com.Andrey.bookMagApp.service.AuthorProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorProductServiceImpl implements AuthorProductService {

    private final AuthorProductDAOimpl authorProductDAOimpl;

    @Autowired
    public AuthorProductServiceImpl(AuthorProductDAOimpl authorProductDAOimpl) {
        this.authorProductDAOimpl = authorProductDAOimpl;
    }

    @Override
    public List<AuthorProduct> getAll() {
        return this.authorProductDAOimpl.getAll();
    }

    @Override
    public long add(AuthorProduct entity) {
        return this.authorProductDAOimpl.add(entity);
    }

    @Override
    public void delete(long authorId, long productId) {
        this.authorProductDAOimpl.delete(authorId,productId);
    }

}
