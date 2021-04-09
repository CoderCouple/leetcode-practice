package com.dsa.facebook;

public class Q_125_Valid_Palindrome {

    public boolean isPalindrome(String s) {
        int start=0;
        int end=s.length()-1;

        while(start<=end){
            char chatAtStart = Character.toLowerCase(s.charAt(start));
            char chatAtEnd = Character.toLowerCase(s.charAt(end));

            if(!Character.isLetterOrDigit(chatAtStart)){
                start++;
            } else if(!Character.isLetterOrDigit(chatAtEnd)){
                end--;
            } else if(chatAtStart != chatAtEnd){
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q_125_Valid_Palindrome obj = new Q_125_Valid_Palindrome();
        System.out.println(obj.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(obj.isPalindrome("race a car"));
    }
}
