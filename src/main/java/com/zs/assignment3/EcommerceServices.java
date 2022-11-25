package com.zs.assignment3;

import java.util.ArrayList;
import java.util.Scanner;

public class EcommerceServices {
    public static ArrayList<Snacks> snacks=new ArrayList<>();
    public static ArrayList<Mobiles> mobiles=new ArrayList<>();
    public static ArrayList<WashingMachine> washingMachines=new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    public void addInitialProducts(){
        mobiles.add(new Mobiles("Realme","mbl-01",10000,"5000 mAh battery",4,128));
        mobiles.add(new Mobiles("Redmi","mbl-02",12000,"Customisable",6,128));
        mobiles.add(new Mobiles("Iphone","mbl-03",50000,"Good processer",8,128));
        washingMachines.add(new WashingMachine("Whirlpool","wm-01",12000,"Good performance",1400));
        washingMachines.add(new WashingMachine("Samsung","wm-002",20000,"Heavy Duty",1450));
        snacks.add(new Snacks("Biscuits","sn-001",100,"Sweet"));
        snacks.add(new Snacks("Patato chips","sn-002",150,"Salty"));
        snacks.add(new Snacks("Popcorn","sn-003",200,"Salty"));
    }
    public void addMobile(){
        System.out.println("Adding new Mobile. Please provide following data");
        System.out.println("Name");
        sc.nextLine();
        String name=sc.nextLine();
        System.out.println("Product id");
        String productID=sc.nextLine();
        System.out.println("Price");
        int price=sc.nextInt();
        System.out.println("Description");
        sc.nextLine();
        String desc=sc.nextLine();
        System.out.println("RAM");
        int ram=sc.nextInt();
        System.out.println("ROM");
        int rom=sc.nextInt();
        mobiles.add(new Mobiles(name,productID,price,desc,ram,rom));
        System.out.println(name+" added successfully");
    }
    public void addSnacks(){
        System.out.println("Adding new Snack. Please provide following data");
        System.out.println("Name");
        String name=sc.nextLine();
        System.out.println("Product id");
        String productID=sc.nextLine();
        System.out.println("Price");
        int price=sc.nextInt();
        System.out.println("Taste");
        sc.nextLine();
        String taste=sc.nextLine();
        snacks.add(new Snacks(name,productID,price,taste));
        System.out.println(name+" added successfully");

    }
    public void addWashMachine(){
        System.out.println("Adding new Washing Machine. Please provide following data");
        sc.nextLine();
        System.out.println("Name");
        String name=sc.nextLine();
        System.out.println("Product id");
        String productID=sc.nextLine();
        System.out.println("Price");
        int price=sc.nextInt();
        System.out.println("Description");
        sc.nextLine();
        String desc=sc.nextLine();
        System.out.println("RPM");
        int rpm=sc.nextInt();
        washingMachines.add(new WashingMachine(name,productID,price,desc,rpm));
        System.out.println(name+" added successfully");

    }
    public void showSnacks(){
        for(Snacks sn:snacks){
            System.out.println("--- Snacks ---");
            System.out.print("\tName\t-\t");
            System.out.println(sn.name);
            System.out.print("\tProduct id\t-\t");
            System.out.println(sn.productID);
            System.out.print("\tPrice(Rs.)\t-\t");
            System.out.println(sn.price);
            System.out.print("\tTaste\t-\t");
            System.out.println(sn.taste);
            System.out.println("-----*----");
        }
    }
    public void showWashMachine(){
        System.out.println("--- Washing Machine ---");
        for(WashingMachine wm:washingMachines){
            System.out.print("\tName\t-\t");
            System.out.println(wm.name+"\t\t");
            System.out.print("\tProduct id\t-\t");
            System.out.println(wm.productID+"\t\t");
            System.out.print("\tPrice\t-\t");
            System.out.println(wm.price+"\t\t");
            System.out.print("\tDescription\t-\t");
            System.out.println(wm.description+"\t\t");
            System.out.print("\tRPM\t-\t");
            System.out.println(wm.rpm);
            System.out.println("-----*----");
        }
    }
    public void showMobiles(){
        for(Mobiles mb:mobiles){
            System.out.println("--- Mobiles ---");
            System.out.print("\tName\t-\t");
            System.out.println(mb.name);
            System.out.print("\tProduct id\t-\t");
            System.out.println(mb.productID);
            System.out.print("\tPrice\t-\t");
            System.out.println(mb.price);
            System.out.print("\tDescription\t-\t");
            System.out.println(mb.description);
            System.out.print("\tRAM\t-\t");
            System.out.println(mb.ram);
            System.out.print("\tROM\t-\t");
            System.out.println(mb.rom);
            System.out.println("-----*----");
        }
    }
}
