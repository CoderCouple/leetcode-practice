package com.dsa.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q_39_Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        if(candidates.length==0)
            return result;

        combinationSumHelper(candidates,target,0,result,new ArrayList<Integer>());
        return result;
    }


    public void combinationSumHelper(int[] candidates,
                                     int currSum,
                                     int index,
                                     List<List<Integer>> result,
                                     List<Integer> currList){

        if(index>= candidates.length)
            return;

        if(currSum<0)
            return;

        if(currSum ==0){
            result.add(currList);
            return;
        }

        List<Integer> listCopy = new ArrayList<>(currList);
        int currentElement = candidates[index];
        currList.add(currentElement);


        combinationSumHelper(candidates,currSum-currentElement,index+1,result,currList);
        combinationSumHelper(candidates,currSum,index+1,result,listCopy);
    }

    public static void main(String[] args) {
        int [] array1 = new int []{2,3,6,7}; int target1=7;
        int [] array2 = new int []{2,3,5}; int target2=8;

        Q_39_Combination_Sum obj = new Q_39_Combination_Sum();
        obj.combinationSum(array1,target1).forEach(System.out::println);
        obj.combinationSum(array2,target2).forEach(System.out::println);
    }

}
