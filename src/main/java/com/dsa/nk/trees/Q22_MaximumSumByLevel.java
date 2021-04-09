package com.dsa.nk.trees;

import java.util.LinkedList;
import java.util.Queue;

public class Q22_MaximumSumByLevel {

    public static int getLevelSum(TreeNode root){
        int maxLevelSum  = 0;
        int levelSum = 0;
        if(root == null)
            return 0;

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()){
            TreeNode<Integer> curr = queue.poll();
            if(curr != null){
                levelSum = levelSum + curr.getData();
                if(curr.getLeft() != null){
                    queue.add(curr.getLeft());
                }
                if(curr.getRight() != null){
                    queue.add(curr.getRight());
                }
            } else if(!queue.isEmpty()){
                queue.add(null);
                maxLevelSum = Math.max(maxLevelSum,levelSum);
                levelSum = 0;
            }

        }
        return maxLevelSum;
    }

    public static void main(String[] args) {
        TreeNode<Integer> treeRoot = TreeNode.getSampleTree();
        System.out.println(getLevelSum(treeRoot));
    }
}
