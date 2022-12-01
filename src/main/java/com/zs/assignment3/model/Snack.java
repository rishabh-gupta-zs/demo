package com.zs.assignment3.model;

public class Snack extends Grocery{
    private String taste;


    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getTaste() {
        return taste;
    }

    @Override
    public String toString() {
        return "#\t" +
                "\tName: '" + getName() + '\'' +
                ",\tPrice: " + getPrice() +
                ",\tTaste: " + taste +
                ",\tWeight(per pack): " + getWeight() +
                ",\tproductID: '" + getProductID() + '\'';
    }
}
