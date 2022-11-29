package com.zs.assignment3.model;

public class Mobile extends Electronics{

    private int ram,rom;

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setRom(int rom) {
        this.rom = rom;
    }

    public int getRam() {
        return ram;
    }

    public int getRom() {
        return rom;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "ram=" + ram +
                ", rom=" + rom +
                ", name='" + name + '\'' +
                ", productID='" + productID + '\'' +
                '}';
    }
}
