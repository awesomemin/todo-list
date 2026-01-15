package com.example.todo_list.repository;

import com.example.todo_list.domain.Todo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<Todo> findAll() {
        String sql = "SELECT * FROM todo";
        RowMapper<Todo> todoRowMapper = (rs, rowNum) -> new Todo(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getBoolean("done")
        );

        return jdbcTemplate.query(sql, todoRowMapper);
    }

    public boolean checkDone(Long id) {
        String sql = "SELECT done FROM todo WHERE id = ?";
        Boolean isDone = jdbcTemplate.queryForObject(sql, Boolean.class, id);
        return isDone != null && isDone;
    }
}