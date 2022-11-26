package com.zs.assignment4;

import com.zs.assignment4.LRUcache.Cache;

import java.util.Scanner;

public class HierarchyController {
    Scanner sc=new Scanner(System.in);
    HierarchyNode rootNode=new HierarchyNode("Flipkart");
    Cache cache=new Cache(4);
    HierarchyServices hrsrv=new HierarchyServices();

    public void showMenu(){
        hrsrv.makeInitialHierarchy(rootNode);
        int x;
        do{
            System.out.println("1.  Add Category to hierarchy");
            System.out.println("2.  Search in hierarchy");
            System.out.println("3.  Show hierarchy");
            System.out.println("-1. Exit");
            x=sc.nextInt();
            switch (x){
                case 1:
                    addtoHierarchy(rootNode);
                    break;
                case 2:
                    System.out.println("Enter Category to search");
                    sc.nextLine();
                    String str=sc.nextLine();
                    HierarchyNode cacheResult=cache.get(str);
                    if(cacheResult.data.equals("")){
                        HierarchyNode res=hrsrv.searchInHierarchy(rootNode,str);
                        if(!res.data.equals("")){
                            hrsrv.showpath(res);
                            cache.set(str,res);
                        }
                        else {
                            System.out.println(str+" not found");
                        }
                    }
                    else{
                        hrsrv.showpath(cacheResult);
                    }

                    break;
                case 3:
                    hrsrv.printHierarchy(rootNode);
                    System.out.println("Enter any number to go back");
                    sc.nextInt();
                    break;
                case -1:
                    System.out.println("End");
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }while (x!=-1);
    }
    public boolean addtoHierarchy(HierarchyNode root){

            System.out.println("-------"+root.data+"--------");
            int childsize=root.childrens.size();
            if(root.childrens.size()!=0){
                for(int i=0;i<childsize;i++)
                    System.out.println(i+". >> "+root.childrens.get(i).data);
            }
            System.out.println(childsize+". + ");
            System.out.println("Any other Number to Terminate action");
            int t;
            while(true){
                t= sc.nextInt();
                if(t==childsize){
                    System.out.println("Enter subcategory");
                    sc.nextLine();
                    String str=sc.nextLine();
                    HierarchyNode ch=new HierarchyNode(str);
                    root.childrens.add(ch);
                    ch.prev=root;
                    cache.set(str,ch);
                    System.out.println(str+" added to "+root.data+" Successfully");
                    return true;
                } else if (t>=0 && t<childsize) {
                    if(addtoHierarchy(root.childrens.get(t))){
                        return true;
                    }
                }
                else{
                    System.out.println("invalid input");
                }
            }

    }


}
