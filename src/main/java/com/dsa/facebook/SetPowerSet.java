package com.dsa.facebook;

import java.util.ArrayList;
import java.util.List;

public class SetPowerSet {


        // TC: O(n * 2^n)
        // SC: O(n * 2^n)
        // Recursive version
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            subsetHelper(nums, new ArrayList<Integer>(),0, result);
            return result;
        }

        public void subsetHelper(int[] nums, List<Integer> curr , int index, List<List<Integer>> result){
            if(index >= nums.length){
                result.add(curr);
                return;
            }

            List<Integer> withSet = new ArrayList<>();
            withSet.addAll(curr);
            withSet.add(nums[index]);

            subsetHelper(nums, curr, index+1, result);
            subsetHelper(nums, withSet, index+1, result);
        }

    // TC: O(n * 2^n)
    // SC: O(n * 2^n)
    // Iterative Version
        public List<List<Integer>> subsetsIterative(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            if(nums == null || nums.length == 0){
                return result;
            }
            int s = 0;
            for(int n:nums){
                s = result.size();
                for(int i = 0;i<s;i++){
                    List<Integer> set = new ArrayList<>(result.get(i));
                    set.add(n);
                    result.add(set);
                }
            }
            return result;
        }
}
