package com.zs.assignment4.model;

import java.util.ArrayList;

public class Category {

    private String category;
    private ArrayList<Category> subcategories=new ArrayList<>();

    public Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public ArrayList<Category> getSubcategories() {
        return subcategories;
    }

    public void addSubCategory(Category subcategory){
        this.subcategories.add(subcategory);
    }
}
