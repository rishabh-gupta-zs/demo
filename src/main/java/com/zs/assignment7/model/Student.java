package com.zs.assignment7.model;

public class Student {

    private int id;
    private String firstname;
    private String lastName;
    private String phone;
    private int departmentID;
    private  String departmentName;

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

    @Override
    public String toString() {
        return "#\t" +
                "id=" + id +
                ",\tfirstname='" + firstname + '\'' +
                ",\tlastName='" + lastName + '\'' +
                ",\tmobile='" + phone + '\'' +
                ",\tdepartmentID=" + departmentID +
                ",\tdepartmentName='" + departmentName;
    }
}
