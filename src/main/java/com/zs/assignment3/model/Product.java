package com.zs.assignment3.model;

public class Product {
    private int price;
    private String name,productID;

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductID(String productID) {
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
