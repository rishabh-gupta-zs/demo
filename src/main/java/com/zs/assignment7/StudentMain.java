package com.zs.assignment7;

import com.zs.assignment7.controller.StudentController;

public class StudentMain {
    public static void main(String[] args) {

        StudentController studentDbController=new StudentController();
        studentDbController.run();

    }
}
