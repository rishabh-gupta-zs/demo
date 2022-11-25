package com.zs.assignment3;

public class Snacks extends Grocery{
    String taste;
    Snacks(String name,String productID,int price,String taste){
        super(name, productID, price);
        this.taste=taste;
    }
}
