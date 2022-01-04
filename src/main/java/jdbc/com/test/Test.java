package jdbc.com.test;

import api.dao.jdbc.StudentDAO;
import api.dao.jdbc.StudentDAOImpl;
import com.jdbc.api.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.api.com.StudentDAOHelper;

public class Test {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("Application context loaded....");

        // Getting the bean from the context
        StudentDAOImpl studentDAOImpl = context.getBean("studentDao", StudentDAOImpl.class);

        StudentDAOHelper studentDAOHelper = context.getBean("studentDaoHelper", StudentDAOHelper.class);
        studentDAOHelper.setUpStudentTable();


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

        //studentDAOImpl.cleanUp();

    }
}
