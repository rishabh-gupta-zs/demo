package com.zs.assignment7.dao;

import com.zs.assignment7.model.Student;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDao {

    private final static String DB_URL = "jdbc:postgresql://localhost:2006/mydb";
    private final static String USER = "postgres";
    private final static String PASSWORD = "root123";

    /**
     * Creates the student table with id,first name,last name,phone
     */
    public void createStudentTable() throws SQLException {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement();) {

            String query = "CREATE TABLE  IF NOT EXISTS student (" +
                    "id serial PRIMARY KEY," +
                    "first_Name varchar (15) ," +
                    "last_Name varchar(15)," +
                    "phone varchar(15));";
            statement.executeUpdate(query);
        }
    }

    /**
     * insert data into student table
     * @param students
     * @throws SQLException - SQLException
     */
    public void insertStudents(ArrayList<Student> students) throws SQLException {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            for(Student student:students) {
                statement.addBatch("insert into student (first_name,last_name,phone) " +
                        "values(\'" + student.getFirstname() + "\',\'" + student.getLastName() + "\',\'" +
                        student.getPhone() + "\')");
            }
            statement.executeBatch();
        }
    }

    /**
     * creates a column in student table
     */
    public void mapDepartmentsToStudents() throws SQLException {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement();) {

            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet tables = databaseMetaData.getColumns(null, null, "student", "department_id");

            String query;
            if (!tables.next()) {
                query = "ALTER TABLE student" +
                        " ADD COLUMN department_id integer";
                statement.executeUpdate(query);
            }

            query = "update student" +
                    " set department_id = mod(id,3)" +
                    " where department_id is null;";
            statement.executeUpdate(query);
        }
    }

    /**
     * makes the arraylist of data in database
     * @return - ArrayList
     */
    public ArrayList<Student> getAllData() throws SQLException {

        ArrayList<Student> studentsList = new ArrayList<>();
        int lowerLimit=0,upperLimit=10000;
        String query;

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement();) {
            ResultSet resultSet = null;

            while(true) {
                query="SELECT " +
                        "id,first_name,last_name,phone,department_name,department.department_id " +
                        "FROM student "+
                        "INNER JOIN department  " +
                        "ON student.department_id = department.department_id "+
                        "WHERE ID BETWEEN " + lowerLimit + " AND " + upperLimit ;
                resultSet = statement.executeQuery(query);

                if(!resultSet.next()) {
                    break;
                }

                while (resultSet.next()) {

                    Student student = new Student(resultSet.getInt("id"),resultSet.getString("first_name"),
                            resultSet.getString("last_name"),resultSet.getString("phone"),
                            resultSet.getInt("department_id"),resultSet.getString("department_name"));
                    studentsList.add(student);
                }
                lowerLimit=upperLimit;
                upperLimit+=10000;
            }
        }
        return studentsList;
    }
}