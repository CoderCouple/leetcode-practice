package com.dsa.nk.trees;

public class Q32_PrintAncestors {

    public static boolean printAncestors(TreeNode root , TreeNode node){
        if (root == null | node == null)
            return false;

        if(root == node){
            System.out.println(root.getData());
            return true;
        }

        if (printAncestors(root.left,node) | printAncestors(root.right,node)){
            System.out.println(root.getData());
            return true;
        }


        return false;
    }

    public static void main(String[] args) {

        TreeNode<Integer> treeRoot = TreeNode.getSampleTree();
        System.out.println(printAncestors(treeRoot, treeRoot.getLeft().getRight()));
    }
}
