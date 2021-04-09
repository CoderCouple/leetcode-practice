package com.dsa.facebook;

public class Q_167_Two_Sum_II_Input_Array_Is_Sorted {

    /**
     Given an array of integers numbers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

     Return the indices of the two numbers (1-indexed) as an integer array answer of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.

     You may assume that each input would have exactly one solution and you may not use the same element twice.



     Example 1:

     Input: numbers = [2,7,11,15], target = 9
     Output: [1,2]
     Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
     Example 2:

     Input: numbers = [2,3,4], target = 6
     Output: [1,3]
     Example 3:

     Input: numbers = [-1,0], target = -1
     Output: [1,2]
     */


    public int[] twoSum(int[] numbers, int target) {
        int [] result = new int [2];
        if(numbers == null || numbers.length == 0)
            return result;

        int start = 0;
        int end = numbers.length-1;

        while(start<end){
            if(numbers[start]+numbers[end] == target){
                result[0] = start+1;
                result[1] = end+1;
                break;
            } else if(numbers[start]+numbers[end] < target){
                start++;
            } else {
                end--;
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
