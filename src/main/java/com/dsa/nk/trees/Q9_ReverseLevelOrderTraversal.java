package com.dsa.nk.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q9_ReverseLevelOrderTraversal {

    public static void reverseLevelOrder(TreeNode root){
        if(root == null)
            return;

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        Stack<TreeNode<Integer>> stack = new Stack<>();

        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode<Integer>  curr = queue.poll();
            if(curr != null){
                stack.add(curr);

                if(curr.getLeft() != null)
                    queue.add(curr.getLeft());


                if(curr.getRight() != null)
                    queue.add(curr.getRight());
            }
        }

        while (!stack.isEmpty()){
            System.out.println(stack.pop().getData());
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> treeRoot = TreeNode.getSampleTree();
        reverseLevelOrder(treeRoot);
    }
}
