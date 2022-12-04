package com.zs.assignment3.model;

public class Electronic extends Product{

    private String description;

    public Electronic(int price, String name, String productID, String description) {
        super(price, name, productID);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
