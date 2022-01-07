package api.dao.jdbc;

import com.jdbc.api.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import result.set.extractor.StudentResultSetExtractor;
import result.set.extractor.groupStudentByResultSetExtractor;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("studentDao")
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // The setter method it is used to inject the dependency in the DAO class
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void cleanUp() {
        String sql = "TRUNCATE TABLE student";
        jdbcTemplate.execute(sql);
        System.out.println("Table cleaned up>>>>");
    }


    @Override
    public void insert(Student student) {
        // The logic to store the student object into the database
        String sql = "INSERT INTO student VALUES (?, ?, ?)";
        Object[] arg = {student.getRollNo(),student.getName(),student.getAddress()};

        int noOfRowInserted = jdbcTemplate.update(sql, arg);
        System.out.println("No of row inserted is: " + noOfRowInserted);

    }

    @Override
    public boolean deleteRecordByRollNo(int roolNo) {
        String sql = "DELETE FROM student WHERE roll_no = ?";
        int noOfRowDeleted = jdbcTemplate.update(sql, roolNo);
        System.out.println("No of record deleted is: " + noOfRowDeleted);

        return noOfRowDeleted == 1;
    }

    @Override
    public int deleteRecordByStudentNameAndStudentAddress(String studentName, String studentAddress) {
        String sql = "DELETE FROM student WHERE student_name = ? OR student_addres = ?";
        Object[] arguments = {studentName, studentAddress};

        int noOfRowsDeleted = jdbcTemplate.update(sql, arguments);
        System.out.println("No of rows got deleted are " + noOfRowsDeleted);

        return noOfRowsDeleted;
    }


    @Override
    public void insert(List<Student> students) {
        String sql = "INSERT INTO student VALUES(?, ?, ?)";

        ArrayList<Object[]> sqlArgs = new ArrayList<>();

        for (Student tempStudent : students) {
            Object[] studentData = {tempStudent.getRollNo(),tempStudent.getName(),tempStudent.getAddress()};
            sqlArgs.add(studentData);
        }

        jdbcTemplate.batchUpdate(sql, sqlArgs);

        System.out.println("Batch Update completed !!!");
    }

    @Override
    public List<Student> findAllStudent() {
        String selectSql = "SELECT * FROM student";
        List<Student> studentList = jdbcTemplate.query(selectSql, new StudentResultSetExtractor());

        return studentList;
    }

    @Override
    public Student findStudentByRollNo(int roolNo) {
        String selectsql = "SELECT roll_no AS rollNo, student_name AS name, student_addres AS address FROM student WHERE roll_no = ?";

        Student student = jdbcTemplate.queryForObject(selectsql, new BeanPropertyRowMapper<Student>(Student.class), roolNo);

        return student;
    }

    @Override
    public List<Student> findStudentByName(String name) {
        String sql = "SELECT * FROM student WHERE student_name = ?";

        List<Student> studentList = jdbcTemplate.query(sql, new StudentResultSetExtractor(), name);

        return studentList;
    }

    @Override
    public Map<String, List<String>> groupStudentByAddress() {
        String sql = "SELECT * FROM student";
        Map<String, List<String>> query = jdbcTemplate.query(sql, new groupStudentByResultSetExtractor());

        return query;
    }

    @Override
    public int updateStudent(Student student) {
        String sql = "UPDATE student SET student_addres = ? WHERE roll_no = ?";
        Object[] args = {student.getAddress(), student.getRollNo()};
        System.out.println("Row updated");
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int updateStudent(List<Student> studentList) {
        int updatedRowCount = 0;

        String sql = "UPDATE student SET student_addres = ? WHERE roll_no = ?";
        int[] batchUpdate = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int index) throws SQLException {

                // I need to set the arguments for the preparedstatement
                ps.setString(1, studentList.get(index).getAddress());
                ps.setInt(2, studentList.get(index).getRollNo());

                System.out.println("Inside the setValues method");
            }

            @Override
            public int getBatchSize() {
                // In this method we need to define how many times our query will execute
                // How many times the seValues() is going to execute?
                System.out.println("Inside the getBatchSize method >> set value method will run for " + studentList.size());
                return studentList.size();
            }
        });

        for (int i = 0; i < batchUpdate.length; i++) {

            if(batchUpdate[i] == 1) {
                updatedRowCount++;
            }

        }

        return updatedRowCount;
    }
}
