package api.dao.jdbc;

import com.jdbc.api.Student;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDAOImpl implements StudentDAO {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Student student) {
        // The logic to store the student object into the database
        String sql = "INSERT INTO student VALUES (?, ?, ?)";
        Object[] arg = {student.getRollNo(),student.getName(),student.getAddress()};
        jdbcTemplate.update(sql, arg);
    }

}
