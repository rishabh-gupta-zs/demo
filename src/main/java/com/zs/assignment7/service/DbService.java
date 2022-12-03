package com.zs.assignment7.service;

import com.zs.assignment7.database.DbOperations;
import com.zs.assignment7.model.Student;

import java.io.*;
import java.util.ArrayList;

public class DbService {

    /**
     * gets the data from database and write to text file
     * @throws FileNotFoundException - FileNotFoundException
     */
    public void extractDbData() throws FileNotFoundException {

    PrintWriter printWriter=new PrintWriter("dbData.txt");

    DbOperations dbOperations=new DbOperations();
    ArrayList<Student> students=dbOperations.getAllData();

    for (Student student:students)
        printWriter.println(student);

    printWriter.flush();
    printWriter.close();
    }
}
