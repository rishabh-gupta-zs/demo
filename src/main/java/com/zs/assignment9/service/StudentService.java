package com.zs.assignment9.service;

import com.zs.assignment9.dao.StudentDao;
import com.zs.assignment9.model.Student;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

public class StudentService {
    private AtomicInteger id = new AtomicInteger();
    private StudentDao studentDao;

    public StudentService() {
        this.studentDao = new StudentDao();
    }

    public void createStudentTable() throws SQLException {

        studentDao.createStudentTable();
    }

    public Student createStudent(String firstName, String lastName) throws SQLException {

        Student student=new Student(id.getAndIncrement(),firstName,lastName);
        studentDao.addStudent(student);
        return student;
    }

    public Student getStudent(int id) throws SQLException {

        Student student= studentDao.getStudent(id);
        return student;
    }
}
