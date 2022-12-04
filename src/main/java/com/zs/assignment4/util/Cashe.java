package com.zs.assignment4.util;

public class Cashe {

    private String key;
    private Cashe pre;
    private Cashe next;

    public Cashe(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public Cashe getPre() {
        return pre;
    }

    public void setPre(Cashe pre) {
        this.pre = pre;
    }

    public Cashe getNext() {
        return next;
    }

    public void setNext(Cashe next) {
        this.next = next;
    }
}

