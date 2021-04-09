package com.dsa.facebook;

import java.util.Arrays;

public class Q_238_Product_Of_Array_Except_Self {

    //SC: O(n)
    //TC: O(n)

    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int [] left = new int[size];
        int [] right = new int[size];
        int [] result = new int[size];

        left[0] = 1;
        for(int index = 1; index<size; index++){
            left[index] =  left[index-1] * nums[index-1];
        }

        right[size-1] = 1;
        for(int index = size-2; index>=0; index--){
            right[index] =  right[index+1] * nums[index+1];
        }

        for(int index= 0; index<size; index++){
            result[index] = left[index] * right[index];
        }

        return result;
    }

    // most optimized
    // TC : O(n)
    // SC : O(1)

    public int[] productExceptSelf2(int[] nums) {
        int size = nums.length;
        int right = 1;
        int [] result = new int[size];

        result[0] = 1;
        for(int index = 1; index<size; index++){
            result[index] =  result[index-1] * nums[index-1];
        }

        for(int index = size-1; index>=0; index--){
            result[index] =  result[index] * right;
            right = right * nums[index];
        }

        return result;
    }


    public static void main(String[] args) {
        Q_238_Product_Of_Array_Except_Self obj = new Q_238_Product_Of_Array_Except_Self();
        int [] input = new int []{1,2,3,4};
        System.out.println(Arrays.toString(obj.productExceptSelf(input)));
    }
}
