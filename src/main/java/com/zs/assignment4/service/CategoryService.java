package com.zs.assignment4.service;

import com.zs.assignment4.model.Category;
import com.zs.assignment4.util.LruCache;

public class CategoryService {

    private Category rootCategories =new Category("Products");
    private LruCache lruCache=new LruCache();

    public CategoryService() {

        Category electronics=new Category("Electronics");
        Category grocery=new Category("Grocery");
        Category mobiles=new Category("Mobiles");
        Category laptops=new Category("Laptops");
        Category homeAppliances=new Category("Home Appliances");
        Category newLaunches=new Category("New Launches");
        Category hairCare=new Category("Hair Care");
        Category oralCare=new Category("Oral Care");

        rootCategories.addSubCategory(electronics);
        rootCategories.addSubCategory(grocery);
        electronics.addSubCategory(laptops);
        electronics.addSubCategory(mobiles);
        electronics.addSubCategory(homeAppliances);
        laptops.addSubCategory(newLaunches);
        grocery.addSubCategory(oralCare);
        grocery.addSubCategory(hairCare);
    }

    /**
     * returns root categories
     * @return - categories root
     */
    public Category getRootCategories(){
        return rootCategories;
    }

    /**
     * adds subcategoie of provided categories
     * @param category - category
     * @param subCategory - subcategory
     * @return - true/false
     */
    public boolean addCategory(String category,String subCategory){
        Category result=getCategory(rootCategories,category);
        if(result == null){
            return false;
        }
        result.addSubCategory(new Category(subCategory));
        lruCache.add(subCategory);
        return true;
    }

    /**
     * gives the category node
     * @param category - category Node
     * @param categoryName - subcstegory name
     * @return - node
     */
    public Category getCategory(Category category,String categoryName){
        if(category.getCategory().equals(categoryName)){
            return category;
        }
        else{
            for (Category category1 : category.getSubcategories()){
                Category result=getCategory(category1,categoryName);
                if(result!=null)
                    return result;
            }
        }
        return null;
    }
    /**
     * search category name
     * @param category - category name
     * @return - true/false
     */
    public boolean search(String category){
        LruCache lruCache=new LruCache();

        if (lruCache.get(category)){
            return true;
        }
        else{
            Category result=getCategory(rootCategories,category);
            if(result==null){
                return false;
            }
            lruCache.add(category);
            return true ;
        }
    }
}
