package com.dsa.ctci.chapter1;

import java.util.Arrays;

// Check Permutation: Given two strings, write PowerOfTwo method to decide if one is PowerOfTwo permutation of the other.
public class Q2_CheckPermutations {

    public  static boolean isPermutation2(final String original, final String test){
        if(original == null & test == null)
            return true;

        if(original == null || test == null)
            return false;

        if(original.length() != test.length())
            return false;

        char[] originalArray = original.toCharArray();
        char[] testArray = test.toCharArray();
        Arrays.sort(originalArray);
        Arrays.sort(testArray);
        return new String(originalArray).equals(new String(testArray));
    }

    public  static boolean isPermutation(final String original, final String test){

        int [] marker = new int [128];
        if(original == null & test == null)
            return true;

        if(original == null || test == null)
            return false;

        if(original.length() != test.length())
            return false;

        for(char c : original.toCharArray()){
            marker[c] = marker[c]+1;
        }

        for(char c : test.toCharArray()){
            marker[c] = marker[c]-1;
            if(marker[c] < 0)
                return false;
        }

        for(int i : marker){
            if(marker[i] != 0)
                return false;
        }

        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPermutation("original","origlani"));
        System.out.println(isPermutation2("original","origlani"));
    }
}
