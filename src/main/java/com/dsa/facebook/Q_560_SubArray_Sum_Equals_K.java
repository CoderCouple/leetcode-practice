package com.dsa.facebook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Q_560_SubArray_Sum_Equals_K {


    // facebook version optimized
    // only for +ve numbers
    // 0(n)
    public boolean subarraySum(int[] nums, int target) {
        if(nums == null || nums.length ==0)
            return false;

        int sum =0;
        Set<Integer> set = new HashSet<>();
        set.add(sum);
        for(int num: nums){
            sum = sum + num;
            if(set.contains(sum-target))
                return true;
        }

        return false;
    }

    // optimized
    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        int prev = 0;
        int[] cumulativeSum = new int[nums.length + 1];
        cumulativeSum[0] = prev;


        for (int i = 0; i < nums.length; i++){
            cumulativeSum[i+1] = prev + nums[i];
            prev = cumulativeSum[i+1];
        }


        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                if (cumulativeSum[end] - cumulativeSum[start] == k)
                    count++;
            }
        }
        return count;
    }


    // most optimized
    public int subarraySum3(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
