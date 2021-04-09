package com.dsa.facebook;


import java.util.HashMap;
import java.util.Map;

public class AbstractDataTypeWithLast_II<K, V> implements AbstractDataTypeWithLast<K,V> {

    int capacity;
    int size;
    DLLNode<Integer,Integer> head;
    DLLNode<Integer,Integer> tail;
    DLLNode<K,V> last;
    Map<K,DLLNode<K,V>> map;

    public AbstractDataTypeWithLast_II(int capacity){
        this.capacity = capacity;
        this.size =0;
        map = new HashMap<>();

        head = new DLLNode<>(0,0);
        tail = new DLLNode<>(0,0);
        last = null;

        head.next = tail;
        tail.prev = head;
    }

    public void addNode(DLLNode<K,V> node){
        if(node != null){
            DLLNode<K,V> prev = (DLLNode<K, V>) head;
            DLLNode<K,V> next = (DLLNode<K, V>) head.next;

            prev.next = node;
            node.prev = prev;

            node.next = next;
            next.prev = node;
        }
    }

    public DLLNode<K, V> removeNode(DLLNode<K, V> node){
        if(node != null) {
            DLLNode<K, V> prev = node.prev;
            DLLNode<K, V> next = node.next;

            prev.next = next;
            next.prev = prev;

            node.next = null;
            node.prev = null;
        }
        return node;
    }


    public void moveToHead(DLLNode<K, V> node){
        addNode(removeNode(node));
    }

    public DLLNode<K, V> removeFromTail(){
        DLLNode<K, V> node = (DLLNode<K, V>) tail.prev;
        map.remove(node.key);
        size--;
        return removeNode(node);
    }

    @Override
    public void put(final K k, final V v) {
        if(map.containsKey(k)){
            DLLNode<K, V> n = map.get(k);
            n.val = v;
            moveToHead(n);
        } else {
            DLLNode<K, V> n = new DLLNode<K, V>(k, v);
            if(size>= capacity){
                removeFromTail();
            }
            addNode(n);
            size++;
            map.put(k,n);
        }
        last = map.get(k);
    }

    @Override
    public V get(final K k) {
        if(map.containsKey(k)){
            DLLNode<K, V> node = map.get(k);
            moveToHead(node);
            last = map.get(k);
            return node.val;
        }
        return null;
    }

    @Override
    public void delete(final K k) {
        if(map.containsKey(k)){
            DLLNode<K, V> n = map.get(k);
            last = map.get(k);
            map.remove(k);
            removeNode(n);
            size--;
        }
    }

    @Override
    public K last() {
        if(size<=0)
            return null;

        return last.key;
    }

    public static void main(String[] args) {
        AbstractDataTypeWithLast<Integer, Integer> obj = new AbstractDataTypeWithLast_II<Integer, Integer>(3);
        obj.put(1,1);
        obj.put(2,2);
        obj.put(3,3);
        System.out.println(obj.get(3));
        obj.put(4,4);
        System.out.println(obj.last());
        System.out.println(obj.get(1));
        System.out.println(obj.last());
        obj.delete(4);
        obj.put(4,4);


    }
}

class DLLNode<K,V>{
    K key;
    V val;
    DLLNode<K,V> next;
    DLLNode<K,V> prev;

    public DLLNode(K key, V value){
        this.key = key;
        this.val = value;
    }
}


interface AbstractDataTypeWithLast <K, V> {
    void put(K k, V v);
    V    get(K k);
    void delete(K k);
    K    last();
}