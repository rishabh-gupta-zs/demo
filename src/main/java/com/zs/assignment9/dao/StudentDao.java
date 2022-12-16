package com.zs.assignment9.dao;

import com.zs.assignment9.exception.StudentNotFoundException;
import com.zs.assignment9.model.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDao {

    private final String DB_URL = "jdbc:postgresql://localhost:2006/mydb1";
    private final String USER = "postgres";
    private final String PASSWORD = "root123";

    public void createStudentTable() throws SQLException {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String query = "CREATE TABLE IF NOT EXISTS student  (" +
                    "id serial PRIMARY KEY," +
                    "first_name varchar (15) ," +
                    "last_name varchar(15))";
            statement.executeUpdate(query);

        }
    }

    public Student addStudent(Student student) throws SQLException {

        String value = "(\'" + student.getFirstName() + "\',\'" + student.getLastName() + "\')";
        String query = "insert into student(first_name, last_name) values "+value;

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

             statement.executeUpdate(query);
        }

        return student;
    }

    public Student getStudent(int id) throws SQLException, StudentNotFoundException {

        final String query = "select * from student where id = " + id;
        Student student = new Student();

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            if (resultSet.next()) {
                student.setId(resultSet.getInt("id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
            }
            else {
                throw new StudentNotFoundException("student with id="+id+" is not exists");
            }
        }
        return student;
    }
}
