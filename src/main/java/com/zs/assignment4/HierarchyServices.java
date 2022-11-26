package com.zs.assignment4;

public class HierarchyServices {
    public HierarchyNode searchInHierarchy(HierarchyNode root,String str){
            if(root.data.equals(str)){
                return root;
            }
            else{
                for (HierarchyNode n:root.childrens){
                    HierarchyNode res=searchInHierarchy(n,str);
                    if(!res.data.equals(""))
                        return res;
                }
            }
            return new HierarchyNode("");
    }
    public void printHierarchy(HierarchyNode root){
        if(root.childrens.size()>0){
            System.out.println(root.data);
            for (HierarchyNode n:root.childrens) {
                System.out.println("\t "+n.data);
            }
            for (HierarchyNode n:root.childrens) {
                printHierarchy(n);
            }
        }
    }
    public void showpath(HierarchyNode root){
        System.out.print(root.data);
        while (!root.data.equals("Flipkart")){
            root=root.prev;
            System.out.print(" << "+root.data);
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
        c111.prev=c11;
        c11.prev=c1;
        c12.prev=c1;
        c13.prev=c1;
        c21.prev=c2;
        c1.prev=root;
        c2.prev=root;
    }
}
