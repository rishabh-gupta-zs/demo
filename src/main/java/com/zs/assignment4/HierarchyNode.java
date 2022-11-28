package com.zs.assignment4;

import java.util.ArrayList;

public class HierarchyNode {
    public String categoryName;
    ArrayList<HierarchyNode> children;
    HierarchyNode pre;
    public HierarchyNode(String data){
        this.categoryName =data;
        children =new ArrayList<>();
    }
}
