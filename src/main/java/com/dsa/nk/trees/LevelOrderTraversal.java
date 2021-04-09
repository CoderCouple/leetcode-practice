package com.dsa.nk.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static List<Integer> levelOrderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();

        if(root == null)
            return result;

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()){
            TreeNode<Integer> curr =  queue.poll();
            if(curr != null){
                result.add(curr.getData());
                if(curr.getLeft() != null)
                    queue.add(curr.getLeft());
                if(curr.getRight() != null)
                    queue.add(curr.getRight());
            }
            else if(queue.isEmpty())
                break;
            else {
                queue.add(null);
                result.add(null);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode<Integer> treeRoot = TreeNode.getSampleTree();
        List<Integer> res = new ArrayList<>();
        System.out.println(levelOrderTraversal(treeRoot));
    }
}
