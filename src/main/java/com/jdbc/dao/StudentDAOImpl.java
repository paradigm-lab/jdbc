package com.jdbc.dao;

import com.jdbc.api.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class StudentDAOImpl implements StudentDAO{

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

    @Override
    public void insert(Student student) {

        // We are using the question marks inorder for as to insert the data dynamically
        // By using the SQL statement
        // We will fill in the '?' with real values "DURING RUNTIME"
        String sql = "INSERT INTO Student VALUES(?, ?, ?)";

        // We have stored all the arguments inside an Object[] because we can't use String[] or Integer[]
        // Because we have student.getRollNo() which will give an Integer and getName() will give me a String
        Object[] arg = {student.getRollNo(), student.getName(), student.getAddress()};

        int noOfRowInserted = jdbcTemplate.update(sql, arg);

        System.out.println("No of row inserted is: " + noOfRowInserted);
    }

    public DataSource getDataSource() {
        String url = "jdbc:postgresql://localhost:5432/student?useSSL=false";
        String username = "student";
        String password = "student";

        DataSource dataSource = new DriverManagerDataSource(url, username, password);

        return dataSource;
    }

}
