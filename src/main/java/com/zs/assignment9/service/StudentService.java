package com.zs.assignment9.service;

import com.zs.assignment9.dao.StudentDao;
import com.zs.assignment9.exception.InvalidNameExcetion;
import com.zs.assignment9.exception.StudentNotFoundException;
import com.zs.assignment9.model.Student;
import java.sql.SQLException;

public class StudentService {
    private StudentDao studentDao;

    public StudentService() {
        this.studentDao = new StudentDao();
    }

    public void createStudentTable() throws SQLException {

        studentDao.createStudentTable();
    }

    public Student createStudent(String firstName, String lastName) throws SQLException, InvalidNameExcetion {

        if (firstName==null || firstName.length()==0){
            throw new InvalidNameExcetion("invalid first name");
        }
        Student student=new Student(firstName,lastName);
        studentDao.addStudent(student);
        return student;


    }

    public Student getStudent(int id) throws SQLException, StudentNotFoundException {

        Student student= studentDao.getStudent(id);
        return student;
    }
}
