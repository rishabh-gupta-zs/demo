package com.zs.assignment3.model;

public class WashingMachine extends Electronics{
    private int rpm;

    public void setRpm(int rpm) {
        this.rpm = rpm;
    }

    public int getRpm() {
        return rpm;
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
