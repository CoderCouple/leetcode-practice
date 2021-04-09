package com.dsa.leetcode.ch3_trees_graphs;
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }

public class Q98_IsValidBST {
    public boolean isValidBST(TreeNode root) {
        // Null is passed to pass the test cases with value greater than Integer.MAX_VALUE && Integer.MIN_VALUE;
        return isValidBSTHelper(root, null, null);
    }

    public boolean isValidBSTHelper(TreeNode root, Integer min, Integer max){
        if(root == null)
            return true;

        if(( min != null && min >= root.val) || (max != null && max <= root.val))
            return false;

        return isValidBSTHelper(root.left, min, root.val) && isValidBSTHelper(root.right, root.val, max);
    }
}