package com.zs.assignment3.service;

import com.zs.assignment3.model.Mobile;
import com.zs.assignment3.model.Snack;
import com.zs.assignment3.model.WashingMachine;
import java.util.ArrayList;
import java.util.HashMap;

public class EcommerceService {

    private HashMap<String, ArrayList<Object>> products=new HashMap<>();

    /**
     * Initialise hashmap with empty arraylist and add initial data of each type
     */
    public void addInitialProducts(){
        products.put("Mobile",new ArrayList());
        products.put("Snack",new ArrayList());
        products.put("WashingMachine",new ArrayList());
        addProduct("Realme","mbl-01",10000,"5000 mAh battery",4,128);
        addProduct("Samsung","wm-01",20000,600,"Heavy Duty");
        addProduct("Chips","sn-01",50,"salty",250);

    }

    /**
     * Adds data in Mobile
     * @param name - Name of mobile
     * @param productID - Product ID
     * @param price - Product price
     * @param description - Product description
     * @param ram - Mobile RAM
     * @param rom - mobile ROM
     */
    public void addProduct(String name,String productID,int price,String description,int ram,int rom){

        Mobile newMobile=new Mobile();
        newMobile.setName(name);
        newMobile.setProductID(productID);
        newMobile.setPrice(price);
        newMobile.setDescription(description);
        newMobile.setRam(ram);
        newMobile.setRom(rom);
        ArrayList mobiles=products.get("Mobile");
        mobiles.add(newMobile);
        products.put("Mobile",mobiles);

    }

    /**
     * Adds data in Snack
     * @param name - Name of Snack
     * @param productID - Product ID
     * @param price - Product price
     * @param taste - Product description
     * @param weight - Product weight per unit
     */
    public void addProduct(String name,String productID,int price,String taste,int weight){

        Snack newSnack=new Snack();
        newSnack.setName(name);
        newSnack.setTaste(taste);
        newSnack.setProductID(productID);
        newSnack.setPrice(price);
        newSnack.setWeight(weight);
        ArrayList snacks=products.get("Snack");
        snacks.add(newSnack);
        products.put("Snack",snacks);

    }

    /**
     * Adds data in Washing machine
     * @param name - Name of washing machine
     * @param productID - Product ID
     * @param price - Product price
     * @param description - Product description
     * @param rpm - Washing machine RPM
     */
    public void addProduct(String name,String productID,int price,int rpm,String description){

        WashingMachine newWashingMachine=new WashingMachine();
        newWashingMachine.setName(name);
        newWashingMachine.setProductID(productID);
        newWashingMachine.setRpm(rpm);
        newWashingMachine.setPrice(price);
        newWashingMachine.setDescription(description);
        ArrayList washingMachines=products.get("WashingMachine");
        washingMachines.add(newWashingMachine);
        products.put("WashingMachine",washingMachines);

    }

    /**
     * Returns the required arraylist from hashMap
     * @param toReturn - key of hashMap whose arrayList need to be return
     * @return - Arraylist of received key
     */
    public ArrayList getData(String toReturn){
        return products.get(toReturn);
    }

}
