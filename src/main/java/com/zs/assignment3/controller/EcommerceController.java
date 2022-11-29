package com.zs.assignment3.controller;

import com.zs.assignment3.model.Mobile;
import com.zs.assignment3.model.Snack;
import com.zs.assignment3.model.WashingMachine;
import com.zs.assignment3.service.EcommerceService;

import java.util.Scanner;

public class EcommerceController {

    Scanner scanner =new Scanner(System.in);
    EcommerceService ecommerceService =new EcommerceService();

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
                    ecommerceService.addMobile(name,productID,price,description,ram,rom);
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
                    ecommerceService.addSnacks(name,productID,price,taste,weight);
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
                    ecommerceService.addWashingMachine(name,productID,price,description,rpm);
                    System.out.println(name+" added successfully");
                    break;

                case -1:
                    break;

                default:
                    System.out.println("Invalid selecion");
                    break;
            }
        }while (input!=-1);
    }

    public void showProducts(){
        int input;
        System.out.println("---  SHOW  ---");
        do{
            System.out.println("1.  Mobile\n2.  Washing Machine\n3.  Snacks\n4.  All\n-1. go back");
            input= scanner.nextInt();
            switch (input){
                case 1:
                    showMobiles();
                    break;
                case 2:
                    showWashingMachine();
                    break;
                case 3:
                    showSnacks();
                    break;
                case 4:
                    showMobiles();
                    showWashingMachine();
                    showSnacks();
                    break;
                case -1:
                    break;
                default:
                    System.out.println("Invalid selection");
            }
        }while (input!=-1);
    }

    public void showSnacks(){
        System.out.println("--- Snacks ---");
        for(Snack snack: ecommerceService.snacks){
            System.out.print("\tName\t-\t");
            System.out.println(snack.getName());
            System.out.print("\tProduct id\t-\t");
            System.out.println(snack.getProductID());
            System.out.print("\tPrice(Rs.)\t-\t");
            System.out.println(snack.getPrice());
            System.out.print("\tTaste\t-\t");
            System.out.println(snack.getTaste());
            System.out.print("\tWeight\t-\t");
            System.out.println(snack.getWeight());
            System.out.println("\t-----*----");
        }
    }

    public void showWashingMachine(){
        System.out.println("--- Washing Machine ---");
        for(WashingMachine washingMachine: ecommerceService.washingMachines){
            System.out.print("\tName\t-\t");
            System.out.println(washingMachine.getName()+"\t\t");
            System.out.print("\tProduct id\t-\t");
            System.out.println(washingMachine.getProductID()+"\t\t");
            System.out.print("\tPrice\t-\t");
            System.out.println(washingMachine.getPrice()+"\t\t");
            System.out.print("\tDescription\t-\t");
            System.out.println(washingMachine.getDescription()+"\t\t");
            System.out.print("\tRPM\t-\t");
            System.out.println(washingMachine.getRpm());
            System.out.println("\t-----*----");
        }
    }

    public void showMobiles(){
        System.out.println("--- Mobiles ---");
        for(Mobile mobile: ecommerceService.mobiles){
            System.out.print("\tName\t-\t");
            System.out.println(mobile.getName());
            System.out.print("\tProduct id\t-\t");
            System.out.println(mobile.getProductID());
            System.out.print("\tPrice\t-\t");
            System.out.println(mobile.getPrice());
            System.out.print("\tDescription\t-\t");
            System.out.println(mobile.getDescription());
            System.out.print("\tRAM\t-\t");
            System.out.println(mobile.getRam());
            System.out.print("\tROM\t-\t");
            System.out.println(mobile.getRom());
            System.out.println("\t-----*----");
        }
    }
}
