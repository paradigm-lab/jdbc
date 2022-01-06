package result.set.extractor;

import com.jdbc.api.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class groupStudentByResultSetExtractor implements ResultSetExtractor<Map<String, List<Student>>> {

    @Override
    public Map<String, List<Student>> extractData(ResultSet rs) throws SQLException, DataAccessException {

        return null;
    }
}
