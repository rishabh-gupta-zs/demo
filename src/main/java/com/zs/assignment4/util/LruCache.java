package com.zs.assignment4.util;

import java.util.HashMap;

public class LruCache {

    private HashMap<String, Cache> cacheStorage;
    private int count;
    private final int CAPACITY=4;
    private Cache head, tail;

    public LruCache() {

        cacheStorage = new HashMap<>();
        head = new Cache("");
        tail = new Cache("");
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
    public void deleteNode(Cache node) {

        node.getPre().setNext(node.getNext());
        node.getNext().setPre(node.getPre());
    }

    /**
     * Adds node to head
     * @param node - LRUNode
     */
    public void addToHead(Cache node) {

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
            Cache node = cacheStorage.get(string);
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

        Cache node = new Cache(string);
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
