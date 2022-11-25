package com.zs.assignment3;

import java.util.ArrayList;
import java.util.Scanner;

public class EcommerceController {

    Scanner sc=new Scanner(System.in);
    EcommerceServices ecs=new EcommerceServices();

    public void showmenu(){
        ecs.addInitialProducts();

        System.out.println("Choose an option");
        int i;
        do{
            System.out.println("1.  Add product\n2.  Show products\n-1. Exit");
            i= sc.nextInt();
            if(i==1){
                addProductMenu();

            } else if (i==2) {
                showProducts();
            } else if (i==-1) {
                System.out.println("Ending task");
            }else {
                System.out.println("Invalid input");
            }
        }while (i!=-1);

    }
    public void addProductMenu(){
        int j;
        System.out.println("Select the category in which you want to add the product");
        do{
            System.out.println("1.  Mobile\n2.  Washing Machine\n3.  Snacks\n");
            j= sc.nextInt();
            if(j==1){
                 ecs.addMobile();
            }else if(j==2){
                 ecs.addWashMachine();
            } else if (j==3) {
                 ecs.addSnacks();
            }else {
                System.out.println("Invalid Input");
            }

        }while (!(j==1 || j==2 || j==3));

    }
    public void showProducts(){
        int k;
        System.out.println("---  SHOW  ---");
        do{

            System.out.println("1.  Mobile\n2.  Washing Machine\n3.  Snacks\n4.  All\n-1 Back");
            k=sc.nextInt();
            if(k==1){
                ecs.showMobiles();
            } else if (k==2) {
                ecs.showWashMachine();
            }else if(k==3){
                ecs.showSnacks();
            } else if (k==4) {
                ecs.showMobiles();
                ecs.showWashMachine();
                ecs.showSnacks();
            } else if (k==-1) {

            }else{
                System.out.println("invalid input");
            }

        }while (k!=-1);
    }

}
