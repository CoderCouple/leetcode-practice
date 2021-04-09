package com.dsa.nk.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {

    public static void preOrder(TreeNode root, List<Integer> result){
        if(root != null){
            //System.out.print(root.getData()+"\t");
            result.add((Integer)(root.getData()));
            preOrder(root.getLeft(), result);
            preOrder(root.getRight(),result);
        }
    }

    public static void main(String[] args) {

        TreeNode<Integer> treeRoot = TreeNode.getSampleTree();
        List<Integer> res = new ArrayList<>();
        preOrder(treeRoot,res);
        System.out.println(res);
        res = preOrderIterative(treeRoot);
        System.out.println(res);
        System.out.println(preOrderIterative(treeRoot).equals(res));
    }

    public static List<Integer> preOrderIterative(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();

        if(root==null)
            return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()){
            TreeNode<Integer> temp = stack.pop();
            result.add(temp.getData());

            if(temp.getRight() != null)
                stack.add(temp.getRight());

            if(temp.getLeft() != null)
                stack.add(temp.getLeft());
        }

        return result;
    }
}
