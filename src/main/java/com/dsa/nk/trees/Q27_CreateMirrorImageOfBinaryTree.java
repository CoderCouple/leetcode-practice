package com.dsa.nk.trees;

public class Q27_CreateMirrorImageOfBinaryTree {

    public static TreeNode createMirrorImage(TreeNode root){
        if (root == null)
            return root;

        TreeNode left = createMirrorImage(root.getLeft());
        TreeNode right = createMirrorImage(root.getRight());
        root.setLeft(right);
        root.setRight(left);
        return root;
    }

    public static void main(String[] args) {
        TreeNode<Integer> treeRoot = TreeNode.getSampleTree();
        TreeNode<Integer> mirror = createMirrorImage(treeRoot);
        TreeNode.levelOrderTraversal(mirror);

    }
}
