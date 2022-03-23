package com.jdbc.dao;

import com.jdbc.api.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("studentDao")
public class StudentDAOImpl implements StudentDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;


    // Creating a Setter method for the dependency Injection
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // The Update method of the jdbcTemplate is designed to deal with DML Commands
    // Truncating a table is a part of the DDL command
    // To perform a DDL operation using jdbcTemplate we use to execute() method

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

    @Override
    public boolean deleteRecordByRollNo(int rollNo) {

        String sql = "DELETE FROM Student WHERE rool_no = ?";

        int rowUpdated = jdbcTemplate.update(sql, rollNo);

        return rowUpdated == 1;
    }

    @Override
    public int deleteRecordByStudentNameOrStudentAddress(String studentName, String studentAddress) {

        String sql = "DELETE FROM Student WHERE student_name = ? OR student_address = ?";

        String[] arguments = {studentName ,studentAddress};

        int noOfRowsDeleted = jdbcTemplate.update(sql, arguments);

        System.out.println("No of rows got deleted are: " + noOfRowsDeleted);

        return noOfRowsDeleted;
    }

    @Override
    public void insert(List<Student> students) {
        String sql = "INSERT INTO Student VALUES(?, ?, ?)";

        ArrayList<Object[]> sqlArgs = new ArrayList<>();

        for (Student tempStudent : students) {
            Object[] studentData = {tempStudent.getRollNo(), tempStudent.getName(), tempStudent.getAddress()};
            sqlArgs.add(studentData);
        }

        jdbcTemplate.batchUpdate(sql, sqlArgs);

        System.out.println("Batch Update Completed!!!");
    }


    public void cleanUp(){
        String sql = "TRUNCATE TABLE Student";
        jdbcTemplate.execute(sql);
        System.out.println("Table cleaned up>>>> ");
    }

    /*
    public DataSource getDataSource() {
        String url = "jdbc:postgresql://localhost:5432/student?useSSL=false";
        String username = "student";
        String password = "student";

        DataSource dataSource = new DriverManagerDataSource(url, username, password);

        return dataSource;
    }
    */

}
