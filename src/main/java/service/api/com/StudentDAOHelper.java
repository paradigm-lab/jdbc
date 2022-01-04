package service.api.com;

import api.dao.jdbc.StudentDAO;
import com.jdbc.api.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("studentDaoHelper")
public class StudentDAOHelper {

    @Autowired
    private StudentDAO studentDAOImpl;

    public void setUpStudentTable() {
        Student student1 = new Student();
        student1.setRollNo(1);
        student1.setName("Collins");
        student1.setAddress("Sakina");

        Student student2 = new Student();
        student2.setRollNo(2);
        student2.setName("John");
        student2.setAddress("Zanzibar");

        Student student3 = new Student();
        student3.setRollNo(3);
        student3.setName("Ismail");
        student3.setAddress("Dodoma");

        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        studentDAOImpl.insert(studentList);
    }

}
