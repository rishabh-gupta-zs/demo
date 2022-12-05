package com.zs.assignment4.controller;

import com.zs.assignment4.model.Category;
import com.zs.assignment4.service.CategoryService;
import java.util.Scanner;

public class CategoryController {

    private Scanner scanner =new Scanner(System.in);
    private CategoryService categoryService =new CategoryService();

    /**
     * Show initial options. Based on selected option shows next method.
     */
    public void start(){

        int input;
        do{
            System.out.println("1.  Add Category to hierarchy\n" +
                    "2.  Search in hierarchy\n" +
                    "3.  Display hierarchy\n" +
                    "-1 Exit");
            input= scanner.nextInt();
            switch (input){

                case 1:
                    System.out.println("Enter Category you want to add.");
                    scanner.nextLine();
                    String subCategory= scanner.nextLine();
                    System.out.println("Enter category in which you want to add.");
                    String category=scanner.nextLine();

                    boolean added= categoryService.addCategory(category,subCategory);
                    if(added){
                        System.out.println(subCategory + " added successfully");
                    }
                    else {
                        System.out.println(category + " not found.");
                    }
                    break;

                case 2:
                    System.out.println("Enter Category to search");
                    scanner.nextLine();
                    category= scanner.nextLine();

                    if(categoryService.search(category)){
                        System.out.println(category+" is present in categories.");
                    }
                    else {
                        System.out.println(category+" is not present in categories.");
                    }
                    break;

                case 3:
                    Category categories= categoryService.getRootCategories();
                    displayHierarchy(categories);
                    System.out.println("Enter any number to go back");
                    scanner.nextInt();
                    break;

                case -1:
                    System.out.println("End");
                    break;

                default:
                    System.out.println("Invalid selection");
            }
        }while (input!=-1);
    }

    /**
     * Prints the Hierarchy
     * @param categories - root of Hierarchy
     */
    public void displayHierarchy(Category categories){

        if(categories.getSubcategories().size()>0){

            System.out.println(categories.getCategory());

            for (Category hierarchyNode:categories.getSubcategories()) {
                System.out.println("\t "+hierarchyNode.getCategory());
            }

            for (Category hierarchyNode:categories.getSubcategories()) {
                displayHierarchy(hierarchyNode);
            }
        }

    }
}
