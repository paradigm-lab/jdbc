package com.jdbc.dao;

import com.jdbc.api.Student;

import java.util.List;


// CRUD operations methods
public interface StudentDAO {

    void insert(Student student);

    boolean deleteRecordByRollNo(int rollNo);

    int deleteRecordByStudentNameOrStudentAddress(String studentName, String studentAddress);

    void insert(List<Student> students);

    List<Student> findAllStudent();

    Student findStudentByRollNo(int rollNo);

    List<Student> findStudentByName(String name);

}
