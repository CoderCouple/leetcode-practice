package com.dsa.ctci.chapter1;

import java.util.Objects;

public class Q6_StringCompression {

    public static String compressString(final String input){
        StringBuilder sb = new StringBuilder();
        Objects.requireNonNull(input,"Input  should not be null");

        int charFrequency = 1;
        char currentChar = ' ';

        for(int i =0; i<input.length();i++){
            currentChar=input.charAt(i);
            if(i+1 < input.length()){
                if(currentChar == input.charAt(i+1)){
                    charFrequency++;
                } else {
                    sb.append(currentChar).append(charFrequency);
                    charFrequency =1;
                }
            } else {
                sb.append(currentChar).append(charFrequency);
            }
        }

        String compressedString = sb.toString();
        return compressedString.length()>input.length() ? input  : compressedString;
    }

    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa"));
    }
}
