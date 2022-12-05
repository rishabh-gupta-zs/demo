package com.zs.assignment3.service;

import com.zs.assignment3.model.Mobile;
import com.zs.assignment3.model.Product;
import com.zs.assignment3.model.Snack;
import com.zs.assignment3.model.WashingMachine;
import java.util.ArrayList;
import java.util.HashMap;

public class EcommerceService {

    private HashMap<String, ArrayList<Product>> products=new HashMap<>();

     public EcommerceService(){

        products.put("Mobile",new ArrayList<>());
        products.put("Snack",new ArrayList<>());
        products.put("WashingMachine",new ArrayList<>());

        addProduct(new Mobile(10000,"Realme","mbl-01","5000 mAh battery",4,128),"Mobile");
        addProduct(new WashingMachine(20000,"Samsung washing machine","wm-01","Heavy  Duty",600),"WashingMachine");
        addProduct(new Snack(50,"Chips","sn-01",250,"Salty"),"Snack");
    }

    /**
     * Adds product in products
     */
    public void addProduct(Product product,String productType) {

        products.get(productType).add(product);
    }

    /**
     * Returns the arraylist of products
     * @param type - key of product
     * @return - Arraylist of products
     */
    public ArrayList<Product> getProduct(String type){

        return products.get(type);
    }
}
