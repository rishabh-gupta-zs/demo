package com.zs.assignment4.util;

import java.util.HashMap;

public class LruCache {

    private HashMap<String, Cashe> cacheStorage;
    private int count;
    private final int CAPACITY=4;
    private Cashe head, tail;

    public LruCache() {

        cacheStorage = new HashMap<>();
        head = new Cashe("");
        tail = new Cashe("");
        head.setNext(tail);
        tail.setPre(head);
        head.setPre(null);
        tail.setNext(null);
        count = 0;
    }

    /**
     * Deletes Node
     * @param node - LRUNode
     */
    public void deleteNode(Cashe node) {

        node.getPre().setNext(node.getNext());
        node.getNext().setPre(node.getPre());
    }

    /**
     * Adds node to head
     * @param node - LRUNode
     */
    public void addToHead(Cashe node) {

        node.setNext(head.getNext());
        node.getNext().setPre(node);
        node.setPre(head);
        head.setNext(node);
    }

    /**
     * Returns true if string is present is cache
     * @param string - String
     * @return - true/false
     */
    public boolean get(String string) {

        if (cacheStorage.containsKey(string)) {
            Cashe node = cacheStorage.get(string);
            deleteNode(node);
            addToHead(node);
            return true;
        }
        return false;
    }

    /**
     * add string in cache storage
     * @param string - string
     */
    public void add(String string) {

        Cashe node = new Cashe(string);
        cacheStorage.put(string, node);
        if (count < CAPACITY) {
            count++;
            addToHead(node);
        }
        else {
            cacheStorage.remove(tail.getPre().getKey());
            deleteNode(tail.getPre());
            addToHead(node);
        }
    }
}
