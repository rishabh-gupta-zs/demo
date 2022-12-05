package com.zs.assignment3.model;

public class Product {
    private int price;
    private String name,productID;

    public Product(int price, String name, String productID) {
        this.price = price;
        this.name = name;
        this.productID = productID;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getProductID() {
        return productID;
    }
}
