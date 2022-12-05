package com.zs.assignment7.controller;

import com.zs.assignment7.util.RandomGenerator;
import com.zs.assignment7.database.DbOperations;
import com.zs.assignment7.service.DbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class DbController {

    /**
     * runs the functionalities
     */
    public void run(){

        DbOperations dbOperations=new DbOperations();
        RandomGenerator randomGenerator=new RandomGenerator();
        DbService dbService=new DbService();
        Logger logger= LoggerFactory.getLogger(DbController.class);

        dbOperations.createStudentTable();
        dbOperations.createDepartmentTable();

        try {

            for( int count=0 ; count<50 ; count++ )
                dbOperations.insertStudent(randomGenerator.generateRandoString(7),randomGenerator.generateRandoString(7),randomGenerator.generateRandomNumericString(13));

        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }

        dbOperations.createColumn();
        dbOperations.fillDepartmentId();

        try {
            dbService.extractDbData();

        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
