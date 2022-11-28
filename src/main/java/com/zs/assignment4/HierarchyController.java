package com.zs.assignment4;

import com.zs.assignment4.lrucache.CacheController;

import java.util.Scanner;

public class HierarchyController {
    Scanner scanner =new Scanner(System.in);
    HierarchyNode rootNode=new HierarchyNode("Flipkart");
    CacheController cacheController =new CacheController(4);
    HierarchyServices hierarchyServices =new HierarchyServices();

    public void showMenu(){
        hierarchyServices.makeInitialHierarchy(rootNode);
        int input;
        do{
            System.out.println("1.  Add Category to hierarchy");
            System.out.println("2.  Search in hierarchy");
            System.out.println("3.  Show hierarchy");
            System.out.println("-1. Exit");
            input= scanner.nextInt();
            switch (input){
                case 1:
                    addtoHierarchy(rootNode);
                    break;

                case 2:
                    System.out.println("Enter Category to search");
                    scanner.nextLine();
                    String toSearch= scanner.nextLine();
                    HierarchyNode cacheResult= cacheController.get(toSearch);
                    if(cacheResult==null){
                        HierarchyNode cacheResponse= hierarchyServices.searchInHierarchy(rootNode,toSearch);
                        if(!cacheResponse.categoryName.equals("")){
                            hierarchyServices.showpath(cacheResponse);
                            cacheController.set(toSearch,cacheResponse);
                        }
                        else {
                            System.out.println(toSearch+" not found");
                        }
                    }
                    else{
                        hierarchyServices.showpath(cacheResult);
                    }
                    break;

                case 3:
                    hierarchyServices.printHierarchy(rootNode);
                    System.out.println("Enter any number to go back");
                    scanner.nextInt();
                    break;

                case -1:
                    System.out.println("End");
                    break;

                default:
                    System.out.println("Invalid input");
            }
        }while (input!=-1);
    }
    public boolean addtoHierarchy(HierarchyNode root){

            System.out.println("-------"+root.categoryName +"--------");
            int childSize=root.childrens.size();
            if(root.childrens.size()!=0){
                for(int i=0;i<childSize;i++)
                    System.out.println(i+". >> "+root.childrens.get(i).categoryName);
            }
            System.out.println(childSize+". + ");
            System.out.println("Any other Number to Terminate action");
            int input;
            while(true){
                input= scanner.nextInt();
                if(input==childSize){
                    System.out.println("Enter subcategory");
                    scanner.nextLine();
                    String toAdd= scanner.nextLine();
                    HierarchyNode newHierarchyNode=new HierarchyNode(toAdd);
                    root.childrens.add(newHierarchyNode);
                    newHierarchyNode.pre =root;
                    cacheController.set(toAdd,newHierarchyNode);
                    System.out.println(toAdd+" added to "+root.categoryName +" Successfully");
                    return true;
                } else if (input>=0 && input<childSize) {
                    if(addtoHierarchy(root.childrens.get(input))){
                        return true;
                    }
                }
                else{
                    System.out.println("invalid input");
                }
            }
    }
}
