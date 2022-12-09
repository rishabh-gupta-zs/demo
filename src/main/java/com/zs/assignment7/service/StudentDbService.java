package com.zs.assignment7.service;

import com.zs.assignment7.dao.DepartmentDao;
import com.zs.assignment7.dao.StudentDao;
import com.zs.assignment7.model.Student;
import com.zs.assignment7.util.RandomGenerator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.zip.DeflaterOutputStream;

public class StudentDbService {

    private static final StudentDao studentDao=new StudentDao();

    public void createStudentTable() throws SQLException {
        studentDao.createStudentTable();
    }

    public void createDepartmentTable() throws SQLException {
        DepartmentDao departmentDao=new DepartmentDao();
        departmentDao.createDepartmentTable();
    }

    public void mapDepartmentsToStudents() throws SQLException {
        studentDao.mapDepartmentsToStudents();
    }

    public void addMillionStudents() throws SQLException {

        ArrayList<Student> students=new ArrayList<>();
        RandomGenerator randomGenerator=new RandomGenerator();
        for (int i=0;i<1000000;i++){
            students.add(new Student(randomGenerator.generateRandoString(6),
                    randomGenerator.generateRandoString(6),randomGenerator.generateRandomNumericString(10)));
        }
        studentDao.insertStudents(students);
    }

    /**
     * gets the data from database and write to text file
     * @throws FileNotFoundException - FileNotFoundException
     */
    public void extractDbData() throws FileNotFoundException, SQLException {

    PrintWriter printWriter=new PrintWriter("src/main/resources/dbData.txt");

    StudentDao studentDao=new StudentDao();
    ArrayList<Student> students=studentDao.getAllData();

    for (Student student:students)
        printWriter.println(student);

    printWriter.flush();
    printWriter.close();
    }

    public void compressFile() throws IOException {
        FileInputStream fileInputStream=new FileInputStream("src/main/resources/dbData.txt");
        FileOutputStream fileOutputStream=new FileOutputStream("src/main/resources/compressedDbData.txt");
        DeflaterOutputStream deflaterOutputStream=new DeflaterOutputStream(fileOutputStream);
        int data;
        while ((data=fileInputStream.read())!=-1)
        {
            deflaterOutputStream.write(data);
        }
        fileInputStream.close();
        deflaterOutputStream.close();
    }
}
