package com.Andrey.bookMagApp.dao.impl;

import com.Andrey.bookMagApp.dao.GenericCrudDAO;
import com.Andrey.bookMagApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserDAOimpl implements GenericCrudDAO<User> {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAOimpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //Find Users By discount
    public List<User> getUsersByDiscount(double discount) {
        BigDecimal discountDec = BigDecimal.valueOf(discount/100);
        String sql = "SELECT * FROM Users WHERE discount >= ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            User user = new User();
            user.setUserId(rs.getInt("user_id"));
            user.setUserName(rs.getString("user_name"));
            user.setDiscount(rs.getBigDecimal("discount"));
            return user;
        }, discountDec);
    }

    //CRUD Operation
    public List<User> getAll() {
        String sql = "SELECT * FROM Users";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            User user = new User();
            user.setUserId(rs.getInt("user_id"));
            user.setUserName(rs.getString("user_name"));
            user.setDiscount(rs.getBigDecimal("discount"));
            return user;
        });
    }

    @Override
    public User getById(long userId) {
        String sql = "SELECT * FROM Users WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            User user = new User();
            user.setUserId(rs.getInt("user_id"));
            user.setUserName(rs.getString("user_name"));
            user.setDiscount(rs.getBigDecimal("discount"));
            return user;
        }, userId);
    }

    @Override
    public long add(User user) {
        String sql = "INSERT INTO Users (user_id, user_name, discount) VALUES (nextval('users_user_id_seq'), ?, ?)";
        return jdbcTemplate.update(sql, user.getUserName(), user.getDiscount());
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE Users SET user_name = ?, discount = ? WHERE user_id = ?";
        jdbcTemplate.update(sql, user.getUserName(), user.getDiscount(), user.getUserId());
    }

    @Override
    public void delete(long userId) {
        String sql = "DELETE FROM Users WHERE user_id = ?";
        jdbcTemplate.update(sql, userId);
    }

}
