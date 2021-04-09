package com.dsa.nk.trees;

import org.junit.Assert;

import java.util.LinkedList;
import java.util.Queue;

public class Q1_MaximumElementInBinaryTree {

    public static int max(TreeNode<Integer> root){
        int max = Integer.MIN_VALUE;
        if(root == null)
            return  max;

        int leftMax = max(root.getLeft());
        int rightMax = max(root.getRight());
        max = leftMax <= rightMax ? rightMax : leftMax;
        max = root.getData() > max ? root.getData() : max;
        return max;
    }

    public static int maxIterative(TreeNode root){
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        if(root == null)
            return max;

        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode<Integer> curr = queue.poll();
            if(curr != null){
             max = curr.getData() > max ? curr.getData() : max;
             if(curr.getLeft() != null)
                 queue.add(curr.getLeft());
             if(curr.getRight() != null)
                 queue.add(curr.getRight());
            } else if(queue.isEmpty()){
                break;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        TreeNode<Integer> treeRoot = TreeNode.getSampleTree();
        System.out.println(max(treeRoot));
        System.out.println(maxIterative(treeRoot));
        Assert.assertTrue((max(treeRoot) == maxIterative(treeRoot)));
    }
}
