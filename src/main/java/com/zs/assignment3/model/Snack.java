package com.zs.assignment3.model;

public class Snack extends Grocery{
    private String taste;
//    Snack(String name, String productID, int price, String taste, int weight){
//        super(name, productID, price,weight);
//        this.taste=taste;
//    }


    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getTaste() {
        return taste;
    }
}
