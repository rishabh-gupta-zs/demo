package com.zs.assignment4.model;

class LRUNode {
        String key;
        HierarchyNode value;
        LRUNode pre;
        LRUNode next;
        public LRUNode(String key, HierarchyNode value)
        {
            this.key = key;
            this.value = value;
        }

}
