package com.dsa.nk.trees;

import java.util.LinkedList;
import java.util.Queue;

public class Q10_TreeHeight {

    public static int getHeight(TreeNode<Integer> root){
        if(root == null)
            return 0;
        return 1+ Math.max(getHeight(root.getLeft()),
                                 getHeight(root.getRight()));
    }


    public static int getTreeHeight(TreeNode<Integer> root){
        int count =0;
        if(root == null)
            return count;

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()){
            TreeNode<Integer> curr = queue.poll();
            if(curr != null){
                if(curr.getLeft() != null)
                    queue.add(curr.getLeft());

                if(curr.getRight() != null)
                    queue.add(curr.getRight());

            } else if(queue.isEmpty()){
                return count+1;
            } else {
                queue.add(null);
                count++;
            }
        }
        return count+1;
    }
    public static void main(String[] args) {

        TreeNode<Integer> treeRoot = TreeNode.getSampleTree();
        System.out.println(getHeight(treeRoot));
        System.out.println(getTreeHeight(treeRoot));
    }
}
