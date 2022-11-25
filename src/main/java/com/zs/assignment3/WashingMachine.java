package com.zs.assignment3;

public class WashingMachine extends Electronics{
    int rpm;
    WashingMachine(String name,String productID,int price,String description,
            int rpm){
        super(name, productID, price,description);
        this.rpm=rpm;
    }


}
