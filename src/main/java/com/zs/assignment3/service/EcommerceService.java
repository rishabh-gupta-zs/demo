package com.zs.assignment3.service;

import com.zs.assignment3.model.Mobile;
import com.zs.assignment3.model.Snack;
import com.zs.assignment3.model.WashingMachine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EcommerceService {

//    public ArrayList<Snack> snacks=new ArrayList<>();
//    public ArrayList<Mobile> mobiles=new ArrayList<>();
//    public ArrayList<WashingMachine> washingMachines=new ArrayList<>();

    private HashMap<String, ArrayList<Mobile>> products=new HashMap<String, ArrayList<Mobile>>();
    Scanner scanner =new Scanner(System.in);

    public void addInitialProducts(){

        addProduct("Mobile","Realme","mbl-01",10000,"5000 mAh battery",4,128);

//        addMobile("Realme","mbl-01",10000,"5000 mAh battery",4,128);
//        addWashingMachine("Samsung","wm-01",20000,"Heavy Duty",600);
//        addSnacks("Chips","sn-01",50,"salty",250);

    }

    public void addProduct(String type,String name,String productID,int price,String description,int ram,int rom){

        Mobile newMobile=new Mobile();
        newMobile.setName(name);
        newMobile.setProductID(productID);
        newMobile.setPrice(price);
        newMobile.setDescription(description);
        newMobile.setRam(ram);
        newMobile.setRom(rom);
//        mobiles.add(newMobile);
//        ArrayList<Mobile> al=new ArrayList<>();
//         products.put(type,al);
        ArrayList al=products.get(type);
        al.add(newMobile);
        products.put(type,al);
    }


    public void addSnacks(String name,String productID,int price,String taste,int weight){

        Snack newSnack=new Snack();
        newSnack.setName(name);
        newSnack.setTaste(taste);
        newSnack.setProductID(productID);
        newSnack.setPrice(price);
        newSnack.setWeight(weight);
        snacks.add(newSnack);

    }

    public void addWashingMachine(String name,String productID,int price,String description,int rpm){

        WashingMachine newWashingMachine=new WashingMachine();
        newWashingMachine.setName(name);
        newWashingMachine.setProductID(productID);
        newWashingMachine.setRpm(rpm);
        newWashingMachine.setPrice(price);
        newWashingMachine.setDescription(description);
        washingMachines.add(newWashingMachine);

    }
}
