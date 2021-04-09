package com.dsa.nk.trees;

public class Q24_PathWithAGivenSum {

    public static boolean hasPath(TreeNode<Integer> root, int sum){
        if(root == null && sum == 0)
            return true;

        if (root == null)
            return false;

        return hasPath(root.getLeft(),sum-root.getData()) ||
                hasPath(root.getRight(),sum-root.getData());
    }

    public static void main(String[] args) {
        TreeNode<Integer> treeRoot = TreeNode.getSampleTree();
        System.out.println(hasPath(treeRoot,8));
    }
}
