package com.zs.assignment10.controller;

import com.zs.assignment10.exception.ProductNotFoundException;
import com.zs.assignment10.service.ProductService;
import com.zs.assignment10.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductController {
    public void run(){

        Logger logger= LoggerFactory.getLogger(ProductController.class);
        Scanner scanner=new Scanner(System.in);
        ProductService crudService;
        try {
            crudService=new ProductService();
            crudService.createProductTable();
        } catch (IOException | SQLException e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }

        int input;
        do{
            logger.info("\n1. get product by Id\n2. get all products\n3. insert product\n4. update product\n" +
                    "5.check if product exists\n6. delete product");
            input=scanner.nextInt();
            switch (input){

                case 1:
                    logger.info("enter product id");
                    Product product= null;
                    try {
                        product = crudService.getById(scanner.nextInt());

                    } catch (SQLException e) {
                        logger.error(e.getMessage());
                        throw new RuntimeException(e);

                    } catch (ProductNotFoundException e){
                        logger.error(e.getMessage());
                    }

                    logger.info(product.toString());
                    break;

                case 2:
                    List<Product> products= null;
                    try {
                        products = crudService.getAll();

                    } catch (SQLException e) {
                        logger.error(e.getMessage());
                        throw new RuntimeException(e);
                    }
                    for (Product product1:products)
                        logger.info(product1.toString());
                    break;

                case 3:
                    logger.info("enter name of product");
                    scanner.nextLine();
                    String name=scanner.nextLine();

                    logger.info("enter price of product");
                    int price=scanner.nextInt();

                    boolean inserted= false;
                    try {
                        inserted = crudService.insert(name,price);
                    } catch (SQLException e) {
                        logger.error(e.getMessage());
                        throw new RuntimeException(e);
                    }

                    if(inserted){
                        logger.info(name+" inserted successfully");
                    }
                    else{
                        logger.info(name+" could not insert");
                    }
                    break;

                case 4:
                    logger.info("enter id of product");
                    int id= scanner.nextInt();

                    logger.info("enter name of product");
                    scanner.nextLine();
                    name=scanner.nextLine();

                    logger.info("enter price of product");
                    price=scanner.nextInt();

                    boolean updated= false;
                    try {
                        updated = crudService.update(id,name,price);
                    } catch (SQLException e) {
                        logger.error(e.getMessage());
                        throw new RuntimeException(e);
                    }

                    if(updated){
                        logger.info(name+" updated successfully");
                    }
                    else{
                        logger.info(name+" could not update");
                    }
                    break;

                case 5:
                    scanner.nextLine();
                    logger.info("enter name of product");
                    name=scanner.nextLine();
                    boolean exists= false;
                    try {
                        exists = crudService.exists(name);
                    } catch (SQLException e) {
                        logger.error(e.getMessage());
                        throw new RuntimeException(e);
                    }

                    if(exists){
                        logger.info(name+" exists in database");
                    }
                    else {
                        logger.info(name + " does not exists in database");
                    }
                    break;

                case 6:
                    logger.info("enter name");
                    scanner.nextLine();
                    name=scanner.nextLine();
                    boolean deleted= false;
                    try {
                        deleted = crudService.delete(name);
                    } catch (SQLException e) {
                        logger.error(e.getMessage());
                        throw new RuntimeException(e);
                    }

                    if(deleted){
                        logger.info(name+" deleted successfully");
                    }
                    else{
                        logger.info(name+" could not delete");
                    }
                    break;

                default:
                    logger.info("Invalid selection");
                    break;
            }
        }while (input!=-1);

    }
}
