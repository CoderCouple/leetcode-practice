package com.dsa.leetcode.ch5_sorting_searching;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Q349_IntersectionOfTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        if(nums1==null || nums2 == null)
           return new int [0];

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int num1Index =0;
        int num2Index =0;

        while(num1Index<nums1.length && num2Index<nums2.length){
            if(nums1[num1Index] == nums2[num2Index]){
                set.add(nums1[num1Index]);
                num1Index++;
                num2Index++;
            } else if(nums1[num1Index] < nums2[num2Index]) {
                num1Index++;
            } else {
                num2Index++;
            }
        }

        int [] result = new int[set.size()];
        Iterator<Integer> it = set.iterator();
        int index =0;
        while (it.hasNext()){
            result[index] = it.next();
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
      int [] num1 = {4,9,5};
      int [] num2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(num1,num2)));

    }
}
