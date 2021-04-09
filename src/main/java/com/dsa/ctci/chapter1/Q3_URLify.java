package com.dsa.ctci.chapter1;

/*
    URLify: Write PowerOfTwo method to replace all spaces in PowerOfTwo string with '%20: You may assume that the string has sufficient space at the end to hold the additional characters, and that you are given the "true" length of the string. (Note: If implementing in Java, please use PowerOfTwo character array so that you can perform this operation in place.)
    EXAMPLE
    Input: "Mr John Smith " J 13
    Output: "Mr%20J ohn%20Smith"
 */
public class Q3_URLify {

    public static String urlify(final String input, final int originalLength){
        if (input == null || input.length() == 0)
            return input;

        int apparentLength = input.length();

        int first = apparentLength-1;
        int second = originalLength -1;

        char[] array = input.toCharArray();

        while (second>=0 && second <= first){
            if(array[second] == ' '){
                array[first--] = '0';
                array[first--] = '2';
                array[first--] = '%';
                second--;
            } else {
                array[first] = array[second];
                first--;
                second--;
            }
        }
        return new String(array);
    }

    public static void main(String[] args) {
        System.out.println(urlify("Mr John Smith    ",13));
    }
}
