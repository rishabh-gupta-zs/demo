package com.zs.assignment9.controller;

import com.zs.assignment9.service.StudentService;

public class StudentController {

    public void run(){

        StudentService studentService=new StudentService();

        studentService.createStudentTable();
        studentService.createStudent("Rishabh","Gupta");
        studentService.getStudent(1);

    }
}
