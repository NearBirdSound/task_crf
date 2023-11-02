package com.Andrey.bookMagApp.service.impl;

import com.Andrey.bookMagApp.dao.impl.ProductDAOimpl;
import com.Andrey.bookMagApp.model.Product;
import com.Andrey.bookMagApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAOimpl productDAOimpl;

    @Autowired
    public ProductServiceImpl(ProductDAOimpl productDAOimpl) {
        this.productDAOimpl = productDAOimpl;
    }

    @Override
    public List<Product> getProductsByAuthorId(long authorId) {
        return this.productDAOimpl.getProductsByAuthorId(authorId);
    }

    @Override
    public List<Product> getAll() {
        return this.productDAOimpl.getAll();
    }


    @Override
    public Product getById(long id) {
        return this.productDAOimpl.getById(id);
    }


    @Override
    public long add(Product entity) {
        return this.productDAOimpl.add(entity);
    }


    @Override
    public void update(Product entity) {
        this.productDAOimpl.update(entity);
    }

    @Override
    public void delete(long id) {
        this.productDAOimpl.delete(id);
    }

}
