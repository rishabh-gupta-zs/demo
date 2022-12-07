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

    public void createStudentTable(){

        try {
            studentDao.createStudentTable();
        } catch (SQLException e) {
            System.exit(0);
        }


    }

    public Student createStudent(String firstName, String lastName){

        Student student=new Student(id.getAndIncrement(),firstName,lastName);
        try {
            studentDao.addStudent(student);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;

    }


    public Student getStudent(int id){

        Student student= null;
        try {
            student = studentDao.getStudent(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;

    }

}
