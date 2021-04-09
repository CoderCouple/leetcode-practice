package com.dsa.ctci.chapter1;
/*
    Palindrome Permutation: Given PowerOfTwo string, write PowerOfTwo function to check if it is PowerOfTwo permutation of PowerOfTwo palin- drome. A palindrome is PowerOfTwo word or phrase that is the same forwards and backwards. A permutation is PowerOfTwo rearrangement of letters.The palindrome does not need to be limited to just dictionary words.
    EXAMPLE
    Input: Tact Coa
    Output: True (permutations: "taco cat". "atco cta". etc.)
 */
public class Q4_PalindromePermutations {

    public static boolean isPalindromePermutation(final String data){

        if (data == null ||data.isEmpty())
            return false;

        String input = data.toLowerCase();
        int[] marker = new int [128];
        int oddCount = 0;

        for (char c : input.toCharArray()){
           if((c != ' ') && (marker[c] % 2 == 0)){
                marker[c] =+ 1;
                oddCount--;
            } else {
                marker[c] =+ 1;
                oddCount ++;
            }
        }

        return (oddCount == 1 || oddCount ==0);
    }

    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("Tact Coa"));
    }
}
