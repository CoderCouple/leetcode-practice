package com.dsa.nk.trees;

import java.util.LinkedList;
import java.util.Queue;

public class Q16_CountLeafNodes {

    public static int count(TreeNode root){
        if(root == null)
            return 0;

        if(root.getLeft() == null && root.getRight() == null)
            return 1;

        return  count(root.getRight()) + count(root.getLeft());

    }

    public static int getLeafNodeCount(TreeNode root){
        int count = 0;
        if(root == null)
            return count;

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr.getLeft() == null && curr.getRight() == null)
                count++;

            if(curr.getLeft() != null)
                queue.add(curr.getLeft());

            if(curr.getRight() != null)
                queue.add(curr.getRight());

        }
        return  count;
    }


    public static void main(String[] args) {
        TreeNode<Integer> treeRoot = TreeNode.getSampleTree();
        System.out.println(count(treeRoot));
        System.out.println(getLeafNodeCount(treeRoot));
    }
}
