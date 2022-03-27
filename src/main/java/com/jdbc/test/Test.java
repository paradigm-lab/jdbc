package com.jdbc.test;

import com.jdbc.api.Student;
import com.jdbc.dao.StudentDAO;
import com.jdbc.dao.StudentDAOImpl;
import com.jdbc.service.StudentDAOHelper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("Application Context Loaded...");

        StudentDAOImpl studentDAO = context.getBean("studentDao", StudentDAOImpl.class);
        StudentDAOHelper studentDAOHelper = (StudentDAOHelper) context.getBean("studentDaoHelper");

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
        // studentDAO.cleanUp();

        // Batch Insert
        // studentDAOHelper.setUpStudentTable();

        // Select the data from the result set >> FETCHING THE DATA FROM THE TABLE
        /*System.out.println("Printing all the students from the student table");
        System.out.println("Using the RowMapper");
        List<Student> studentList = studentDAO.findAllStudent();
        studentDAOHelper.printStudent(studentList);*/

        //System.out.println("*************************************************************");
        // Querying for a specific object
        /*System.out.println("Fetching the student with the roll no 2");
        Student student = studentDAO.findStudentByRollNo(2);
        System.out.println(student);*/

        // Fetching the Student with the name
        /*System.out.println("Printing students where the name is collin>>>>");
        System.out.println("Using the ResultSetExtract approach>>>>>");
        List<Student> studentListByName = studentDAO.findStudentByName("Collin");
        studentDAOHelper.printStudent(studentListByName);*/

        // Grouping the Student according to there address
        /*Map<String, List<String>> groupStudentByAddress = studentDAO.groupStudentByAddress();
        System.out.println(groupStudentByAddress);*/


        Student Collin = new Student();
        Collin.setAddress("United States Of America 1");
        Collin.setRollNo(1);

        Student David = new Student();
        David.setAddress("Kenya 1");
        David.setRollNo(4);

        Student Kangaroo = new Student();
        Kangaroo.setAddress("South Africa 1");
        Kangaroo.setRollNo(3);

        List<Student> studentList = new ArrayList<Student>();
        studentList.add(Collin);
        studentList.add(Kangaroo);
        studentList.add(David);

        // Starting the Batch update
        int updateStudent = studentDAO.updateStudent(studentList);
        System.out.println(updateStudent + " No of rows affected...........");

    }

}
