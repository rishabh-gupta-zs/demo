package com.zs.assignment4.service;

import com.zs.assignment4.HierarchyNode;

import java.util.HashMap;

public class CacheService {
    public HashMap<String, LRUNode> map;
    public int capacity, count;
    public LRUNode head, tail;
    public CacheService(int capacity)
    {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new LRUNode("", new HierarchyNode(""));
        tail = new LRUNode("",new HierarchyNode(""));
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
        count = 0;
    }
    public void deleteNode(LRUNode node)
    {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    public void addToHead(LRUNode node)
    {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }
    public HierarchyNode get(String key)
    {
        if (map.get(key) != null) {
            LRUNode node = map.get(key);
            HierarchyNode result = node.value;
            deleteNode(node);
            addToHead(node);
            return result;
        }
//        HierarchyNode blank=new HierarchyNode("");
        return null;
    }
    public void set(String key, HierarchyNode val)
    {
//        System.out.println("setting"+key+"**"+val.data);
        if (map.get(key) != null) {
            LRUNode node = map.get(key);
            node.value = val;
            deleteNode(node);
            addToHead(node);
        }
        else {
            LRUNode node = new LRUNode(key, val);
            map.put(key, node);
            if (count < capacity) {
                count++;
                addToHead(node);
            }
            else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
    }
}
