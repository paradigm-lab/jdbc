package com.jdbc.service;

import com.jdbc.api.Student;
import com.jdbc.dao.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("studentDaoHelper")
public class StudentDAOHelper {

    @Autowired
    private StudentDAO studentDAOImpl;

    public void setUpStudentTable() {
        Student student = new Student();
        student.setRollNo(001);
        student.setName("Collin");
        student.setAddress("Sakina");

        Student student1 = new Student();
        student1.setRollNo(003);
        student1.setName("Kangaroo");
        student1.setAddress("Pune");

        Student student2 = new Student();
        student2.setRollNo(004);
        student2.setName("David");
        student2.setAddress("Pune");


        Student student3 = new Student();
        student3.setRollNo(005);
        student3.setName("Jon");
        student3.setAddress("New York");


        Student student4 = new Student();
        student4.setRollNo(006);
        student4.setName("Prasad");
        student4.setAddress("Pune");

        Student student5 = new Student();
        student5.setRollNo(002);
        student5.setName("Noura");
        student5.setAddress("Austria");

        ArrayList<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        studentDAOImpl.insert(students);
    }


    public void printStudent(List<Student> students) {
        for (Student tempStudent : students) {
            System.out.println(tempStudent);
        }
    }

}

