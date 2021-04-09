package com.dsa.nk.trees;

public class Q30_TreeFromInOrderAndPostOrder {

    public TreeNode buildTree(int[] postorder, int[] inorder) {
        if(inorder.length == 0 || postorder.length == 0)
            return null;

        return build(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode build(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart , int inEnd) {
        return null;
    }

    public static void main(String[] args) {

    }
}
