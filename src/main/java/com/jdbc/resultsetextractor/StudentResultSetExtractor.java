package com.jdbc.resultsetextractor;

import com.jdbc.api.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentResultSetExtractor implements ResultSetExtractor<List<Student>> {

    @Override
    public List<Student> extractData(ResultSet res) throws SQLException, DataAccessException {

        List<Student> studentList = new ArrayList<>();

        while (res.next()) {
            Student student = new Student();

            student.setRollNo(res.getInt("rool_no"));
            student.setName(res.getString("student_name"));
            student.setAddress(res.getString("student_address"));

            studentList.add(student);
        }

        System.out.println("Inside the extractData method of ResultSetExtractor");

        return studentList;
    }

}
