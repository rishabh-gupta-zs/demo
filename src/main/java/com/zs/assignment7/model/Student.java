package com.zs.assignment7.model;

public class Student {

    private int id;
    private String firstname;
    private String lastName;
    private String phone;
    private int departmentID;
    private  String departmentName;

    public Student(int id, String firstname, String lastName, String phone, int departmentID, String departmentName) {
        this.id = id;
        this.firstname = firstname;
        this.lastName = lastName;
        this.phone = phone;
        this.departmentID = departmentID;
        this.departmentName = departmentName;
    }

    public Student() {
    }

    public Student(String firstname, String lastName, String phone) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.phone = phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {

        return id+"|"+firstname+"|"+lastName+"|"+phone+"|"+departmentName;
    }

    public String capitalize(String string) {

        char firstLetter = string.charAt(0);
        char capitalFirstLetter = Character.toUpperCase(firstLetter);
        return capitalFirstLetter+string.substring(0,string.length());
    }
}
