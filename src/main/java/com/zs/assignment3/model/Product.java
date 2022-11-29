package com.zs.assignment3.model;

public class Product {
    private int price;
    String name,productID;
//    Product(String name,String productID,int price){
//        this.name=name;
//        this.price=price;
//        this.productID=productID;
//    }


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
