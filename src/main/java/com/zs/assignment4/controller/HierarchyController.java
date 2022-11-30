package com.zs.assignment4.controller;

import com.zs.assignment4.model.HierarchyNode;
import com.zs.assignment4.service.CacheService;
import com.zs.assignment4.service.HierarchyService;
import java.util.Scanner;

public class HierarchyController {

    Scanner scanner =new Scanner(System.in);
    CacheService cacheService =new CacheService();
    HierarchyService hierarchyService =new HierarchyService();

    /**
     * Show initial options. Based on selected option shows next method.
     */
    public void start(){

        hierarchyService.setRootName("Flipkart");
        hierarchyService.addInitialCategory();

        int input;
        do{
            System.out.println("1.  Add Category to hierarchy");
            System.out.println("2.  Search in hierarchy");
            System.out.println("3.  Show hierarchy");
            System.out.println("-1. Exit");
            input= scanner.nextInt();

            switch (input){
                case 1:
                    addToHierarchy(hierarchyService.getRoot());
                    break;

                case 2:
                    System.out.println("Enter Category to search");
                    scanner.nextLine();
                    String toSearch= scanner.nextLine();
                    HierarchyNode resultNode=hierarchyService.getNodeOf(toSearch);

                    if(resultNode==null){
                        System.out.println(toSearch+" not Found");
                    }

                    else{
                        System.out.print(resultNode.getCategoryName());

                        while (!resultNode.getCategoryName().equals("Flipkart")){
                            resultNode=resultNode.getPre();
                            System.out.print(" << "+resultNode.getCategoryName());
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    hierarchyService.printHierarchy(hierarchyService.getRoot());
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
     * Shows category inside root and give option to create subCategory
     * @param root - current root node
     * @return - true
     */
    public boolean addToHierarchy(HierarchyNode root){

        System.out.println("-------"+root.getCategoryName() +"--------");
        int numberOfChild=root.getChildren().size();
        if(root.getChildren().size()!=0){
            for(int i=0;i<numberOfChild;i++)
                System.out.println(i+". >> "+root.getChildren().get(i).getCategoryName());
        }
        System.out.println(numberOfChild+". + ");
        System.out.println("Any other Number to Terminate action");

        int input;
        while(true){
            input= scanner.nextInt();

            if(input==numberOfChild){

                System.out.println("Enter subcategory");
                scanner.nextLine();
                String toAdd= scanner.nextLine();

                HierarchyNode newHierarchyNode=new HierarchyNode();
                newHierarchyNode.setCategoryName(toAdd);
                root.getChildren().add(newHierarchyNode);
                newHierarchyNode.setPre(root);

                cacheService.set(toAdd,newHierarchyNode);
                System.out.println(toAdd+" added to "+root.getCategoryName() +" Successfully");
                return true;

            } else if (input>=0 && input<numberOfChild) {

                if(addToHierarchy(root.getChildren().get(input))){
                    return true;
                }
            }

            else{
                System.out.println("invalid input");
            }

        }
    }
}
