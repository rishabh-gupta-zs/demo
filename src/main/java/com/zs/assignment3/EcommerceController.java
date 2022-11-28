package com.zs.assignment3;

import java.util.Scanner;

public class EcommerceController {

    Scanner scanner =new Scanner(System.in);
    EcommerceServices ecommerceServices =new EcommerceServices();

    public void showMenu(){
        ecommerceServices.addInitialProducts();
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
                    System.out.println("Invalid input");
                    break;
            }
        }while ( input!=-1 );

    }
    public void addProductMenu(){
        int input;
        System.out.println("Select the category in which you want to add the product");
        do{
            System.out.println("1.  Mobile\n2.  Washing Machine\n3.  Snacks\n-1. go back");
            input= scanner.nextInt();
            switch (input){
                case 1:
                    ecommerceServices.addMobile();
                    break;
                case 2:
                    ecommerceServices.addWashMachine();
                    break;
                case 3:
                    ecommerceServices.addSnacks();
                    break;
                case -1:
                    break;
                default:
                    System.out.println("Invalid Input");
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
                    showWashMachine();
                    break;
                case 3:
                    showSnacks();
                    break;
                case 4:
                    showMobiles();
                    showWashMachine();
                    showSnacks();
                    break;
                case -1:
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }while (input!=-1);
    }

    public void showSnacks(){
        System.out.println("--- Snacks ---");
        for(Snacks snack: ecommerceServices.snacks){
            System.out.print("\tName\t-\t");
            System.out.println(snack.name);
            System.out.print("\tProduct id\t-\t");
            System.out.println(snack.productID);
            System.out.print("\tPrice(Rs.)\t-\t");
            System.out.println(snack.price);
            System.out.print("\tTaste\t-\t");
            System.out.println(snack.taste);
            System.out.println("\t-----*----");
        }
    }

    public void showWashMachine(){
        System.out.println("--- Washing Machine ---");
        for(WashingMachine washMachine: ecommerceServices.washingMachines){
            System.out.print("\tName\t-\t");
            System.out.println(washMachine.name+"\t\t");
            System.out.print("\tProduct id\t-\t");
            System.out.println(washMachine.productID+"\t\t");
            System.out.print("\tPrice\t-\t");
            System.out.println(washMachine.price+"\t\t");
            System.out.print("\tDescription\t-\t");
            System.out.println(washMachine.description+"\t\t");
            System.out.print("\tRPM\t-\t");
            System.out.println(washMachine.rpm);
            System.out.println("\t-----*----");
        }
    }

    public void showMobiles(){
        System.out.println("--- Mobiles ---");
        for(Mobiles mobile: ecommerceServices.mobiles){
            System.out.print("\tName\t-\t");
            System.out.println(mobile.name);
            System.out.print("\tProduct id\t-\t");
            System.out.println(mobile.productID);
            System.out.print("\tPrice\t-\t");
            System.out.println(mobile.price);
            System.out.print("\tDescription\t-\t");
            System.out.println(mobile.description);
            System.out.print("\tRAM\t-\t");
            System.out.println(mobile.ram);
            System.out.print("\tROM\t-\t");
            System.out.println(mobile.rom);
            System.out.println("\t-----*----");
        }
    }
}
