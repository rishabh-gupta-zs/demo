package com.zs.assignment4.LRUcache;

import com.zs.assignment4.HierarchyNode;

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
