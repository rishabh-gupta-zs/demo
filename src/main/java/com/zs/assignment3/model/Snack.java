package com.zs.assignment3.model;

public class Snack extends Grocery{
    private String taste;

    public Snack(int price, String name, String productID, int weight, String taste) {
        super(price, name, productID, weight);
        this.taste = taste;
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
