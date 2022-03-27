package com.jdbc.dao;

import com.jdbc.api.Student;
import com.jdbc.resultsetextractor.StudentAddressResultSetExtractor;
import com.jdbc.resultsetextractor.StudentResultSetExtractor;
import com.jdbc.rowmapper.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

        Object[] arguments = {studentName ,studentAddress};

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

    @Override
    public List<Student> findAllStudent() {

        String selectSql = "SELECT * FROM Student";

        List<Student> studentList = jdbcTemplate.query(selectSql, new StudentRowMapper());

        return studentList;
    }

    @Override
    public Student findStudentByRollNo(int rollNo) {
        String selectSql = "SELECT rool_no as rollNo, student_name as name, student_address as address FROM Student WHERE rool_no = ?";

        Student student = jdbcTemplate.queryForObject(selectSql, new BeanPropertyRowMapper<Student>(Student.class), rollNo);

        return student;
    }

    @Override
    public List<Student> findStudentByName(String name) {

        String sql = "SELECT * FROM Student WHERE student_name = ?";

        List<Student> studentsList = jdbcTemplate.query(sql, new StudentResultSetExtractor(), name);

        return studentsList;
    }

    @Override
    public Map<String, List<String>> groupStudentByAddress() {
        String sql = "SELECT * FROM Student";

        Map<String, List<String>> query = jdbcTemplate.query(sql, new StudentAddressResultSetExtractor());

        return query;
    }

    @Override
    public int updateStudent(Student student) {
        String sql = "UPDATE student SET student_address = ? WHERE rool_no = ?";

        Object[] args = {student.getAddress(), student.getRollNo()};

        System.out.println("Row updated.....");

        return jdbcTemplate.update(sql, args);
    }

    @Override
    @Transactional
    public int updateStudent(List<Student> studentList) {

        int updateCount = 0;

        String sql = "UPDATE student SET student_address = ? WHERE rool_no = ?";

        int[] batchUpdate = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int index) throws SQLException {
                // I need to set the arguments for the prepared statement
                ps.setString(1, studentList.get(index).getAddress());
                ps.setInt(2, studentList.get(index).getRollNo());

                System.out.println("Inside setValues method");
            }

            @Override
            public int getBatchSize() {

                // It will first get executed
                // In this method we need to define how many times our query execute
                // How many times the setValues() is going to execute?

                System.out.println("Inside getBatchSize method >>>> Set value method will run for " + studentList.size());

                return studentList.size();
            }
        });

        for (int i = 0; i < batchUpdate.length; i++) {
            if (batchUpdate[i] == 1){
                updateCount++;
            }
        }

        return updateCount;
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
