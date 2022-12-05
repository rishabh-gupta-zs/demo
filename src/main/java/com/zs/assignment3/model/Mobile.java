package com.zs.assignment3.model;

public class Mobile extends Electronic {

    private int ram,rom;

    public Mobile(int price, String name, String productID, String description, int ram, int rom) {
        super(price, name, productID, description);
        this.ram = ram;
        this.rom = rom;
    }

    @Override
    public String toString() {
        return "#\t" +
                "\tName: '" + getName() + '\'' +
                ",\tRAM: " + ram +
                ",\tROM: " + rom +
                ",\tPrice: " + getPrice() +
                ",\tDescription: " + getDescription() +
                ",\tproductID: '" + getProductID() + '\'';
    }
}
