package com.zs.assignment3;

public class Mobiles extends Electronics{
    int ram,rom;
    Mobiles(String name,String productID,int price,String description,
            int ram,int rom){
        super(name, productID, price,description);
        this.ram=ram;
        this.rom=rom;
    }

}
