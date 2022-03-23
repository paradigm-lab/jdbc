package com.jdbc.dao;

import com.jdbc.api.Student;

public interface StudentDAO {

    void insert(Student student);
    boolean deleteRecordByRollNo(int rollNo);

}
