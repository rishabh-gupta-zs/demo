package com.zs.assignment7.controller;

import com.zs.assignment7.service.StudentDbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class StudentController {

    /**
     * runs the functionalities
     */
    public void run(){

        StudentDbService studentService=new StudentDbService();
        Logger logger= LoggerFactory.getLogger(StudentController.class);

        try {
            studentService.createStudentTable();
            studentService.createDepartmentTable();
            studentService.addMillionStudents();
            studentService.mapDepartmentsToStudents();

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }

        try {
            studentService.extractDbData();
        } catch (FileNotFoundException | SQLException e) {
            logger.error(e.getMessage());
        }

        try {
            studentService.compressFile();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
