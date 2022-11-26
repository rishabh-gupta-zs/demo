package com.zs.assignment4;

import java.util.ArrayList;

public class HierarchyNode {
    public String data;
    ArrayList<HierarchyNode> childrens;
    HierarchyNode prev;
    public HierarchyNode(String data){
        this.data=data;
        childrens=new ArrayList<>();
    }
}
