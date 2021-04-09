package com.dsa.facebook;

import java.util.ArrayList;
import java.util.List;

public class Q_162_Find_All_Local_Maxima {



    //TC: O(n)
    //SC: O(1)
    public int findLocalOneMaxima(int [] nums){

        for(int i=0; i< nums.length-2; i++){
            if(nums[i]>=nums[i+1])
                return nums[i];
        }
        return nums[nums.length-1];
    }

    //TC: O(logn)
    //SC: O(1)
    public int findLocalOneMaximaBinary(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while(start< end){
            int mid = start + (end - start)/2;
            if(nums[mid] >= nums[mid + 1]){
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return nums[end];
    }


    //TC: O(logn)
    //SC: O(n)
    public List<Integer> findLocalAllMaxima(int [] nums){
        List<Integer> list = new ArrayList<>();
        if(nums.length == 1){
            list.add(nums[0]);
            return list;
        }

        for(int i=0; i<= nums.length-1; i++){
            int prev = i-1;
            int next = i+1;
            if( (prev >=0 && prev<nums.length) && (next >=0 && next<nums.length)){
                if(nums[prev] <= nums[i] && nums[i] >= nums[next])
                    list.add(nums[i]);
            } else if((prev >=0 && prev<nums.length)){
                if(nums[prev] <= nums[i]){
                    list.add(nums[i]);
                }
            } else {
                if(nums[i] >= nums[next]){
                    list.add(nums[i]);
                }
            }
        }
        return list;
    }

    //TC: O(nlogn)
    //SC: O(n)
    public List<Integer> findLocalAllMaximaBinary(int [] nums){
        List<Integer> list = new ArrayList<>();
        return list;
    }


    public static void main(String[] args) {
        Q_162_Find_All_Local_Maxima obj = new Q_162_Find_All_Local_Maxima();


        System.out.println(obj.findLocalOneMaxima(new int []{1}));
        System.out.println(obj.findLocalOneMaxima(new int []{1,1,1}));
        System.out.println(obj.findLocalOneMaxima(new int []{5,9,7,10,12}));
        System.out.println(obj.findLocalOneMaxima(new int []{1,2,3,4,5}));
        System.out.println(obj.findLocalOneMaxima(new int []{5,4,3,2,1}));

        System.out.println("=====================");



        System.out.println(obj.findLocalOneMaximaBinary(new int []{1}));
        System.out.println(obj.findLocalOneMaximaBinary(new int []{1,1,1}));
        System.out.println(obj.findLocalOneMaximaBinary(new int []{5,9,7,10,12}));
        System.out.println(obj.findLocalOneMaximaBinary(new int []{1,2,3,4,5}));
        System.out.println(obj.findLocalOneMaximaBinary(new int []{5,4,3,2,1}));

        System.out.println("=====================");

        System.out.println(obj.findLocalAllMaxima(new int []{1}));
        System.out.println(obj.findLocalAllMaxima(new int []{1,1,1}));
        System.out.println(obj.findLocalAllMaxima(new int []{5,9,7,10,12}));
        System.out.println(obj.findLocalAllMaxima(new int []{1,2,3,4,5}));
        System.out.println(obj.findLocalAllMaxima(new int []{5,4,3,2,1}));


    }
}
