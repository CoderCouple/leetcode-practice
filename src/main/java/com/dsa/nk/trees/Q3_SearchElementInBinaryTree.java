package com.dsa.nk.trees;

import org.junit.Assert;

import java.util.LinkedList;
import java.util.Queue;

public class Q3_SearchElementInBinaryTree {

    public static boolean search(TreeNode<Integer> root, int num){

        if(root == null)
            return false;

        if(root.getData() == num)
            return true;

        return search(root.getLeft(), num) | search(root.getRight(), num);
    }

    public static void main(String[] args) {
        TreeNode<Integer> treeRoot = TreeNode.getSampleTree();
        System.out.println(search(treeRoot, 5));
        System.out.println(search(treeRoot, 15));

        System.out.println(searchIteratively(treeRoot, 5));
        System.out.println(searchIteratively(treeRoot, 15));

        Assert.assertTrue(search(treeRoot, 5) == searchIteratively(treeRoot, 5));
        Assert.assertTrue(search(treeRoot, 15) == searchIteratively(treeRoot, 15));
    }

    public static boolean searchIteratively(TreeNode root , int num){
        if(root == null)
            return false;

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode<Integer> currNode = queue.poll();
            if(currNode == null){
                break;
            }
            if(currNode.getData() == num)
                return true;

            if(currNode.getLeft() != null)
                queue.add(currNode.getLeft());

            if(currNode.getRight() != null)
                queue.add(currNode.getRight());
        }

        return false;
    }
}
