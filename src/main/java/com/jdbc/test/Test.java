package com.jdbc.test;

import com.jdbc.api.Student;
import com.jdbc.dao.StudentDAO;
import com.jdbc.dao.StudentDAOImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("Application Context Loaded...");

        StudentDAOImpl studentDAO = context.getBean("studentDao", StudentDAOImpl.class);

        // Creating Student class object
        Student student = new Student();

        student.setRollNo(001);
        student.setName("Collin");
        student.setAddress("Sakina");

        Student student1 = new Student();
        student1.setRollNo(002);
        student1.setName("Paradigm");
        student1.setAddress("Anonymous");

        studentDAO.insert(student);
        studentDAO.insert(student1);
    }

}
