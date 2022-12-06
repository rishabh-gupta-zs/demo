package com.zs.assignment7.service;

import com.zs.assignment7.dao.StudentDao;
import com.zs.assignment7.model.Student;

import java.io.*;
import java.util.ArrayList;

public class StudentDbService {

    /**
     * gets the data from database and write to text file
     * @throws FileNotFoundException - FileNotFoundException
     */
    public void extractDbData() throws FileNotFoundException {

    PrintWriter printWriter=new PrintWriter("src/main/dbData.txt");

    StudentDao studentDao=new StudentDao();
    ArrayList<Student> students=studentDao.getAllData();

    for (Student student:students)
        printWriter.println(student);

    printWriter.flush();
    printWriter.close();
    }
}
