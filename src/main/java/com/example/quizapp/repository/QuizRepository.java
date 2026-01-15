package com.example.quizapp.repository;

import com.example.quizapp.model.QuizQuestion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuizRepository {

    private final JdbcTemplate jdbcTemplate;

    public QuizRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<QuizQuestion> findAll() {
        String sql = "SELECT * FROM quiz_question";
        return jdbcTemplate.query(sql, new QuizRowMapper());
    }

    public QuizQuestion findById(int id) {
        String sql = "SELECT * FROM quiz_question WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new QuizRowMapper(), id);
    }
}
