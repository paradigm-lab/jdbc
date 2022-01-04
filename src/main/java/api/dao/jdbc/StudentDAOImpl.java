package api.dao.jdbc;

import com.jdbc.api.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class StudentDAOImpl implements StudentDAO {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

    @Override
    public void insert(Student student) {
        // The logic to store the student object into the database
        String sql = "INSERT INTO student VALUES (?, ?, ?)";
        Object[] arg = {student.getRollNo(),student.getName(),student.getAddress()};

        int noOfRowInserted = jdbcTemplate.update(sql, arg);
        System.out.println("No of row inserted is: " + noOfRowInserted);

    }

    public DataSource getDataSource(){
        String url = "jdbc:postgresql://localhost:5432/school?useSSL=false";
        String username = "ccolaria";
        String password = "collin";

        DataSource dataSource = new DriverManagerDataSource(url, username, password);

        return dataSource;
    }

}
