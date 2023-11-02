package com.Andrey.bookMagApp.dao.impl;

import com.Andrey.bookMagApp.dao.AuthorProductDAO;
import com.Andrey.bookMagApp.model.AuthorProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;


@Service
public class AuthorProductDAOimpl implements AuthorProductDAO<AuthorProduct> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorProductDAOimpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<AuthorProduct> getAll() {
        String sql = "SELECT * FROM AuthorProduct";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            AuthorProduct authorProduct = new AuthorProduct();
            authorProduct.setAuthorId(rs.getInt("author_id"));
            authorProduct.setProductId(rs.getInt("product_id"));
            return authorProduct;
        });
    }
    @Override
    public AuthorProduct getById(long authorId, long productId) {
        String sql = "SELECT * FROM AuthorProduct WHERE author_id = ? AND product_id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            AuthorProduct authorProduct = new AuthorProduct();
            authorProduct.setAuthorId(rs.getInt("author_id"));
            authorProduct.setProductId(rs.getInt("product_id"));
            return authorProduct;
        }, authorId, productId);
    }

    @Override
    public long add(AuthorProduct authorProduct) {
        String sql = "INSERT INTO AuthorProduct (author_id, product_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, authorProduct.getAuthorId(), authorProduct.getProductId());
        return 0;
    }

    @Override
    public void update(long id, AuthorProduct entity) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(long authorId, long productId) {
        String sql = "DELETE FROM AuthorProduct WHERE author_id = ? AND product_id = ?";
        jdbcTemplate.update(sql, authorId, productId);
    }

}
