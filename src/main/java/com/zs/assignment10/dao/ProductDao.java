package com.zs.assignment10.dao;

import com.zs.assignment10.model.Product;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ProductDao {

    private String  dbURL;
    private String user;
    private String password;

    public ProductDao() throws IOException {

        Properties properties=new Properties();
        FileInputStream fileInputStream;

        fileInputStream=new FileInputStream("src/main/resources/db.properties");
        properties.load(fileInputStream);

        dbURL=properties.getProperty("DB_URL");
        user=properties.getProperty("USER");
        password=properties.getProperty("PASSWORD");
    }

    public void createProductTable() throws SQLException {

        try (Connection connection = DriverManager.getConnection(dbURL, user, password);
             Statement statement = connection.createStatement();) {

            String query = "CREATE TABLE IF NOT EXISTS product (" +
                    "id serial PRIMARY KEY," +
                    "name varchar (15) ," +
                    "price integer);";
            statement.executeUpdate(query);
        }
    }


    public List<Product> getAll() throws SQLException {

        List<Product> productList = new ArrayList<>();
        final String query = "select * from Product";

        try(Connection connection = DriverManager.getConnection(dbURL, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Product Product = toProduct(resultSet);
                productList.add(Product);
            }

        }
        return productList;
    }

    public Product getById(Integer id) throws SQLException {

        Product product = null;
        final String query = "select * from Product where id = "+id;
        try(Connection connection = DriverManager.getConnection(dbURL, user, password);
            Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                product = toProduct(resultSet);
            }
        }
        return product;
    }

    public boolean delete(String name) throws SQLException {

        boolean deleted = false;
        final String query = "DELETE FROM product WHERE name=\'"+name+"\'";

        try(Connection connection = DriverManager.getConnection(dbURL, user, password);
            Statement statement = connection.createStatement()) {

            int numInserts = statement.executeUpdate(query);
            deleted = 0 < numInserts;
        }
        return deleted;
    }

    public boolean insert(Product product) throws SQLException {

        boolean inserted = false;
        final String query = "insert into Product(name,price) values (\'"+product.getName()+"\',"+product.getPrice()+")";

        try(Connection connection = DriverManager.getConnection(dbURL, user, password);
            Statement statement = connection.createStatement()) {

            int numInserts = statement.executeUpdate(query);
            inserted = 0 < numInserts;
        }
        return inserted;
    }

    public boolean update(Product product) throws SQLException {
        boolean updated = false;
        final String query = "update Product set name=\'"+product.getName()+"\', price="+product.getPrice()+" where id="+product.getId();
        try(Connection connection = DriverManager.getConnection(dbURL, user, password);
            Statement statement = connection.createStatement()) {

            int numUpdates = statement.executeUpdate(query);
            updated = 0 < numUpdates;
        }
        return updated;
    }

    public boolean exists(String name) throws SQLException {

        final String query = "select * from Product where name = \'"+name+"\'";
        try(Connection connection = DriverManager.getConnection(dbURL, user, password);
            Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);
            if (!resultSet.next()) {
                return false;
            }

        }
        return true;
    }

    private Product toProduct(ResultSet resultSet) throws SQLException {

        Product Product = new Product();
        Product.setId(resultSet.getInt("id"));
        Product.setName(resultSet.getString("name"));
        Product.setPrice(resultSet.getInt("price"));
        return Product;

    }
}
