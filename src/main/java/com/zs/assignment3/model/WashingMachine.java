package com.zs.assignment3.model;

public class WashingMachine extends Electronic {
    private int rpm;

    public WashingMachine(int price, String name, String productID, String description, int rpm) {
        super(price, name, productID, description);
        this.rpm = rpm;
    }

    @Override
    public String toString() {
        return "#\t\t" +
                "Name='" + getName() + '\'' +
                ",\tDescription='" + getDescription() + '\'' +
                ",\tPrice='" + getPrice() + '\'' +
                ",\tRPM=" + rpm +
                ",\tproductID='" + getProductID() + '\'';
    }

}
