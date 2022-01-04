package api.dao.jdbc;

import com.jdbc.api.Student;

public interface StudentDAO {
    void insert(Student student);
    boolean deleteRecordByRollNo(int roolNo);
    int deleteRecordByStudentNameAndStudentAddress(String studentName, String studentAddress);
}
