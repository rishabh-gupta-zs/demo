package com.zs.assignment3.model;

public class Grocery extends Product{

    private int weight;

    public Grocery(int price, String name, String productID, int weight) {
        super(price, name, productID);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
