package com.dsa.ctci.chapter1;
/*
    One Away: There are three types of edits that can be performed on strings: insert PowerOfTwo character, remove PowerOfTwo character, or replace PowerOfTwo character. Given two strings, write PowerOfTwo function to check if they are one edit (or zero edits) away.
    EXAMPLE
    pale, pIe -> true
    pales, pale -> true
    pale, bale -> true
    pale, bake -> false
 */
public class Q5_OneAway {

    public static boolean isOneEditAway(final String str1, final String str2){
        int count = 0;
        int longPtr = 0;
        int shortPtr = 0;
        String longStr = str1;
        String shortStr = str2;

        if(str1 == null && str2 == null)
            return true;

        if(str1 == null || str2 == null)
            return false;

        if(Math.abs(str1.length()-str2.length())>1)
            return false;

        if(str1.length() <= str2.length()){
            longStr = str2;
            shortStr = str1;
            longPtr = str2.length()-1;
            shortPtr = str1.length()-1;
        } else {
            longStr = str1;
            shortStr = str2;
            longPtr = str1.length()-1;
            shortPtr = str2.length()-1;
        }

        if(str1.length() == str2.length()){
            while (longPtr>=0 || shortPtr >=0){
                if(longStr.charAt(longPtr) == shortStr.charAt(shortPtr)){
                    longPtr--;
                    shortPtr--;
                } else {
                    longPtr--;
                    shortPtr--;
                    count++;
                    if(count>1)
                        return false;
                }
            }
        } else {
            while (longPtr>=0 || shortPtr >=0){
                if(longStr.charAt(longPtr) == shortStr.charAt(shortPtr)){
                    longPtr--;
                    shortPtr--;
                } else {
                    longPtr--;
                    count++;
                    if(count>1)
                        return false;
                }
            }
        }
        return count == 1;
    }

    public static void main(String[] args) {
        System.out.println(isOneEditAway("pale", "ple")); // --> true
        System.out.println(isOneEditAway("pales", "pale")); // --> true
        System.out.println(isOneEditAway("pale", "bale")); // --> true
        System.out.println(isOneEditAway("pale", "bake")); // --> false
    }
}
