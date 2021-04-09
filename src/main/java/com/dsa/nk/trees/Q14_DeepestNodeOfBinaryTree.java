package com.dsa.nk.trees;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class Q14_DeepestNodeOfBinaryTree {

    public static TreeNode<Integer> getDeepestNodeHelper(TreeNode root){
        if(root == null)
            return root;
        return deepestNode(root).getLeft();
    }

    public static Pair<TreeNode<Integer>,Integer> deepestNode(TreeNode root){
        Pair<TreeNode<Integer>,Integer> left;
        Pair<TreeNode<Integer>,Integer> right;
        if(root.getLeft() != null){
            left = deepestNode(root.getLeft());
        } else {
            Pair<TreeNode<Integer>, Integer> pair = new MutablePair<>(root, 1);
            return pair;
        }

        if(root.getRight() != null){
            right = deepestNode(root.getRight());
        } else {
            Pair<TreeNode<Integer>, Integer> pair = new MutablePair<>(root, 1);
            return pair;
        }

        Pair<TreeNode<Integer>,Integer> max = left.getRight() >= right.getRight() ? left : right;
        Pair<TreeNode<Integer>, Integer> pair = new MutablePair<>(max.getLeft(), max.getRight()+1);
        return pair;
    }

    public static TreeNode<Integer> getDeepestNode(TreeNode root){
        TreeNode result = root;
        if(root == null)
            return result;

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            result = queue.poll();
            if(result.getRight()!=null)
                queue.add(result.getRight());
            if(result.getLeft()!=null)
                queue.add(result.getLeft());
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode<Integer> treeRoot = TreeNode.getSampleTree();
        System.out.println(getDeepestNodeHelper(treeRoot).toString());
        System.out.println(getDeepestNode(treeRoot).toString());
    }
}
