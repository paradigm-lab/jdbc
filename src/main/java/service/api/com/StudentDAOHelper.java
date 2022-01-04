package service.api.com;

import com.jdbc.api.Student;

public class StudentDAOHelper {

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
        student3.setRollNo(1);
        student3.setName("Ismail");
        student3.setAddress("Dodoma");

    }

}
