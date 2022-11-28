package com.zs.assignment3;

import java.util.ArrayList;
import java.util.Scanner;

public class EcommerceServices {
    public ArrayList<Snacks> snacks=new ArrayList<>();
    public ArrayList<Mobiles> mobiles=new ArrayList<>();
    public ArrayList<WashingMachine> washingMachines=new ArrayList<>();
    Scanner scanner =new Scanner(System.in);

    public void addInitialProducts(){
        mobiles.add(new Mobiles("Realme","mbl-01",10000,"5000 mAh battery",4,128));
        mobiles.add(new Mobiles("Redmi","mbl-02",12000,"Customisable",6,128));
        mobiles.add(new Mobiles("Iphone","mbl-03",50000,"Good processor",8,128));
        washingMachines.add(new WashingMachine("Whirlpool","wm-01",12000,"Good performance",1400));
        washingMachines.add(new WashingMachine("Samsung","wm-002",20000,"Heavy Duty",1450));
        snacks.add(new Snacks("Biscuits","sn-001",100,"Sweet"));
        snacks.add(new Snacks("Potato chips","sn-002",150,"Salty"));
        snacks.add(new Snacks("Popcorn","sn-003",200,"Salty"));
    }

    public void addMobile(){
        System.out.println("Adding new Mobile. Please provide following data");
        System.out.println("Name");
        String name= scanner.nextLine();
        System.out.println("Product id");
        String productID= scanner.nextLine();
        System.out.println("Price");
        int price= scanner.nextInt();
        System.out.println("Description");
        scanner.nextLine();
        String desc= scanner.nextLine();
        System.out.println("RAM");
        int ram= scanner.nextInt();
        System.out.println("ROM");
        int rom= scanner.nextInt();
        mobiles.add(new Mobiles(name,productID,price,desc,ram,rom));
        System.out.println(name+" added successfully");
    }

    public void addSnacks(){
        System.out.println("Adding new Snack. Please provide following data");
        System.out.println("Name");
        String name= scanner.nextLine();
        System.out.println("Product id");
        String productID= scanner.nextLine();
        System.out.println("Price");
        int price= scanner.nextInt();
        System.out.println("Taste");
        scanner.nextLine();
        String taste= scanner.nextLine();
        snacks.add(new Snacks(name,productID,price,taste));
        System.out.println(name+" added successfully");
    }

    public void addWashMachine(){
        System.out.println("Adding new Washing Machine. Please provide following data");
        scanner.nextLine();
        System.out.println("Name");
        String name= scanner.nextLine();
        System.out.println("Product id");
        String productID= scanner.nextLine();
        System.out.println("Price");
        int price= scanner.nextInt();
        System.out.println("Description");
        scanner.nextLine();
        String desc= scanner.nextLine();
        System.out.println("RPM");
        int rpm= scanner.nextInt();
        washingMachines.add(new WashingMachine(name,productID,price,desc,rpm));
        System.out.println(name+" added successfully");
    }

}
