package api.dao.jdbc;

import com.jdbc.api.Student;

import java.util.List;

public interface StudentDAO {

    void insert(List<Student> students);

    void insert(Student student);

    boolean deleteRecordByRollNo(int roolNo);

    int deleteRecordByStudentNameAndStudentAddress(String studentName, String studentAddress);
}
