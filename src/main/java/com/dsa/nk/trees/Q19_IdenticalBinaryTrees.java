package com.dsa.nk.trees;

public class Q19_IdenticalBinaryTrees {

    //SC: O(n)
    //TC: O(n)
    public static boolean isIdentical(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        if(root1.getData() != root2.getData())
            return false;

        return  isIdentical(root1.getLeft(),root2.getLeft()) &&
                isIdentical(root1.getRight(),root2.getRight());

    }

    public static void main(String[] args) {
        TreeNode<Integer> treeRoot1 = TreeNode.getSampleTree();
        TreeNode<Integer> treeRoot2 = TreeNode.getSampleTree();
        System.out.println(isIdentical(treeRoot1, treeRoot2));
    }
}
