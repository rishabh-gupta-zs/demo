package com.zs.assignment9.controller;

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
            studentService.createStudent("student","name");
            studentService.getStudent(1);

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }
}
