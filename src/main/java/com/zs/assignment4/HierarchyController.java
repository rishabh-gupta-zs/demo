package com.zs.assignment4;

import com.zs.assignment4.lrucache.CacheController;

import java.util.Scanner;

public class HierarchyController {
    Scanner scanner =new Scanner(System.in);
    HierarchyNode rootNode=new HierarchyNode("Flipkart");
    CacheController cacheController =new CacheController(4);
    HierarchyService hierarchyService =new HierarchyService();

    public void showMenu(){
        hierarchyService.makeInitialHierarchy(rootNode);
        int input;
        do{
            System.out.println("1.  Add Category to hierarchy");
            System.out.println("2.  Search in hierarchy");
            System.out.println("3.  Show hierarchy");
            System.out.println("-1. Exit");
            input= scanner.nextInt();
            switch (input){
                case 1:
                    addToHierarchy(rootNode);
                    break;

                case 2:
                    System.out.println("Enter Category to search");
                    scanner.nextLine();
                    String toSearch= scanner.nextLine();
                    HierarchyNode cacheResult= cacheController.get(toSearch);
                    if(cacheResult==null){
                        HierarchyNode cacheResponse= hierarchyService.searchInHierarchy(rootNode,toSearch);
                        if(!cacheResponse.categoryName.equals("")){
                            hierarchyService.showpath(cacheResponse);
                            cacheController.set(toSearch,cacheResponse);
                        }
                        else {
                            System.out.println(toSearch+" not found");
                        }
                    }
                    else{
                        hierarchyService.showpath(cacheResult);
                    }
                    break;

                case 3:
                    hierarchyService.printHierarchy(rootNode);
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
    public boolean addToHierarchy(HierarchyNode root){

            System.out.println("-------"+root.categoryName +"--------");
            int numberOfChild=root.children.size();
            if(root.children.size()!=0){
                for(int i=0;i<numberOfChild;i++)
                    System.out.println(i+". >> "+root.children.get(i).categoryName);
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
                    HierarchyNode newHierarchyNode=new HierarchyNode(toAdd);
                    root.children.add(newHierarchyNode);
                    newHierarchyNode.pre =root;
                    cacheController.set(toAdd,newHierarchyNode);
                    System.out.println(toAdd+" added to "+root.categoryName +" Successfully");
                    return true;
                } else if (input>=0 && input<numberOfChild) {
                    if(addToHierarchy(root.children.get(input))){
                        return true;
                    }
                }
                else{
                    System.out.println("invalid input");
                }
            }
    }
}
