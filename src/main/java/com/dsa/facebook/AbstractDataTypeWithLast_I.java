package com.dsa.facebook;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class AbstractDataTypeWithLast_I<K, V> extends LinkedHashMap<K, V> {

    private int capacity;
    public AbstractDataTypeWithLast_I(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public V get(Objects key) {
        return super.get(key);
    }

    public V put(K key, V value) {
        super.put(key, value);
        return value;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return size() > capacity;
    }

    public K last() {
        Iterator<Map.Entry<K, V>> iterator = this.entrySet().iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        return iterator.next().getKey();
    }

    public static void main(String[] args) {
        AbstractDataTypeWithLast_I<Integer, Integer> adt = new AbstractDataTypeWithLast_I<>(2);
        adt.put(1,1);
        adt.put(2,2);
        adt.put(3,3);
        System.out.println(adt.last());
//        Map.Entry<Integer,Integer> pair = new SimpleEntry<>(1,1);
//        adt.removeEldestEntry(pair);
        adt.put(4,4);
        System.out.println(adt.last());
    }
}
