package com.dsa.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q_17_Letter_Combinations_Of_A_Phone_Number {
    public static List<String> letterCombinations(String digits) {

        Map<String,String> map = new HashMap<>();
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");

        List<String> results = new ArrayList<>();
        if(digits == null || digits.isEmpty())
            return results;

        letterCombinationsHelper(digits,"",0,results,map);
        return results;

    }

    public static void letterCombinationsHelper(String digits, String curr, int index, List<String> results, Map<String,String> map){
        if(index >= digits.length()){
            results.add(curr);
            return;
        }

        String digit = Character.toString(digits.charAt(index));
        String chars = map.get(digit);
        for(char c : chars.toCharArray()){
            letterCombinationsHelper(digits,curr+c,index+1,results,map);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
