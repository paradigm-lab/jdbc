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

        List<Student> studentList = new ArrayList<Student>();
        while(rs.next()) {
            Student student = new Student();

            student.setRollNo(rs.getInt("roll_no"));
            student.setName(rs.getString("student_name"));
            student.setAddress(rs.getString("student_addres"));

            studentList.add(student);
        }

        return studentList;
    }
}

