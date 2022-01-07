package api.dao.jdbc;

import com.jdbc.api.Student;

import java.util.List;
import java.util.Map;

public interface StudentDAO {

    void insert(List<Student> students);

    void insert(Student student);

    boolean deleteRecordByRollNo(int roolNo);

    int deleteRecordByStudentNameAndStudentAddress(String studentName, String studentAddress);

    List<Student> findAllStudent();

    Student findStudentByRollNo(int roolNo);

    List<Student> findStudentByName(String name);

    Map<String, List<String>> groupStudentByAddress();

    int updateStudent(Student student);

    int updateStudent(List<Student> studentList);

}
