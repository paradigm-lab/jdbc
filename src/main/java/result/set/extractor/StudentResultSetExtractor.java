package result.set.extractor;

import com.jdbc.api.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentResultSetExtractor implements ResultSetExtractor<List<Student>> {


    @Override
    public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
        int increament = 0;

        List<Student> studentList = new ArrayList<Student>();
        while(rs.next()) {
            increament++;
            Student student = new Student();

            student.setRollNo(rs.getInt("roll_no"));
            student.setName(rs.getString("student_name"));
            student.setAddress(rs.getString("student_addres"));

            studentList.add(student);
            System.out.println("This is the iteration of the ResultSet extractor: " + increament);
        }

        System.out.println("Inside the extractData method of ResultSetExtractor");

        return studentList;
    }
}

