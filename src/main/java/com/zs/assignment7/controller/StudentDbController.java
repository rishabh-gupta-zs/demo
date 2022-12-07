package com.zs.assignment7.controller;

import com.zs.assignment7.util.RandomGenerator;
import com.zs.assignment7.dao.StudentDao;
import com.zs.assignment7.service.StudentDbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class StudentDbController {

    /**
     * runs the functionalities
     */
    public void run(){

        StudentDao studentDao=new StudentDao();
        RandomGenerator randomGenerator=new RandomGenerator();
        StudentDbService studentDbService=new StudentDbService();
        Logger logger= LoggerFactory.getLogger(StudentDbController.class);

        studentDao.createStudentTable();
        studentDao.createDepartmentTable();

        try {

            for( int count=0 ; count<1000 ; count++ )
                studentDao.insertStudent(randomGenerator.generateRandoString(7),randomGenerator.generateRandoString(7),randomGenerator.generateRandomNumericString(13));

        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }

        studentDao.createColumn("department","departmentID");
        studentDao.insertDepartmentId();

        try {
            studentDbService.extractDbData();

        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
