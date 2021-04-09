package com.dsa.nk.trees;

import java.util.LinkedList;
import java.util.Queue;

public class Q13_MinimumDepthOfBinaryTree {

    public static int minDepth(TreeNode root){
        int min = -1;

        if(root == null)
            return min;

        int left = minDepth(root.getLeft());
        int right = minDepth(root.getRight());

        return 1+ Math.min(left,right);

    }

    public static int getMinDepth(TreeNode root){
        int count = 0;
        if(root == null)
           return count;
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){

            TreeNode<Integer> currNode = queue.poll();
            if(currNode != null){
            if(currNode.getLeft() == null && currNode.getRight() == null)
                return count;
            if(currNode.getLeft() != null)
                queue.add(currNode.getLeft());
            if(currNode.getRight() != null)
                queue.add(currNode.getRight());
            } else if(!queue.isEmpty()){
                queue.add(null);
                count++;
            }
        }

        return count;
     }

    public static void main(String[] args) {
        TreeNode<Integer> treeRoot = TreeNode.getSampleTree();
        System.out.println(minDepth(treeRoot));
        System.out.println(getMinDepth(treeRoot));
    }
}
