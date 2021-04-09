package com.dsa.nk.trees;

public class Q6_SizeOfTree {

    public static int size(TreeNode root){
        if(root == null)
            return 0;

        int left = size(root.getLeft());
        int right = size(root.getRight());

        return left + right +1;
    }

    public static void main(String[] args) {
        TreeNode<Integer> treeRoot = TreeNode.getSampleTree();
        System.out.println(size(treeRoot));
    }
}

