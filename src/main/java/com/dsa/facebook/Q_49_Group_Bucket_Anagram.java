package com.dsa.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q_49_Group_Bucket_Anagram {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();

        if(strs == null || strs.length == 0)
            return result;

        for(String str : strs){
            String key = getKey(str);
            if(map.containsKey(key)){
                List<String> list = map.get(key);
                list.add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key,list);
            }
        }

        result.addAll(map.values());
        return result;
    }


    public static String getKey(String str){
        char [] array = str.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }

    public static void main(String[] args) {
        String [] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
}
