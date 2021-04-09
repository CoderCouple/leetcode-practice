package com.dsa.facebook;

import java.util.ArrayList;
import java.util.List;

public class Q_647_All_Palindromic_Substrings {



    // this is also contain repeated characters to remove the repeated characters store it in set instead of list
    public static int countSubstrings(String s) {
        if(s == null || s.isEmpty())
            return 0;

        List<String> list = new ArrayList<String>();
        for(int i=0; i<s.length(); i++){

            // for odd length
            isSubString(s,i,i,list);

            // for even length
            isSubString(s,i,i+1,list);
        }

        return list.size();
    }


    public static void isSubString(String s, int leftStart, int rightStart, List<String> list){

        if(leftStart <0 || rightStart >= s.length())
            return;

        while(leftStart >= 0 && rightStart < s.length()){

            if(!Character.isAlphabetic(s.charAt(leftStart)))
                leftStart--;

            if(!Character.isAlphabetic(s.charAt(rightStart)))
                rightStart++;

            if(s.charAt(leftStart) != s.charAt(rightStart))
                break;


            list.add(s.substring(leftStart,rightStart+1));
            leftStart--;
            rightStart++;
        }
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aaa"));
    }

}

