package com.zs.assignment3.controller;

import com.zs.assignment3.model.Mobile;
import com.zs.assignment3.model.Product;
import com.zs.assignment3.model.Snack;
import com.zs.assignment3.model.WashingMachine;
import com.zs.assignment3.service.EcommerceService;
import java.util.ArrayList;
import java.util.Scanner;

public class EcommerceController {

    private Scanner scanner =new Scanner(System.in);
    private EcommerceService ecommerceService =new EcommerceService();

    /**
     * Shows the initial options
     */
    public void run(){

        System.out.println("Choose an option");
        int input;
        do{
            System.out.println("1.  Add product\n2.  Show products\n-1. Exit");
            input= scanner.nextInt();
            switch (input){

                case 1:
                    int input1;
                    System.out.println("Select the category in which you want to add the product");
                    do{
                        System.out.println("1.  Mobile\n2.  Snacks\n3.  Washing Machine\n-1. go back");
                        input1= scanner.nextInt();
                        switch (input1){

                            case 1:
                                System.out.println("Adding new Mobile. Please provide following data");
                                Product product=inputProduct();
                                System.out.println("Description");
                                scanner.nextLine();
                                String description= scanner.nextLine();
                                System.out.println("RAM");
                                int ram= scanner.nextInt();
                                System.out.println("ROM");
                                int rom= scanner.nextInt();
                                Product mobile=new Mobile(product.getPrice(),product.getName(),product.getProductID(),description,ram,rom);
                                ecommerceService.addProduct(mobile,"Mobile");
                                System.out.println(product.getName()+" added successfully");
                                break;

                            case 2:
                                System.out.println("Adding new Snack. Please provide following data");
                                product=inputProduct();
                                System.out.println("Taste");
                                scanner.nextLine();
                                String taste= scanner.nextLine();
                                System.out.println("Weight");
                                int weight=scanner.nextInt();
                                Product snack=new Snack(product.getPrice(),product.getName(),product.getProductID(),weight,taste);
                                ecommerceService.addProduct(snack,"Snack");
                                System.out.println(product.getName()+" added successfully");
                                break;

                            case 3:
                                System.out.println("Adding new Washing Machine. Please provide following data");
                                product=inputProduct();
                                System.out.println("Description");
                                scanner.nextLine();
                                description= scanner.nextLine();
                                System.out.println("RPM");
                                int rpm= scanner.nextInt();
                                Product washingMachine=new WashingMachine(product.getPrice(),product.getName(),product.getProductID(),description,rpm);
                                ecommerceService.addProduct(washingMachine,"WashingMachine");
                                System.out.println(product.getName()+" added successfully");
                                break;

                            case -1:
                                break;

                            default:
                                System.out.println("Invalid selection");
                                break;
                        }
                    }while (input1!=-1);
                    break;

                case 2:
                    int input2;
                    System.out.println("---  SHOW  ---");
                    do{
                        System.out.println("1.  Mobile\n2.  Washing Machine\n3.  Snacks\n4.  All\n-1. go back");
                        input2= scanner.nextInt();
                        switch (input2){

                            case 1:
                                showProduct("Mobile");
                                break;

                            case 2:
                                showProduct("WashingMachine");
                                break;

                            case 3:
                                showProduct("Snack");
                                break;

                            case 4:
                                showProduct("Mobile");
                                showProduct("WashingMachine");
                                showProduct("Snack");
                                break;

                            case -1:
                                break;

                            default:
                                System.out.println("Invalid selection");
                        }
                    }while (input2!=-1);
                    break;

                case -1:
                    System.out.println("Ending task");
                    break;

                default:
                    System.out.println("Invalid selection");
                    break;
            }
        }while ( input!=-1 );
    }

    /**
     * take information of products from user
     * @return - Product
     */
    public Product inputProduct(){

        System.out.println("Name");
        scanner.nextLine();
        String name= scanner.nextLine();
        System.out.println("Product id");
        String productID= scanner.nextLine();
        System.out.println("Price");
        int price= scanner.nextInt();
        return new Product(price,name,productID);
    }

    /**
     * prints details of product
     * @param type - type of product
     */
    public void showProduct(String type){

        ArrayList<Product> productsToShow=ecommerceService.getProduct(type);
        System.out.println("\n---* " + type + " *---");

        for(Product product:productsToShow){
          System.out.println(product);
        }
    }
}
