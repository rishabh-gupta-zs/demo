package com.zs.assignment9.controller;

import com.zs.assignment9.exception.InvalidNameExcetion;
import com.zs.assignment9.exception.StudentNotFoundException;
import com.zs.assignment9.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.SQLException;

public class StudentController {

    public void run(){

        Logger logger= LoggerFactory.getLogger(StudentController.class);
        StudentService studentService=new StudentService();

        try {
            studentService.createStudentTable();
            studentService.createStudent("first name","last name");
            logger.info(studentService.getStudent(7).toString());

        } catch (SQLException | InvalidNameExcetion | StudentNotFoundException e) {
            logger.error(e.getMessage());
        }
    }
}
