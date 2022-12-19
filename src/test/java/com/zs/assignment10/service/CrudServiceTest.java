package com.zs.assignment10.service;


import com.zs.assignment10.dao.ProductDao;
import com.zs.assignment10.exception.ProductNotFoundException;
import com.zs.assignment10.model.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CrudServiceTest {

    @Mock
    private ProductDao productDao;

    @InjectMocks
    private ProductService crudService;

    @Test
    void getAll() throws SQLException {

        List<Product> expectedProducts=new ArrayList<>();
        expectedProducts.add(new Product(1,"soap",20));
        expectedProducts.add(new Product(2,"iron",700));

        Mockito.when(productDao.getAllProducts()).thenReturn(expectedProducts);
        List<Product> actualProducts= null;
        actualProducts = crudService.getAll();
        assertEquals(expectedProducts,actualProducts);
    }


    @Test
    void getById() throws SQLException, ProductNotFoundException {

        Product expectedProduct=new Product(1,"soap",20);
        Mockito.when(productDao.getById(1)).thenReturn(expectedProduct);
        Product actualProduct=crudService.getById(1);
        assertEquals(expectedProduct,actualProduct);
    }

    @Test
    void getInvalidProduct() throws SQLException, ProductNotFoundException {

        Mockito.when(productDao.getById(1)).thenThrow(ProductNotFoundException.class);
        assertThrows(ProductNotFoundException.class,() -> crudService.getById(1));
    }

    @Test
    void exists() throws SQLException {

        Mockito.when(productDao.exists("soap")).thenReturn(true);
        assertTrue(crudService.exists("soap"));
    }

    @Test
    void notExists() throws SQLException {

        Mockito.when(productDao.exists("soap")).thenReturn(false);
        assertFalse(crudService.exists("soap"));
    }

    @Test
    void update() throws SQLException {

        Mockito.when(productDao.update(Mockito.any(Product.class))).thenReturn(true);
        assertTrue(crudService.update(1,"pepsi",20));
    }

    @Test
    void updateFail() throws SQLException {

        Mockito.when(productDao.update(Mockito.any(Product.class))).thenReturn(false);
        assertFalse(crudService.update(1,"pepsi",20));
    }

    @Test
    void insert() throws SQLException {

        Mockito.when(productDao.insert(Mockito.any(Product.class))).thenReturn(true);
        assertTrue(crudService.insert("pepsi",20));
    }

    @Test
    void insertionFail() throws SQLException {

        Mockito.when(productDao.insert(Mockito.any(Product.class))).thenReturn(false);
        assertFalse(crudService.insert("pepsi",20));
    }

    @Test
    void delete() throws SQLException {

        Mockito.when(productDao.delete("ParleG")).thenReturn(true);
        assertTrue(crudService.delete("ParleG"));
    }

    @Test
    void deletionFail() throws SQLException {

        Mockito.when(productDao.delete("ParleG")).thenReturn(false);
        assertFalse(crudService.delete("ParleG"));
    }
}