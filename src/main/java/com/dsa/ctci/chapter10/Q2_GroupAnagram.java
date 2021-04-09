package com.dsa.ctci.chapter10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q2_GroupAnagram {

    public String[] getSortedAnagrams(final String [] str){
        if(str ==null || str.length ==0)
            return str;

        Map<String, List<String>> map = new HashMap<>();
        Arrays.stream(str).forEach( s -> {
                List<String> l = map.getOrDefault(getSortedKey(s),new ArrayList<>());
                l.add(s);
                map.put(getSortedKey(s),l);
        });

        int index =0;
        for(String s : map.keySet()){
            List<String> list = map.get(s);
            for(String item : list){
                str[index] = item;
                index++;
            }
        }
        return str;
    }

    public String getSortedKey(String input){
        char [] array = input.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }

    public static void main(String[] args) {

    }
}
