package com.zs.assignment10.service;


import com.zs.assignment10.dao.ProductDao;
import com.zs.assignment10.model.Product;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CrudService {

    private ProductDao productDao;

    public  CrudService() throws IOException {
        productDao=new ProductDao();
    }

    public void createProductTable() throws SQLException {
        productDao.createProductTable();
    }

    public List<Product> getAll() throws SQLException {
        return productDao.getAll();
    }

    public Product getById(Integer id) throws SQLException {
        return productDao.getById(id);
    }

    public boolean exists(String name) throws SQLException {
        return productDao.exists(name);
    }

    public boolean update(int id,String name,int price) throws SQLException {
        return productDao.update(new Product(id,name,price));
    }

    public boolean insert(String name,int price) throws SQLException {

        Product product=new Product();
        product.setName(name);
        product.setPrice(price);
        return productDao.insert(product);
    }

    public boolean delete(String name) throws SQLException {
        return productDao.delete(name);
    }
}
