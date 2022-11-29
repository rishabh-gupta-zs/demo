package com.zs.assignment3.model;

public class WashingMachine extends Electronics{
    private int rpm;
//    WashingMachine(String name,String productID,int price,String description,
//            int rpm){
//        super(name, productID, price,description);
//        this.rpm=rpm;
//    }


    public void setRpm(int rpm) {
        this.rpm = rpm;
    }

    public int getRpm() {
        return rpm;
    }
}
