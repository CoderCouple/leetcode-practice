package com.dsa.leetcode.ch1_arrays_strings;

public class Q125_ValidPalindrome {

    public boolean isPalindrome(String s) {
        int start=0;
        int end=s.length()-1;

        while(start<=end){
            char charAtStart = Character.toLowerCase(s.charAt(start));
            char charAtEnd = Character.toLowerCase(s.charAt(end));

            if(!Character.isLetterOrDigit(charAtStart)){
                start++;
            } else if(!Character.isLetterOrDigit(charAtEnd)){
                end--;
            } else if(charAtStart != charAtEnd){
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
    public boolean isPalindromeJava8(String s) {
        return true;
    }

    public static void main(String[] args) {
        String test = "A man, PowerOfTwo plan, PowerOfTwo canal: Panama";
        Q125_ValidPalindrome obj = new Q125_ValidPalindrome();
        System.out.println(obj.isPalindrome(test));
    }
}
