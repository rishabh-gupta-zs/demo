package com.zs.assignment4.service;

import com.zs.assignment4.model.HierarchyNode;
import com.zs.assignment4.model.LRUNode;
import java.util.HashMap;

public class CacheService {

    private HashMap<String, LRUNode> dataNodeAddress;
    private int count;
    private final int CAPACITY=4;
    private LRUNode head, tail;

    /**
     * Initialize variables
     */
    public CacheService() {

        dataNodeAddress = new HashMap<>();
        head = new LRUNode();
        tail = new LRUNode();
        head.setNext(tail);
        tail.setPre(head);
        head.setPre(null);
        tail.setNext(null);
        count = 0;
    }

    /**
     * Deletes Node from data
     * @param node - LRUNode
     */
    public void deleteNode(LRUNode node) {

        node.getPre().setNext(node.getNext());
        node.getNext().setPre(node.getPre());
    }

    /**
     * Adds node to head
     * @param node - LRUNode
     */
    public void addToHead(LRUNode node) {

        node.setNext(head.getNext());
        node.getNext().setPre(node);
        node.setPre(head);
        head.setNext(node);
    }

    /**
     * Returns Hierarchy node of respective key
     * @param key - String whose data need to return
     * @return - HierarchyNode or null
     */
    public HierarchyNode get(String key) {

        if (dataNodeAddress.get(key) != null) {
            LRUNode node = dataNodeAddress.get(key);
            HierarchyNode result = node.getValue();
            deleteNode(node);
            addToHead(node);
            return result;
        }
        return null;
    }

    /**
     * Store HierarchyNode with key
     * @param key - key for HierarchyNode
     * @param value _ HierarchyNode
     */
    public void set(String key, HierarchyNode value) {

        if (dataNodeAddress.get(key) != null) {
            LRUNode node = dataNodeAddress.get(key);
            node.setValue(value);
            deleteNode(node);
            addToHead(node);
        }

        else {
            LRUNode node = new LRUNode();
            node.setValue(value);
            node.setKey(key);
            dataNodeAddress.put(key, node);
            if (count < CAPACITY) {
                count++;
                addToHead(node);
            }
            else {
                dataNodeAddress.remove(tail.getPre().getKey());
                deleteNode(tail.getPre());
                addToHead(node);
            }
        }
    }
}
