package jdbc.com.test;

import api.dao.jdbc.StudentDAO;
import api.dao.jdbc.StudentDAOImpl;
import com.jdbc.api.Student;

public class Test {
    public static void main(String[] args) {
        Student newStudent1 = new Student();
        newStudent1.setRollNo(001);
        newStudent1.setName("Collins");
        newStudent1.setAddress("Sakina");

        StudentDAO studentDAO = new StudentDAOImpl();
        studentDAO.insert(newStudent1);
    }
}
