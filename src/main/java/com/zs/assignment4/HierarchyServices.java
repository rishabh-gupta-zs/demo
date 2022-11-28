package com.zs.assignment4;

public class HierarchyServices {
    public HierarchyNode searchInHierarchy(HierarchyNode root,String toSearch){
            if(root.categoryName.equals(toSearch)){
                return root;
            }
            else{
                for (HierarchyNode hierarchyNode:root.childrens){
                    HierarchyNode res=searchInHierarchy(hierarchyNode,toSearch);
                    if(!res.categoryName.equals(""))
                        return res;
                }
            }
            return new HierarchyNode("");
    }
    public void printHierarchy(HierarchyNode root){
        if(root.childrens.size()>0){
            System.out.println(root.categoryName);
            for (HierarchyNode hierarchyNode:root.childrens) {
                System.out.println("\t "+hierarchyNode.categoryName);
            }
            for (HierarchyNode hierarchyNode:root.childrens) {
                printHierarchy(hierarchyNode);
            }
        }
    }
    public void showpath(HierarchyNode root){
        System.out.print(root.categoryName);
        while (!root.categoryName.equals("Flipkart")){
            root=root.pre;
            System.out.print(" << "+root.categoryName);
        }
        System.out.println();
    }
    public void makeInitialHierarchy(HierarchyNode root){
        HierarchyNode c1=new HierarchyNode("Electronics");
        HierarchyNode c2=new HierarchyNode("Grocery");
        HierarchyNode c11=new HierarchyNode("Mobiles");
        HierarchyNode c12=new HierarchyNode("Laptops");
        HierarchyNode c13=new HierarchyNode("Home Appliences");
        HierarchyNode c111=new HierarchyNode("SmartPhone");
        HierarchyNode c21=new HierarchyNode("food items");
        root.childrens.add(c1);
        root.childrens.add(c2);
        c1.childrens.add(c11);
        c1.childrens.add(c12);
        c1.childrens.add(c13);
        c11.childrens.add(c111);
        c2.childrens.add(c21);
        c111.pre =c11;
        c11.pre =c1;
        c12.pre =c1;
        c13.pre =c1;
        c21.pre =c2;
        c1.pre =root;
        c2.pre =root;
    }
}
