package com.dsa.facebook;

import java.util.Arrays;

public class Q_283_Move_Zeroes {

    public static void moveZeroes(int[] nums) {
        if(nums == null || nums.length <2)
            return;

        int nonZeroPointer = 0;
        int zeroPointer = 0;

        while(nonZeroPointer<nums.length){
            if(nums[nonZeroPointer] != 0){
                int temp = nums[zeroPointer];
                nums[zeroPointer] = nums[nonZeroPointer];
                nums[nonZeroPointer] = temp;
                zeroPointer++;
            }
            nonZeroPointer++;
        }
    }

    public static void main(String[] args) {
        int [] array1 = {1,2,3,4,5};
        int [] array2 = {0,0};
        int [] array3 = {0,1};
        int [] array4 = {0,1,0,3,12};
        moveZeroes(array1);
        System.out.println(Arrays.toString(array1));

        moveZeroes(array2);
        System.out.println(Arrays.toString(array2));

        moveZeroes(array3);
        System.out.println(Arrays.toString(array3));

        moveZeroes(array4);
        System.out.println(Arrays.toString(array4));
    }
}
