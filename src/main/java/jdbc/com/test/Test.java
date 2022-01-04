package jdbc.com.test;

import api.dao.jdbc.StudentDAO;
import api.dao.jdbc.StudentDAOImpl;
import com.jdbc.api.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("Application context loaded....");

        // Getting the bean from the context
        StudentDAOImpl studentDAO = context.getBean("studentDao", StudentDAOImpl.class);


        Student newStudent1 = new Student();
        newStudent1.setRollNo(004);
        newStudent1.setName("Rose");
        newStudent1.setAddress("Dodoma");

        studentDAO.insert(newStudent1);
    }
}
