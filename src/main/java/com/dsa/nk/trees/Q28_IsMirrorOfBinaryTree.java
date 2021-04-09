package com.dsa.nk.trees;

public class Q28_IsMirrorOfBinaryTree {

    public static boolean isMirror(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        if(root1 == null && root2 == null)
            return true;

        if(root1 == null || root2 == null)
            return false;

        if (root1.getData() != root2.getData())
            return false;

        return isMirror(root1.getLeft(),root2.getRight()) &&
                isMirror(root1.getRight(),root2.getLeft());

    }
    public static void main(String[] args) {
        TreeNode<Integer> treeRoot1 = TreeNode.getSampleTree();
        TreeNode<Integer> treeRoot2 = TreeNode.getSampleTree();
        System.out.println(isMirror(treeRoot1, treeRoot2));
    }
}
