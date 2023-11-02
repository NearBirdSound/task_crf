package com.Andrey.bookMagApp.dao.impl;

import com.Andrey.bookMagApp.dao.GenericCrudDAO;
import com.Andrey.bookMagApp.model.PurchaseHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Реализация DAO для сущности PurchaseHistory.
 */
@Service
public class PurchaseHistoryDAOimpl implements GenericCrudDAO<PurchaseHistory> {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PurchaseHistoryDAOimpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<PurchaseHistory> getAll() {
        String sql = "SELECT * FROM PurchaseHistory";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            PurchaseHistory purchaseHistory = new PurchaseHistory();
            purchaseHistory.setPurchaseId(rs.getInt("purchase_id"));
            purchaseHistory.setUserId(rs.getInt("user_id"));
            purchaseHistory.setProductId(rs.getInt("product_id"));
            purchaseHistory.setQuantity(rs.getInt("quantity"));
            purchaseHistory.setPurchaseDate(rs.getDate("purchase_date"));
            purchaseHistory.setCost(rs.getBigDecimal("total_cost"));
            return purchaseHistory;
        });
    }

    @Override
    public PurchaseHistory getById(long purchaseId) {
        String sql = "SELECT * FROM PurchaseHistory WHERE purchase_id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            PurchaseHistory purchaseHistory = new PurchaseHistory();
            purchaseHistory.setPurchaseId(rs.getInt("purchase_id"));
            purchaseHistory.setUserId(rs.getInt("user_id"));
            purchaseHistory.setProductId(rs.getInt("product_id"));
            purchaseHistory.setQuantity(rs.getInt("quantity"));
            purchaseHistory.setPurchaseDate(rs.getDate("purchase_date"));
            purchaseHistory.setCost(rs.getBigDecimal("total_cost"));
            return purchaseHistory;
        }, purchaseId);
    }

    @Override
    public long add(PurchaseHistory purchaseHistory) {
        String sql = "INSERT INTO PurchaseHistory (purchase_id, user_id, product_id, quantity, purchase_date, total_cost) VALUES (nextval('purchasehistory_purchase_id_seq'), ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, purchaseHistory.getUserId(), purchaseHistory.getProductId(), purchaseHistory.getQuantity(), purchaseHistory.getPurchaseDate(), purchaseHistory.getCost());

    }

    @Override
    public void update(PurchaseHistory purchaseHistory) {
        String sql = "UPDATE PurchaseHistory SET user_id = ?, product_id = ?, quantity = ?, purchase_date = ?, total_cost = ? WHERE purchase_id = ?";
        jdbcTemplate.update(sql, purchaseHistory.getUserId(), purchaseHistory.getProductId(), purchaseHistory.getQuantity(), purchaseHistory.getPurchaseDate(), purchaseHistory.getCost(), purchaseHistory.getPurchaseId());
    }

    @Override
    public void delete(long purchaseId) {
        String sql = "DELETE FROM PurchaseHistory WHERE purchase_id = ?";
        jdbcTemplate.update(sql, purchaseId);
    }

}
