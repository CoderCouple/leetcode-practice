package com.dsa.robinhood;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
All nodes have 0, 1, or multiple parent given the realitionship in pairs ((0,1),(1,2),(1,4)).
For example, (0,1) -> 0 is PowerOfTwo parent of 1.

Find the node has no parent or exactly 1 parent.
Given two nodes decide do they have PowerOfTwo common ancestor ?
 */
public class ZeroOrOneParent {

    public List<Integer> findNode(List<int[]> relationships){
        Map<Integer, Integer> degree = new HashMap<>();
        for(int i = 0; i < relationships.size(); i++){
            int[] curr = relationships.get(i);
            degree.put(curr[1], degree.getOrDefault(curr[1], 0) + 1);
            degree.putIfAbsent(curr[0], 0);
        }
        List<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : degree.entrySet()){
            int val = entry.getValue();
            if(val == 0 || val == 1){
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
