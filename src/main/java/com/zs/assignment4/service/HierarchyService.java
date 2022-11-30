package com.zs.assignment4.service;

import com.zs.assignment4.model.HierarchyNode;

public class HierarchyService {

    private HierarchyNode root=new HierarchyNode();
    CacheService cacheService=new CacheService();

    /**
     * Search category is current tree
     * @param root - root of category tree
     * @param toSearch - Category to search
     * @return - HierarchyNode
     */
    public HierarchyNode searchInHierarchy(HierarchyNode root, String toSearch){
        if(root.getCategoryName().equals(toSearch)){
            return root;
        }
        else{
            HierarchyNode result;
            for (HierarchyNode hierarchyNode:root.getChildren()){
                result=searchInHierarchy(hierarchyNode,toSearch);
                if(result!=null)
                    return result;
            }
        }
        return null;
    }

    public void setRootName(String rootName){
        root.setCategoryName(rootName);
    }

    public HierarchyNode getRoot(){
        return root;
    }

    /**
     * Prints parent's category name on make recursive call for parent till reach the top most category
     * @param root - HierarchyNode
     */
    public void printHierarchy(HierarchyNode root){

        if(root.getChildren().size()>0){
            System.out.println(root.getCategoryName());
            for (HierarchyNode hierarchyNode:root.getChildren()) {
                System.out.println("\t "+hierarchyNode.getCategoryName());
            }
            for (HierarchyNode hierarchyNode:root.getChildren()) {
                printHierarchy(hierarchyNode);
            }
        }
    }

    /**
     * Returns HierarchyNode with given category name
     * @param toSearch - Category which need to search
     * @return - HierarchyNode
     */
    public HierarchyNode getNodeOf(String toSearch){

        HierarchyNode cacheResult= cacheService.get(toSearch);

        if(cacheResult==null){
            HierarchyNode searchResult= searchInHierarchy(root,toSearch);
            if(searchResult!=null){
                return searchResult;
            }
            else {
                return null;
            }
        }

        else{
            return cacheResult;
        }
    }

    /**
     * Add initial data in Hierarchy
     */
    public void addInitialCategory(){

        HierarchyNode c1=new HierarchyNode();
        HierarchyNode c2=new HierarchyNode();
        HierarchyNode c11=new HierarchyNode();
        HierarchyNode c12=new HierarchyNode();
        HierarchyNode c13=new HierarchyNode();
        HierarchyNode c111=new HierarchyNode();
        HierarchyNode c21=new HierarchyNode();

        c1.setCategoryName("Electronics");
        c2.setCategoryName("Grocery");
        c11.setCategoryName("Mobiles");
        c12.setCategoryName("Laptops");
        c13.setCategoryName("Home Appliences");
        c111.setCategoryName("SmartPhone");
        c21.setCategoryName("food items");

        root.addChildren(c1);
        root.addChildren(c2);
        c1.addChildren(c11);
        c1.addChildren(c12);
        c1.addChildren(c13);
        c11.addChildren(c111);
        c2.addChildren(c21);
        c111.setPre(c11);
        c11.setPre(c1);
        c12.setPre(c1);
        c13.setPre(c1);
        c21.setPre(c2);
        c1.setPre(root);
        c2.setPre(root);

    }
}
