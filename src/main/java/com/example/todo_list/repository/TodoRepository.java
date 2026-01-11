package com.example.todo_list.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TodoRepository {
    private final JdbcTemplate jdbcTemplate;

    public TodoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(String title) {
        String sql = "INSERT INTO todo (title, done) VALUES (?, ?)";
        jdbcTemplate.update(sql, title, false);
    }
}