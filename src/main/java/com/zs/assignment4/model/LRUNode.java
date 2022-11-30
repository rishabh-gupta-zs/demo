package com.zs.assignment4.model;

public class LRUNode {

    private String key;
    private HierarchyNode value;
    private LRUNode pre;
    private LRUNode next;

    public String getKey() {
        return key;
    }

    public HierarchyNode getValue() {
        return value;
    }

    public LRUNode getPre() {
        return pre;
    }

    public LRUNode getNext() {
        return next;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(HierarchyNode value) {
        this.value = value;
    }

    public void setPre(LRUNode pre) {
        this.pre = pre;
    }

    public void setNext(LRUNode next) {
        this.next = next;
    }

}

