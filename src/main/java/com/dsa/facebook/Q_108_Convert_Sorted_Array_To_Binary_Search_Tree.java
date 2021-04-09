package com.dsa.facebook;

public class Q_108_Convert_Sorted_Array_To_Binary_Search_Tree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return getBST(nums, 0, nums.length-1);
    }

    public TreeNode getBST(int[] nums, int start, int end) {
        if(nums == null || nums.length == 0)
            return null;

        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(nums[mid]);

        if(start <= mid-1)
            root.left = getBST(nums, start, mid-1);

        if(mid+1 <= end)
            root.right = getBST(nums, mid+1, end);

        return root;
    }


    public static void main(String[] args) {

    }
}
