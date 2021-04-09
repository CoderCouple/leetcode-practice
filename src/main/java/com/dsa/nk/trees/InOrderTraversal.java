package com.dsa.nk.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    public static void inOrder(TreeNode root, List<Integer> res){
        if(root != null){
            inOrder(root.getLeft(), res);
            res.add((Integer) root.getData());
            //System.out.print(root.getData()+"\t");
            inOrder(root.getRight(),res);
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> treeRoot = TreeNode.getSampleTree();
        List<Integer> res = new ArrayList<>();
        inOrder(treeRoot,res);
        System.out.println(res);
        res = inOrderIterative(treeRoot);
        System.out.println(res);
        System.out.println(inOrderIterative(treeRoot).equals(res));
    }

    public static List<Integer> inOrderIterative(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode<Integer>> stack = new Stack<>();
        boolean done = false;
        while (!done){
            if(root!= null){
                stack.push(root);
                root = root.getLeft();
            } else {
                if(stack.isEmpty()){
                    done = true;
                } else {
                    root = stack.pop();
                    result.add((Integer)root.getData());
                    root = root.getRight();
                }
            }
        }
        return result;
    }
}
