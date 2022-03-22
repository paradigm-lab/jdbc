package com.jdbc.dao;

import com.jdbc.api.Student;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDAOImpl implements StudentDAO{

    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Student student) {

        // We are using the question marks inorder for as to insert the data dynamically
        // By using the SQL statement
        // We will fill in the '?' with real values "DURING RUNTIME"
        String sql = "INSERT INTO student VALUES(?, ?, ?)";
        jdbcTemplate.update(sql);
    }

}
