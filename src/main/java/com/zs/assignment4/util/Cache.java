package com.zs.assignment4.util;

public class Cache {

    private String key;
    private Cache pre;
    private Cache next;

    public Cache(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public Cache getPre() {
        return pre;
    }

    public void setPre(Cache pre) {
        this.pre = pre;
    }

    public Cache getNext() {
        return next;
    }

    public void setNext(Cache next) {
        this.next = next;
    }
}

