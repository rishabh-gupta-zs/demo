package com.zs.assignment7.dao;

import com.zs.assignment7.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDao {

    private final String DB_URL = "jdbc:postgresql://localhost:2006/mydb";
    private final String USER = "postgres";
    private final String PASSWORD = "root123";
    private final Logger logger= LoggerFactory.getLogger(StudentDao.class);

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
            logger.error(e.getMessage());
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
                    "departmentid integer PRIMARY KEY," +
                    "departmentName varchar (20));";
            statement.executeUpdate(query);
            String value = "(0,'CS'),(1,'EC'),(2,'ME')";
            query = "insert into department(departmentid, departmentName) values " + value;
            statement.executeUpdate(query);

        } catch (Exception e) {
            logger.error(e.getMessage());
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

        String value = "(\'" + firstName + "\',\'" + lastname + "\',\'" + phone + "\')";
        String query = "insert into student(firstName, lastName, phone) values "+value;

        for(int i=0;i<1000;i++)
            query+=","+value;

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            PreparedStatement preparedStatement = connection.prepareStatement(query+";");
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
    public void createColumn(String tablename,String columnName) {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement();) {

            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet tables = databaseMetaData.getColumns(null, null, "student", "departmentid");
            if (tables.next()) {
                return;
            }

            String query = "ALTER TABLE "+ tablename +
                    " ADD COLUMN "+columnName+" integer";
            statement.executeUpdate(query);

        } catch (Exception e) {
            logger.error(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * makes the arraylist of data in database
     * @return - ArrayList
     */
    public ArrayList<Student> getAllData() {
        ArrayList<Student> studentsList = new ArrayList<>();
            String query = "SELECT " +
                    "id,firstname,lastname,phone,departmentname,department.departmentid " +
                    "FROM student " +
                    "LEFT JOIN department  " +
                    "ON student.departmentid = department.departmentid";

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);) {

            while (resultSet.next()) {

                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setFirstname(resultSet.getString("firstName"));
                student.setLastName(resultSet.getString("lastName"));
                student.setPhone(resultSet.getString("phone"));
                student.setDepartmentName(resultSet.getString("departmentName"));
                student.setDepartmentID(resultSet.getInt("departmentId"));
                studentsList.add(student);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return studentsList;
    }

    /**
     * fill random id in newly created column
     */
    public void insertDepartmentId() {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement();) {
            String query = "update student" +
                    " set departmentid = mod(id,3)" +
                    " where departmentid is null;";
            statement.executeUpdate(query);
        } catch (Exception e) {
            logger.error(e.getMessage());
            System.exit(0);
        }
    }
}