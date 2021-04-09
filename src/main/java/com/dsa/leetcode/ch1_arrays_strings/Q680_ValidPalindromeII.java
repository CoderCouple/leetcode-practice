package com.dsa.leetcode.ch1_arrays_strings;

import java.util.stream.IntStream;

public class Q680_ValidPalindromeII {

    public boolean validPalindrome(String s) {
        int start=0;
        int end=s.length()-1;

        while(start<=end){
            char charAtStart = Character.toLowerCase(s.charAt(start));
            char charAtEnd = Character.toLowerCase(s.charAt(end));

            if(charAtStart != charAtEnd){
                return isPalindromeRange(s,start+1, end) || isPalindromeRange(s, start, end-1);
            } else {
                start++;
                end--;
            }
        }
        return true;
    }

    public boolean isPalindromeRange(String s , int start, int end){
        while (start<=end){
            if(s.charAt(start)!= s.charAt(end))
                return false;

            start++;
            end--;
        }
        return true;
    }
    public boolean isPalindromeJava8(String s) {
        return true;
    }

    public static void main(String[] args) {
        String test = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        Q680_ValidPalindromeII obj = new Q680_ValidPalindromeII();
        System.out.println(obj.validPalindrome(test));
        test.chars().forEach(x -> System.out.print((char)x+"\t"));
        System.out.println("");
        IntStream.range(0, test.length()).forEach(x -> System.out.print(x+"\t"));
    }


}
