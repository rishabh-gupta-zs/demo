package com.zs.assignment3.controller;

import com.zs.assignment3.service.EcommerceService;
import java.util.ArrayList;
import java.util.Scanner;

public class EcommerceController {

    Scanner scanner =new Scanner(System.in);
    EcommerceService ecommerceService =new EcommerceService();

    /**
     * Shows the initial options
     */
    public void start(){
        ecommerceService.addInitialProducts();
        System.out.println("Choose an option");
        int input;
        do{
            System.out.println("1.  Add product\n2.  Show products\n-1. Exit");
            input= scanner.nextInt();
            switch (input){
                case 1:
                    addProductMenu();
                    break;
                case 2:
                    showProducts();
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
     * Shows the option to choose which type of category user want to add and according to user's choice
     * takes the appropriate data from user and call the function to add the product.
     */
    public void addProductMenu(){
        int input;
        System.out.println("Select the category in which you want to add the product");
        do{
            System.out.println("1.  Mobile\n2.  Snacks\n3.  Washing Machine\n-1. go back");
            input= scanner.nextInt();
            switch (input){
                case 1:
                    System.out.println("Adding new Mobile. Please provide following data");
                    System.out.println("Name");
                    scanner.nextLine();
                    String name= scanner.nextLine();
                    System.out.println("Product id");
                    String productID= scanner.nextLine();
                    System.out.println("Price");
                    int price= scanner.nextInt();
                    System.out.println("Description");
                    scanner.nextLine();
                    String description= scanner.nextLine();
                    System.out.println("RAM");
                    int ram= scanner.nextInt();
                    System.out.println("ROM");
                    int rom= scanner.nextInt();
                    ecommerceService.addProduct(name,productID,price,description,ram,rom);
                    System.out.println(name+" added successfully");
                    break;

                case 2:
                    System.out.println("Adding new Snack. Please provide following data");
                    System.out.println("Name");
                    scanner.nextLine();
                    name= scanner.nextLine();
                    System.out.println("Product id");
                    productID= scanner.nextLine();
                    System.out.println("Price");
                    price= scanner.nextInt();
                    System.out.println("Taste");
                    scanner.nextLine();
                    String taste= scanner.nextLine();
                    System.out.println("Weight");
                    int weight=scanner.nextInt();
                    ecommerceService.addProduct(name,productID,price,taste,weight);
                    System.out.println(name+" added successfully");
                    break;

                case 3:
                    System.out.println("Adding new Washing Machine. Please provide following data");
                    scanner.nextLine();
                    System.out.println("Name");
                    name= scanner.nextLine();
                    System.out.println("Product id");
                    productID= scanner.nextLine();
                    System.out.println("Price");
                    price= scanner.nextInt();
                    System.out.println("Description");
                    scanner.nextLine();
                    description= scanner.nextLine();
                    System.out.println("RPM");
                    int rpm= scanner.nextInt();
                    ecommerceService.addProduct(name,productID,price,rpm,description);
                    System.out.println(name+" added successfully");
                    break;

                case -1:
                    break;

                default:
                    System.out.println("Invalid selection");
                    break;
            }
        }while (input!=-1);
    }

    /**
     * Shows the option to choose which type of category user want to see and according to user's choice,
     * it calls the showProduct() methode.
     */
    public void showProducts(){
        int input;
        System.out.println("---  SHOW  ---");
        do{
            System.out.println("1.  Mobile\n2.  Washing Machine\n3.  Snacks\n4.  All\n-1. go back");
            input= scanner.nextInt();

            switch (input){
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
        }while (input!=-1);
    }

    /**
     * It prints th data from hashmap with key received in parameter.
     * @param toShow - Key of hashmap which data user want to print on console
     */
    public void showProduct(String toShow){

        ArrayList productsToShow=ecommerceService.getData(toShow);
        System.out.println("\n---* " + toShow + " *---");

        for(Object product:productsToShow){
          System.out.println(product);
        }

    }
}
