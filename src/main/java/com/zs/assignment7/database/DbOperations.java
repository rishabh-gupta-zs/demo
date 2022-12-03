package com.zs.assignment7.database;

import com.zs.assignment7.model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class DbOperations {

    private final String DB_URL = "jdbc:postgresql://localhost:2006/mydb";
    private final String USER = "postgres";
    private final String PASSWORD = "root123";
    private int id = -1 * (int) (new Date()).getTime();

    /**
     * Creates the student table with id,first name,last name,phone
     */
    public void createStudentTable() {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement();) {
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet tables = databaseMetaData.getTables(null, null, "student", null);
            if (tables.next()) {
                return;
            }
            String query = "CREATE TABLE student (" +
                    "id serial PRIMARY KEY," +
                    "firstName varchar (15) ," +
                    "lastName varchar(15)," +
                    "phone varchar(15));";
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.exit(0);
        }
    }

    /**
     * creates department table
     */
    public void createDepartmentTable() {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet tables = databaseMetaData.getTables(null, null, "department", null);
            if (tables.next()) {
                return;
            }
            String query = "CREATE TABLE IF NOT EXISTS department (" +
                    "departmentid serial PRIMARY KEY," +
                    "departmentName varchar (20));";
            statement.executeUpdate(query);
            String value = "(0,'CS'),(1,'EC'),(2,'ME')";
            query = "insert into department(departmentid, departmentName) values " + value;
            statement.executeUpdate(query);

        } catch (Exception e) {
            System.exit(0);
        }
    }

    /**
     * insert data into student table
     * @param firstName - first name
     * @param lastname - last name
     * @param phone - phone
     * @throws SQLException - SQLException
     */
    public void insertStudent(String firstName, String lastname, String phone) throws SQLException {

        String value = "(" + id + ",\'" + firstName + "\',\'" + lastname + "\',\'" + phone + "\')";
        String query = "insert into student(id, firstName, lastName, phone) values " + value;
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();

        }
    }

    /**
     * makes a department table
     * @throws SQLException - SQSException
     */
    public void makeDepartmentTable() throws SQLException {

        String value = "(" + (int) Math.random() * 3 + "),(2,'EC'),(3,'ME')";
        String query = "insert into department(id, departmentName) values " + value;
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        }
    }

    /**
     * creates a column in student table
     */
    public void createColumn() {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement();) {
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet tables = databaseMetaData.getColumns(null, null, "student", "departmentid");
            if (tables.next()) {
                return;
            }
            String query = "ALTER TABLE student " +
                    "ADD COLUMN departmentID VARCHAR";
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.exit(0);
        }
    }

    /**
     * makes the arraylist of data in database
     * @return - ArrayList
     */
    public ArrayList<Student> getAllData() {
        ArrayList<Student> studentsList = new ArrayList<>();
//            String query = "SELECT * " +
//                    "FROM student  " +
//                    "FULL OUTER JOIN department " +
//                    "ON student.departmentId = department.departmentId;";
        String query = "Select * from student";

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);) {

            while (resultSet.next()) {
                Student student = toEmployee(resultSet);
                studentsList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentsList;
    }

    /**
     * makes object of student
     * @param resultSet - result set
     * @return - student object
     * @throws SQLException - SQSException
     */
    private Student toEmployee(ResultSet resultSet) throws SQLException {

        Student student = new Student();
        student.setId(resultSet.getInt("id"));
        student.setFirstname(resultSet.getString("firstName"));
        student.setLastName(resultSet.getString("lastName"));
        student.setPhone(resultSet.getString("phone"));
        student.setDepartmentName("resultSet.getString(\"departmentName\")");
        student.setDepartmentID(resultSet.getInt("departmentId"));
        return student;
    }

    /**
     * fill random id in newly created column
     */
    public void fillDepartmentId() {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement();) {
            String query = "update student" +
                    " set departmentid = mod(id,3)" +
                    " where departmentid is null;";
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.exit(0);
        }
    }
}