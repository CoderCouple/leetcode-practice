package com.dsa.leetcode.ch5_sorting_searching;


class Solution {
    public  static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] arrayX = null;
        int [] arrayY = null;

        if(nums1.length <= nums2.length){
            arrayX = nums1;
            arrayY = nums2;
        } else {
            arrayX = nums2;
            arrayY = nums1;
        }

        int lengthX = arrayX.length;
        int lengthY = arrayY.length;

        int start = 0;
        int end = lengthX-1;

        while(start <= end){
            int partitionX = (start + end)/2;
            int partitionY = (lengthX + lengthY +1)/2 - partitionX;

            int maxLefX = partitionX == 0 ? Integer.MIN_VALUE : arrayX[partitionX-1];
            int minRightX = partitionX == lengthX ? Integer.MAX_VALUE : arrayX[partitionX];

            int maxLefY = partitionY == 0 ? Integer.MIN_VALUE : arrayY[partitionY-1];
            int minRightY = partitionY == lengthY ? Integer.MAX_VALUE : arrayY[partitionY];

            if(maxLefX <= minRightY && maxLefY <= minRightX){
                if((lengthX + lengthY)%2 == 0 ){
                    return ((double)Math.max(maxLefX,maxLefY) + (double) Math.min(minRightX,minRightY))/2;
                } else {
                    return (double)Math.max(maxLefX,maxLefY);
                }
            } else if (maxLefX > minRightY){
                end = partitionX-1;
            } else {
                start = partitionX+1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int [] x = {2};
        int [] y = {1,3};

        System.out.println(findMedianSortedArrays(x,y));
    }
}