package jdbc.com.test;

import api.dao.jdbc.StudentDAO;
import api.dao.jdbc.StudentDAOImpl;
import com.jdbc.api.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.api.com.StudentDAOHelper;

import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("Application context loaded....");


        // Getting the bean from the context
        StudentDAOImpl studentDAOImpl = context.getBean("studentDao", StudentDAOImpl.class);

        StudentDAOHelper studentDAOHelper = context.getBean("studentDaoHelper", StudentDAOHelper.class);

        Student Collins = new Student();
        Collins.setAddress("Australia");
        Collins.setRollNo(2);

        Student Luka = new Student();
        Luka.setAddress("Tanzania");
        Luka.setRollNo(4);
        studentDAOImpl.updateStudent(Collins);

        Student George = new Student();
        George.setAddress("Zanzibar");
        George.setRollNo(5);

        studentDAOImpl.updateStudent();

        /*
        Map<String, List<String>> groupStudentByAddress = studentDAOImpl.groupStudentByAddress();
        System.out.println(groupStudentByAddress);


        // Using the result Set Extractor
        System.out.println("Printing students where the name is Collins>>>>>>>>");
        System.out.println("Using ResultSetExtractor approach>>>>>>>>>");

        List<Student> findStudentByName = studentDAOImpl.findStudentByName("Collins");
        studentDAOHelper.printStudent(findStudentByName);


        // Using the RowMapper
        System.out.println("***********************************************");
        System.out.println("Printing all the student from the Student table");
        System.out.println("Using the ResultSetExtractor approach");

        List<Student> students = studentDAOImpl.findAllStudent();
        studentDAOHelper.printStudent(students);


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
        */


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
