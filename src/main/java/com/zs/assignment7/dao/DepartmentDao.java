package com.zs.assignment7.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DepartmentDao {

    private final static String DB_URL = "jdbc:postgresql://localhost:2006/mydb";
    private final static String USER = "postgres";
    private final static String PASSWORD = "root123";

    /**
     * creates department table
     */
    public void createDepartmentTable() throws SQLException {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String query = "CREATE TABLE IF NOT EXISTS department (" +
                    "department_id integer PRIMARY KEY," +
                    "department_Name varchar (20));";
            statement.executeUpdate(query);

            String values = "(0,'CS'),(1,'EC'),(2,'ME')";
            query = "insert into department(department_id, department_name) values " + values + "On CONFLICT(department_id) DO NOTHING;";
            statement.executeUpdate(query);
        }
    }
}
