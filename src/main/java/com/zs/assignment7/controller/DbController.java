package com.zs.assignment7.controller;

import com.zs.assignment7.util.RandomGenerator;
import com.zs.assignment7.database.DbOperations;
import com.zs.assignment7.service.DbService;
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

        dbOperations.createStudentTable();
        dbOperations.createDepartmentTable();

        try {

            for( int count=0 ; count<50 ; count++ )
                dbOperations.insertStudent(randomGenerator.generateRandoString(7),randomGenerator.generateRandoString(7),randomGenerator.generateRandomNumericString(13));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        dbOperations.createColumn();
        dbOperations.fillDepartmentId();

        try {
            dbService.extractDbData();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
