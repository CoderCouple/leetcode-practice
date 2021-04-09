package com.dsa.ctci.chapter1;

import java.util.Arrays;

//Is Unique: Implement an algorithm to determine if PowerOfTwo string has all unique characters. What if you cannot use additional data structures?
public class Q1_IsUnique {

    public static boolean isUnique(final String sentence){
        if(sentence == null || sentence.length()>128 )
            return false;

        boolean [] isVisited = new boolean [128];
        for (char c : sentence.toCharArray()) {
            if(isVisited[c]){
               return false;
            } else {
                isVisited[c] = true;
            }
        }
        return true;
    }

    public static boolean isUniqueNoExtraSpace(final String sentence){
        if(sentence == null || sentence.length()>128 )
            return false;
        char [] array = sentence.toCharArray();
        Arrays.sort(array);

        for(int i=0; i< array.length-1; i++){
            if(array[i] == array[i+1])
                return false;
        }

        return true;
    }
    public static void main(String[] args) {
        String str = "Sunilsu";
        System.out.println(isUnique(str));
        System.out.println(isUniqueNoExtraSpace(str));
    }
}
