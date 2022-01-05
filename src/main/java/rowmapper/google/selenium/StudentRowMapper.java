package rowmapper.google.selenium;

import com.jdbc.api.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet res, int rowNum) throws SQLException {

        Student newStudent = new Student();

        newStudent.setRollNo(res.getInt("roll_no"));
        newStudent.setName(res.getString("student_name"));
        newStudent.setAddress(res.getString("student_addres"));

        //System.out.println("MapRow() called....");

        return newStudent;
    }
}
