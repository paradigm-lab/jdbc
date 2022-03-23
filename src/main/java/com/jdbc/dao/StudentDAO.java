package com.jdbc.dao;

import com.jdbc.api.Student;


// CRUD operations methods
public interface StudentDAO {

    void insert(Student student);
    boolean deleteRecordByRollNo(int rollNo);
    int deleteRecordByStudentNameOrStudentAddress(String studentName, String studentAddress);

}
