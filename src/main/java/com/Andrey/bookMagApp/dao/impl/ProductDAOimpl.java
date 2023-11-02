package com.Andrey.bookMagApp.dao.impl;

import com.Andrey.bookMagApp.dao.GenericCrudDAO;
import com.Andrey.bookMagApp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDAOimpl implements GenericCrudDAO<Product> {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDAOimpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    // get products by id_author
    public List<Product> getProductsByAuthorId(long authorId) {
        String sql = "SELECT p.product_id, p.product_type, p.title, p.purchase_price, p.markup " +
                "FROM Products p " +
                "INNER JOIN AuthorProduct ap ON p.product_id = ap.product_id " +
                "WHERE ap.author_id = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Product product = new Product();
            product.setProductId(rs.getInt("product_id"));
            product.setProductType(rs.getString("product_type"));
            product.setTitle(rs.getString("title"));
            product.setPurchasePrice(rs.getBigDecimal("purchase_price"));
            product.setMarkup(rs.getBigDecimal("markup"));
            return product;
        }, authorId);
    }


    //CRUD operation
    @Override
    public List<Product> getAll() {
        String sql = "SELECT * FROM Products";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Product product = new Product();
            product.setProductId(rs.getInt("product_id"));
            product.setProductType(rs.getString("product_type"));
            product.setTitle(rs.getString("title"));
            product.setPurchasePrice(rs.getBigDecimal("purchase_price"));
            product.setMarkup(rs.getBigDecimal("markup"));
            return product;
        });
    }
    @Override
    public Product getById(long productId) {
        String sql = "SELECT * FROM Products WHERE product_id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Product product = new Product();
            product.setProductId(rs.getInt("product_id"));
            product.setProductType(rs.getString("product_type"));
            product.setTitle(rs.getString("title"));
            product.setPurchasePrice(rs.getBigDecimal("purchase_price"));
            product.setMarkup(rs.getBigDecimal("markup"));
            product.setQuantityProducts((rs.getInt("quantity")));
            return product;
        }, productId);
    }

    @Override
    public long add(Product product) {
        String sql = "INSERT INTO Products (product_id, product_type, title, purchase_price, markup, quantity) VALUES (nextval('products_product_id_seq'), ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, product.getProductType(), product.getTitle(), product.getPurchasePrice(), product.getMarkup(), product.getQuantityProducts());
    }
    @Override
    public void update(Product product) {
        String sql = "UPDATE Products SET product_type = ?, title = ?, purchase_price = ?, markup = ?, quantity = ? WHERE product_id = ?";
        jdbcTemplate.update(sql, product.getProductType(), product.getTitle(), product.getPurchasePrice(), product.getMarkup(), product.getQuantityProducts(), product.getProductId());
    }
    @Override
    public void delete(long productId) {
        String sql = "DELETE FROM Products WHERE product_id = ?";
        jdbcTemplate.update(sql, productId);
    }

}
