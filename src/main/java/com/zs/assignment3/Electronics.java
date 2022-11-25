package com.zs.assignment3;

public class Electronics extends Product{
    String description;
    Electronics(String name,String productID,int price,String description){
        super(name, productID, price);
        this.description=description;
    }
}
