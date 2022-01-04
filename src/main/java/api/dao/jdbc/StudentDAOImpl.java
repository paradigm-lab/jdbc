package api.dao.jdbc;

import com.jdbc.api.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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
}
