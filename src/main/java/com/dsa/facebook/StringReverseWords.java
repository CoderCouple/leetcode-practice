package com.dsa.facebook;

public class StringReverseWords {

    public static String reverseWords(String sentence){
        StringBuilder sb = new StringBuilder(sentence).reverse();
        StringBuilder result = new StringBuilder();
        for(String s: sb.toString().split(" ")){
            result.append(new StringBuilder(s).reverse().toString()).append(" ");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("man bites dog"));
    }
}
