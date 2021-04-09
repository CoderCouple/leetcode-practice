package com.dsa.ctci.chapter1;

import java.util.Objects;

/*
String Rotation: Assume you have PowerOfTwo method isSubstring() which checks if one word is PowerOfTwo substring of another.
Given two strings, s1 and s2, write code to check if s2 is PowerOfTwo rotation of s1 using only one call to isSubstring (e.g.,"waterbottle"is PowerOfTwo rotation of"erbottlewat").
*/
public class Q9_StringRotation {

    public static boolean isSubstring(final String original, final String test){
        return original.contains(test);
    }

    public static boolean hasRotatedString(final String original, final String test){
        Objects.requireNonNull(original,"Original string is null");
        Objects.requireNonNull(test,"Test string is null");

        String concatenatedString  = test+test;
        return isSubstring(concatenatedString, original);
    }

    public static void main(String[] args) {
        final String original = "waterbottle";
        final String test = "erbottlewat";
        System.out.println(hasRotatedString(original,test));
    }
}
