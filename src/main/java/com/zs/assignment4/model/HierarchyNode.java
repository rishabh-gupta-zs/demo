package com.zs.assignment4.model;

import java.util.ArrayList;

public class HierarchyNode {

    private String categoryName;
    private ArrayList<HierarchyNode> children=new ArrayList<>();
    private HierarchyNode pre;

    public String getCategoryName() {
        return categoryName;
    }

    public HierarchyNode getPre() {
        return pre;
    }

    public ArrayList<HierarchyNode> getChildren() {
        return children;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setPre(HierarchyNode pre) {
        this.pre = pre;
    }

    public void addChildren(HierarchyNode node){
        this.children.add(node);
    }
}
