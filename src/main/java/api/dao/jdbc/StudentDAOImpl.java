package api.dao.jdbc;

import com.jdbc.api.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("studentDao")
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // The setter method it is used to inject the dependency in the DAO class
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
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
}
