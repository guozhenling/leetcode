package com.gzl.tesla;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建一个LRU缓存;容量为capacity;
 * 删除策略为最不常使用的删除
 * hashtable+双向链表
 */
public class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public DLinkedNode() {
        }
    }
    int capacity;
    Map<Integer, DLinkedNode> cache;
    DLinkedNode head;
    DLinkedNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    private void addToHead(DLinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null){
            DLinkedNode linkedNode = new DLinkedNode(key, value);
            cache.put(key,linkedNode);
            addToHead(linkedNode);
            if (cache.size() > capacity){
                DLinkedNode cur = tail.pre;
                // remove lru node
                cur.next.pre = cur.pre;
                cur.pre.next = cur.next;
                cache.remove(cur.key);
            }
        }else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DLinkedNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
}
