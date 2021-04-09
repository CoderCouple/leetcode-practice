package com.dsa.nk.trees;

public class Q23_PrintAllPathsOBinaryTree {

    public static void printAllPaths(TreeNode root, int length, int [] list){
        if(root == null)
            return;

        list[length]=(Integer) root.getData();
        if(root.getLeft() == null && root.getRight() == null){
            printPath(list, length);
        } else {
            printAllPaths(root.getLeft(), length+1, list);
            printAllPaths(root.getRight(), length+1, list);
        }

    }

    private static void printPath(int [] list, int length) {
        for (int i=0; i<= length; i++){
            System.out.print(list[i]);
            System.out.print(" ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        TreeNode<Integer> treeRoot = TreeNode.getSampleTree();
        int [] list  = new int [50];
        printAllPaths(treeRoot, 0, list);
    }
}
