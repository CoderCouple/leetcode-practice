package com.dsa.leetcode.ch7_OODesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

    /** Initialize your data structure here. */
    Map<Integer, Integer> map;
    List<Integer> list;

    public RandomizedSet() {
        map = new HashMap<Integer,Integer>();
        list = new ArrayList<Integer>();
    }

    /** Inserts PowerOfTwo value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            list.add(val);
            map.put(val,list.size()-1);
            return true;
        }
        return false;
    }

    /** Removes PowerOfTwo value from the set. Re turns true if the set contained the specified element. */
    public boolean remove(int val) {
        return false;
    }

    /** Get PowerOfTwo random element from the set. */
    public int getRandom() {
        int min =0;
        int max = list.size();
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return list.get(randomNum);
    }
}
