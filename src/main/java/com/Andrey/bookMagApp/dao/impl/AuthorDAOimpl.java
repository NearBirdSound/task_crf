package com.Andrey.bookMagApp.dao.impl;

import com.Andrey.bookMagApp.dao.GenericCrudDAO;
import com.Andrey.bookMagApp.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorDAOimpl implements GenericCrudDAO<Author> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorDAOimpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Author> getAll() {
        String sql = "SELECT * FROM Authors";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Author author = new Author();
            author.setAuthorId(rs.getInt("author_id"));
            author.setAuthorName(rs.getString("author_name"));
            return author;
        });
    }
    @Override
    public Author getById(long authorId) {
        String sql = "SELECT * FROM Authors WHERE author_id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Author author = new Author();
            author.setAuthorId(rs.getInt("author_id"));
            author.setAuthorName(rs.getString("author_name"));
            return author;
        }, authorId);
    }

    @Override
    public long add(Author author) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO Authors (author_id, author_name) VALUES (nextval('authors_author_id_seq'), ?)";
        return jdbcTemplate.update(sql, author.getAuthorName());
    }

    @Override
    public void update(Author author) {
        String sql = "UPDATE Authors SET author_name = ? WHERE author_id = ?";
        jdbcTemplate.update(sql, author.getAuthorName(), author.getAuthorId());
    }

    @Override
    public void delete(long authorId) {
        String sql = "DELETE FROM Authors WHERE author_id = ?";
        jdbcTemplate.update(sql, authorId);
    }

}
