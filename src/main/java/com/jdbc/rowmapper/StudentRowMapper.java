package com.jdbc.rowmapper;

import com.jdbc.api.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet res, int rowNum) throws SQLException {

        Student student = new Student();

        // Using the column lable
        student.setRollNo(res.getInt("rool_no"));
        student.setName(res.getString("student_name"));
        student.setAddress(res.getString("student_address"));

        System.out.println("mapRow() called.....");

        return student;
    }
}
