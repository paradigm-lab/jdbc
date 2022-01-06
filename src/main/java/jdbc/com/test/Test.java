package jdbc.com.test;

import api.dao.jdbc.StudentDAO;
import api.dao.jdbc.StudentDAOImpl;
import com.jdbc.api.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.api.com.StudentDAOHelper;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("Application context loaded....");

        // Getting the bean from the context
        StudentDAOImpl studentDAOImpl = context.getBean("studentDao", StudentDAOImpl.class);

        StudentDAOHelper studentDAOHelper = context.getBean("studentDaoHelper", StudentDAOHelper.class);
        // SETTING UP THE TABLE DATA
        studentDAOHelper.setUpStudentTable();

        // CALL THE findAllStudent() >> FETCHING THE DATA FROM THE TABLE
        List<Student> studentList = studentDAOImpl.findAllStudent();
        studentDAOHelper.printStudent(studentList);

        //QUERYING FOR A SPECIFIC OBJECT
        System.out.println("Fatching the student with the roll no 1");
        Student student = studentDAOImpl.findStudentByRollNo(1);
        System.out.println(student.toString());

        // CLEAN UP THE TABLE DATA
        //studentDAOImpl.cleanUp();

        /*
        Student newStudent1 = new Student();
        newStudent1.setRollNo(006);
        newStudent1.setName("David");
        newStudent1.setAddress("Raphael");

        studentDAOImpl.insert(newStudent1);


        boolean isDeleted = studentDAOImpl.deleteRecordByRollNo(4);
        if(isDeleted) {
            System.out.println("The roll no 2 data got deleted.......>>");
        }
        */

        //studentDAOImpl.deleteRecordByStudentNameAndStudentAddress("Collins", "Sakina");


    }
}
