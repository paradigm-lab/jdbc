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

        /*
        // Creating Student class object
        Student student = new Student();
        student.setRollNo(001);
        student.setName("Collin");
        student.setAddress("Sakina");

        Student student1 = new Student();
        student1.setRollNo(003);
        student1.setName("Collin");
        student1.setAddress("Pune");

        Student student2 = new Student();
        student2.setRollNo(004);
        student2.setName("David");
        student2.setAddress("Pune");


        Student student3 = new Student();
        student3.setRollNo(005);
        student3.setName("Rakesh");
        student3.setAddress("Odisha");


        Student student4 = new Student();
        student4.setRollNo(006);
        student4.setName("Prasad");
        student4.setAddress("Pune");

        Student student5 = new Student();
        student5.setRollNo(002);
        student5.setName("Collin");
        student5.setAddress("Anonymous");

        studentDAO.insert(student);
        studentDAO.insert(student1);
        studentDAO.insert(student2);
        studentDAO.insert(student3);
        studentDAO.insert(student4);
        studentDAO.insert(student5);
        */

        /*
        boolean doneUpdate = studentDAO.deleteRecordByRollNo(1);
        if (doneUpdate) {
            System.out.println("Record number 1 is deleted");
        }
        */


        // Delete Record by the Student Name and Student Address
        // studentDAO.deleteRecordByStudentNameOrStudentAddress("Collin", "Pune");

        // Truncate the Table
        studentDAO.cleanUp();

    }

}
