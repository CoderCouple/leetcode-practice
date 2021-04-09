package com.dsa.facebook;

public class Q_26_Remove_Duplicates_from_Sorted_Array {
    public static int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;
        int count=1;
        while(fast<nums.length && slow<=fast){
            if(nums[slow] != nums[fast]){
                slow++;
                count++;
                nums[slow]=nums[fast];
            }
            fast++;
        }

        return count;
    }

    public static void main(String[] args) {
        int [] nums1 = {1,1,2}; // [1,2]
        int [] nums2 = {0,0,1,1,1,2,2,3,3,4}; //[0,1,2,3,4]

        System.out.println(removeDuplicates(nums1));
        System.out.println(removeDuplicates(nums2));
    }
}
