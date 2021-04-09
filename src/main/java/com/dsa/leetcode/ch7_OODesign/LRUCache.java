package com.dsa.leetcode.ch7_OODesign;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    int capacity;
    int size;
    DLLNode head;
    DLLNode tail;
    Map<Integer,DLLNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size =0;
        map = new HashMap<>();

        head = new DLLNode(0,0);
        tail = new DLLNode(0,0);

        head.next = tail;
        tail.prev = head;
    }

    public void addNode(DLLNode node){
        if(node != null){
            DLLNode prev = head;
            DLLNode next = head.next;

            prev.next = node;
            node.prev = prev;

            node.next = next;
            next.prev = node;
        }
    }

    public DLLNode removeNode(DLLNode node){
        if(node != null) {
            DLLNode prev = node.prev;
            DLLNode next = node.next;

            prev.next = next;
            next.prev = prev;

            node.next = null;
            node.prev = null;
        }
        return node;
    }

    public void moveToHead(DLLNode node){
        addNode(removeNode(node));
    }

    public DLLNode removeFromTail(){
        DLLNode node = tail.prev;
        map.remove(node.key);
        size--;
        return removeNode(node);
    }

    public int get(int key) {
        if(map.containsKey(key)){
            DLLNode node = map.get(key);
            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            DLLNode n = map.get(key);
            n.val = value;
            moveToHead(n);
        } else {
            DLLNode n = new DLLNode(key, value);
            if(size>= capacity){
                removeFromTail();
            }
            addNode(n);
            size++;
            map.put(key,n);
        }
    }

    public static void main(String[] args) {
        int capacity = 2;
        LRUCache obj = new LRUCache(capacity);
        obj.put(1,1);
        obj.put(2,2);
        System.out.println(obj.get(1));
        obj.put(3,3);
        System.out.println(obj.get(2));
        obj.put(4,4);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));
    }
}

class DLLNode{
    int key;
    int val;
    DLLNode next;
    DLLNode prev;

    public DLLNode(int key, int value){
        this.key = key;
        this.val = value;
    }
}
