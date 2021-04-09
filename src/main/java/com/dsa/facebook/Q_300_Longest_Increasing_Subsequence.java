package com.dsa.facebook;

import java.util.Arrays;

public class Q_300_Longest_Increasing_Subsequence {

    //TC: O(n^2)
    //SC: O(n)
    public int lengthOfLIS(int[] nums) {
        int max = 1;
        int length = nums.length;
        int [] subsequenceCount = new int [length];
        Arrays.fill(subsequenceCount,1);

        for(int i=0; i<length; i++){
            for(int j=0; j<i ; j++){
                if(nums[j]<nums[i]){
                    subsequenceCount[i] = Math.max(subsequenceCount[i],subsequenceCount[j]+1);
                    max = Math.max(max, subsequenceCount[i]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Q_300_Longest_Increasing_Subsequence obj = new Q_300_Longest_Increasing_Subsequence();
        System.out.println(obj.lengthOfLIS(new int []{10,9,2,5,3,7,101,18})); // [2,3,7,101]

        assert 4 == obj.lengthOfLIS(new int []{0,1,0,3,2,3}); // [0,1,2,3]

        assert  1 == obj.lengthOfLIS(new int []{7,7,7,7,7,7,7}); // [7]
    }
}
