package com.zs.assignment10.service;


import com.zs.assignment10.dao.ProductDao;
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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class CrudServiceTest {

    @Mock
    private ProductDao productDao;

    @InjectMocks
    private CrudService crudService;

    @Test
    void getAll() {

        List<Product> expectedProducts=new ArrayList<>();
        expectedProducts.add(new Product(1,"soap",20));
        expectedProducts.add(new Product(2,"iron",700));

        try {
            Mockito.when(productDao.getAll()).thenReturn(expectedProducts);
            List<Product> actualProducts= null;
            actualProducts = crudService.getAll();
            assertEquals(expectedProducts,actualProducts);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getById() {

        Product expectedProduct=new Product(1,"soap",20);
        try {
            Mockito.when(productDao.getById(1)).thenReturn(expectedProduct);
            Product actualProduct=crudService.getById(1);
            assertEquals(expectedProduct,actualProduct);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void existsTrue() {
        try {
            Mockito.when(productDao.exists(Mockito.anyString())).thenReturn(true);
            assertTrue(crudService.exists("soap"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void update() {
        try {
            Mockito.when(productDao.update(Mockito.any(Product.class))).thenReturn(true);
            assertTrue(crudService.update(1,"pepsi",20));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void insert() {
        try {
            Mockito.when(productDao.insert(Mockito.any(Product.class))).thenReturn(true);
            assertTrue(crudService.insert("pepsi",20));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void delete() {
        try {
            Mockito.when(productDao.delete("ParleG")).thenReturn(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            assertTrue(crudService.delete("ParleG"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}